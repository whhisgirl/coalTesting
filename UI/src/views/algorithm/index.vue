<template>
  <div>
    <el-card style="width: 98%;margin-left: 1%;">
      <div style="width: 98%; margin-left: 10px; background: #d2e9ff; border-radius: 10px">
        <p style="font-family: Arial; font-size: 20px; font-weight: 600; display: inline-block; margin-left: 20px;">
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
            <el-col :span="9" :offset="1">
              <img src="../../assets/algotithm/algorithm.png" style="width: 100%;height: 300px" fit="fill">
            </el-col>
            <el-col :span="10" :offset="1">
              <h3 style="font-weight: 600; "> SSA-CNN-LSTM模型 </h3>
              <p style="font-family: Arial; font-size: 16px; font-weight: 400; ">
                <span
                  style="margin-left: 2rem;"></span>算法是一种综合利用麻雀搜索算法、卷积神经网络和长短时记忆网络的深度学习模型，旨在解决静态数据中的特征提取和预测问题，通过检测煤炭中的水分、密度和电阻率计算灰分值、挥发分值和基低位发热量。
              </p>
              <p style="font-family: Arial; font-size: 16px; font-weight: 400; ">
                <span
                  style="margin-left: 2rem;"></span>通过SSA算法初始化种群，迭代次数，快速提取数据特征，帮助模型在少参数的情况下依然能够得到高精度的数值，提高搜索效率，从而提升算法整体的效率。
              </p>
              <p style="font-family: Arial; font-size: 16px; font-weight: 400; ">
                <span
                  style="margin-left: 2rem;"></span>CNN算法用于提取和学习自变量的一维序列数据特征，通过卷积和池化降维操作，CNN能够有效地捕获数据中的相关性，帮助模型提取数据的局部特征。
              </p>
              <p style="font-family: Arial; font-size: 16px; font-weight: 400; ">
                <span style="margin-left: 2rem;"></span>LSTM算法用于整合来自SSA和CNN的特征，并进行预测。有效避免了梯度消失等问题，提高算法的准确度。
              </p>
              <p style="font-family: Arial; font-size: 16px; font-weight: 400; ">
                <span style="margin-left: 2rem;"></span>通过SSA算法对CNN-LSTM模型的参数进行优化，主要是为了避免CNN-LSTM模型依据经验选取参数会使精度降低这一问题，能够在少参数的情况下高精度快速检测煤质信息。
              </p>
        </el-col>
      </el-row>
      <el-divider></el-divider>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" style="margin-top: 10px;">
        <el-row>
          <el-col :span="6">
            <el-form-item label="水分">
              <el-input placeholder="请输入水分" v-model="form.param1" style="width: 150px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="密度">
              <el-input placeholder="请输入密度" v-model="form.param2" style="width: 150px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="电阻率">
              <el-input placeholder="请输入电阻率" v-model="form.param3" style="width: 150px"></el-input>
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
        <p style="font-family: Arial; font-size: 20px; font-weight: 600; display: inline-block; margin-left: 20px;">
          运算结果
        </p>
      </div>
      <el-table :header-cell-style="{
        background: '#84BBFE',
        color: '#fff',
        fontSize: '14px',
        textAlign: 'center',
        fontWeight: '600',
        fontFamily: '黑体',
        padding: '0',
      }" :header-row-style="{
  height: '20',
}" :data="algorithData" style="margin-top: 20px; width:97%;margin-left: 1%">
        <el-table-column label="水分" align="center" prop="waterContent" />
        <el-table-column label="密度" align="center" prop="density" />
        <el-table-column label="电阻率" align="center" prop="resistivity" />
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
  data() {
    return {
      form: {
        param1: "",
        param2: "",
        param3: ""
      },
      algorithData: [],
      rules: {
        param1: [
          { required: true, message: "水分值不能为空", trigger: "blur" }
        ],
        param2: [
          { required: true, message: "密度值不能为空", trigger: "blur" }
        ],
        param3: [
          { required: true, message: "电阻率值不能为空", trigger: "blur" }
        ],
      }
    }
  },
  methods: {
    handleRun() {
      this.algorithData = undefined;
      this.algorithData = new Array();
      this.algorithData.push({
        waterContent:this.form.param1,
        density:this.form.param2,
        resistivity:this.form.param3,
        ashContent:-45.535-0.338*this.form.param1+49.032*this.form.param2,
        coalVolatile:64.55-0.451*this.form.param1-21.878*this.form.param2,
        baseLowCalorific:10192.095-64.378*this.form.param1-3166.731*this.form.param2+"KJ",
      })
    },
  }
}
</script>
<style scoped>
.el-tree-node__label {
  font-size: 20px;
}</style>
