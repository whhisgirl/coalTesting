<template>
  <div>
    <el-card class="box-card">
      <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
        <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
          煤种发运情况记录
        </p>
      </div>
      <br>
      <el-tabs v-model="activeTab" ref="tabs" @tab-click="handleClick">
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
            <el-col :span="5">
              <el-form-item label="批次编号">
                <el-input v-model="form.batchNumber"></el-input>
              </el-form-item>
            </el-col>
            &nbsp;
            &nbsp;
            &nbsp;
            <el-col :span="8">
              <el-form-item label="检测时间">
                <el-date-picker v-model="form.dateRange" type="daterange" range-separator="至" start-placeholder="开始日期"
                                end-placeholder="结束日期">
                </el-date-picker>
              </el-form-item>
            </el-col>

            <el-col :span="5">
              <el-form-item label="所在矿区">
                <el-select v-model="form.region" placeholder="请选择矿区">
                  <el-option label="A矿区" value="A"></el-option>
                  <el-option label="B矿区" value="B"></el-option>
                </el-select>
              </el-form-item>
            </el-col>

            <el-col :span="4">
            <el-form-item>
              <el-button type="primary" @click="onSubmit">搜索</el-button>
              <el-button @click="resetForm">重置</el-button>
            </el-form-item>
            </el-col>
          </el-row>

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
      activeTab: 'first',
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
        location: '山西省忻州市',
        goal: '内蒙古棋盘井车站',
        height: '40',
        car: '辽B 926QB',
        time: '2023-10-07'
      }, {
        date: '2023-10-10',
        code: 'GB475-2008',
        granularity: '粒煤',
        number: 'C1201J11',
        location: '山西省忻州市',
        goal: '朔州市平鲁车站',
        height: '40',
        car: '豫H SD52D',
        time: '2023-10-12',
      }, {
        date: '2023-10-15',
        code: 'GB475-2008',
        granularity: '粉煤',
        number: 'C1201J20',
        location: '山西省忻州市',
        goal: '河南焦作站',
        height: '40',
        car: '蒙B 356SD',
        time: '2023-10-17'
      }, {
        date: '2023-10-18',
        code: 'GB475-2008',
        granularity: '小块',
        number: 'C1201J50',
        location: '山西省忻州市',
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
      this.$nextTick(()=>{
           echarts.getInstanceByDom(this.$refs.chart1).resize()
           echarts.getInstanceByDom(this.$refs.chart2).resize()
           echarts.getInstanceByDom(this.$refs.chart3).resize()
      })

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
            /*dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar'] },
            restore: { show: true },
            saveAsImage: { show: true }*/
          }
        },
        legend: {
          data: ['低热值煤','中热值煤','高热值煤'],
          bottom: 0
        },
        xAxis: [
          {
            type: 'category',
            data: ['2023-04', '2023-05', '2023-06', '2023-07', '2023-08', '2023-09'],
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name:'千吨',
            min: 0,
            max: 100,
            interval: 20,
            axisLabel: {
              formatter: '{value} '
            }
          }
        ],
        series: [
         /* {
            name: '低热值煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} '
            },
            data: [
              23.5,27.3,30.5,13.2,28.9,16.2
            ]
          },*/
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
          }/*,
          {
            name: '高热值煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} '
            },
            data: [
              25.6,15.8,24.3,14.3,23.2,11.3
            ]
          },
          {
            name: '超高热值煤',
            type: 'bar',
            tooltip: {
              formatter: '{c}'
            },
            data: [
              2.1,1.5,3.3,5.4,1.2,3.4
            ]
          }*/
        ],
        title: {
          text: '近半年发运批次按发热量划分三大煤种运输情况',
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
           // dataView: { show: true, readOnly: false },
            //magicType: { show: true, type: ['line', 'bar'] },
            //restore: { show: true },
            //saveAsImage: { show: true }
          }
        },
        legend: {
          data: ['特低灰煤', '低灰煤', '中灰煤','高灰煤','特高灰煤'],
          bottom: 0
        },
        xAxis: [
          {
            type: 'category',
            data: ['2023-04', '2023-05', '2023-06', '2023-07', '2023-08', '2023-09'],
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name:'千吨',
            min: 0,
            max: 100,
            interval: 20,
            axisLabel: {
              formatter: '{value} '
            }
          }
        ],
        series: [
          /*{
            name: '特低灰煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              2.0,1.2,0.9,4.3,3.6,2.2
            ]
          },*/
          {
            name: '低灰煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              22.1,25.6,24.3,33.0,26.8,29.6
            ]
          },
          {
            name: '中灰煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              55.6,78.2,54.5,65.6,56.5,49.5
            ]
          },
          {
            name: '高灰煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
             13.4,25.3,24.6,19.6,32.1,17.6
            ]
          }/*,
          {
            name: '特高灰煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              2.1,3.3,5.4,6.3,2.1,2.3
            ]
          }*/
        ],
        title: {
          text: '近半年发运批次按灰分划分三大煤种运输情况',
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
            /*dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar'] },
            restore: { show: true },
            saveAsImage: { show: true }*/
          }
        },
        legend: {
          data: ['无烟煤', '烟煤', '褐煤','泥煤'],
          bottom: 0
        },
        xAxis: [
          {
            type: 'category',
            data: ['2023-04', '2023-05', '2023-06', '2023-07', '2023-08', '2023-09'],
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name:'千吨',
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
            name: '无烟煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              34.8,56.9,43.2,26.3,45.6,59.3
            ]
          },
          {
            name: '烟煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              23.6,21.3,36.5,42.3,21.3,22.6
            ]
          },
          {
            name: '褐煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
              2.0, 4.9, 7.0,2.3,5.4,3.3
            ]
          },
          {
            name: '泥煤',
            type: 'bar',
            tooltip: {
              formatter: '{c} ml'
            },
            data: [
             32.1,23.5,34.2,15.6,24.3,16.8
            ]
          }
        ],
        title: {
          text: '近半年发运批次按挥发分划分四大煤种运输情况',
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
