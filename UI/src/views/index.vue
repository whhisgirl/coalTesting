<template>
  <div id="index" ref="appRef" class="all" :style="defaultHeight">
    <div class="bg">
      <dv-loading v-show="loading">Loading...</dv-loading>
      <div class="host-body">
        <div class="head">
          <el-row>
            <el-col :span="6">
              <div class="title_left">
                <el-button class="bhover"  style="margin-left: 100px;" @click="handletest()">煤质快速检测</el-button>
                <el-button class="bhover"  style="margin-left: 100px;margin-right: 10px;"@click="handleContrast()">煤质对比分析</el-button>
              </div>
            </el-col>
            <el-col :span="12"
            > <h1 style=" font-size: 22px; color: white; font-weight: 700; margin-top: 30px; background-color: rgba(0, 0, 0, 0);">快速煤质检测分析平台</h1>
            </el-col>
            <el-col :span="6">
              <div class="title_right">
                <el-button class="bhover" style="margin-right: 100px;." @click="handleReport()">检测报告生成</el-button>
                <el-button class="bhover" style="margin-right: 100px;" @click="handleAlgorithm()">算法介绍</el-button>
              </div>
            </el-col>
          </el-row>
          </div>
          <!-- 主体部分 -->
<!--        第一行-->
          <el-row>
            <!-- 第一列 -->
            <el-col :span="7">
              <el-card class="box-card" shadow="hover" style="height: 450px;">
              <div
                id="left1"
                key="left1"
        style="height: 445px"
              ></div>
              </el-card>
            </el-col>
            <!-- 第二列 -->
            <el-col :span="10">
              <el-card class="box-card" style="height: 150px;background-color:rgb(48,65,86);">
                <div class="oneRowTwoCol">
                  <p style="text-align: center;color: white;font-size: 20px; ">本年度发运异常批次情况</p>
                  <!--<el-card style="margin-top: 12px;padding: 0px;height: 100px;background-color:rgb(48,65,86);">-->
                    <el-row style="margin-top: 0px;height: 5px;margin-top: 10px;">
                      <el-col span="8">
                        <!--<p style="text-align: center;color: rgb(112,137,212);font-size:22px;max-height: 5px"><b><scroll-number :val="caseNum" style="color: rgb(112,137,212);"></scroll-number></b></p>-->
                        <p style="text-align: center;color: rgb(112,137,212);font-size:22px;max-height: 5px"><b>379</b></p>
                      </el-col>
                      <el-col span="8">
                        <!--<p style="text-align: center;color: red ;font-size: 22px;"><b><scroll-number :val="faultNum" style="text-align: center;color: red"></scroll-number></b></p>-->
                        <p style="text-align: center;color: red;font-size:22px;max-height: 5px"><b>62</b></p>
                      </el-col>
                      <el-col span="8">
                        <!--<p style="text-align: center;color: #97694F ;font-size: 22px;"><b><scroll-number :val="typeNum" style="text-align: center;color: #97694F"></scroll-number></b></p>-->
                        <p style="text-align: center;color: #97694F ;font-size: 22px;"><b>317</b></p>
                      </el-col>
                    </el-row>
                    <el-row>
                      <!--<div style="margin-top: 8px">-->
                        <!--<el-row >-->
                          <el-col span="8">
                            <p style="text-align: center;color: rgb(112,137,212);font-size: 22px;font-weight: 700;">批次总数</p>
                          </el-col>
                          <el-col span="8">
                            <p style="text-align: center;color: red ;font-size: 22px;font-weight: 700; ">异常批次</p>
                          </el-col>
                          <el-col span="8">
                            <p style="text-align: center;color: #97694F ;font-size: 22px;font-weight: 700;">正常批次</p>
                          </el-col>
                        <!--</el-row>-->
                      <!--</div>-->
                    </el-row>
                  <!--</el-card>-->

                </div>

              </el-card>
              <el-card class="box-card-center" shadow="hover" style="height:295px;background-color:rgb(48,65,86);margin-bottom: 15px;">

              </el-card>

            </el-col>
            <!-- 第三列 -->
            <el-col :span="7">
              <el-card class="box-card" shadow="hover" style="height: 450px;margin-bottom: 15px;">
                <div><p style="text-align: center;color: white;font-size: 18px;font-weight: 700;margin-bottom: 30px;">近半年煤种运输情况</p></div>
                <center></center>
              </el-card>
            </el-col>
          </el-row>
