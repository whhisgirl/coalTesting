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
        <el-col :span="24">

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
              <img :span="8"  src="../../assets/algotithm/algorithm.png" style="width: 450px;height: 300px" fit="fill">
            </el-col>
            <el-col :span="15">
              <p style="font-family: Arial; font-size: 16px; font-weight: 600; "
              >
                SSA-CNN-LSTM算法是一种综合利用频域分析、卷积神经网络和长短时记忆网络的深度学习模型，旨在解决静态数据中的特征提取和预测问题，如本煤炭质检问题中的水分、密度和导电率等自变量与目标变量煤炭属性，如灰分、挥发分、热值等的关系建模。
                麻雀搜索算法(SSA)：
                Convolutional Neural Network (CNN)：CNN是第二部分，用于提取自变量的空域特征。通过卷积和池化操作，CNN能够有效地捕获数据中的空间相关性，对于煤炭质检，这可以帮助模型理解各自变量之间的复杂关系。
                Long Short-Term Memory (LSTM)：LSTM构成了算法的最后一部分，它用于整合来自SSA和CNN的特征，并进行预测。在这里，LSTM可以用来处理水分、密度和导电率的变化对灰分、挥发分和热值的影响，即模型的建模和预测。
                SSA-CNN-LSTM算法的关键创新在于引入了频域分析和空域特征提取，同时具备LSTM的长短时记忆能力。这使得它能够有效地建模非平稳时间序列数据，也能用于静态数据分析。在煤炭质检中，它有潜力提供更准确和可靠的煤炭属性预测，有助于提高质检的精度和效率。
              </p>
            </el-col>
          </el-row>
          <el-divider></el-divider>
          <el-form ref="form" :model="form" :rules="rules" label-width="80px" style="margin-top: 10px;">
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
      rules: {
        param1: [
          {required: true, message: "水分值不能为空", trigger: "blur"}
        ],
        param2: [
          {required: true, message: "密度值不能为空", trigger: "blur"}
        ],
        param3: [
          {required: true, message: "电阻率值不能为空", trigger: "blur"}
        ],
      }
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
        baseLowCalorific:this.form.param3*2+this.form.param2*2+this.form.param1*2+"KJ",
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
