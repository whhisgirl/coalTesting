<template>
  <div>
    <el-row>
      <el-col style=" width: 50%;height: 950px">
        <el-card  style=" width: 100%;height: 950px">
          <one-radical></one-radical>
          <span></span>
          <el-button type="primary" @click="search()" class="searchButton">搜索</el-button>
        </el-card>
      </el-col>
      <el-col style=" width: 50%;height: 950px">
        <el-card style=" width: 100%;height: 950px" :body-style="{ width: '100%' ,height: '950px' }">
          <one-result v-if="show"></one-result>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>

import scrollNumber from "@/components/scrollNumber/scrollNumber.vue";
import center from "@/views/algorithm/gundong.vue";
import oneRadical from "./oneRadical.vue";
import oneResult from "./result.vue";
import {searchIfUseDict} from "@/api/casedata/casedata";

export default {
  name: "Graph",
  components: {
    // right2
    oneRadical,
    oneResult,
  },
  data() {
    return {
      show: false,
    };
  },
  methods: {
    search() {
      this.show = true;
      console.log("show");
    },
  }
}
</script>

<style scoped>
.root {
  height: calc(90vh - 120px);
  width: 100%;
}

.searchButton {
  height: 50px;
  width: 100px;
  font-size: 18px;
  float: right
}

.graph {
  height: 50%;
  width: 50%;
  /*border: 1px solid black*/
  /*display: inline-block;*/
  /*position: relative;*/
  /*top: -105%;*/
  /*right: -40%*/
}




</style>