<!--        第二行-->
        <el-row>
<!--          第一列-->
          <el-col :span="7">
            <el-card class="box-card" shadow="hover" style="height: 450px;margin-bottom: 15px;">
              <div><p style="text-align: center;color: white;font-size: 18px;font-weight: 700;">近半年按挥发分划分的煤种基低位发热量检测均值情况</p></div>
              <div
                id="center"
                key="center"
                style=" height: 445px;"
              ></div>
            </el-card>
          </el-col>
<!--          第二列-->
          <el-col :span="10">
            <el-card class="box-card-center" style="">

            </el-card>
          </el-col>
<!--          第三列-->
          <el-col :span="7">
            <el-card class="box-card"   shadow="hover" style="height: 450px;margin-bottom: 15px;">
              <div><p style="text-align: center;color: white;font-size: 18px;font-weight: 700;">近半年煤质指标所占百分比</p></div>
              <div
                id="right1"
                key="right1"
                style=" height: 445px;"
              ></div>
            </el-card>
          </el-col>
        </el-row>
        </div>
      </div>
    </div>
</template>

<script>
import drawMixin from "../utils/drawMixin"; //自适应缩放
import { formatTime } from "../utils/index.js"; //日期格式转换
import * as echarts from "echarts";
// import right2 from "./algorithm/shouyeTable.vue";
import scrollNumber from "@/components/scrollNumber/scrollNumber";
import center from "./algorithm/gundong.vue"
export default {
  mixins: [drawMixin],
  components:{
    // right2,
    scrollNumber,
    center
  },
  data() {
    return {
      caseNum: '379',
      typeNum: '317',
      faultNum: '62',

    };
  },
  // created() {
  //   this.getChartleft1();
  // },
  mounted() {
    this.getChartleft1();
    this.getChartright1();
    this.getChartCenter();
  },
  methods: {
    // 跳转到煤炭登记页面
    handletest(){
      this.$router.push({
        path:"/test/coal"
      })
    },
    // 跳转到煤质运输分析页面
    handleContrast(){
      this.$router.push({
        path:"/comAnalysis/coalTransportationAnalysis"
      })
    },
    // 跳转到检测报告页面
    handleReport(){
      this.$router.push({
        path:"/reportAnalysis/report"
      })
    },
    // 跳转到算法库页面
    handleAlgorithm(){
      this.$router.push({
        path:"/algorithm"
      })
    },
    getChartleft1(){
      var myChart = echarts.init(document.getElementById('left1'))
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
          data: ['低热值煤','中热值煤','高热值煤'],
          bottom:'5%',
          textStyle:{
            color:'white'
          }
        },
        xAxis: [
          {
            type: 'category',
            data: ['2023-05', '2023-06', '2023-07', '2023-08', '2023-09', '2023-10'],
            axisPointer: {
              type: 'shadow'
            },
            axisLine: {
              lineStyle: {
                color: '#fff',
              },
            },
          }
        ],
        yAxis: [
          {
            name: '吨数',
            type: 'value',
            min: 0,
            max: 100,
            interval: 20,
            axisLabel: {
              formatter: '{value} T '
            },
            axisLine: {
              lineStyle: {
                color: '#fff',
              },
            },
          }
        ],
        series: [
          {
            name: '低热值煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} '
            },
            data: [
              78.6,63.2,47.6,32.1,56.3,48.2
            ]
          },
          {
            name: '中热值煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} '
            },
            data: [
              59.6,62.3,24.5,58.6,45.6,23.6
            ]
          },
          {
            name: '高热值煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} '
            },
            data: [
              35.6,24.2,36.3,12.5,24.1,36.9
            ]
          },
        ],
        title: {
          text: '近半年发运批次按发热量划分三大煤种运输情况',
          left: 'center',
          textStyle:{
            color:'white'
          }
        },
      };
      myChart.setOption(option)
      window.addEventListener('resize', function() {
        myChart.resize()
      })
    },
    getChartright1(){
      var myChart = echarts.init(document.getElementById('right1'))
      const option = {
        xAxis: {
          max: 60,
          axisLine: {
            lineStyle: {
              color: '#fff',
            },
          },
        },
        yAxis: {
          type: 'category',
          data: ['水分(%)', '密度(%)', '电阻率(%)', '灰分(%)', '挥发分(%)','基低位发热量(%)'],
          max: 5, // only the largest 3 bars will be displayed
          axisLine: {
            lineStyle: {
              color: '#fff',
            },
          },
        },
        series: [
          {
            type: 'bar',
            data: [ 18, 12, 23, 25, 21, 53],
            label: {
              show: true,
              position: 'right',
            }
          }
        ],
        legend: {
          show: true,
          textStyle:{
            color:'white'
          }
        },
        grid:{
          left:100,
          top:50,
          bottom:100
        }
      };
      myChart.setOption(option)
      window.addEventListener('resize', function() {
        myChart.resize()
      })
    },
    getChartCenter(){
      var myChart = echarts.init(document.getElementById('center'))
      const option = {
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['2023-04', '2023-05', '2023-06', '2023-07', '2023-08', '2023-09'],
          axisLine: {
            lineStyle: {
              color: '#fff',
            },
          },
        },
        yAxis: {
          type: 'value',
          axisLine: {
            lineStyle: {
              color: '#fff',
            },
          },
        },
        series: [
          {
            data: [ 300, 150, 350, 403, 200, 150],
            type: 'line',
            // 折线图变曲线图
            smooth: true,
            // 区域面积样式
            areaStyle: {
              color: 'rgb(135,155,215)',
              opacity: 0.8
            }
          },
          {
            data: [ 200, 100, 220, 350, 320, 430],
            type: 'line',
            // 折线图变曲线图
            smooth: true,
            // 区域面积样式
            areaStyle: {
              color: 'rgb(178,219,158)',
              opacity: 0.8
            }
          },
          {
            data: [150, 350, 150, 403, 150, 320],
            type: 'line',
            // 折线图变曲线图
            smooth: true,
            // 区域面积样式
            areaStyle: {
              color: 'rgb(251,216,138)',
              opacity: 0.5
            }
          },
          {
            data: [50, 180, 250, 200, 350, 250],
            type: 'line',
            // 折线图变曲线图
            smooth: true,
            // 区域面积样式
            areaStyle: {
              color: 'rgb(228,206,109)',
              opacity: 0.5
            }
          }
        ],
        grid:{
          // top:200,
          // left:50
          bottom:100
        }
      };
      myChart.setOption(option)
      window.addEventListener('resize', function() {
        myChart.resize()
      })
    }
  }
};
</script>

