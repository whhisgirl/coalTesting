<template>
  <el-main>
    <el-form :inline="true" :model="queryParams" class="demo-form-inline">

      <el-form-item label="矿区名称">
        <el-input v-model="queryParams.miningAreaName">
        </el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="queryParams.arrivalStatus" clearable>
          <el-option v-for="item in options"
                     :key="item.value"
                     :label="item.label"
                     :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="采样时间">
        <el-date-picker
          v-model="st"
          type="datetimerange"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          value-format="yyyy-MM-dd hh:mm:ss"
          placeholder="请选择煤采样时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
        <el-button type="primary" @click="cl">新增</el-button>
      </el-form-item>
    </el-form>
    <div style="margin-bottom: 20px">
      <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
        <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
          煤样登记
        </p>
      </div>
    </div>
    <el-table v-loading="loading" :data=registrationList :default-sort="{prop: 'sampleTime', order: 'descending'}" @selection-change="handleSelectionChange">
      <el-table-column label="批次编号" align="center" prop="batchNumber"/>
      <el-table-column    label="煤采样编号" align="center" prop="coalNumber">
      <template slot-scope="{row}">
        <span   style="color:blue;cursor:pointer" @click="jump(row)">{{ row.coalNumber }}</span>
      </template>
      </el-table-column>
      <el-table-column label="煤采样时间" align="center" prop="sampleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.sampleTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="矿区名称" align="center" prop="miningAreaName"/>
      <el-table-column label="矿区所在地" align="center" prop="locationMiningArea"/>
      <el-table-column label="状态" align="center">
        <div slot-scope="scope">
          <el-button
            size="mini" :type="scope.row.arrivalStatus=='0'?'primary':''"
            :disabled="scope.row.arrivalStatus=='1'?true:false">运输中
          </el-button>
          <el-button
            size="mini" :type="scope.row.arrivalStatus=='1'?'primary':''"
            :disabled="scope.row.arrivalStatus=='0'?true:false">已送达
          </el-button>
        </div>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="primary"
            class="el-icon-check"
            v-if="scope.row.arrivalStatus==0"
            @click="handleUpdate(scope.row.coalNumber)" v-hasPermi="['test:coal:edit']"></el-button>
          <el-button
            size="mini" type="success" class="el-icon-document"
            @click="handleLook(scope.row.coalNumber)" v-hasPermi="['test:coal:query']"></el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :page-size="5"
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList">
    </el-pagination>
    <el-dialog  width=80% title="煤样登记详情" :visible.sync="dialogShow" append-to-body @selection-change="handleSelectionChange">
      <el-form :model="form">
        <el-row>
          <el-col :span="8" :offset="1">
        <el-form-item label="煤采样时间" :label-width="formLabelWidth" width="300px">
          <el-date-picker v-model="form.sampleTime" type="datetime" autocomplete="off"
                          value-format="yyyy-MM-dd hh:mm:ss"></el-date-picker>
        </el-form-item>
          </el-col>
          <el-col :span="8" :offset="4">
        <el-form-item label="样品粒度" :label-width="formLabelWidth">
          <el-input v-model="form.sampleStrength"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8" :offset="1">
        <el-form-item label="采样方法" :label-width="formLabelWidth">
          <el-input v-model="form.samplingMethod"></el-input>
        </el-form-item>
          </el-col>
          <el-col :span="8" :offset="4">
        <el-form-item label="矿区名称" :label-width="formLabelWidth">
          <el-input v-model="form.miningAreaName"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8" :offset="1">
        <el-form-item label="矿区所在地" :label-width="formLabelWidth">
          <el-input v-model="form.locationMiningArea"></el-input>
        </el-form-item>
          </el-col>
          <el-col :span="8" :offset="4">
        <el-form-item label="批次煤的重量" :label-width="formLabelWidth">
          <el-input v-model="form.batchCoalWeight"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8" :offset="1">
        <el-form-item label="车牌号码" :label-width="formLabelWidth">
          <el-input v-model="form.licensePlate"></el-input>
        </el-form-item>
          </el-col>
          <el-col :span="8" :offset="4">
        <el-form-item label="出发时间" :label-width="formLabelWidth">
          <el-input v-model="form.startTime"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8" :offset="1">
        <el-form-item label="目的地" :label-width="formLabelWidth">
          <el-input v-model="form.destination"></el-input>
        </el-form-item>
          </el-col>
          <el-col :span="8" :offset="4">
        <el-form-item label="采样人" :label-width="formLabelWidth">
          <el-input v-model="form.sampler"></el-input>
        </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="closeShow">返回</el-button>
      </div>
    </el-dialog>
  </el-main>
</template>
<script>
import {listCoal, getList, updateList} from "@/api/test/CoalList";

export default {
  data() {
    return {
      options: [{
        value: '0',
        label: '运输中'
      }, {
        value: '1',
        label: '已送达'

      }],
      dialogShow: false,
      st: [],
      formLabelWidth: '120px',
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
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      registrationList: [],
      queryParams: {
        pageNum: 1,
        pageSize: 5,
        batchNumber: null,
        coalNumber: null,
        beginTime: null,
        endTime: null,
        sampleTime: null,
        sampleStrength: null,
        samplingMethod: null,
        miningAreaName: null,
        sampler: null,
        batchCoalWeight: null,
        locationMiningArea: null,
        arrivalStatus: null,
      },
      form: {
        arrivalStatus: '',
      },
      // 表单校验
      rules: {}
    };
  },
  mounted() {
    this.getList()
  },
  methods: {
    closeShow() {
      this.dialogShow = false
    },
    remake() {
      this.form.arrivalStatus = "1";

    },
    handleUpdate(val) {
      const coalNumber = val;
      getList(coalNumber).then(response => {
         this.form = response.data;
         console.log(response.data);
        this.open = true;
        this.remake();
        updateList(this.form).then(response => {
          this.open = false;
          this.getList();
        });
      });
    },
    jump:function (row){
      let coalNumber = row.coalNumber;
      this.$router.push({path: "jump", query: {coalNumber: coalNumber}});
    },
    getList() {
      this.loading = true;
      if (this.st != null) {
        this.queryParams.beginTime = this.st[0]
        this.queryParams.endTime = this.st[1]
      } else {
        this.queryParams.beginTime = null
        this.queryParams.endTime = null
      }
      listCoal(this.queryParams).then(response => {
        this.registrationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    handleLook(val) {
      const coalNumber = val;
      getList(coalNumber).then(response => {
        this.form = response.data;
        this.open = true;
      })
      this.dialogShow = true;
      this.loading = false;
    },
    onSubmit() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    cl() {
      // this.$router.push({name: 'coal-abc'});
      this.$router.push({path: "coal-abc"})
    },
    handleSelectionChange(selection) {
      this.form.coalNumber = selection.map(item => item.coalNumber);
      this.single = selection.length != 1;
      this.multiple = !selection.length;
    },
    handleSizeChange(val) {
      this.currentPage = val;
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.queryParams.pageNum = val;
      this.getList();
    }
  },
}

</script>



