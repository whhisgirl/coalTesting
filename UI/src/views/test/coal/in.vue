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
      <el-table-column label="批次编号" align="center" prop="batchNumber"/>
      <el-table-column label="煤采样编号" align="center" prop="coalNumber"/>
      <el-table-column label="煤采样时间" align="center" prop="sampleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.sampleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="矿区名称" align="center" prop="miningAreaName"/>
      <el-table-column label="矿区所在地" align="center" prop="locationMiningArea"/>
      <el-table-column label="状态" align="center">
        <div slot-scope="scope">
          <el-button
            size="mini" :type="scope.row.arrivalStatus=='0'?'primary':''"
            :disabled="scope.row.arrivalStatus=='1'?true:false">未出发
          </el-button>
          <el-button
            size="mini" :type="scope.row.arrivalStatus=='1'?'primary':''"
            :disabled="scope.row.arrivalStatus=='0'?true:false">已送达
          </el-button>
        </div>
      </el-table-column>
      <el-table-column label="操作" align="center" prop="arrivalStatus">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="primary"
            class="el-icon-edit"
            @click="dialog"></el-button>
          <el-button
            size="mini" type="success" class="el-icon-document"
            @click="handleEdit(scope.$index, scope.row)"></el-button>
        </template>

      </el-table-column>
    </el-table>
    <el-pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList">
    </el-pagination>
    <el-dialog  title="登记详情" :visible.sync="dialogFormVisible" append-to-body>
      <el-form :model="t">
        <el-form-item label="活动名称" :label-width="formLabelWidth">
          <el-input v-model="t.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="活动区域" :label-width="formLabelWidth">
          <el-select v-model="t.region" placeholder="请选择活动区域">
            <el-option label="区域一" value="shanghai"></el-option>
            <el-option label="区域二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>
  </el-main>
</template>
<script>
import {getAuthRole, updateAuthRole} from "@/api/system/user";
import {listCoal, getList} from "@/api/test/in"
  ;

export default {
  data() {
    return {
      t:{
        name: '',
        region: '',
      },
      dialogFormVisible:false,
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
      rules: {}
    };
  },
  created() {
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
    cl() {
      // this.$router.push({name: 'coal-abc'});
      this.$router.push({path: "coal-abc"})
    },
    dialog(){
      this.dialogFormVisible=true;
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




