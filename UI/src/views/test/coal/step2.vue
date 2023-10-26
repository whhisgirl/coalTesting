<template>
  <div>
    <el-form style="margin-top: 5%;margin-left: 80px;margin-right: 80px;" label-width="100px">
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="批次煤的重量" prop="name">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="矿区名称" prop="man">
            <el-input v-model="form.man"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="运输车辆车牌" prop="name">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="矿区所在地" prop="man">
            <el-input v-model="form.man"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="出发时间" prop="date">
            <el-date-picker
              v-model="form.date"
              type="datetime"
              placeholder="选择日期时间" style="width:100%;">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
        <el-form-item label="到达时间" prop="date">
          <el-date-picker
            v-model="form.date"
            type="datetime"
            placeholder="选择日期时间" style="width:100%;">
          </el-date-picker>
        </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="汽运目的地" prop="name">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="到达状态" prop="man">
            <el-input v-model="form.man"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
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
  methods:{
  }
}
</script>
<style>
.el-row {
  margin-bottom: 30px;
}
</style>
