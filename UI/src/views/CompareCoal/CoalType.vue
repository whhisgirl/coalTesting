<template>
  <div>
    <el-card style="width: 95%;height:500px; margin-left: 30px; margin-top: 10px">
      <h2 id="control-3414428" style="font-weight: bold;display: flex;justify-content: center;align-items: center;">煤质分类结果</h2>
      <el-row>
        <el-col :span="12" style="height: 20rem">
          <el-card style="width: 95%; margin-right: 15px;margin-top: 10px">
            煤种分类标准
            <br>
            <br>
            <el-table :data="myCoalList">
              <el-table-column label="类别名称" align="center" prop="typeName" />
              <el-table-column label="发热量范围（MJ/kg）" align="center" prop="heatRange" />
            </el-table>
            <br>
            <br>
          </el-card>
        </el-col>
        <el-col :span="12" style="height: 20rem">
          <el-card style="width: 95%; margin-right: 15px;margin-top: 10px">
            运输前煤种分类结果
            <h2 style="color: red;font-weight: bold;display: flex;justify-content: center;align-items: center;">高发热量煤</h2>
          </el-card>
          <el-card style="width: 95%; margin-right: 15px;margin-top: 10px">
            运输后煤种分类结果
            <h2 style="color: red;font-weight: bold;display: flex;justify-content: center;align-items: center;">中发热量煤</h2>
          </el-card>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
  // import * as echarts from 'echarts'

  export default {
    name: 'CoalType',
    props:['CoalType'],
    data() {
      return {
        // 遮罩层
        loading: true,
        myCoalList: [
          {
            typeName: '高热值煤',
            heatRange: '>25.51'
          },
          {
            typeName: '中热值煤',
            heatRange: '22.41~25.50'
          },
          {
            typeName: '低热值煤',
            heatRange: '<22.40'
          }
        ]
      }
    },
    created() {},
    mounted() {
    },

    methods: {

    }
  }
</script>

<style lang="scss" scoped>
  .myTable {
    width: 100%;
    height: 50%;
  }
</style>

