<template>

  <body>
  <header>
    <h1>煤炭指标分析</h1>
  </header>
  <div>
    <div class="divBox">
      <div class="left">
        <el-table
          :data="tableData"
          stripe
          style="width: auto">
          <el-table-column
            prop="number"
            label="序号"
            width="70">
          </el-table-column>
          <el-table-column
            prop="id"
            label="煤炭编号"
            width="100">
          </el-table-column>
          <el-table-column
            prop="shuifen"
            label="水分"
            width="70">
          </el-table-column>
          <el-table-column
            prop="huifen"
            label="灰分"
            width="70">
          </el-table-column>
          <el-table-column
            prop="midu"
            label="密度"
            width="70">
          </el-table-column>
          <el-table-column
            prop="huifafen"
            label="挥发分"
            width="70">
          </el-table-column>
          <el-table-column
            prop="dianzulv"
            label="电阻率"
            width="70">
          </el-table-column>
          <el-table-column
            prop="jidi"
            label="基地位发热量"
            width="120">
          </el-table-column>
        </el-table></div>
      <div class="right">
        <div  class="right" ref="chart" style="width: 1000px;height:500px">
        </div>
      </div>
    </div>
  </div>
  </body>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: "analyse",
  data() {
    return {
      tableData: [{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },{
        number: '1',
        id: '2023',
        shuifen: '8.84',
        huifen: '22.61',
        midu: '1.4',
        huifafen: '28.31',
        dianzulv: '4',
        jidi: '29.27'
      },]
    }
  },
  mounted() {
    this.getEchartData()
  },
  methods:{
    getEchartData(){
      const chart = this.$refs.chart
      if(chart){
        const myChart = echarts.init(chart)
        const option = { legend: {},
          xAxis:{
            type:'category',
            data:['水分','灰分','密度','挥发分','电阻率','基低位发热量']
          },
          yAxis:{
            type:'value'
          },
          series:[
            {
              data:[8.84,22.61,1.4,38.31,4,29.27],
              type:'bar'
            }
          ]
        };
        option && myChart.setOption(option);
      }
    }
  }
}

</script>
<style>
header {
  height: 50px;
  background-size: 100% 100%;
}

header h1 {
  position: absolute;
  top: 10px;
  left: 10px;
}

*{
  margin:0;
  padding: 0;
}
.divBox{
  height: 500px;
}
.left{
  float:left;
  width:640px;
  height: 100%;
}
.right{
  margin-left:290px;
  height: 100%;
  width: 900px;
}
</style>
