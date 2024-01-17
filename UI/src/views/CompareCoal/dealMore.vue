
<template>

      <!-- 对话框 -->
      <el-card :title="title" :visible.sync="open" width="90%" style="padding-bottom: 0;" append-to-body>
        <el-form ref="infoForm" :model="infoForm" :rules="rules" label-width="80px">
          <el-row>
            <el-descriptions class="margin-top" title="批次信息" :column="4" border>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-edit"></i>
                  批次编号
                </template>
                {{ infoForm.batchNumber }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-coordinate"></i>
                  矿区名称
                </template>
                {{ infoForm.miningAreaName }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-truck"></i>
                  运输车辆车牌
                </template>
                {{ infoForm.licensePlate }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-location-outline"></i>
                  矿区所在地
                </template>
                {{ infoForm.locationMiningArea }}
              </el-descriptions-item>
            </el-descriptions>
          </el-row>
          <el-divider></el-divider>
          <el-row>
            <el-descriptions class="margin-top" title="成分对比" :column="6"  border>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输前水分
                </template>
                {{ infoForm.firstWater }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输前灰分
                </template>
                {{ infoForm.firstAshContent }}

              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输前密度
                </template>
                {{ infoForm.firstDensity }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输前挥发分
                </template>
                {{ infoForm.firstCoalVolatile }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输前电阻率
                </template>
                {{ infoForm.firstrResistivity }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输前基低位发热量
                </template>
                {{ infoForm.firstBaseLowCalorific }}
              </el-descriptions-item>
            </el-descriptions>
          </el-row>
          <el-row>
            <el-descriptions class="margin-top" :column="6"  border>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输后水分
                </template>
                {{ infoForm.secondWater }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输后灰分
                </template>
                {{ infoForm.secondAshContent }}

              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输后密度
                </template>
                {{ infoForm.secondDensity }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输后挥发分
                </template>
                {{ infoForm.secondCoalVolatile }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输后电阻率
                </template>
                {{ infoForm.secondrResistivity }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  运输后基低位发热量
                </template>
                {{ infoForm.secondBaseLowCalorific }}
              </el-descriptions-item>
            </el-descriptions>
          </el-row>
        </el-form>

        <div>
          <div style="margin-top:10px"></div>
          <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
            <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
              异常批次详情
            </p>
            <el-tooltip placement="top">
              <div slot="content">
                <p>水分(0~1%)</p>
                <p>灰分(0~1%)</p>
                <p>密度(0~0.5%)</p>
                <p>挥发分(0~1%)</p>
                <p>电阻率(0~1%)</p>
                <p>发热量(0~1.5%)</p>
              </div>
              <i class="el-icon-question"
                 style="float: right; margin-right: 20px; margin-top: 12px; font-size: 30px;"></i>
            </el-tooltip>
          </div>
        </div>
        <div ref="exceptionCompareChart" style="width: 100%;height: 300px;"></div>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancel">退 出</el-button>
        </div>
      </el-card>

</template>

<script>
import * as echarts from 'echarts';
import { listBatchAndIndicators } from "@/api/system/indicators";


export default {
  name: "coalTransportationAnalysis",
  data() {
    return {
     title:"煤质异常批次",
      searchForm: {
        pageNum: 1,
        pageSize: 10,
        miningAreaName: ''
      },
      sampleTimeList: [],
      infoForm: {

        batchNumber :"G1201G1",
        miningAreaName : "忻州宏远矿区",
        licensePlate : "晋H 5D553/晋H FDG49",
        locationMiningArea : "山西省/忻州市",

        firstWater : 8.01,
        firstAshContent : 23.28,
        firstBaseLowCalorific :	3.97,
        firstCoalVolatile : 	28.31,
        firstDensity : 377,
        firstrResistivity : 	5235,

        secondWater : 	8.21,
        secondAshContent :23.92,
        secondBaseLowCalorific : 	3.98,
        secondCoalVolatile : 	28.26,
       secondDensity : 	371,
        secondrResistivity : 	5129},
      // 遮罩层
      loading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 异常批次图表
      exceptionList: [],

      // 异常批次对比
      exceptionCompareList: [],

      // 弹出层标题

      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
      },
      //表单校验
      rules: {},
      chartData1: [

      ],
      chartData2: [
        0.7, 0.4, {
          value: 3.6,
          itemStyle: {
            color: '#a90000'
          }
        }, 0.6, 0.4,
        {
          value: -2.3,
          itemStyle: {
            color: '#a90000'
          }
        }
      ],
      chartData3: [
        2, 1, 1, 0, 2, 1
      ],
      chartData4: [
        0.7, 0.4, 3.6, 0.6, 0.4, -2.3
      ],
      exceptionBarChart: null,
      chartOption: {},
      exceptionCompareBarChart: null,
      exceptionCompareBarChartOption: {}
    };
  },
  methods: {
    search() {
      console.log(this.searchForm);
      if (this.sampleTimeList !== null) {
        this.searchForm.sampleTimeBegin = this.sampleTimeList[0]
        this.searchForm.sampleTimeAfter = this.sampleTimeList[1]
      }
      listBatchAndIndicators(this.searchForm).then(response => {
        console.log(response);
        let list = response.data.batchAndIndicatorsList
        //去重
        const filterList = (arr, id) => {
          let newList = arr.reduce((pre, cur) => pre.some(item => item[id] === cur[id]) ? pre : [...pre, cur], [])
          return newList;
        }
        this.exceptionList = filterList(list, 'batchNumber')
        this.total = response.data.total
      });
    },
    cancel() {
      this.exceptionCompareBarChart.dispose()
      this.exceptionCompareBarChartOption = null
      this.open = false
    },
    reset() {
      this.searchForm = {}
      this.sampleTimeList = []
      listBatchAndIndicators({ pageNum: 1, pageSize: 10, }).then(response => {
        console.log(response);
        let list = response.data.batchAndIndicatorsList
        //去重
        const filterList = (arr, id) => {
          let newList = arr.reduce((pre, cur) => pre.some(item => item[id] === cur[id]) ? pre : [...pre, cur], [])
          return newList;
        }
        this.exceptionList = filterList(list, 'batchNumber')
        this.total = response.data.total
      });
    },
    handleSelectionChange() { },
    submitForm() { },
    getList() {
      listBatchAndIndicators(this.queryParams).then(response => {
        console.log(response);
        let list = response.data.batchAndIndicatorsList
        //去重
        const filterList = (arr, id) => {
          let newList = arr.reduce((pre, cur) => pre.some(item => item[id] === cur[id]) ? pre : [...pre, cur], [])
          return newList;
        }
        this.exceptionList = filterList(list, 'batchNhumber')
        this.total = this.exceptionList.length
      });
    },
    handleInfo() {
        //水分
        let waterContentDiff = 0.025
      if (Math.abs(waterContentDiff) > 0.01) {
          this.chartData1.push({
            value: waterContentDiff*100,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: waterContentDiff*100,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }

        //灰分
        let ashContentDiff =0.02749
      if (Math.abs(ashContentDiff) > 0.01) {
          this.chartData1.push({
            value: ashContentDiff*100,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: ashContentDiff*100,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }
        console.log("ashContentDiff", ashContentDiff);

        //密度
        let densityDiff =0.00252
      if (Math.abs(densityDiff) > 0.005) {
          this.chartData1.push({
            value: densityDiff*100,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: densityDiff*100,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }

        //挥发分
        let coalVolatileDiff = -0.001413
      if (Math.abs(coalVolatileDiff) > 0.01) {
          this.chartData1.push({
            value: coalVolatileDiff*100,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: coalVolatileDiff*100,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }

        //电阻率
        let resistivityDiff =-0.01592
      if (Math.abs(resistivityDiff) > 0.01) {
          this.chartData1.push({
            value: resistivityDiff*100,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: resistivityDiff*100,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }

        //基低位发热量
        let baseLowCalorificDiff = -0.02025
      if (Math.abs(baseLowCalorificDiff) > 0.015) {
          this.chartData1.push({
            value: baseLowCalorificDiff*100,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: baseLowCalorificDiff*100,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }
        this.open = true
        this.$nextTick(() => {
          this.initExceptionCompareChart()
        })

    },

    initExceptionCompareChart() {
      this.exceptionCompareBarChart = echarts.init(this.$refs.exceptionCompareChart);
      // 配置图表
      this.exceptionCompareBarChartOption = {
        //笛卡尔坐标系的底板
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          data: ['水分', '灰分', '密度', '挥发分', '电阻率', '基低位发热量']
        },
        yAxis: {
          type: 'value',
          name: '变化%'
        },
        series: [
          {
            data: this.chartData1,
            type: 'bar',
            label: {
              show: true,
              position: 'inside'
            },
          },
        ]
      }
      this.exceptionCompareBarChart.setOption(this.exceptionCompareBarChartOption)
    },
  },
  mounted() {
    this.getList()
    this.handleInfo()
  }
};
</script>

<style scoped lang="scss">
.box-card {
  margin: 1% 1%;
  width: 98%;
}
</style>

