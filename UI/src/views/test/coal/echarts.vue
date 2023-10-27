<template>
  <div style="margin-bottom: 20px">
    <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
      <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
        煤样登记
      </p>
    </div>
  </div>
</template>

<script>

import *as echarts from 'echarts';
export default {
  name: "echarts",
  mounted() {
    this.getEchartData();
  },
  methods:{
    getEchartData() {
      const chart = this.$refs.chart
      if(chart){
        const myChart = echarts.init(chart)
        const option = {
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: ['第一次检测', '第二次检测']
          },
          calculable: true,
          xAxis: [
            {
              type: 'category',
              data: ['水分','密度','电阻率','灰分','挥发分','基低位发热量']
            }
          ],
          yAxis: [
            {
              type: 'value'
            }
          ],
          series: [
            {
              name: '第一次检测',
              type: 'bar',
              data: [
                8.13,3.97,3.77,23.28,28.30,52.35
              ],
            },
            {
              name: '第二次检测',
              type: 'bar',
              data: [
                9.10,4.13,3.81,23.92,28.11,44.00
              ],
            }
          ],
        }
        option && myChart.setOption(option);
      }
    },
  },
}
</script>

<style scoped>

</style>
