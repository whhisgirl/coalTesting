<template>
  <el-main>
  <el-form :inline="true" :model="formInline" class="demo-form-inline">
    <el-form-item label="采样方式">
      <el-input v-model="formInline.method"></el-input>
    </el-form-item>
    <el-form-item label="采样人">
      <el-input v-model="formInline.guy">
      </el-input>
    </el-form-item>
    <el-form-item label="采样时间">
    <el-date-picker
      v-model="formInline.t"
      type="datetimerange"
      range-separator="至"
      start-placeholder="开始日期"
      end-placeholder="结束日期">
    </el-date-picker>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">查询</el-button>
      <el-button type="primary" @click="cl">新增</el-button>
    </el-form-item>
  </el-form>

  <el-table
    :data="tableData"
    width="100%" :row-style="{height:'80px'}">
    <el-table-column
      prop="date"
      label="采样时间"
      align="center">
    </el-table-column>
    <el-table-column
      prop="weather"
      label="采样天气"
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
      prop="way"
      label="采样方式" align="center">
    </el-table-column>
    <el-table-column
      prop="place"
      label="采样地点" align="center">
    </el-table-column>
    <el-table-column
      prop="man"
      label="采样人" align="center">
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
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[5, 10]"
      :page-size="5"
      layout="total, sizes, prev, pager, next, jumper"
      :total="40">
    </el-pagination>
  </el-main>
</template>

<script>
import {getAuthRole, updateAuthRole} from "@/api/system/user";

export default {
  data() {
    return {
      currentPage: 1,
      formInline: {
        method: '',
        guy: '',
        t:[],
      },
      tableData: [{
        date: '2023-10-05',
        weather: '晴',
        code: 'GB475-2008',
        granularity: '粒煤',
        way: '连续采样法',
        place: '冯西矿区',
        man: '李东',
        number: 'C1201J05',
        location: '朔州市',
        goal: '内蒙古棋盘井车站',
        height: '40',
        car: '辽B 926QB',
        time: '2023-10-07'
      }, {
        date: '2023-10-10',
        weather: '阴',
        code: 'GB475-2008',
        granularity: '粒煤',
        way: '连续采样法',
        place: '焦作矿区',
        man: '赵利霞',
        number: 'C1201J11',
        location: '焦作市',
        goal: '朔州市平鲁车站',
        height: '40',
        car: '豫H SD52D',
        time: '2023-10-12',
      }, {
        date: '2023-10-15',
        weather: '晴',
        code: 'GB475-2008',
        granularity: '粉煤',
        way: '随机采样法',
        place: '包头矿区',
        man: '孙泰',
        number: 'C1201J20',
        location: '包头市',
        goal: '河南焦作站',
        height: '40',
        car: '蒙B 356SD',
        time: '2023-10-17'
      }, {
        date: '2023-10-18',
        weather: '晴',
        code: 'GB475-2008',
        granularity: '小块',
        way: '随机采样法',
        place: '晋城矿区',
        man: '张志德',
        number: 'C1201J50',
        location: '山西市',
        goal: '山西晋城站',
        height: '40',
        car: '晋E AS5D4',
        time: '2023-10-20'
      },
        {
          date: '2023-10-21',
          weather: '晴',
          code: 'GB475-2008',
          granularity: '粒煤',
          way: '随机采样法',
          place: '焦作矿区',
          man: '赵利霞',
          number: 'C1201J13',
          location: '焦作市',
          goal: '山西晋城站',
          height: '40',
          car: '豫H WER51',
          time: '2023-10-23',
        }]
    };
  },
  methods: {
    onSubmit() {

    },
    cl(){
    this.$router.push({name: 'coal-abc'});
  },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    }
  },
}

</script>




