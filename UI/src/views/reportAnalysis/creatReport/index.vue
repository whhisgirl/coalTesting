<template>
  <div>
    <h2>检测报告生成记录</h2>
    <div ref="chart" style="height: 400px;"></div>
    <br>
    <br>
    <br>
    <br>
    <div>
      <el-form ref="form" :model="form" label-width="80px">
        <el-row>
          <el-col :span="4">
            <el-form-item label="批次编号">
              <el-input v-model="form.batchNumber"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="9">
            <el-form-item label="检测时间">
              <el-date-picker v-model="form.dateRange" type="daterange" range-separator="至" start-placeholder="开始日期"
                              end-placeholder="结束日期">
              </el-date-picker>
            </el-form-item>
          </el-col>

          <el-col :span="6">
            <el-form-item label="所在矿区">
              <el-select v-model="form.region" placeholder="请选择矿区">
                <el-option label="A矿区" value="A"></el-option>
                <el-option label="B矿区" value="B"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">搜索</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

    <div>
      <table>
        <thead>
        <tr>
          <th>日期</th>
          <th>煤种</th>
          <th>地址</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(item, index) in tableData" :key="index">
          <td>{{ item.date }}</td>
          <td>{{ item.coalType }}</td>
          <td>{{ item.address }}</td>
        </tr>
        </tbody>
      </table>
    </div>

  </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  data() {
    return {
      form: {
        batchNumber: '',
        dateRange: [],
        licensePlate: '',
        region: ''
      },
      tableData: [
        { date: '2023-10-01', coalType: '低热量煤', address: 'A矿区' },
        { date: '2023-10-02', coalType: '中热量煤', address: 'A矿区' },
        { date: '2023-10-03', coalType: '高热量煤', address: 'A矿区' },
        { date: '2023-10-04', coalType: '低热量煤', address: 'A矿区' },
        { date: '2023-10-05', coalType: '中热量煤', address: 'A矿区' }
      ]

    };
  },
  mounted() {
    this.renderChart();
  },
  methods: {
    renderChart() {
      const chart = echarts.init(this.$refs.chart);

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
        toolbox: {
          feature: {
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar'] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        legend: {
          data: ['低热量煤', '中热量煤', '高热量煤'],
          bottom: 0
        },
        xAxis: [
          {
            type: 'category',
            data: ['一月', '二月', '三月', '四月', '五月', '六月'],
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            min: 0,
            max: 100,
            interval: 20,
            axisLabel: {
              formatter: '{value} '
            }
          }
        ],
        series: [
          {
            name: '低热量煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3
            ]
          },
          {
            name: '中热量煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3
            ]
          },
          {
            name: '高热量煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3
            ]
          }
        ],
        title: {
          text: '本年度煤种发运情况',
          left: 'center'
        }
      };

      chart.setOption(option);
    },
    onSubmit() {
      // 处理搜索逻辑
      console.log('提交搜索');
    },
    resetForm() {
      this.$refs.form.resetFields();
    }
  }
};
</script>

<style>
table {
  border-collapse: collapse;
  margin-left: 64px; /* 假设每个单元格的宽度为8px */
}

th,
td {
  border: 1px solid black;
  padding: 8px;
}
</style>
