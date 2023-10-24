<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="司机姓名" prop="driverName">
        <el-input
          v-model="queryParams.driverName"
          placeholder="请输入司机姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车牌号" prop="driverLicensePlate">
        <el-input
          v-model="queryParams.driverLicensePlate"
          placeholder="请输入车牌号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="司机年龄" prop="driverAge">
        <el-input
          v-model="queryParams.driverAge"
          placeholder="请输入司机年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="司机驾龄" prop="driverExperience">
        <el-input
          v-model="queryParams.driverExperience"
          placeholder="请输入司机驾龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="司机信用" prop="driverCredit">
        <el-input
          v-model="queryParams.driverCredit"
          placeholder="请输入司机信用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车型" prop="vehicleModel">
        <el-input
          v-model="queryParams.vehicleModel"
          placeholder="请输入车型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="荷载" prop="vehicleLoad">
        <el-input
          v-model="queryParams.vehicleLoad"
          placeholder="请输入荷载"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车辆使用时间" prop="vehicleUsageTime">
        <el-input
          v-model="queryParams.vehicleUsageTime"
          placeholder="请输入车辆使用时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:information:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:information:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:information:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:information:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="informationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="司机姓名" align="center" prop="driverName" />
      <el-table-column label="车牌号" align="center" prop="driverLicensePlate" />
      <el-table-column label="司机年龄" align="center" prop="driverAge" />
      <el-table-column label="司机驾龄" align="center" prop="driverExperience" />
      <el-table-column label="司机信用" align="center" prop="driverCredit" />
      <el-table-column label="车型" align="center" prop="vehicleModel" />
      <el-table-column label="荷载" align="center" prop="vehicleLoad" />
      <el-table-column label="车辆使用时间" align="center" prop="vehicleUsageTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:information:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:information:remove']"
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
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="司机姓名" prop="driverName">
          <el-input v-model="form.driverName" placeholder="请输入司机姓名" />
        </el-form-item>
        <el-form-item label="车牌号" prop="driverLicensePlate">
          <el-input v-model="form.driverLicensePlate" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="司机年龄" prop="driverAge">
          <el-input v-model="form.driverAge" placeholder="请输入司机年龄" />
        </el-form-item>
        <el-form-item label="司机驾龄" prop="driverExperience">
          <el-input v-model="form.driverExperience" placeholder="请输入司机驾龄" />
        </el-form-item>
        <el-form-item label="司机信用" prop="driverCredit">
          <el-input v-model="form.driverCredit" placeholder="请输入司机信用" />
        </el-form-item>
        <el-form-item label="车型" prop="vehicleModel">
          <el-input v-model="form.vehicleModel" placeholder="请输入车型" />
        </el-form-item>
        <el-form-item label="荷载" prop="vehicleLoad">
          <el-input v-model="form.vehicleLoad" placeholder="请输入荷载" />
        </el-form-item>
        <el-form-item label="车辆使用时间" prop="vehicleUsageTime">
          <el-input v-model="form.vehicleUsageTime" placeholder="请输入车辆使用时间" />
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
import { listInformation, getInformation, delInformation, addInformation, updateInformation } from "@/api/system/information";

export default {
  name: "Information",
  data() {
    return {
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
      informationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        driverName: null,
        driverLicensePlate: null,
        driverAge: null,
        driverExperience: null,
        driverCredit: null,
        vehicleModel: null,
        vehicleLoad: null,
        vehicleUsageTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listInformation(this.queryParams).then(response => {
        this.informationList = response.rows;
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
        id: null,
        driverName: null,
        driverLicensePlate: null,
        driverAge: null,
        driverExperience: null,
        driverCredit: null,
        vehicleModel: null,
        vehicleLoad: null,
        vehicleUsageTime: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加【请填写功能名称】";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInformation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInformation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInformation(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + ids + '"的数据项？').then(function() {
        return delInformation(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/information/export', {
        ...this.queryParams
      }, `information_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
