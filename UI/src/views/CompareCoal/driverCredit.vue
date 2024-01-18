<template>
  <el-main>
    <el-form :inline="true" class="demo-form-inline">

      <el-form-item label="姓名">
        <el-input v-model="driverName">
        </el-input>
      </el-form-item>
      <el-form-item label="信用分">
        <el-input v-model="creditNumber">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
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
          司机信用
        </p>
      </div>
    </div>
    <el-table :data="tableData">
      <el-table-column label="司机姓名" align="center" prop="driveName"/>
      <el-table-column label="车牌号" align="center" prop="driverLicense">
      </el-table-column>
      <el-table-column label="信用分" align="center" prop="number" width="180">
      </el-table-column>
      <el-table-column label="状态" align="center" prop="state" width="180">
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button
            size="mini" type="success"
            @click="handleLook()">详情
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :page-size="5"
      v-show="total>0"
      :total="1"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList">
    </el-pagination>

    <el-dialog width=80% title="司机信用详情" :visible.sync="dialogShow" append-to-body
               @selection-change="handleSelectionChange">
      <el-form :model="form">
        <el-row style="margin-top:10px;margin-bottom:20px;">
          <el-col :span="8" :offset="1">
            <el-form-item label="司机姓名" :label-width="formLabelWidth" width="300px">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8" :offset="4">
            <el-form-item label="车牌号" :label-width="formLabelWidth">
              <el-input v-model="form.driverLicense"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8" :offset="1">
            <el-form-item label="信用分" :label-width="formLabelWidth">
              <el-input v-model="form.number"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8" :offset="4">
            <el-form-item label="异常记录" :label-width="formLabelWidth">
              <el-input v-model="form.record"></el-input>
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
      tableData: [{
        driveName: '赵天明',
        driverLicense: '晋H 5D553',
        number: '80',
        state:'教育整改中',
      }],


      driverName: "",
      creditNumber: "",
      options: [{
        value: '0',
        label: '运输中'
      }, {
        value: '1',
        label: '已送达'

      }],
      dialogShow: false,
      st: [],
      formLabelWidth: '80px',
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
        name:'赵天明',
        driverLicense: '晋H 5D553',
        number: '80',
        record:'2023-09-21 忻州宏远矿区煤质运输异常',
      },
      // 表单校验
      rules: {}
    };
  },
  mounted() {
    this.getList()
  },
  methods: {
    //设置按钮不能点击
    setButton() {
      $('myButton').attr('disabled', true);
    },
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
    jump3(val) {
      // let coalNumber = row.coalNumber;
      console.log("val", val);
      const coalNumber = val.coalNumber;
      console.log("arrivalStatus", val.arrivalStatus);
      if (val.arrivalStatus === '0') {
        this.$router.push({path: "coalClassification", query: {coalNumber: coalNumber}});
      } else if (val.arrivalStatus === '1') {
        this.$router.push({path: "jump", query: {coalNumber: coalNumber}});
      }
    },
    jump(val) {
      // let coalNumber = row.coalNumber;
      const coalNumber = val;
      this.$router.push({path: "jump", query: {coalNumber: coalNumber}});
    },
    jump2(val) {
      let coalNumber = val.coalNumber;
      this.$router.push({path: "coalClassification", query: {coalNumber: coalNumber}});
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
        console.log('response', response);
        for (let i in response.rows) {
          if (i.arrivalStatus == '0') {
            $('myButton').attr('disabled', true);
          }
        }
        this.registrationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    handleLook() {
      this.open = true;
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



