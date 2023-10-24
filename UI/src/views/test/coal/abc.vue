<template>
  <div>
    <el-steps :active="active" align-center finish-status="success">
      <el-step title="采样信息录入"></el-step>
      <el-step title="煤炭批次记录"></el-step>
    </el-steps>
    <el-form id="input">
      <el-form-item label="采样时间" prop="date">
        <el-date-picker
          v-model="form.date"
          type="datetime"
          placeholder="选择日期时间" style="width:100%;">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="采样标准号" prop="code">
        <el-input v-model="form.code"></el-input>
      </el-form-item>
      <el-form-item label="样品粒度" prop="granularity">
        <el-input v-model="form.granularity"></el-input>
      </el-form-item>
      <el-form-item label="采样方式" prop="way">
        <el-input v-model="form.way"></el-input>
      </el-form-item>
      <el-form-item label="矿区名称" prop="name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="采样人" prop="man">
        <el-input v-model="form.man"></el-input>
      </el-form-item>
    </el-form>
    <el-button @click="before" v-if="isShowBefore">上一步</el-button>
    <el-button @click="next" v-if="isShowNext">下一步</el-button>
  </div>
</template>
<script>
export default {
  data() {
    return {
      active: 0,
      isShowBefore:true,
      isShowNext:true,
      form: {
        date: '',
        code:'',
        granularity:'',
        way: '',
        name:'',
        man:'',
      }
    }
  },
  mounted() {
    this.queryStatus()
  },
  methods: {
    next() {
      this.active++ ;
    },
    before() {
      this.active--;
    },
    queryStatus() {
      if(this.active==0){

      };
    }
  }
}
</script>
<style>
#input {
  width: 500px;
  margin-top:10px
}

</style>
