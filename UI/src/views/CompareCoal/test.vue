<template>
	<div>
		<el-card style="width: 95%; margin-left: 30px; margin-top: 10px">
			<el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="68px">
				<el-form-item label="煤炭批次编号" prop="batchNumber" label-width="100px">
					<el-input v-model="queryParams.batchNumber" placeholder="请输入煤炭批次编号" clearable />
				</el-form-item>
				<el-form-item label="检测时间" prop="sampleTime">
					<el-date-picker
						v-model="dateRange"
						style="width: 240px"
						value-format="yyyy-MM-dd"
						type="daterange"
						range-separator="-"
						start-placeholder="开始日期"
						end-placeholder="结束日期"
					></el-date-picker>
				</el-form-item>

				<el-form-item label="车牌号" prop="licensePlate">
					<el-input v-model="queryParams.licensePlate" placeholder="请输入车牌号" clearable />
				</el-form-item>
				<el-form-item label="所在矿区" prop="locationMiningArea">
					<el-input v-model="queryParams.locationMiningArea" placeholder="请输入所在矿区" clearable />
				</el-form-item>
			</el-form>
		</el-card>
		<el-card style="width: 95%;height:500px; margin-left: 30px; margin-top: 10px">
			<el-row>
				<el-col :span="17" style="height: 20rem">
					<div key="barChart" id="barChart" :style="{ width: '100%', height: '100%' }"></div>
				</el-col>
				<el-col :span="7" style="height: 20rem">
					<el-card style="width: 95%; margin-right: 15px;margin-top: 10px">
						分析结果
						<h2 id="control-3414428">中高发热量煤</h2>
						<el-table :data="coalList">
							<el-table-column label="类别名称" align="center" prop="typeName" />
							<el-table-column label="发热量范围（MJ/kg）" align="center" prop="heatRange" />
						</el-table>
					</el-card>
				</el-col>
			</el-row>
		</el-card>
	</div>
</template>

<script>
	import * as echarts from 'echarts'

	export default {
		name: 'test',
		data() {
			return {
				// 遮罩层
				loading: true,
				barChartX: [
					'水分',
					'灰分',
					'挥发分',
					'电阻率',
					'密度',
					'基低位发热量KJ'
				],
				barChart1Y: [10, 30, 15, 13, 40, 7],
				barChart2Y: [15, 20, 3, 7, 28, 5],
				color: [
					'#5470c6',
					'#91cc75',
					'#fac858',
					'#ee6666',
					'#73c0de',
					'#3ba272',
					'#fc8452',
					'#9a60b4',
					'#ea7ccc'
				],
				queryParams: {
					pageNum: 1,
					pageSize: 5,
					batchNumber: null,
					licensePlate: null,
					locationMiningArea: null
				},
				dateRange: [],
				coalList: [
					{
						typeName: '特高发热量',
						heatRange: '30.90~'
					},
					{
						typeName: '高发热量',
						heatRange: '27.21~30.90'
					},
					{
						typeName: '中高发热量',
						heatRange: '24.31~27.20'
					},
					{
						typeName: '中发热量',
						heatRange: '21.31~24.30'
					},
					{
						typeName: '低发热量',
						heatRange: '0~16.70'
					}
				]
			}
		},
		created() {},
		mounted() {
			this.initChart()
			window.addEventListener('resize', this.resizeCharts)
		},
		beforeDestroy() {
			window.addEventListener('resize', this.resizeCharts)
		},
		methods: {
			initChart() {
				let getchart = echarts.init(document.getElementById('barChart'))
				var option = {
					title: {
						show: true,
						text: '煤种分析',
						textAlign: 'center',
						left: '50%',
						top: '5%'
					},
					color: this.color,
					xAxis: {
						type: 'category',
						interval: 0,
						data: this.barChartX
					},
					yAxis: {
						type: 'value'
					},
					legend: {
						x: 'center',
						y: 'bottom',
						data: ['车辆样本数据', '标准数据']
					},
					series: [
						{
							name: '车辆样本数据',
							// barWidth: '50%',
							data: this.barChart1Y,
							type: 'bar'
						},
						{
							name: '标准数据',
							// barWidth: '50%',
							data: this.barChart2Y,
							type: 'bar'
						}
					]
				}
				getchart.setOption(option)
				//随着屏幕大小调节图表
				window.addEventListener('resize', () => {
					getchart.resize()
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
	.myTable {
		width: 100%;
		height: 50%;
	}
</style>

