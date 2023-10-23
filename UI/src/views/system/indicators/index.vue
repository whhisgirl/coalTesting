<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="挥发分" prop="volatile">
        <el-input
          v-model="queryParams.volatile"
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
          v-hasPermi="['system:indicators:add']"
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
          v-hasPermi="['system:indicators:edit']"
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
          v-hasPermi="['system:indicators:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:indicators:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="indicatorsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="煤采样编号" align="center" prop="coalNumber" />
      <el-table-column label="水分" align="center" prop="waterContent" />
      <el-table-column label="灰分" align="center" prop="ashContent" />
      <el-table-column label="挥发分" align="center" prop="volatile" />
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

    <!-- 添加或修改指标结果记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="水分">
          <editor v-model="form.waterContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="灰分">
          <editor v-model="form.ashContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="挥发分" prop="volatile">
          <el-input v-model="form.volatile" placeholder="请输入挥发分" />
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

export default {
  name: "Indicators",
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
      // 指标结果记录表格数据
      indicatorsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        waterContent: null,
        ashContent: null,
        volatile: null,
        density: null,
        resistivity: null,
        baseLowCalorific: null
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
    /** 查询指标结果记录列表 */
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
        volatile: null,
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
      this.title = "添加指标结果记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const coalNumber = row.coalNumber || this.ids
      getIndicators(coalNumber).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改指标结果记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.coalNumber != null) {
            updateIndicators(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
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
      this.$modal.confirm('是否确认删除指标结果记录编号为"' + coalNumbers + '"的数据项？').then(function() {
        return delIndicators(coalNumbers);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
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
