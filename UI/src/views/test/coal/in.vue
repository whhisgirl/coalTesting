<template>
  <el-main>
  <el-form :inline="true" :model="queryParams" class="demo-form-inline">
    <el-form-item label="采样方式">
      <el-input v-model="queryParams.samplingMethod"></el-input>
    </el-form-item>
    <el-form-item label="采样人">
      <el-input v-model="queryParams.sampler">
      </el-input>
    </el-form-item>
    <el-form-item label="采样时间">
    <el-date-picker
      v-model="queryParams.sampleTime"
      type="date"
      value-format="yyyy-MM-dd"
      placeholder="请选择煤采样时间">
    </el-date-picker>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">查询</el-button>
      <el-button type="primary" @click="cl">新增</el-button>
    </el-form-item>
  </el-form>

    <el-table v-loading="loading" :data=registrationList @selection-change="handleSelectionChange">

      <el-table-column label="煤采样时间" align="center" prop="sampleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.sampleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="采样标准号" align="center" prop="standardNumber" />
      <el-table-column label="样品粒度" align="center" prop="sampleStrength" />
      <el-table-column label="采样方式" align="center" prop="samplingMethod" />
      <el-table-column label="矿区名称" align="center" prop="miningAreaName" />
      <el-table-column label="采样人" align="center" prop="sampler" />
      <el-table-column label="批次煤的重量" align="center" prop="batchCoalWeight" />
      <el-table-column label="矿区所在地" align="center" prop="locationMiningArea" />
  </el-table>
    <el-pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList">
    </el-pagination>
  </el-main>
</template>

<script>
import {getAuthRole, updateAuthRole} from "@/api/system/user";
import { listCoal,getList } from "@/api/test/in"
  ;

export default {
  data() {
    return {
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
        pageSize: 10,
        sampleTime: null,
        standardNumber: null,
        sampleStrength: null,
        samplingMethod: null,
        miningAreaName: null,
        sampler: null,
        batchCoalWeight: null,
        locationMiningArea: null,
      },
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created(){
    this.getList()
  },
  methods: {
    getList() {
      this.loading = true;
      listCoal(this.queryParams).then(response => {
        this.registrationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    onSubmit() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    cl(){
    // this.$router.push({name: 'coal-abc'});
      this.$router.push({ path: "coal-abc" })
  },

    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    }
  },
}

</script>




