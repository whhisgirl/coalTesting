<template>
  <div>
    <!-- <div style="width: 100%; background: #d2e9ff; border-radius: 10px;margin-top: 5px;
">
      <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
        数据对比
      </p>
    </div> -->
    <el-card style="width: 95%;margin-left: 30px; margin-top: 10px">
      <div ref="barChart" style="width: 100%;height: 300px; border-radius: 10px"></div>
    </el-card>
    <CoalType></CoalType>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import CoalType from '@/views/CompareCoal/CoalType'
export default {
  name: "echarts",
  components: {
    CoalType
  },
  mounted() {
    this.getEchartData();
    this.initChart()
    window.addEventListener('resize', this.resizeCharts)
  },
  methods: {
    getEchartData() {
      const chart = this.$refs.barChart
      if (chart) {
        const myChart = echarts.init(chart)
        const option = {
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            left: "75%",
            data: ['运输前检测', '运输后检测']
          },
          calculable: true,
          title: {
            show: true,
            text: '运输前后煤质对比分析',
            textAlign: 'center',
            left: '50%',
            textStyle: {
              fontSize: 25,
            },
          },
          xAxis: [
            {
              type: 'category',
              data: ['水分', '密度', '电阻率', '灰分', '挥发分', '基低位发热量']
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
                8.13, 3.97, 3.77, 23.28, 28.30, 52.35
              ],
            },
            {
              name: '运输后检测',
              type: 'bar',
              data: [
                9.10, 4.13, 3.81, 23.92, 28.11, 44.00
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

<style scoped></style>
