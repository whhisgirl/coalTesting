<template>
  <div>
    <div id="myChart" :style="{ width: '800px', height: '300px' }"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts'
export default {
  name: 'Radar',
  data() {
    return {}
  },
  mounted() {
    this.drawLine()
  },
  methods: {
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = echarts.init(document.getElementById('myChart'))
      let option = {
        color: ['#67F9D8', '#FFE434', '#56A3F1', '#FF917C'],
        legend: {},
        radar: [
          {
            indicator: [
              {text: '信用动态分'},
              {text: '身份认证'},
              {text: '运输行为'},
              {text: '履约能力'},
              {text: '服务能力'}
            ],
            center: ['25%', '45%'],
            radius: 100,
            startAngle: 90,
            splitNumber: 4,
            shape: 'circle',
            axisName: {
              formatter: '【{value}】',
              color: '#428BD4'
            },
            splitArea: {
              areaStyle: {
                color: ['#77EADF', '#26C3BE', '#64AFE9', '#428BD4'],
                shadowColor: 'rgba(0, 0, 0, 0.2)',
                shadowBlur: 10
              }
            },
            axisLine: {
              lineStyle: {
                color: 'rgba(211, 253, 250, 0.8)'
              }
            },
            splitLine: {
              lineStyle: {
                color: 'rgba(211, 253, 250, 0.8)'
              }
            }
          },

        ],
        series: [
          {
            type: 'radar',
            emphasis: {
              lineStyle: {
                width: 12
              }
            },
            data: [
              {
                value: [105, 120, 100,71, 65],
              },
            ]
          },
        ],
      }
      // 绘制图表
      myChart.setOption(option)
    },
  },
}
</script>

<style>
</style>
