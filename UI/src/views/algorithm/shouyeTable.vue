<template>
  <el-table
    :data="tableData"
    :header-cell-style="{backgroundColor:'#4f81bd',color:'white'}"
    border
    style="width: 100%;margin-top: 30px">
    <el-table-column
      prop="coalNumber"
      label="煤采样编号"
      align="center"
      width="120">
    </el-table-column>
    <el-table-column
      prop="sampler"
      label="采样人"
      align="center"
      width="80">
    </el-table-column>
    <el-table-column
      prop="miningAreaName"
      align="center"
      label="矿区名称"
      width="120">
    </el-table-column>
    <el-table-column label="报告生成时间" align="center" prop="reportTime" >
      <template slot-scope="scope">
        <span>{{ parseTime(scope.row.reportTime, '{y}-{m}-{d}') }}</span>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name:"shouyeTable",
  data() {
    return {
      tableData: [{
        coalNumber: 'C1201G101',
        sampler: '汤景',
        miningAreaName: '忻州宏远矿区',
        reportTime:'2023-10-10 15:30'
      },
        {
          coalNumber: 'C1201G303',
          sampler: '汤景',
          miningAreaName: '忻州宏远矿区',
          reportTime:'2023-10-12 18:10'
        },
        {
          coalNumber: 'C1201G201',
          sampler: '汤景',
          miningAreaName: '忻州宏远矿区',
          reportTime:'2023-10-13 12:25'
        },
        {
          coalNumber: 'C1201G301',
          sampler: '汤景',
          miningAreaName: '忻州宏远矿区',
          reportTime:'2023-10-14 11:40'
        },
        {
          coalNumber: 'C1201G201',
          sampler: '汤景',
          miningAreaName: '忻州宏远矿区',
          reportTime:'2023-10-18 14:10'
        },
        {
          coalNumber: 'C1201G201',
          sampler: '汤景',
          miningAreaName: '忻州宏远矿区',
          reportTime:'2023-10-19 16:10'
        },]
    }
  },
}
</script>
<style scoped>
</style>
