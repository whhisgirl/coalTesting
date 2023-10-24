<template>
  <div>
    <el-card class="box-card">
      <el-form ref="form" :model="form" label-width="80px">
        <el-row>
          <el-col :span="4">
            <el-form-item label="批次编号">
              <el-input v-model="form.name"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="检测时间">
              <el-date-picker v-model="value1" type="daterange" range-separator="至" start-placeholder="开始日期"
                end-placeholder="结束日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="车牌号">
              <el-input v-model="form.name"></el-input>
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
          <el-button>重置</el-button>
        </el-form-item>
      </el-form>
      <el-divider></el-divider>
      今日异常批次
      <el-divider></el-divider>
      煤质异常情况
      <div style="width: 100%;height: 300px;" ref="exceptionBarChart"></div>
    </el-card>
  </div>
</template>
  
<script>
import * as echarts from 'echarts';

export default {
  name: "coalTransportationAnalysis",
  data() {
    return {
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      }
    };
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },
  },
  mounted() {
    var exceptionBarChart = echarts.init(this.$refs.exceptionBarChart);
    console.log(exceptionBarChart);
    // 配置图表
    var option = {
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
        type: 'value'
      },
      series: [
        {
          data: [
            {
              value: 3.6,
              itemStyle: {
                color: '#a90000'
              }
            }, 0.7, 0.4, 0.6, 0.4, 2.3
          ],
          type: 'bar'
        }
      ]
    }
    exceptionBarChart.setOption(option)
  }
};
</script>
  
<style scoped lang="scss">
.box-card {
  margin: 1% 1%;
  width: 98%;
}
</style>
  
  