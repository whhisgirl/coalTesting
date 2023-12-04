<template>
  <div>
<el-col :span="12">
    <one-radical></one-radical>
  <span></span><el-button type="primary" class="searchButton">搜索</el-button>
</el-col>
    <el-col  :span="12">

    </el-col>
  </div>
</template>

<script>

import scrollNumber from "@/components/scrollNumber/scrollNumber.vue";
import center from "@/views/algorithm/gundong.vue";
import oneRadical from "./oneRadical.vue";
export default {
  name: "Graph",
  components:{
    // right2
    oneRadical,
  },



}
</script>

<style scoped>
.root {
  height: calc(90vh - 120px);
  width: 100%;
}
.searchButton{
  height:50px;
  width:100px;
  font-size:18px;
  float:right
}
.graph {
  height: 100%;
  width: 100%;
  /*border: 1px solid black*/
  /*display: inline-block;*/
  /*position: relative;*/
  /*top: -105%;*/
  /*right: -40%*/
}
</style>

