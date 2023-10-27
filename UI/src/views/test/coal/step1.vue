<template>
  <div>
    <el-form style="margin-top: 5%;margin-left: 80px;margin-right: 80px;" label-width="100px">
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="采样时间" prop="date">
            <el-date-picker
              v-model="form.date"
              type="datetime"
              placeholder="选择日期时间" style="width:100%;">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="采样标准号" prop="code">
            <el-input v-model="form.code" width="100px"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="样品粒度" prop="granularity">
            <el-input v-model="form.granularity"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="采样方式" prop="way">
            <el-input v-model="form.way"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="矿区名称" prop="name">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="采样人" prop="man">
            <el-input v-model="form.man"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <el-row type="flex" :gutter="280" justify="space-around">
      <el-col :span="8">
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      current: 0,
      form: {
        date: '',
        code: '',
        granularity: '',
        way: '',
        name: '',
        man: '',
      }
    }
  },
  methods: {

}
}
</script>
<style scoped>
.el-row {
  margin-bottom: 30px;
}
</style>
