<template>
	<div>
		<el-card style="width: 95%; margin-left: 30px; margin-top: 10px">
			<el-form
				:model="queryParams"
				ref="queryForm"
				size="small"
				:inline="true"
				v-show="showSearch"
				label-width="68px"
			>
				<el-form-item label="煤采样编号" prop="batchNumber" label-width="100px">
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
				<el-form-item>
					<el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
					<el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
				</el-form-item>
			</el-form>
			<el-table v-loading="loading" :data="indicatorsList" @selection-change="handleSelectionChange">
				<el-table-column type="selection" width="55" align="center" />
				<el-table-column label="煤采样编号" align="center" prop="coalNumber" />
				<el-table-column label="水分" align="center" prop="waterContent" />
        <el-table-column label="密度" align="center" prop="density" />
        <el-table-column label="电阻率" align="center" prop="resistivity" />
				<el-table-column label="灰分" align="center" prop="ashContent" />
				<el-table-column label="挥发分" align="center" prop="coalVolatile" />
				<el-table-column label="基低位发热量" align="center" prop="baseLowCalorific" />
				<el-table-column label="操作" align="center" class-name="small-padding fixed-width">
					<template slot-scope="scope">
						<el-button size="mini" type="text" icon="el-icon-edit" @click="handleView(scope.row)">查看</el-button>
					</template>
				</el-table-column>
			</el-table>
			<pagination
				v-show="total>0"
				:total="total"
				:page.sync="queryParams.pageNum"
				:limit.sync="queryParams.pageSize"
				@pagination="getList"
			/>
		</el-card>
	</div>
</template>

<script>
	// import { listData, getData, delData, addData, updateData } from "@/api/system/data";
	// import {getToken} from "@/utils/auth";
	import * as echarts from 'echarts'
	import {
		listIndicators,
		getIndicators,
		addIndicators
	} from '@/api/system/indicators'

	export default {
		name: 'CompareCoalType',
		data() {
			return {
				// 遮罩层
				loading: true,
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
				// 【请填写功能名称】表格数据
				indicatorsList: [],
				// 弹出层标题
				title: '',
				// 是否显示弹出层
				open: false,
				dateRange: [],
				//查询参数
				queryParams: {
					pageNum: 1,
					pageSize: 5,
					batchNumber: null,
					licensePlate: null,
					locationMiningArea: null
					// status: null,
					// completeTime: null,
					// name: null
				},
				// 表单参数
				form: {},
				// 表单重置
				reset() {
					this.form = {
						batchNumber: null,
						locationMiningArea: null,
						licensePlate: null
					}
					this.resetForm('form')
				},
				// 表单校验
				rules: {}

				//查看页面跳转
				// isShow: true,
				// info: '煤种分析'
			}
		},
		created() {
			this.getList()
		},

		methods: {
			/** 查询【请填写功能名称】列表 */
			getList() {
				this.loading = true
				listIndicators(this.queryParams).then(response => {
					this.indicatorsList = response.rows
					this.total = response.total
					this.loading = false
				})
			},
			/** 搜索按钮操作 */
			handleQuery() {
				this.queryParams.pageNum = 1
				this.getList()
			},
			/** 重置按钮操作 */
			resetQuery() {
				this.resetForm('queryForm')
				this.handleQuery()
			},
			/** 修改按钮操作 */
			// handleView(row) {
			// 	this.reset()
			// 	const coalNumber = row.coalNumber || this.ids
			// 	getIndicators(coalNumber).then(response => {
			// 		this.form = response.data
			// 		this.open = true
			// 		this.title = '修改【请填写功能名称】'
			// 	})
			// },
			handleView(row) {
				// this.$router.push({name:'testC',params:{setid:111222}});
				this.$router.push({ path: '/comAnalysis/test', params: {} })
			},
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
					series: [
						{
							name: '车辆样本数据',
							// barWidth: '50%',
							data: this.barChart1Y,
							type: 'bar',
							label: {
								show: true,
								position: 'top'
							}
						},
						{
							name: '标准数据',
							// barWidth: '50%',
							data: this.barChart2Y,
							type: 'bar',
							label: {
								show: true,
								position: 'top'
							}
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

