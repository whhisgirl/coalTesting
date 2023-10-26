<template>
  <div>
    <el-card class="box-card">
      <el-form ref="form" :model="form" label-width="80px">
        <el-row>
          <el-col :span="4">
            <el-form-item label="批次编号">
              <el-input v-model="form.batchNumber"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="检测时间">
              <el-date-picker v-model="form.sampleTimeList" type="daterange" range-separator="至" start-placeholder="开始日期"
                end-placeholder="结束日期" value-format="yyyy-MM-dd">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="车牌号">
              <el-input v-model="form.licensePlate"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="所在矿区">
              <el-select v-model="form.miningAreaName" placeholder="请选择矿区">
                <el-option label="A矿区" value="A"></el-option>
                <el-option label="B矿区" value="B"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item>
          <el-button type="primary" @click="search">搜索</el-button>
          <el-button @click="reset">重置</el-button>
        </el-form-item>
      </el-form>
      <div>
        <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
          <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
            异常批次
          </p>
        </div>
      </div>
      <el-table v-loading="loading" :data="exceptionList" @selection-change="handleSelectionChange">
        <el-table-column label="批次编号" align="center" prop="batchNumber" />
        <el-table-column label="矿区名称" align="center" prop="miningAreaName" />
        <el-table-column label="运输车辆车牌" align="center" prop="licensePlate" />
        <el-table-column label="矿区所在地" align="center" prop="locationMiningArea" />
        <el-table-column label="检测时间" align="center" prop="sampleTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.sampleTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
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

      <!-- 对话框 -->
      <el-dialog :title="title" :visible.sync="open" width="80%" append-to-body>
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="批次编号" prop="registrationNumber">
                {{ 1 }}
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="矿区名称" prop="miningAreaName">
                {{ 'a' }}
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="运输车辆车牌" prop="licensePlate">
                {{ 'ASA' }}
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="矿区所在地" prop="locationMiningArea">
                {{ 'AADD' }}
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <div ref="exceptionCompareChart" style="width: 100%;height: 300px;"></div>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancel">退 出</el-button>
        </div>
      </el-dialog>
      <el-divider></el-divider>
      <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
        <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
          煤质异常次数
        </p>
        <el-tooltip placement="top">
          <div slot="content">
            <p>水分(0~1%)</p>
            <p>灰分(0~1%)</p>
            <p>密度(0~0.5%)</p>
            <p>挥发分(0~1%)</p>
            <p>电阻率(0~1%)</p>
            <p>发热量(0~1.5%)</p>
          </div>
          <i class="el-icon-question" style="float: right; margin-right: 20px; margin-top: 12px; font-size: 30px;"></i>
        </el-tooltip>
      </div>
      <div style="width: 100%;height: 200px;" ref="exceptionBarChart"></div>
    </el-card>
  </div>
</template>
  
<script>
import * as echarts from 'echarts';
import { listBatchAndIndicators } from "@/api/system/indicators";


export default {
  name: "coalTransportationAnalysis",
  data() {
    return {
      form: {
        pageNum: 1,
        pageSize: 10,
        sampleTimelist:[],
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
      exceptionList: [],

      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
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
      chartData3: [
        0.7, 0.4, 3.6, 0.6, 0.4, 2.3
      ],
      chartData4: [
        0.7, 0.4, 3.6, 0.6, 0.4, -2.3
      ],
      exceptionBarChart: null,
      chartOption: {},
    };
  },
  methods: {
    search() {
      console.log(this.form);
      this.form.sampleTimeBegin = this.form.sampleTimeList[0]
      this.form.sampleTimeAfter = this.form.sampleTimeList[1]
      listBatchAndIndicators(this.form).then(response => {
        console.log(response);
        this.exceptionList = response.data.batchAndIndicatorsList
        this.total = response.data.total
      });
    },
    cancel() {
      this.open = false
    },
    reset(){
      listBatchAndIndicators({pageNum: 1, pageSize: 10,}).then(response => {
        console.log(response);
        this.exceptionList = response.data.batchAndIndicatorsList
        this.total = response.data.total
      });
    },
    handleSelectionChange() { },
    submitForm() { },
    getList() {
      listBatchAndIndicators(this.queryParams).then(response => {
        console.log(response);
        this.exceptionList = response.data.batchAndIndicatorsList
        this.total = response.data.total
      });
    },
    handleInfo(row) {
      this.open = true
      this.$nextTick(()=>{
        this.initExceptionCompareChart()
      })
    },
    initExceptionNumBarChart() {
      this.exceptionBarChart = echarts.init(this.$refs.exceptionBarChart);
      // 配置图表
      this.chartOption = {
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
          name: '次数'
        },
        series: [
          {
            data: this.chartData3,
            type: 'bar'
          }
        ]
      }
      this.exceptionBarChart.setOption(this.chartOption)
    },
    initExceptionCompareChart() {
      this.exceptionBarChart = echarts.init(this.$refs.exceptionCompareChart);
      // 配置图表
      this.chartOption = {
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
          },
        ]
      }
      this.exceptionBarChart.setOption(this.chartOption)
    },
  },
  mounted() {
    this.getList()
    this.initExceptionNumBarChart()
  }
};
</script>
  
<style scoped lang="scss">
.box-card {
  margin: 1% 1%;
  width: 98%;
}
</style>
  
  