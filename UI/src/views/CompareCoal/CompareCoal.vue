<template>
    <div id="chart-section">
        <!-- 统计图表标题 -->
        <div class="chart-titles">
            <h2>煤质对比</h2>
            <br>
        </div>
        <div id="分页标签">
            <!--分页-->
            <div class="chart-partPage">
                <div class="pagination">
            <span @click="changePage(1)" :class="{ active: currentPage === 1 }">车型煤质对比</span>
            <span @click="changePage(2)" :class="{ active: currentPage === 2 }">矿区煤质对比</span>
  
                </div> 

              
            </div>
        </div>
        <!-- 主统计图表 -->
        <div ref="mainChart" style="width: 100%; height: 400px; clear: both;"></div>
        <div class="sub-charts">
            <!-- 左侧柱状图 -->
            <div ref="leftChart" style="width: 50%; height: 400px; float: left;"></div>
            <!-- 右侧柱状图 -->
            <div ref="rightChart" style="width: 50%; height: 400px; float: left;"></div>
        </div>
    </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
    name: "ChartSection",
    data() {
        return {
            mainChartInstance: null,
            leftChartInstance: null,
            rightChartInstance: null
        };
    },
    mounted() {
        this.initMainChart();
        this.initLeftChart();
        this.initRightChart();
    },
    methods: {
        initMainChart() {
            const chartDom = this.$refs.mainChart;
            this.mainChartInstance = echarts.init(chartDom);
            const mainOption = {
                title: {
             text: '矿区发运煤炭均低位发热量情况',
                    left: 'center'
                                    },
                    tooltip: {},
                    xAxis: {
                    data: ["大同","兴陶","晋城","榆神","包头","冯西"]
                    },
                    yAxis: {
                    min: 4500,
                    max: 5300,
                    axisLabel: {
                    formatter: '{value} cal'
                    }
                    },

            series: [{
            name: '值',
            type: 'bar',
            data: [4900,5100,4600,4650,4870,4750],
            barWidth: 100, // 示例数据
            }]
                // ... 你之前的主图表配置 ...
            };
            this.mainChartInstance.setOption(mainOption);
        },
        initLeftChart() {
            const chartDom = this.$refs.leftChart;
            this.leftChartInstance = echarts.init(chartDom);
            const leftOption = {
                title: {
                text: '矿区发运煤炭平均灰分情况',
                    left: 'center'
                                    },
                    tooltip: {},
                    xAxis: {
                    data: ["大同","兴陶","晋城","榆神","包头","冯西"]
                    },
                    yAxis: {
                    min: 18,
                    max: 24,
                    axisLabel: {
                    formatter: '{value} %'
                    }
                    },

                    series: [{
                    name: '值',
                    type: 'bar',
                    data: [21.39, 23.04, 19.51 ,21.8, 20.32 ,21.1],
                    barWidth: 50, // 示例数据
                    itemStyle: {
                        color: 'green'}
                    }]
                // ... 左侧图表的配置 ...
            };
            this.leftChartInstance.setOption(leftOption);
        },
        initRightChart() {
            const chartDom = this.$refs.rightChart;
            this.rightChartInstance = echarts.init(chartDom);
            const rightOption = {
                title: {
                text: '矿区发运煤炭平均挥发分情况',
                    left: 'center'
                                    },
                    tooltip: {},
                    xAxis: {
                    data: ["大同","兴陶","晋城","榆神","包头","冯西"]
                    },
                    yAxis: {
                    min: 27,
                    max: 29,
                    axisLabel: {
                    formatter: '{value} %'
                    }
                    },

                    series: [{
                    name: '值',
                    type: 'bar',
                    data: [27.53,28.19,27.87,28.64,28.43,27.69],
                    barWidth: 50, // 示例数据
                    itemStyle: {
                        color: 'orange'}
                    }]
                // ... 右侧图表的配置 ...
            };
            this.rightChartInstance.setOption(rightOption);
        }
    }
};
</script>

<style scoped>
/* ... 你之前的样式 ... */
#chart-section {
 padding: 20px;
}
.chart-partPage{
 line-height: 2; /* 默认值为1，可以根据需要增加这个值 */

}
span:first-child {
 margin-right: 50px; /* 调整这个值以获得所需的间隙 */
}

.chart-titles {
display: flex;
justify-content: space-between;
 align-items: center;
}
</style>
