<template>
  <div class="table_body">
    <div class="table_th">
      <div class="tr1 th_style">排名</div>
      <div class="tr3 th_style">煤炭种类</div>
      <div class="tr4 th_style">产量（吨）</div>
      <div class="tr2 th_style">增长率</div>
    </div>

    <div class="table_main_body">
      <div class="table_inner_body" :style="{top: tableTop + 'px'}">
        <div class="table_tr" v-for="(item, index) in displayBatchList" :key="index">
          <div class="tr1 tr">{{ item.batchNumber }}</div>
          <div class="tr3 tr">{{ item.miningAreaName }}</div>
          <div class="tr4 tr">{{ item.arrivalStatus }}</div>
          <div class="tr2 tr">{{ item.startTime }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 静态数据
      batchList: [
        { batchNumber: '1', miningAreaName: '低热值煤', arrivalStatus: '10000', startTime: '23%' },
        { batchNumber: '2', miningAreaName: '中热值煤', arrivalStatus: '9568', startTime: '16%' },
        { batchNumber: '3', miningAreaName: '中灰煤', arrivalStatus: '8569', startTime: '7%' },
        { batchNumber: '4', miningAreaName: '低灰煤', arrivalStatus: '7638', startTime: '2%' },
        { batchNumber: '5', miningAreaName: '高热值煤', arrivalStatus: '5249', startTime: '-3%' },
        { batchNumber: '6', miningAreaName: '高灰煤', arrivalStatus: '3261', startTime: '-6%' },
        { batchNumber: '7', miningAreaName: '无烟煤', arrivalStatus: '2879', startTime: '-8%' },
        { batchNumber: '8', miningAreaName: '烟煤', arrivalStatus: '2632', startTime: '-10%' },
        { batchNumber: '9', miningAreaName: '褐煤', arrivalStatus: '2431', startTime: '-12%' },
        { batchNumber: '10', miningAreaName: '泥煤', arrivalStatus: '2014', startTime: '-9%' },
      ],
      displayBatchList: [],
      tableTop: 0,
      lineHeight: 49,
      tableTimer: null,
      tableTimerInterval: 100,
    };
  },
  mounted() {
    this.prepareScrollData();
    this.startScrolling();
  },
  methods: {
    prepareScrollData() {
      // 确保有足够的数据来滚动
      this.displayBatchList = [...this.batchList, ...this.batchList, ...this.batchList];
    },
    startScrolling() {
      // 滚动逻辑
      let count = 0;
      const maxScroll = (this.displayBatchList.length / 3) * this.lineHeight;
      this.tableTimer = setInterval(() => {
        if (count < maxScroll) {
          this.tableTop -= 1;
          count++;
        } else {
          this.tableTop = 0;
          count = 0;
        }
      }, this.tableTimerInterval);
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
