<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="煤采样编号" prop="coalNumber">
        <el-input
          v-model="queryParams.coalNumber"
          placeholder="请输入煤采样编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="水分" prop="waterContent">
        <el-input
          v-model="queryParams.waterContent"
          placeholder="请输入水分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="灰分" prop="ashContent">
        <el-input
          v-model="queryParams.ashContent"
          placeholder="请输入灰分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="挥发分" prop="coalVolatile">
        <el-input
          v-model="queryParams.coalVolatile"
          placeholder="请输入挥发分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="密度" prop="density">
        <el-input
          v-model="queryParams.density"
          placeholder="请输入密度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电阻率" prop="resistivity">
        <el-input
          v-model="queryParams.resistivity"
          placeholder="请输入电阻率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="基低位发热量" prop="baseLowCalorific">
        <el-input
          v-model="queryParams.baseLowCalorific"
          placeholder="请输入基低位发热量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button  icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-dialog :title="title" :visible.sync="open1" width="1200px" append-to-body>
      <div style="width: 500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="煤采样编号" prop="coalNumber">
          <el-input v-model="form.coalNumber" style="width: 400px" disabled="true"/>
        </el-form-item>
        <el-form-item label="水分" prop="waterContent">
          <el-input v-model="form.waterContent" style="width: 400px" disabled="true"/>
        </el-form-item>
        <el-form-item label="灰分" prop="ashContent">
          <el-input v-model="form.ashContent" style="width: 400px" disabled="true"/>
        </el-form-item>
        <el-form-item label="挥发分" prop="coalVolatile">
          <el-input v-model="form.coalVolatile" style="width: 400px" disabled="true" />
        </el-form-item>
        <el-form-item label="密度" prop="density">
          <el-input v-model="form.density" style="width: 400px" disabled="true" />
        </el-form-item>
        <el-form-item label="电阻率" prop="resistivity">
          <el-input v-model="form.resistivity" style="width: 400px" disabled="true" />
        </el-form-item>
        <el-form-item label="基低位发热量" prop="baseLowCalorific">
          <el-input v-model="form.baseLowCalorific" style="width: 400px" disabled="true" />
        </el-form-item>
      </el-form>
      </div>
      <el-card class="box-card">
      <div style="width: 100%; height: 300px;" ref="exceptionBarChart" ></div>
      </el-card>
    </el-dialog>
<!--  <el-row :gutter="10" class="mb8">-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['system:indicators:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="success"-->
<!--          plain-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['system:indicators:edit']"-->
<!--        >修改</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="warning"-->
<!--          plain-->
<!--          icon="el-icon-download"-->
<!--          size="mini"-->
<!--          @click="handleExport"-->
<!--          v-hasPermi="['system:indicators:export']"-->
<!--        >导出</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="danger"-->
<!--          plain-->
<!--          icon="el-icon-delete"-->
<!--          size="mini"-->
<!--          :disabled="multiple"-->
<!--          @click="handleDelete"-->
<!--          v-hasPermi="['system:indicators:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
<!--      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>-->
<!--    </el-row>-->
    <div>
      <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
        <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
          运输采样指标记录
        </p>
      </div>
    </div>
    <el-tabs v-model="activeTab" ref="tabs" @tab-click="handleClick">
      <el-tab-pane label="运输前指标" name="first">
        <div ref="table1"  style="height: 400px;"></div>
      </el-tab-pane>
      <el-tab-pane label="运达后指标" name="second">
        <div ref="table2" style="height: 400px;"></div>
      </el-tab-pane>


    </el-tabs>
    <el-table v-model="table1" v-loading="loading" :data="indicatorsList" @selection-change="handleSelectionChange">
<!--      <el-table-column type="selection" width="55" align="center" />-->
      <el-table-column label="煤采样编号" align="center" prop="coalNumber" />
      <el-table-column label="水分" align="center" prop="waterContent" />
      <el-table-column label="灰分" align="center" prop="ashContent" />
      <el-table-column label="挥发分" align="center" prop="coalVolatile" />
      <el-table-column label="密度" align="center" prop="density" />
      <el-table-column label="电阻率" align="center" prop="resistivity" />
      <el-table-column label="基低位发热量" align="center" prop="baseLowCalorific" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:indicators:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-info"
            @click="getDetail(scope.row)"
          >详情</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:indicators:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="煤采样编号">
          <el-input v-model="form.coalNumber" placeholder="请输入煤采样编号"/>
        </el-form-item>
        <el-form-item label="水分">
          <el-input v-model="form.waterContent" placeholder="请输入水分"/>
        </el-form-item>
        <el-form-item label="灰分">
          <el-input v-model="form.ashContent" placeholder="请输入灰分"/>
        </el-form-item>
        <el-form-item label="挥发分" prop="coalVolatile">
          <el-input v-model="form.coalVolatile" placeholder="请输入挥发分" />
        </el-form-item>
        <el-form-item label="密度" prop="density">
          <el-input v-model="form.density" placeholder="请输入密度" />
        </el-form-item>
        <el-form-item label="电阻率" prop="resistivity">
          <el-input v-model="form.resistivity" placeholder="请输入电阻率" />
        </el-form-item>
        <el-form-item label="基低位发热量" prop="baseLowCalorific">
          <el-input v-model="form.baseLowCalorific" placeholder="请输入基低位发热量" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listIndicators, getIndicators, delIndicators, addIndicators, updateIndicators } from "@/api/system/indicators";
