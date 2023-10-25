<template>
  <div>
    <el-card class="box-card">
      <h2>检测报告生成记录</h2>
      <br>
      <el-tabs v-model="activeTab" @tab-click="handleClick">
        <el-tab-pane label="按基低位发热量划分" name="first">
          <div ref="chart1"  style="height: 400px;"></div>

        </el-tab-pane>
        <el-tab-pane label="按灰分划分" name="second">
          <div ref="chart2" style="height: 400px;"></div>
        </el-tab-pane>
        <el-tab-pane label="按挥发分划分" name="third">
          <div ref="chart3" style="height: 400px;"></div>
        </el-tab-pane>
      </el-tabs>
      <!--<div ref="chart" style="height: 400px;"></div> -->

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

      <div style="margin-right: 60px;">
        <el-table
          :data="tableData" stripe style="width: 100%" >
          <el-table-column
            prop="date"
            label="采样时间"
            align="center">
          </el-table-column>
          <el-table-column
            prop="code"
            label="采样标准号"
            align="center">
          </el-table-column>
          <el-table-column
            prop="granularity"
            label="样品粒度" align="center">
          </el-table-column>

          <el-table-column
            prop="number"
            label="批次编号" align="center">
          </el-table-column>
          <el-table-column
            prop="location"
            label="矿区所在地" align="center">
          </el-table-column>
          <el-table-column
            prop="goal"
            label="到达地" align="center">
          </el-table-column>
          <el-table-column
            prop="height"
            label="批次重量(吨)" align="center">
          </el-table-column>
          <el-table-column
            prop="car"
            label="所在车车牌号" align="center">
          </el-table-column>
          <el-table-column
            prop="time"
            label="约定到达时间" align="center">
          </el-table-column>
        </el-table>
      </div>
    </el-card>
  </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  data() {
    return {
      activeTab: 'second',
      chart:{},
      form: {
        batchNumber: '',
        dateRange: [],
        licensePlate: '',
        region: ''
      },
      tableData: [{
        date: '2023-10-05',
        code: 'GB475-2008',
        granularity: '粒煤',
        number: 'C1201J05',
        location: '朔州市',
        goal: '内蒙古棋盘井车站',
        height: '40',
        car: '辽B 926QB',
        time: '2023-10-07'
      }, {
        date: '2023-10-10',
        code: 'GB475-2008',
        granularity: '粒煤',
        number: 'C1201J11',
        location: '焦作市',
        goal: '朔州市平鲁车站',
        height: '40',
        car: '豫H SD52D',
        time: '2023-10-12',
      }, {
        date: '2023-10-15',
        code: 'GB475-2008',
        granularity: '粉煤',
        number: 'C1201J20',
        location: '包头市',
        goal: '河南焦作站',
        height: '40',
        car: '蒙B 356SD',
        time: '2023-10-17'
      }, {
        date: '2023-10-18',
        code: 'GB475-2008',
        granularity: '小块',
        number: 'C1201J50',
        location: '山西市',
        goal: '山西晋城站',
        height: '40',
        car: '晋E AS5D4',
        time: '2023-10-20'
      }
      ]

    };
  },
  mounted() {
    this.renderChart();
  },
  methods: {
    handleClick(tab) {
      console.log('点击了标签页:',tab.name);
      /* if (tab.name === 'first') {
         this.showChart('chart1');
       } else if (tab.name === 'second') {
         this.showChart('chart2');
       } else if (tab.name === 'third') {
         this.showChart('chart3');
       }*/

    },

    renderChart() {
      const chart1 = echarts.init(this.$refs.chart1);
      const chart2 = echarts.init(this.$refs.chart2);
      const chart3 = echarts.init(this.$refs.chart3);

      const option1 = {
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
        },


      };

      const option2 = {
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

      const option3 = {
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

      chart1.setOption(option1);
      chart2.setOption(option2);
      chart3.setOption(option3);

      this.charts.chart1 = chart1;
      this.charts.chart2 = chart2;
      this.charts.chart3 = chart3;
    },


  },

  onSubmit() {
    // 处理搜索逻辑
    console.log('提交搜索');
  },
  resetForm() {
    this.$refs.form.resetFields();
  }
};
</script>

<style scoped>
table {
  border-collapse: collapse;
  margin-left: 64px; /* 假设每个单元格的宽度为8px */
}

th,
td {
  border: 1px solid black;
  padding: 8px;
}

.box-card {
  margin: 1% 1%;
  width: 98%;
}
</style>
