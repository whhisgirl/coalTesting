<template>
  <div style="margin-bottom: 20px;height: 500px;width: 100%;">
    <div ref="step5Chart" style="width: 100%; height:500px;">
    </div>
  </div>
</template>

<script>

import * as echarts from 'echarts';
export default {
  name: "step5",
  mounted() {
    this.getEchartData();
  },
  methods:{
    getEchartData() {
      const chart = this.$refs.step5Chart
      if(chart){
        const myChart = echarts.init(chart)
        const option = {
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data: ['运输前检测', '运输后检测']
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
              name: '运输前检测',
              type: 'bar',
              data: [
                8.13,3.97,3.77,23.28,28.30,52.35
              ],
            },
            {
              name: '运输后检测',
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
