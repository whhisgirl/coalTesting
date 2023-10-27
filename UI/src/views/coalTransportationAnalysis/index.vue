<template>
  <div>
    <el-card class="box-card">
      <el-form ref="searchForm" :model="searchForm" label-width="80px">
        <el-row>
          <el-col :span="4">
            <el-form-item label="批次编号">
              <el-input v-model="searchForm.batchNumber" label-width="auto"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="车牌号">
              <el-input v-model="searchForm.licensePlate" label-width="auto"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="检测时间">
              <el-date-picker v-model="sampleTimeList" type="daterange" range-separator="至" start-placeholder="开始日期"
                end-placeholder="结束日期" value-format="yyyy-MM-dd" label-width="auto">
              </el-date-picker>
            </el-form-item>
          </el-col>

          <el-col :span="6">
            <el-form-item label="所在矿区">
              <el-select v-model="searchForm.miningAreaName" placeholder="请选择矿区">
                <el-option label="大同矿区" value="大同矿区"></el-option>
                <el-option label="忻州矿区" value="忻州矿区"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item>
          <el-button type="primary" @click="search">搜索</el-button>
          <el-button @click="reset">重置</el-button>
        </el-form-item>
      </el-form>
      <div>
        <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
          <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
            异常批次
          </p>
        </div>
      </div>
      <el-table v-loading="loading" :data="exceptionList" @selection-change="handleSelectionChange">
        <el-table-column label="批次编号" align="center" prop="batchNumber" />
        <el-table-column label="矿区名称" align="center" prop="miningAreaName" />
        <el-table-column label="运输车辆车牌" align="center" prop="licensePlate" />
        <el-table-column label="矿区所在地" align="center" prop="locationMiningArea" />
        <el-table-column label="检测时间" align="center" prop="sampleTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.sampleTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button size="mini" type="text" icon="el-icon-edit" @click="handleInfo(scope.row)">查看详情</el-button>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
        @pagination="getList" />

      <!-- 对话框 -->
      <el-dialog :title="title" :visible.sync="open" width="90%" style="padding-bottom: 0;" append-to-body>
        <el-form ref="infoForm" :model="infoForm" :rules="rules" label-width="80px">
          <el-row>
            <el-descriptions class="margin-top" title="批次信息" :column="4" :size="size" border>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-user"></i>
                  批次编号
                </template>
                {{ infoForm.batchNumber }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-mobile-phone"></i>
                  矿区名称
                </template>
                {{ infoForm.miningAreaName }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-location-outline"></i>
                  运输车辆车牌
                </template>
                {{ infoForm.licensePlate }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-tickets"></i>
                  矿区所在地
                </template>
                {{ infoForm.miningAreaName }}
              </el-descriptions-item>
            </el-descriptions>
          </el-row>
          <el-divider></el-divider>
          <el-row>
            <el-descriptions class="margin-top" title="成分对比" :column="6" :size="size" border>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-user"></i>
                  运输前水分
                </template>
                {{ infoForm.firstWater }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-mobile-phone"></i>
                  运输前灰分
                </template>
                {{ infoForm.firstAshContent }}

              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-location-outline"></i>
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
            <el-descriptions class="margin-top" :column="6" :size="size" border>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-user"></i>
                  运输后水分
                </template>
                {{ infoForm.secondWater }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-mobile-phone"></i>
                  运输后灰分
                </template>
                {{ infoForm.secondAshContent }}

              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label">
                  <i class="el-icon-location-outline"></i>
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
      </el-dialog>
      <el-divider></el-divider>
      <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
        <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
          煤质异常次数
        </p>
      </div>
      <div style="width: 100%;height: 200px;" ref="exceptionBarChart"></div>
    </el-card>
  </div>
</template>
  
<script>
import * as echarts from 'echarts';
import { listBatchAndIndicators } from "@/api/system/indicators";


export default {
  name: "coalTransportationAnalysis",
  data() {
    return {
      searchForm: {
        pageNum: 1,
        pageSize: 10,
        miningAreaName: ''
      },
      sampleTimeList: [],
      infoForm: {},
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
      title: "",
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
        0.7, 0.4, 3.6, 0.6, 0.4, 2.3
      ],
      chartData4: [
        0.7, 0.4, 3.6, 0.6, 0.4, -2.3
      ],
      exceptionBarChart: null,
      chartOption: {},
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
        this.exceptionList = filterList(list, 'batchNumber')
        this.total = response.data.total
      });
    },
    handleInfo(row) {
      this.title = "异常批次详情"
      console.log(row);
      listBatchAndIndicators({ coalNumber: row.coalNumber }).then(response => {
        console.log(response);
        this.exceptionCompareList = response.data.batchAndIndicatorsList
        this.total = response.data.total
        this.infoForm.batchNumber = this.exceptionCompareList[0].batchNumber
        this.infoForm.miningAreaName = this.exceptionCompareList[0].miningAreaName
        this.infoForm.licensePlate = this.exceptionCompareList[0].licensePlate
        this.infoForm.miningAreaName = this.exceptionCompareList[0].miningAreaName

        this.infoForm.firstWater = this.exceptionCompareList[0].waterContent
        this.infoForm.firstAshContent = this.exceptionCompareList[0].ashContent
        this.infoForm.firstBaseLowCalorific = this.exceptionCompareList[0].baseLowCalorific
        this.infoForm.firstCoalVolatile = this.exceptionCompareList[0].coalVolatile
        this.infoForm.firstDensity = this.exceptionCompareList[0].density
        this.infoForm.firstrResistivity = this.exceptionCompareList[0].resistivity

        this.infoForm.secondWater = this.exceptionCompareList[1].waterContent
        this.infoForm.secondAshContent = this.exceptionCompareList[1].ashContent
        this.infoForm.secondBaseLowCalorific = this.exceptionCompareList[1].baseLowCalorific
        this.infoForm.secondCoalVolatile = this.exceptionCompareList[1].coalVolatile
        this.infoForm.secondDensity = this.exceptionCompareList[1].density
        this.infoForm.secondrResistivity = this.exceptionCompareList[1].resistivity

        //水分
        let waterContentDiff = ((this.exceptionCompareList[0].waterContent - this.exceptionCompareList[1].waterContent) / this.exceptionCompareList[0].waterContent).toFixed(5)
        if (Math.abs(waterContentDiff) > 0.01) {
          this.chartData1.push({
            value: waterContentDiff,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: waterContentDiff,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }

        //灰分
        let ashContentDiff = ((this.exceptionCompareList[1].ashContent - this.exceptionCompareList[0].ashContent) / this.exceptionCompareList[0].ashContent).toFixed(5)
        if (Math.abs(ashContentDiff) > 0.01) {
          this.chartData1.push({
            value: ashContentDiff,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: ashContentDiff,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }
        console.log("ashContentDiff", ashContentDiff);

        //密度
        let densityDiff = ((this.exceptionCompareList[1].density - this.exceptionCompareList[0].density) / this.exceptionCompareList[0].density).toFixed(5)
        if (Math.abs(densityDiff) > 0.005) {
          this.chartData1.push({
            value: densityDiff,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: densityDiff,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }

        //挥发分
        let coalVolatileDiff = ((this.exceptionCompareList[1].coalVolatile - this.exceptionCompareList[0].coalVolatile) / this.exceptionCompareList[0].coalVolatile).toFixed(5)
        if (Math.abs(coalVolatileDiff) > 0.01) {
          this.chartData1.push({
            value: coalVolatileDiff,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: coalVolatileDiff,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }

        //电阻率
        let resistivityDiff = ((this.exceptionCompareList[1].resistivity - this.exceptionCompareList[0].resistivity) / this.exceptionCompareList[0].resistivity).toFixed(5)
        if (Math.abs(resistivityDiff) > 0.01) {
          this.chartData1.push({
            value: resistivityDiff,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: resistivityDiff,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }

        //基低位发热量
        let baseLowCalorificDiff = ((this.exceptionCompareList[1].baseLowCalorific - this.exceptionCompareList[0].baseLowCalorific) / this.exceptionCompareList[0].baseLowCalorific).toFixed(5)
        if (Math.abs(baseLowCalorificDiff) > 0.015) {
          this.chartData1.push({
            value: baseLowCalorificDiff,
            itemStyle: {
              color: '#a90000'
            }
          })
        } else {
          this.chartData1.push({
            value: baseLowCalorificDiff,
            itemStyle: {
              color: '#5470C6'
            }
          })
        }
        this.open = true
        this.$nextTick(() => {
          this.initExceptionCompareChart()
        })
      });

    },
    initExceptionNumBarChart() {
      this.exceptionBarChart = echarts.init(this.$refs.exceptionBarChart);
      // 配置图表
      this.chartOption = {
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
          name: '次数'
        },
        series: [
          {
            data: this.chartData3,
            type: 'bar'
          }
        ]
      }
      this.exceptionBarChart.setOption(this.chartOption)
    },
    initExceptionCompareChart() {
      this.exceptionBarChart = echarts.init(this.$refs.exceptionCompareChart);
      // 配置图表
      this.chartOption = {
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
      this.exceptionBarChart.setOption(this.chartOption)
    },
  },
  mounted() {
    this.getList()
    this.initExceptionNumBarChart()
  }
};
</script>
  
<style scoped lang="scss">
.box-card {
  margin: 1% 1%;
  width: 98%;
}
</style>
  
  