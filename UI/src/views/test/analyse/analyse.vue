<template>
  <body>
  <header>
    <h1>煤炭指标分析</h1>
  </header>
  <div>
    <el-breadcrumb separator="/">
      <div class="el-card__body">
      <div class="divBox">
        <div class="top">
          <el-table
            :data="tableData"
            height="500"
            border
            style="width: 100%">
            <el-table-column
              prop="number"
              label="序号"
              width="50">
            </el-table-column>
            <el-table-column
              prop="id"
              label="煤炭编号"
              width="120">
            </el-table-column>
            <el-table-column
              prop="shuifen1"
              label="第一次的水分(%)"
              width="120">
            </el-table-column>
            <el-table-column
              prop="shuifen2"
              label="第二次的水分(%)"
              width="120">
            </el-table-column>
            <el-table-column
              prop="huifen1"
              label="第一次的灰分(%)"
              width="120">
            </el-table-column>
            <el-table-column
              prop="huifen2"
              label="第二次的灰分(%)"
              width="120">
            </el-table-column>
            <el-table-column
              prop="midu1"
              label="第一次的密度(g/cm³)"
              width="150">
            </el-table-column>
            <el-table-column
              prop="midu2"
              label="第二次的密度(g/cm³)"
              width="150">
            </el-table-column>
            <el-table-column
              prop="huifafen1"
              label="第一次的挥发分(%)"
              width="140">
            </el-table-column>
            <el-table-column
              prop="huifafen2"
              label="第二次的挥发分(%)"
              width="140">
            </el-table-column>
            <el-table-column
              prop="dianzulv1"
              label="第一次的电阻率(100Ω·m)"
              width="180">
            </el-table-column>
            <el-table-column
              prop="dianzulv2"
              label="第二次的电阻率(100Ω·m)"
              width="180">
            </el-table-column>
            <el-table-column
              prop="jidi1"
              label="第一次的发热量(MJ/kg)"
              width="170">
            </el-table-column><el-table-column
             prop="jidi2"
             label="第二次的发热量(MJ/kg)"
             width="170">
          </el-table-column>
          </el-table></div>
        <div class="bottom">
          <el-col span="22">
          <div  ref="chart" style="width: 100%;height:500px">
          </div>
          </el-col>
        </div>
      </div>
      </div>
    </el-breadcrumb>
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
        id: 'C2023092503',
        shuifen1: '8.82',
        shuifen2: '8.48',
        huifen1: '23.28',
        huifen2: '23.92',
        midu1: '3.97',
        midu2: '4.13',
        huifafen1: '28.30',
        huifafen2: '28.11',
        dianzulv1: '3.77',
        dianzulv2: '3.81',
        jidi1: '49.99',
        jidi2: '49.35',
      },{
        number: '2',
        id: 'C2023092702',
        shuifen1: '8.62',
        shuifen2: '8.43',
        huifen1: '23.15',
        huifen2: '21.50',
        midu1: '3.85',
        midu2: '3.93',
        huifafen1: '28.60',
        huifafen2: '28.33',
        dianzulv1: '3.86',
        dianzulv2: '3.93',
        jidi1: '50.68',
        jidi2: '50.26',
      },{
        number: '3',
        id: 'C2023100301',
        shuifen1: '9.18',
        shuifen2: '9.38',
        huifen1: '21.61',
        huifen2: '21.51',
        midu1: '3.76',
        midu2: '4.05',
        huifafen1: '28.05',
        huifafen2: '28.81',
        dianzulv1: '3.95',
        dianzulv2: '4.09',
        jidi1: '49.61',
        jidi2: '51.35',
      },{
        number: '4',
        id: 'C2023100501',
        shuifen1: '8.83',
        shuifen2: '8.14',
        huifen1: '23.21',
        huifen2: '22.82',
        midu1: '3.87',
        midu2: '4.10',
        huifafen1: '28.11',
        huifafen2: '28.90',
        dianzulv1: '4.02',
        dianzulv2: '4.05',
        jidi1: '50.53',
        jidi2: '48.36',
      },{
        number: '5',
        id: 'C2023100802',
        shuifen1: '8.12',
        shuifen2: '8.36',
        huifen1: '22.77',
        huifen2: '22.66',
        midu1: '4.31',
        midu2: '3.86',
        huifafen1: '28.39',
        huifafen2: '29.43',
        dianzulv1: '4.06',
        dianzulv2: '4.04',
        jidi1: '49.44',
        jidi2: '50.21',
      },{
        number: '6',
        id: 'C2023101001',
        shuifen1: '8.13',
        shuifen2: '9.32',
        huifen1: '22.34',
        huifen2: '23.01',
        midu1: '4.21',
        midu2: '3.99',
        huifafen1: '28.33',
        huifafen2: '29.03',
        dianzulv1: '3.88',
        dianzulv2: '4.12',
        jidi1: '49.27',
        jidi2: '49.36',
      },{
        number: '7',
        id: 'C2023101503',
        shuifen1: '8.19',
        shuifen2: '9.22',
        huifen1: '22.21',
        huifen2: '22.91',
        midu1: '4.11',
        midu2: '3.89',
        huifafen1: '28.36',
        huifafen2: '29.01',
        dianzulv1: '3.89',
        dianzulv2: '4.10',
        jidi1: '49.29',
        jidi2: '49.46',
      },{
        number: '8',
        id: 'C2023101804',
        shuifen1: '8.21',
        shuifen2: '9.02',
        huifen1: '22.04',
        huifen2: '23.03',
        midu1: '4.01',
        midu2: '3.79',
        huifafen1: '28.03',
        huifafen2: '29.06',
        dianzulv1: '3.98',
        dianzulv2: '4.01',
        jidi1: '49.77',
        jidi2: '49.86',
      },{
        number: '9',
        id: 'C2023101903',
        shuifen1: '8.88',
        shuifen2: '9.13',
        huifen1: '22.44',
        huifen2: '23.11',
        midu1: '4.23',
        midu2: '3.79',
        huifafen1: '28.21',
        huifafen2: '29.79',
        dianzulv1: '3.78',
        dianzulv2: '4.22',
        jidi1: '49.17',
        jidi2: '49.17',
      },{
        number: '10',
        id: 'C2023101904',
        shuifen1: '8.88',
        shuifen2: '9.13',
        huifen1: '22.44',
        huifen2: '23.11',
        midu1: '4.23',
        midu2: '3.79',
        huifafen1: '28.21',
        huifafen2: '29.79',
        dianzulv1: '3.78',
        dianzulv2: '4.22',
        jidi1: '49.17',
        jidi2: '49.17',
      },{
        number: '11',
        id: 'C2023102105',
        shuifen1: '8.88',
        shuifen2: '9.13',
        huifen1: '22.44',
        huifen2: '23.11',
        midu1: '4.23',
        midu2: '3.79',
        huifafen1: '28.21',
        huifafen2: '29.79',
        dianzulv1: '3.78',
        dianzulv2: '4.22',
        jidi1: '49.17',
        jidi2: '49.17',
      },]
    }
  },
  mounted() {
    this.getEchartData();
  },
 methods:{
    getEchartData(){
      const chart = this.$refs.chart
      if(chart){
        const myChart = echarts.init(chart)
        const option = {
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              crossStyle: {
                color: '#999'
              }
            }
          },
          legend: {
            data:['第一次检测','第二次检测']
          },
          dataZoom: [
            {
              type: 'inside'
            },
            {
              type: 'slider'
            }
          ],
          xAxis:{
            show:false,
            type:'category',
            axisPointer: {
              type: 'shadow'
            },

            axisTick:{
              alignWithLabel: true
            },
            data:['C2023092503水分',
              'C2023092503灰分',
              'C2023092503密度',
              'C2023092503挥发分',
              'C2023092503电阻率',
              'C2023092503基低位发热量',

              'C2023092702水分',
              'C2023092702灰分',
              'C2023092702密度',
              'C2023092702挥发分',
              'C2023092702电阻率',
              'C2023092702基低位发热量',

              'C2023100301水分',
              'C2023100301灰分',
              'C2023100301密度',
              'C2023100301挥发分',
              'C2023100301电阻率',
              'C2023100301基低位发热量',

              'C2023100501水分',
              'C2023100501灰分',
              'C2023100501密度',
              'C2023100501挥发分',
              'C2023100501电阻率',
              'C2023100501基低位发热量',

              'C2023100802水分',
              'C2023100802灰分',
              'C2023100802密度',
              'C2023100802挥发分',
              'C2023100802电阻率',
              'C2023100802基低位发热量',

              'C2023101001水分',
              'C2023101001灰分',
              'C2023101001密度',
              'C2023101001挥发分',
              'C2023101001电阻率',
              'C2023101001基低位发热量',

              'C2023101503水分',
              'C2023101503灰分',
              'C2023101503密度',
              'C2023101503挥发分',
              'C2023101503电阻率',
              'C2023101503基低位发热量',

              'C2023101804水分',
              'C2023101804灰分',
              'C2023101804密度',
              'C2023101804挥发分',
              'C2023101804电阻率',
              'C2023101804基低位发热量',

              'C2023101903水分',
              'C2023101903灰分',
              'C2023101903密度',
              'C2023101903挥发分',
              'C2023101903电阻率',
              'C2023101903基低位发热量',

              'C2023101904水分',
              'C2023101904灰分',
              'C2023101904密度',
              'C2023101904挥发分',
              'C2023101904电阻率',
              'C2023101904基低位发热量',

              'C2023102105水分',
              'C2023102105灰分',
              'C2023102105密度',
              'C2023102105挥发分',
              'C2023102105电阻率',
              'C2023102105基低位发热量',]
          },
          yAxis:[{
            type:'value',
            position:'left',
            alignTicks:true,
            axisLine:{
              show:false,
            }
          },
            {
              type:'value',
              position:'right',
              alignTicks:true,
              axisLine:{
                show:false,
              }
            }],
          series:[
            {
              name:'第一次检测',
              type:'bar',
              data:[8.82,23.28,3.97,28.30,3.77,49.99,8.62,23.15,3.85,28.60,3.86,50.68,9.18,21.61,3.76,28.05,3.95,49.61,8.83,23.21,3.87,28.11,4.02,50.53,8.12,],
            },
            {
              name:'第二次检测',
              type:'bar',
              data:[8.84,22.61,1.4,38.31,4,29.27,8.84,22.61,1.4,38.31,4,29.27],
            }
          ]
        };
        //echarts图跟随变化
        window.addEventListener("resize", function () {
          myChart.resize();
        });
        option && myChart.setOption(option);
      }
    }
  }
}

</script>
<style scoped>
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
  height: 1200px;
}
.top{
  position: absolute;
  float:left;
  width:1825px;
  height: 100%;
}
.bottom{
  position: absolute;
  top:650px;
  height: 100%;
  width: 2000px;
}
</style>
