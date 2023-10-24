<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="批次煤的重量" prop="batchCoalWeight">
        <el-input
          v-model="queryParams.batchCoalWeight"
          placeholder="请输入批次煤的重量"
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
      <el-form-item label="运输车辆车牌" prop="licensePlate">
        <el-input
          v-model="queryParams.licensePlate"
          placeholder="请输入运输车辆车牌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="矿区所在地" prop="locationMiningArea">
        <el-input
          v-model="queryParams.locationMiningArea"
          placeholder="请输入矿区所在地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出发时间" prop="startTime">
        <el-date-picker clearable
          v-model="queryParams.startTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出发时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="到达时间" prop="arrivalTime">
        <el-date-picker clearable
          v-model="queryParams.arrivalTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择到达时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="登记表编号" prop="registrationNumber">
        <el-input
          v-model="queryParams.registrationNumber"
          placeholder="请输入登记表编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="煤采样编号" prop="coalNumber">
        <el-input
          v-model="queryParams.coalNumber"
          placeholder="请输入煤采样编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="汽运目的地" prop="destination">
        <el-input
          v-model="queryParams.destination"
          placeholder="请输入汽运目的地"
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
          v-hasPermi="['system:batch:add']"
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
          v-hasPermi="['system:batch:edit']"
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
          v-hasPermi="['system:batch:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:batch:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="batchList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="批次编号" align="center" prop="batchNumber" />
      <el-table-column label="批次煤的重量" align="center" prop="batchCoalWeight" />
      <el-table-column label="矿区名称" align="center" prop="miningAreaName" />
      <el-table-column label="运输车辆车牌" align="center" prop="licensePlate" />
      <el-table-column label="矿区所在地" align="center" prop="locationMiningArea" />
      <el-table-column label="出发时间" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="到达时间" align="center" prop="arrivalTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.arrivalTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="登记表编号" align="center" prop="registrationNumber" />
      <el-table-column label="煤采样编号" align="center" prop="coalNumber" />
      <el-table-column label="汽运目的地" align="center" prop="destination" />
      <el-table-column label="到达状态" align="center" prop="arrivalStatus" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:batch:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:batch:remove']"
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
          <el-date-picker clearable
            v-model="form.startTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出发时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="到达时间" prop="arrivalTime">
          <el-date-picker clearable
            v-model="form.arrivalTime"
            type="date"
            value-format="yyyy-MM-dd"
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
  </div>
</template>

<script>
import { listBatch, getBatch, delBatch, addBatch, updateBatch } from "@/api/system/batch";

export default {
  name: "Batch",
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
      batchList: [],
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
      listBatch(this.queryParams).then(response => {
        this.batchList = response.rows;
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
        batchNumber: null,
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
      this.ids = selection.map(item => item.batchNumber)
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
      const batchNumber = row.batchNumber || this.ids
      getBatch(batchNumber).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.batchNumber != null) {
            updateBatch(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBatch(this.form).then(response => {
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
      const batchNumbers = row.batchNumber || this.ids;
      this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + batchNumbers + '"的数据项？').then(function() {
        return delBatch(batchNumbers);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/batch/export', {
        ...this.queryParams
      }, `batch_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
