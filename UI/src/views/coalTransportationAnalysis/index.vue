<template>
  <div>
    <el-card class="box-card">
      <el-form ref="form" :model="form" label-width="80px">
        <el-row>
          <el-col :span="4">
            <el-form-item label="批次编号">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="检测时间">
              <el-date-picker v-model="form.value1" type="daterange" range-separator="至" start-placeholder="开始日期"
                end-placeholder="结束日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="车牌号">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="所在矿区">
              <el-select v-model="form.region" placeholder="请选择矿区">
                <el-option label="A矿区" value="A"></el-option>
                <el-option label="B矿区" value="B"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">搜索</el-button>
          <el-button>重置</el-button>
        </el-form-item>
      </el-form>
      <el-divider></el-divider>
      今日异常批次
      <el-table v-loading="loading" :data="exceptionList" @selection-change="handleSelectionChange">
        <el-table-column label="批次编号" align="center" prop="batchNumber" />
        <el-table-column label="矿区名称" align="center" prop="miningAreaName" />
        <el-table-column label="运输车辆车牌" align="center" prop="licensePlate" />
        <el-table-column label="矿区所在地" align="center" prop="locationMiningArea" />
        <el-table-column label="检测时间" align="center" prop="testTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.testTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button size="mini" type="text" icon="el-icon-edit" @click="handleInfo(scope.row)">查看详情</el-button>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
        @pagination="getList" />

      <!-- 添加或修改【请填写功能名称】对话框 -->
      <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
          <el-form-item label="批次煤的重量" prop="batchCoalWeight">
            <el-input v-model="form.batchCoalWeight" placeholder="请输入批次煤的重量" />
          </el-form-item>
          <el-form-item label="矿区名称" prop="miningAreaName">
            <el-input v-model="form.miningAreaName" placeholder="请输入矿区名称" />
          </el-form-item>
          <el-form-item label="运输车辆车牌" prop="licensePlate">
            <el-input v-model="form.licensePlate" placeholder="请输入运输车辆车牌" />
          </el-form-item>
          <el-form-item label="矿区所在地" prop="locationMiningArea">
            <el-input v-model="form.locationMiningArea" placeholder="请输入矿区所在地" />
          </el-form-item>
          <el-form-item label="出发时间" prop="startTime">
            <el-date-picker clearable v-model="form.startTime" type="date" value-format="yyyy-MM-dd"
              placeholder="请选择出发时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="到达时间" prop="arrivalTime">
            <el-date-picker clearable v-model="form.arrivalTime" type="date" value-format="yyyy-MM-dd"
              placeholder="请选择到达时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="登记表编号" prop="registrationNumber">
            <el-input v-model="form.registrationNumber" placeholder="请输入登记表编号" />
          </el-form-item>
          <el-form-item label="煤采样编号" prop="coalNumber">
            <el-input v-model="form.coalNumber" placeholder="请输入煤采样编号" />
          </el-form-item>
          <el-form-item label="汽运目的地" prop="destination">
            <el-input v-model="form.destination" placeholder="请输入汽运目的地" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </el-dialog>
      <el-divider></el-divider>
      煤质异常情况
      <div style="width: 100%;height: 300px;" ref="exceptionBarChart"></div>
    </el-card>
  </div>
</template>
  
<script>
import * as echarts from 'echarts';

export default {
  name: "coalTransportationAnalysis",
  data() {
    return {
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: '',
        value1: ''
      },
      // 遮罩层
      loading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 【请填写功能名称】表格数据
      exceptionList: [
        {
          batchNumber: 'C2023102401',
          miningAreaName: '忻州矿区',
          licensePlate: '晋C83752',
          locationMiningArea: '忻州',
          testTime: '2023-10-24'
        },
        {
          batchNumber: 'C2023102402',
          miningAreaName: '大同矿区',
          licensePlate: '晋C83752',
          locationMiningArea: '大同',
          testTime: '2023-10-24'
        }
      ],

      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        batchCoalWeight: null,
        miningAreaName: null,
        licensePlate: null,
        locationMiningArea: null,
        startTime: null,
        arrivalTime: null,
        registrationNumber: null,
        coalNumber: null,
        destination: null,
        arrivalStatus: null
      },
      //表单校验
      rules: {},
      chartData1: [
        {
          value: 3.6,
          itemStyle: {
            color: '#a90000'
          }
        }, 0.7, 0.4, 0.6, 0.4,
        {
          value: -2.3,
          itemStyle: {
            color: '#a90000'
          }
        }
      ],
      chartData2: [
        0.7, 0.4, {
          value: 3.6,
          itemStyle: {
            color: '#a90000'
          }
        }, 0.6, 0.4,
        {
          value: -2.3,
          itemStyle: {
            color: '#a90000'
          }
        }
      ],
      exceptionBarChart:null
    };
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },
    cancel() {

    },
    handleSelectionChange() { },
    submitForm() { },
    getList() { },
    handleInfo(row) {
      console.log(row);

    },
  },
  mounted() {
    this.exceptionBarChart = echarts.init(this.$refs.exceptionBarChart);
    // 配置图表
    var option = {
      //笛卡尔坐标系的底板
      grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
      },
      xAxis: {
        type: 'category',
        data: ['水分', '灰分', '密度', '挥发分', '电阻率', '基低位发热量']
      },
      yAxis: {
        type: 'value',
        name: '变化%'
      },
      series: [
        {
          data: this.chartData1,
          type: 'bar'
        }
      ]
    }
    this.exceptionBarChart.setOption(option)
  }
};
</script>
  
<style scoped lang="scss">
.box-card {
  margin: 1% 1%;
  width: 98%;
}
</style>
  
  