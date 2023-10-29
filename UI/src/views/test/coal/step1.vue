<template>
  <div>
    <el-form style="margin-top: 5%;margin-left: 80px;margin-right: 80px;" label-width="100px">
      <el-row>
<!--        <el-col :span="8" :offset="1">-->
<!--          <el-form-item label="煤采样编号" prop="coalNumber">-->
<!--            <el-input v-model="form1.coalNumber" width="100px"></el-input>-->
<!--          </el-form-item>-->
<!--        </el-col>-->
<!--        <el-col :span="8" :offset="4">-->
<!--          <el-form-item label="采样时间" prop="sampleTime">-->
<!--            <el-date-picker-->
<!--              v-model="form1.sampleTime"-->
<!--              type="datetime"-->
<!--              placeholder="选择日期时间" style="width:100%;"-->
<!--              value-format="yyyy-MM-dd hh:mm:ss">-->
<!--            </el-date-picker>-->
<!--          </el-form-item>-->
<!--        </el-col>-->
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="采样标准号" prop="standardNumber">
            <el-input v-model="form1.standardNumber" width="100px"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="样品粒度" prop="sampleStrength">
            <el-input v-model="form1.sampleStrength"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="采样方式" prop="samplingMethod">
            <el-input v-model="form1.samplingMethod"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="矿区名称" prop="miningAreaName">
            <el-input v-model="form1.miningAreaName"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="采样人" prop="sampler">
            <el-input v-model="form1.sampler"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="采样时间" prop="sampleTime">
            <el-date-picker
              v-model="form1.sampleTime"
              type="datetime"
              placeholder="选择日期时间" style="width:100%;"
              value-format="yyyy-MM-dd hh:mm:ss">
            </el-date-picker>
          </el-form-item>
        </el-col>
<!--        <el-col :span="8" :offset="4">-->
<!--            <el-form-item label="到达状态" prop="status">-->
<!--              <el-input  disabled v-model="status"></el-input>-->
<!--            </el-form-item>-->
<!--        </el-col>-->
      </el-row>
    </el-form>
  </div>
</template>
<script>
export default {
  name:"step1",
  data() {
    return {
      status:'未出发',
      current: 0,
      form1: {
        coalNumber: '',
        sampleTime: '',
        standardNumber: '',
        sampleStrength: '',
        samplingMethod:'',
        sampler: '',
        miningAreaName:'',
        pictureBefore: null,
        pictureAfter: null,
        reportTime: null,
        testStandardNumber: null
      }
    }
  },
  methods: {
    getVal(){
      return this.form1;
    }
}
}
</script>
<style scoped>
.el-row {
  margin-bottom: 30px;
}
</style>
