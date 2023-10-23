<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="煤采样时间" prop="sampleTime">
        <el-date-picker clearable
          v-model="queryParams.sampleTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择煤采样时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="采样标准号" prop="standardNumber">
        <el-input
          v-model="queryParams.standardNumber"
          placeholder="请输入采样标准号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="样品粒度" prop="sampleStrength">
        <el-input
          v-model="queryParams.sampleStrength"
          placeholder="请输入样品粒度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采样方式" prop="samplingMethod">
        <el-input
          v-model="queryParams.samplingMethod"
          placeholder="请输入采样方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="矿区名称" prop="miningAreaName">
        <el-input
          v-model="queryParams.miningAreaName"
          placeholder="请输入矿区名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采样人" prop="sampler">
        <el-input
          v-model="queryParams.sampler"
          placeholder="请输入采样人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采样照片" prop="pictureBefore">
        <el-input
          v-model="queryParams.pictureBefore"
          placeholder="请输入采样照片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采样照片" prop="pictureAfter">
        <el-input
          v-model="queryParams.pictureAfter"
          placeholder="请输入采样照片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="报告生成时间" prop="reportTime">
        <el-date-picker clearable
          v-model="queryParams.reportTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择报告生成时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="检测标准号" prop="testStandardNumber">
        <el-input
          v-model="queryParams.testStandardNumber"
          placeholder="请输入检测标准号"
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
          v-hasPermi="['system:registration:add']"
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
          v-hasPermi="['system:registration:edit']"
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
          v-hasPermi="['system:registration:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:registration:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="registrationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="煤采样编号" align="center" prop="coalNumber" />
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
      <el-table-column label="采样照片" align="center" prop="pictureBefore" />
      <el-table-column label="采样照片" align="center" prop="pictureAfter" />
      <el-table-column label="报告生成时间" align="center" prop="reportTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.reportTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="检测标准号" align="center" prop="testStandardNumber" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:registration:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:registration:remove']"
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
        <el-form-item label="煤采样时间" prop="sampleTime">
          <el-date-picker clearable
            v-model="form.sampleTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择煤采样时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="采样标准号" prop="standardNumber">
          <el-input v-model="form.standardNumber" placeholder="请输入采样标准号" />
        </el-form-item>
        <el-form-item label="样品粒度" prop="sampleStrength">
          <el-input v-model="form.sampleStrength" placeholder="请输入样品粒度" />
        </el-form-item>
        <el-form-item label="采样方式" prop="samplingMethod">
          <el-input v-model="form.samplingMethod" placeholder="请输入采样方式" />
        </el-form-item>
        <el-form-item label="矿区名称" prop="miningAreaName">
          <el-input v-model="form.miningAreaName" placeholder="请输入矿区名称" />
        </el-form-item>
        <el-form-item label="采样人" prop="sampler">
          <el-input v-model="form.sampler" placeholder="请输入采样人" />
        </el-form-item>
        <el-form-item label="采样照片" prop="pictureBefore">
          <el-input v-model="form.pictureBefore" placeholder="请输入采样照片" />
        </el-form-item>
        <el-form-item label="采样照片" prop="pictureAfter">
          <el-input v-model="form.pictureAfter" placeholder="请输入采样照片" />
        </el-form-item>
        <el-form-item label="报告生成时间" prop="reportTime">
          <el-date-picker clearable
            v-model="form.reportTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择报告生成时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="检测标准号" prop="testStandardNumber">
          <el-input v-model="form.testStandardNumber" placeholder="请输入检测标准号" />
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
import { listRegistration, getRegistration, delRegistration, addRegistration, updateRegistration } from "@/api/system/registration";

export default {
  name: "Registration",
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
      registrationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        sampleTime: null,
        standardNumber: null,
        sampleStrength: null,
        samplingMethod: null,
        miningAreaName: null,
        sampler: null,
        pictureBefore: null,
        pictureAfter: null,
        reportTime: null,
        testStandardNumber: null
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
      listRegistration(this.queryParams).then(response => {
        this.registrationList = response.rows;
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
        sampleTime: null,
        standardNumber: null,
        sampleStrength: null,
        samplingMethod: null,
        miningAreaName: null,
        sampler: null,
        pictureBefore: null,
        pictureAfter: null,
        reportTime: null,
        testStandardNumber: null
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
      this.title = "添加【请填写功能名称】";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const coalNumber = row.coalNumber || this.ids
      getRegistration(coalNumber).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.coalNumber != null) {
            updateRegistration(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRegistration(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + coalNumbers + '"的数据项？').then(function() {
        return delRegistration(coalNumbers);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/registration/export', {
        ...this.queryParams
      }, `registration_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
