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
              width="100">
            </el-table-column>
            <el-table-column
              prop="id"
              label="煤炭编号"
              width="100">
            </el-table-column>
            <el-table-column
              prop="shuifen1"
              label="第一次检测水分"
              width="120">
            </el-table-column>
            <el-table-column
              prop="shuifen2"
              label="第二次检测水分"
              width="120">
            </el-table-column>
            <el-table-column
              prop="huifen1"
              label="第一次检测灰分"
              width="120">
            </el-table-column>
            <el-table-column
              prop="huifen2"
              label="第二次检测灰分"
              width="120">
            </el-table-column>
            <el-table-column
              prop="midu1"
              label="第一次检测密度"
              width="120">
            </el-table-column>
            <el-table-column
              prop="midu2"
              label="第二次检测密度"
              width="120">
            </el-table-column>
            <el-table-column
              prop="huifafen1"
              label="第一次检测挥发分"
              width="130">
            </el-table-column>
            <el-table-column
              prop="huifafen2"
              label="第二次检测挥发分"
              width="130">
            </el-table-column>
            <el-table-column
              prop="dianzulv1"
              label="第一次检测电阻率"
              width="130">
            </el-table-column>
            <el-table-column
              prop="dianzulv2"
              label="第二次检测电阻率"
              width="130">
            </el-table-column>
            <el-table-column
              prop="jidi1"
              label="第一次检测基地位发热量"
              width="190">
            </el-table-column><el-table-column
            prop="jidi2"
            label="第二次检测基地位发热量"
            width="190">
          </el-table-column>
            <div class="block">
              <span class="demonstration">完整功能</span>
              <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currentPage4"
                :page-sizes="[100, 200, 300, 400]"
                :page-size="100"
                layout="total, sizes, prev, pager, next, jumper"
                :total="400">
              </el-pagination>
            </div>
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
import {listIndicators} from "@/api/system/indicators"

export default {
  name: "analyse",
  data() {
    return {
      tableData: [{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      },{
        number: '1',
        id: '2023',
        shuifen1: '8.84',
        shuifen2: '8.84',
        huifen1: '22.61',
        huifen2: '22.61',
        midu1: '1.4',
        midu2: '1.4',
        huifafen1: '28.31',
        huifafen2: '28.31',
        dianzulv1: '4',
        dianzulv2: '4',
        jidi1: '29.27',
        jidi2: '29.27',
      }]
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
            data:['2023水分','2023灰分','2023密度','2023挥发分','2023电阻率','2023基低位发热量','2024水分','2024灰分','2024密度','2024挥发分','2024电阻率','2024基低位发热量']
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
              data:[8.84,22.61,1.4,38.31,4,29.27,8.84,22.61,1.4,38.31,4,29.27],
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
