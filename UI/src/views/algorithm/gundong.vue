<template>
  <div class="table_body">
    <div class="table_th">
    <div class="tr1 th_style">批次编号</div>
    <div class="tr2 th_style">煤采样编号</div>
    <div class="tr3 th_style">矿区名称</div>
    <div class="tr4 th_style">到达状态</div>
    </div>
<!--    <el-table v-loading="loading" :data="batchList" @selection-change="handleSelectionChange">-->
<!--      <el-table-column min-width="25%" label="批次编号" align="center" prop="batchNumber" />-->
<!--      <el-table-column min-width="25%" label="煤采样编号" align="center" prop="coalNumber" />-->
<!--      <el-table-column min-width="25%" label="矿区名称" align="center" prop="miningAreaName" />-->
<!--      <el-table-column min-width="25%" label="到达状态" align="center" prop="arrivalStatus" />-->
<!--    </el-table>-->
    <div class="table_main_body">
      <div class="table_inner_body" :style="{top: tableTop + 'px'}">
        <div class="table_tr" v-for="(item,index) in batchList" :key="index">
          <div class="tr1 tr">{{item.batchNumber}}</div>
          <div class="tr2 tr">{{item.coalNumber}}</div>
          <div class="tr3 tr">{{item.miningAreaName}}</div>
          <div class="tr4 tr" v-if="item.arrivalStatus=='1'">已送达</div>
          <div class="tr4 tr" v-else="item.arrivalStatus=='0'">运输中</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { listBatch, getBatch, delBatch, addBatch, updateBatch } from "@/api/system/batch";
export default {
  data(){
    return{
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
      batchList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        batchCoalWeight: null,
        miningAreaName: null,
        licensePlate: null,
        locationMiningArea: null,
        startTime: null,
        arrivalTime: null,
        registrationNumber: null,
        coalNumber: null,
        destination: null,
        arrivalStatus: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      visibleSize: 4, //容器内可视最大完整行数
      tableTimer: null,
      lineHeight: 49, //每行的实际高度（包含margin-top/bottom,border等）
      componentTimerInterval: 360000, //刷新数据的时间间隔
      tableTimerInterval: 100 ,//向上滚动 1px 所需要的时间，越小越快，推荐值 100
      tableTop: 0,
      tableListSize: 0,
      componentTimer: null,
    };
  },
  // created() {
  //   this.getList();
  //   this.componentTimerFun();
  // },
mounted() {
  clearInterval(this.componentTimer);
  this.getList();
  this.componentTimerFun();
},
  methods:{
    getList() {
      // this.loading = true;
      clearInterval(this.tableTimer);
      this.tableTop = 0;
      listBatch(this.queryParams).then(response => {
        this.batchList = response.rows;
        console.log(this.batchList)
        this.total = response.total;
        this.tableActionFun();
      });
    },
    //根据列表长度是否超过可视范围内能够显示的最大完整数据条数，来控制列表是否需要滚动
    tableActionFun() {
      // console.log(tableActionFun)
      this.tableListSize = this.batchList.length;
      //下面的visibleSize是可视范围内能够显示的最大完整数据条数
      if (this.tableListSize > this.visibleSize) {
        this.batchList = this.batchList.concat(this.batchList);
        this.batchList = this.batchList.concat(this.batchList);
        this.batchList = this.batchList.concat(this.batchList);
        this.tableTimerFun();  //列表滚动方法
      }
    },

//列表滚动方法
    tableTimerFun() {
      // console.log(tableTimerFun)
      var count = 0;
      this.tableTimer = setInterval(() => {
        if (count < (this.batchList.length / 2) * this.lineHeight) {
          this.tableTop -= 1;
          count++;
        } else {
          count = 0;
          this.tableTop = 0;
        }
      }, this.tableTimerInterval);
    },
    componentTimerFun() {
      console.log("componentTimerFun")
      this.componentTimer = setInterval(() => {
        this.getList();
      }, this.componentTimerInterval);
    }
  }
}
</script>

<style scoped>

.tr {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  box-sizing: border-box;
  padding: 0 5px;
  text-align: center;
  font-size: 14px;
}
.tr1 {
  width: 25%;
}
.tr2 {
  width: 25%;
}
.tr3 {
  width: 25%;
  font-size: 13px;
}

.tr4 {
  flex: 1;
}

.th_style {
  color: rgb(0, 221, 253);
  font-weight: bold;
  font-size: 18px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  box-sizing: border-box;
  /*padding: 0 5px;*/
  text-align: center;
  text-align: center;
}

.table_main_body {
  width: 100%;
  height: 294px;
  overflow: hidden;
  position: relative;
}
.table_inner_body {
  width: 100%;
  position: absolute;
  left: 0;
}
.table_th {
  width: 100%;
  display: flex;
  height: 30px;
  /*line-height: 40px;*/
}

.table_tr {
  display: flex;
  height: 40px;
  line-height: 40px;
  color: #eee;
  font-size: 15px;
  background: rgba(3, 145, 167, 0.1);
  border: 1px solid rgb(4, 114, 131);
  margin-top: 7px;
}
.table_body {
  width: 100%;
  /*margin-top: 15px;*/
}

</style>
