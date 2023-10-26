<template>
  <div>
    <el-steps :active="current" align-center finish-status="success" style="height:100px; padding-top: 40px">
      <el-step v-for="item in steps" :key="item.title" :title="item.title"></el-step>
    </el-steps>
    <child v-if="change1"></child>
    <Child2 v-if="change2"></Child2>
    <el-row type="flex" :gutter="240" justify="space-around">
      <el-col :span="8">
        <el-button @click="last" v-if="current!=0?true:false">上一步</el-button>
      </el-col>
      <el-col :span="8">
        <el-button @click="next" v-if="current!=steps.length-1?true:false">下一步</el-button>
        <el-button @click="complete">完成</el-button>
      </el-col>
    </el-row>
  </div>
</template>
<script>

import Child from '@/views/test/coal/step1.vue'
import Child2 from '@/views/test/coal/step2.vue'

export default {
  components: {
    Child, Child2

  },
  data() {
    return {
      current: 0,
      change1: false,
      change2: false,
      steps: [
        {
          title: '采样信息录入',
        },
        {
          title: '煤炭批次记录',
        },
        {
          title: '运输前6项',
        },
        {
          title: '到达后6项',
        },
        {
          title: '指标分析',
        },
      ],


    }
  },
  mounted() {
    this.change1 = true;
  },
  methods: {
    next() {
      this.current++;
      if (this.current == 0) {
        this.change1 = true;
        this.change2 = false;
      } else if (this.current == 1) {
        this.change1 = false;
        this.change2 = true;
      }
    },
    last() {
      this.current--;
      if (this.current == 0) {
        this.change1 = true;
        this.change2 = false;
      } else if (this.current == 1) {
        this.change1 = false;
        this.change2 = true;
      }
    },
    complete() {
    },
  }
}

</script>