import * as echarts from 'echarts/core';
import { TitleComponent, LegendComponent } from 'echarts/components';
import { RadarChart } from 'echarts/charts';
import { CanvasRenderer } from 'echarts/renderers';

echarts.use([TitleComponent, LegendComponent, RadarChart, CanvasRenderer]);
export default {
  name: "Indicators",
  data() {
    return {
      activeTab: 'first',
      a:'',
      // 遮罩层
      loading: true,
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
      indicatorsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      open1: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        waterContent: null,
        ashContent: null,
        coalVolatile: null,
        density: null,
        resistivity: null,
        baseLowCalorific: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},

    };
  },


  mounted() {
    this.getList();

  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    /** 查询指标记录列表 */
    getList() {
      this.loading = true;
      listIndicators(this.queryParams).then(response => {
        this.indicatorsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        coalNumber: null,
        waterContent: null,
        ashContent: null,
        coalVolatile: null,
        density: null,
        resistivity: null,
        baseLowCalorific: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.coalNumber)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加指标记录";
      this.a='1'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.a='2'
      const coalNumber = row.coalNumber || this.ids
      getIndicators(coalNumber).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改指标记录";
      });
    },
    printchart(){
      var chartDom = document.getElementById('Chart');
      var myChart = echarts.init(chartDom);
      var option;
      option = {
        title: {
          text: '指标数据图'
        },
        legend: {
          data: ['Allocated Budget', 'Actual Spending']
        },
        radar: {
          // shape: 'circle',
          indicator: [
            { name: '水分', max: 10 },
            { name: '灰分', max: 25 },
            { name: '挥发分', max: 30 },
            { name: '密度', max: 5 },
            { name: '电阻率', max: 450 },
            { name: '基低位发热量', max: 5500 }
          ]
        },
        series: [
          {
            name: 'Budget vs spending',
            type: 'radar',
            data: [
              {
                value: [8.82, 23.28, 28.3, 3.97, 377, 4999],
                name: '指标数据'
              }
            ]
          }
        ]
      };

      option && myChart.setOption(option);
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.a === '2') {
            updateIndicators(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else if(this.a === '1') {
            addIndicators(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const coalNumbers = row.coalNumber || this.ids;
      this.$modal.confirm('是否确认删除煤采样编号为"' + coalNumbers + '"的数据项？').then(function() {
        return delIndicators(coalNumbers);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    getDetail(row) {

         // this.indicatorScore.capabilityId = response.rows[i].capabilityId
    //   //     this.indicatorScore.indicatorId = response.rows[i].indicatorId
    //   //     this.indicatorScore.score = response.rows[i].score
    //   //     this.indicatorScore.scoreId = response.rows[i].scoreId
    //   //     this.indicatorScore.taskId = response.rows[i].taskId
    //   //     this.indicatorList[i] = this.indicatorScore
    //   //   }
      const coalNumber = row.coalNumber || this.ids
      getIndicators(coalNumber).then(response => {
          this.form = response.data;
     this.open1 = true;
     this.title = "指标详情";
     this.printchart();
    });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/indicators/export', {
        ...this.queryParams
      }, `indicators_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
<style scoped lang="scss">
.box-card {
  margin: 1% 1%;
  width: 50%;
}
</style>
