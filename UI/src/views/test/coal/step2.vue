<template>
  <div>
    <el-form style="margin-top: 5%;margin-left: 80px;margin-right: 80px;" label-width="100px">
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="批次编号" prop="batchNumber">
            <el-input v-model="form2.batchNumber"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="煤采样编号" prop="coalNumber">
            <el-input v-model="form2.coalNumber"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="运输车辆车牌" prop="licensePlate">
            <el-input v-model="form2.licensePlate"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="矿区所在地" prop="locationMiningArea">
            <el-input v-model="form2.locationMiningArea"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="出发时间" prop="startTime">
            <el-date-picker
              v-model="form2.startTime"
              type="datetime"
              placeholder="选择日期时间" style="width:100%;" value-format="yyyy-MM-dd hh:mm:ss">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
        <el-form-item label="矿区名称" prop="miningAreaName">
          <el-input v-model="form2.miningAreaName"></el-input>
        </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="批次煤重量" prop="batchCoalWeight">
            <el-input v-model="form2.batchCoalWeight"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="汽运目的地" prop="destination">
            <el-input  v-model="form2.destination"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
export default {
  name:"step2",
  data() {
    return {
      form2: {
        batchNumber: '',
        coalNumber: '',
        licensePlate: '',
        locationMiningArea: '',
        startTime: '',
        miningAreaName: '',
        batchCoalWeight:'',
        destination:'',
        arrivalStatus:'0',
      }
    }
  },
  methods:{ getVal(){
      return this.form2;
    }
  }
}
</script>
<style scoped>
.el-row {
  margin-bottom: 30px;
}
</style>