<style lang="scss" scoped>
.oneRowTwoCol .el-card ::v-deep .el-card__body {
  padding: 0px;
  padding-top: 8px;
}
.bhover{
  cursor: pointer;
  color: white;
  background-color: rgba(0, 0, 0, 0);
  font-size: 18px;
  font-weight: 700;
  height: 38px;
  width: 130px;
  margin-top: 0px;
  //border: 1px solid rgb(4, 114, 131);
}
.head {
  position: relative;
  height: 100px !important;
  background: url(../assets/images/header.png) no-repeat;
  background-size: 100%;
  text-align: center;
  margin-top: 16px;
}
.head h1 {
  display: inline-block;
  font-size: 1.3em;
  margin-top: 10px;
  color: #bde4ff;
}
.left{
  //float: left;
  background-color: rgba(0, 0, 0, 0);
}
.right{
  //float: right;
  background-color: rgba(0, 0, 0, 0);
}
.bg {
  //整体页面背景
  width: 100%;
  height: 100%;
  padding: 16px 16px 0 16px;
  //background-image: url("../assets/images/img.png"); //背景图
  //background-color: #0a1863;
  background-color: rgb(48,65,86);

  background-size: cover; //背景尺寸
  background-position: center center; //背景位置
}
.box-card {
  padding: 10px;
  margin: 5px 10px;
  //border-color: rgba(29, 86, 153, 0.5);
  border-color: #0a1863;
  background-color: rgb(48,65,86);
}
.box-card-center {
  padding: 10px;
  margin: 5px 10px;
  //border-color: rgba(29, 86, 153, 0.5);
  border-color: rgb(48,65,86);
  background-color: rgb(48,65,86);
}
//全局样式部分！！！！
* {
  margin: 0;
  padding: 0;
  list-style-type: none;
  outline: none;
  box-sizing: border-box;
}
html {
  margin: 0;
  padding: 0;
}
body {
  font-family: Arial, Helvetica, sans-serif;
  line-height: 1.2em;
  background-color: #f1f1f1;
  margin: 0;
  padding: 0;
}
a {
  color: #343440;
  text-decoration: none;
}
//--------------------------------------------

