User
<template>
    <div id="chart-section">
      <!-- 统计图表标题 -->
      <div class="chart-titles">
        <h2>煤质对比</h2>
        <br>
      </div>
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="车型煤质对比" name="first"></el-tab-pane>
        <el-tab-pane label="矿区煤质对比" name="second"></el-tab-pane>
      </el-tabs>
  
      
      <!-- 根据activeName的值判断要显示的图表 -->
    <div v-if="activeName === 'first'" class="chart-container">
      <div ref="upChart" style="width: 100%; height: 400px;"></div>
      <div ref="bottomChart" style="width: 100%; height: 400px;"></div>
    </div>
      
      <div v-if="activeName === 'second'">
        <div ref="mainChart" style="width: 100%; height: 400px;"></div>
        <div class="sub-charts">
          <div ref="leftChart" style="width: 50%; height: 400px; float: left;"></div>
          <div ref="rightChart" style="width: 50%; height: 400px; float: left;"></div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import * as echarts from 'echarts';
  
  export default {
    name: "CompareCoal",
    data() {
      return {
        mainChartInstance: null,
        leftChartInstance: null,
        rightChartInstance: null,
        activeName: 'second'
      };
    },
    mounted() {
      this.renderCharts();
    },
    methods: {
        handleClick(tab, event) {
   this.$nextTick(() => {
      this.renderCharts();
      // 这里我们不直接调用resize，因为renderCharts已经处理了图表的初始化和设置。
   });
}
,


renderCharts() {
   if (this.activeName === 'first') {
      this.otherChart1();
      this.otherChart2();
   } else {
      this.initMainChart();
      this.initLeftChart();
      this.initRightChart();
   }

   // 确保所有图表都被调整到正确的尺寸
   if (this.mainChartInstance) this.mainChartInstance.resize();
   if (this.leftChartInstance) this.leftChartInstance.resize();
   if (this.rightChartInstance) this.rightChartInstance.resize();
   if (this.upChartInstance) this.upChartInstance.resize();
   if (this.bottomChartInstance) this.bottomChartInstance.resize();
},


      // ... 其他方法 ...
  
      otherChart1(){
        const chartDom = this.$refs.upChart;
        this.upChartInstance = echarts.init(chartDom);
        var upOption = {
            
        // ... 你的图表配置（上面提供的option）...
        tooltip: {
        trigger: 'axis',
        axisPointer: {
        type: 'shadow'
        }
        },
        legend: {},
        grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
        },
        xAxis: {
        type: 'value',
        min:0,
        max:2000,
        itemStyle:'red',    
        boundaryGap: [0, 0.01]
        },
        yAxis: {
        type: 'category',
        data: ['基底发热量',]
        },
        series: [
          {
            name: '样本检测数据',
            type: 'bar',
            barWidth: 25,
            data: [1000, ],
           
        itemStyle: {
            color: 'red'  // 设置为红色
        }
          },
          {
            name: '矿区样本数据',
            type: 'bar',
            data: [2000, ],
            barWidth: 25,
            itemStyle: {
            color: 'blue'  // 设置为红色
        }
          }
            ]
         
        };
        this.upChartInstance.setOption(upOption);},
  
        otherChart2(){
        const chartDom = this.$refs.bottomChart;
        this.bottomChartInstance = echarts.init(chartDom);
        var option = {
 
        tooltip: {
        trigger: 'axis',
        axisPointer: {
        type: 'shadow'
        }
        },
        legend: {},
        grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
        },
        xAxis: {
        type: 'value',
        min:0,
        max:50,
            
        boundaryGap: [0, 0.01]
        },
        yAxis: {
        type: 'category',
        data: ['灰分','挥发分','电阻率','水分',]
        },
        series: [
        {
                name: '样本检测数据',
                barWidth:25,
            
                type: 'bar',
                data: [10,20,30,40,],
                itemStyle: {
            color: 'red'  // 设置为红色
        }
        },
        {
                name: '矿区样本数据',
                type: 'bar',
                barWidth:25,
                data: [20,25,50,48 ],
                itemStyle: {
            color: 'blue'  // 设置为红色
        }
        }
        ]
        };
        this.bottomChartInstance.setOption(option);

        },
  
        initMainChart() {
            const chartDom = this.$refs.mainChart;
            this.mainChartInstance = echarts.init(chartDom);
            const mainOption = {
                title: {
             text: '矿区发运煤炭均低位发热量情况',
                    left: 'center'
                                    },
                    tooltip: {},
                    xAxis: {
                    data: ["大同","兴陶","晋城","榆神","包头","冯西"]
                    },
                    yAxis: {
                    min: 4500,
                    max: 5300,
                    axisLabel: {
                    formatter: '{value} cal'
                    }
                    },

            series: [{
            name: '值',
            type: 'bar',
            data: [4900,5100,4600,4650,4870,4750],
            barWidth: 100, // 示例数据
            }]
                // ... 你之前的主图表配置 ...
            };
            this.mainChartInstance.setOption(mainOption);
        },
      
        initLeftChart() {
            const chartDom = this.$refs.leftChart;
            this.leftChartInstance = echarts.init(chartDom);
            const leftOption = {
                title: {
                text: '矿区发运煤炭平均灰分情况',
                    left: 'center'
                                    },
                    tooltip: {},
                    xAxis: {
                    data: ["大同","兴陶","晋城","榆神","包头","冯西"]
                    },
                    yAxis: {
                    min: 18,
                    max: 24,
                    axisLabel: {
                    formatter: '{value} %'
                    }
                    },

                    series: [{
                    name: '值',
                    type: 'bar',
                    data: [21.39, 23.04, 19.51 ,21.8, 20.32 ,21.1],
                    barWidth: 50, // 示例数据
                    itemStyle: {
                        color: 'green'}
                    }]
                // ... 左侧图表的配置 ...
            };
            this.leftChartInstance.setOption(leftOption);
        },
      
        initRightChart() {
            const chartDom = this.$refs.rightChart;
            this.rightChartInstance = echarts.init(chartDom);
            const rightOption = {
                title: {
                text: '矿区发运煤炭平均挥发分情况',
                    left: 'center'
                                    },
                    tooltip: {},
                    xAxis: {
                    data: ["大同","兴陶","晋城","榆神","包头","冯西"]
                    },
                    yAxis: {
                    min: 27,
                    max: 29,
                    axisLabel: {
                    formatter: '{value} %'
                    }
                    },

                    series: [{
                    name: '值',
                    type: 'bar',
                    data: [27.53,28.19,27.87,28.64,28.43,27.69],
                    barWidth: 50, // 示例数据
                    itemStyle: {
                        color: 'orange'}
                    }]
                // ... 右侧图表的配置 ...
            };
            this.rightChartInstance.setOption(rightOption);
        }
    }
};
   
</script>

<style scoped>

@import url("//unpkg.com/element-ui@2.15.14/lib/theme-chalk/index.css");
/* ... 你之前的样式 ... */
#chart-section {
 padding: 20px;
}
.chart-partPage{
 line-height: 2; /* 默认值为1，可以根据需要增加这个值 */

}
span:first-child {
 margin-right: 50px; /* 调整这个值以获得所需的间隙 */
}

.chart-titles {
display: flex;
justify-content: space-between;
 align-items: center;
}
</style>