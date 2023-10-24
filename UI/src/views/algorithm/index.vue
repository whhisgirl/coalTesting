<template>
  <div>
    <el-card style="width: 98%;margin-left: 1%;">
      <div style="width: 98%; margin-left: 10px; background: #d2e9ff; border-radius: 10px">
        <p style="font-family: Arial; font-size: 20px; font-weight: 600; display: inline-block; margin-left: 20px;"
        >
          算法介绍：SSA-CNN-LSTM
        </p>
      </div>
      <el-row>
<!--        <el-col :span="6">-->
<!--          <el-card style="height: 800px">-->
<!--            <p style="font-family: Arial">SSA-CNN-LSTM算法</p>-->
<!--          </el-card>-->
<!--        </el-col>-->

        <el-col :span="24">
<!--          <div style="width: 98%; margin-left: 10px;margin-top: 10px; background: #d2e9ff; border-radius: 10px">-->
<!--            <p style="font-family: Arial; font-size: 20px; font-weight: 600; display: inline-block; margin-left: 20px;"-->
<!--            >-->
<!--              SSA-CNN-LSTM-->
<!--            </p>-->
<!--          </div>-->
          <el-row>
            <el-col :span="8" :offset="1">
              <p style="font-size: 24px;font-weight: bold">算法流程</p>
            </el-col>
            <el-col :span="15">
              <p style="font-size: 24px;font-weight: bold">算法简介</p>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8" :offset="1">
            </el-col>
            <el-col :span="15">
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <el-form ref="form" :model="form" label-width="80px" style="margin-top: 10px;">
            <el-row>
              <el-col :span="6">
                <el-form-item label="水分">
                  <el-input
                    placeholder="请输入水分"
                    v-model="form.param1"
                    style="width: 150px"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="密度">
                  <el-input
                    placeholder="请输入密度"
                    v-model="form.param2"
                    style="width: 150px"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="电阻率">
                  <el-input
                    placeholder="请输入电阻率"
                    v-model="form.param3"
                    style="width: 150px"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="4">
                <el-form-item>
                  <el-button type="primary" @click="handleRun()">预测</el-button>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
          <div style="width: 98%; margin-left: 10px; background: #d2e9ff; border-radius: 10px">
            <p style="font-family: Arial; font-size: 20px; font-weight: 600; display: inline-block; margin-left: 20px;"
            >
              运算结果
            </p>
          </div>
          <el-table
            :header-cell-style="{
                  background: '#84BBFE',
                  color: '#fff',
                  fontSize: '14px',
                  textAlign: 'center',
                  fontWeight: '600',
                  fontFamily: '黑体',
                  padding: '0',
              }"
            :header-row-style="{
                  height: '20',
              }"
            :data="algorithData"
            style="margin-top: 20px; width:97%;margin-left: 1%">
            <el-table-column label="水分" align="center" prop="waterContent"/>
            <el-table-column label="密度" align="center" prop="density" />
            <el-table-column label="电阻率" align="center" prop="resistivity"/>
            <el-table-column label="灰分" align="center" prop="ashContent" />
            <el-table-column label="挥发分" align="center" prop="coalVolatile" />
            <el-table-column label="基低位发热量" align="center" prop="baseLowCalorific" />
          </el-table>
        </el-col>
      </el-row>

    </el-card>
  </div>
</template>

<script>

export default {
  data(){
    return{
      form:{
        param1:"",
        param2:"",
        param3:""
      },
      algorithData:[],

    }
  },
  methods:{
    handleRun(){
    this.algorithData=undefined;
    this.algorithData=new Array();
      this.algorithData.push({
        waterContent:this.form.param1,
        density:this.form.param2,
        resistivity:this.form.param3,
        ashContent:this.form.param1*2,
        coalVolatile:this.form.param2*2,
        baseLowCalorific:this.form.param3*2+this.form.param2*2+this.form.param1*2,
      })
    },
  }
}
</script>
<style scoped>
.el-tree-node__label{
  font-size: 20px;
}
</style>