//页面样式部分！！！！
#index {
  color: #d3d6dd;
  width: 1920px;
  height: 1080px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  transform-origin: left top;
  overflow: hidden;

  //顶部右边装饰效果
  .title_right {
    //width: 100%;
    //height: 50px;
    margin-top: 10px;
    float: right;
  }
  //顶部左边装饰效果
  .title_left {
    //width: 100%;
    //height: 50px;
    margin-top: 10px;
    float: left;
  }
  //顶部中间装饰效果
  .title_center {
    width: 100%;
    height: 50px;
  }
  //顶部中间文字数据可视化系统
  .title_text {
    text-align: center;
    font-size: 24px;
    font-weight: bold;
    margin-top: 14px;
    color: #008cff;
  }
  //时间日期
  .title_time {
    text-align: center;
  }
  //中国地图
  #china-map {
    height: 660px;
    width: 100%;
  }
  //中间折线图
  .line_center {
    width: 100%;
    height: 288px;
  }
  //左1模块
  .left_box1 {
    height: 310px;
    width: 100%;
    margin-bottom: 10px;
    position: relative;
  }
  //左2模块
  .left_box2 {
    height: 310px;
    width: 100%;
    margin-bottom: 10px;
  }
  //左3模块
  .left_box3 {
    height: 310px;
    width: 100%;
  }
  //右1模块
  .right_box1 {
    height: 310px;
    width: 100%;
    margin-bottom: 10px;
  }
  //右2模块
  .right_box2 {
    height: 310px;
    width: 100%;
    margin-bottom: 10px;
  }
  //右3模块
  .right_box3 {
    height: 310px;
    width: 100%;
  }
  //左1模块-玫瑰饼图
  #Rose_diagram {
    height: 70%;
    width: 55%;
  }
  //左1模块-圆环图
  .left_box1_rose_right {
    height: 85%;
    width: 55%;
    position: absolute;
    right: 0;
    top: 0;
  }
  //左1模块-文字部分
  .rose_text {
    display: inline-block;
    margin-top: 4%;
    margin-left: 4%;
  }
  // 左1模块-￥符号样式
  .coin {
    font-size: 20px;
    color: #ffc107;
  }
  //左1模块-（件）样式
  .colorYellow {
    color: yellowgreen;
  }
  //左1模块-数字样式
  .rose_text_nmb {
    font-size: 20px;
    color: #00b891;
  }
  //左2模块 柱状图
  #columnar {
    height: 97%;
    width: 95%;
    margin-left: 3%;
    margin-top: 5px;
  }
  //折线图
  #line_center_diagram {
    height: 100%;
    width: 100%;
  }
  //轮播表格
  .carousel_list {
    width: 96%;
    height: 98%;
    margin-left: 10px;
  }
  //虚线柱状图
  #dotter_bar {
    width: 100%;
    height: 100%;
  }
  //锥形图
  .cone_box {
    width: 95%;
    height: 97%;
    margin-left: 3%;
  }
}
</style>

