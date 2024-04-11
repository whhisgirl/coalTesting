<template>
  <div>
    <div class="size-icon">
      <el-popover
        width="100"
        trigger="manual"
        :close-delay="0"
        v-model="item.isShow"
      >
        <div>{{ item.content }}</div>
        <i
          class="el-icon-truck" style="margin-top:10px; color:orange;margin-left: 235px;margin-bottom:10px"
          slot="reference"
          @mouseover="changeStatus(item, true)"
          @mouseleave="changeStatus(item, false)"
        ></i></el-popover>
    </div>
    <el-steps :active="current" align-center finish-status="success" style="height:100px">
      <el-step v-for="item in steps" :key="item.title" :title="item.title"></el-step>
    </el-steps>
  </div>
</template>
<script>

import Child from '@/views/test/coal/step1.vue'
import Child2 from '@/views/test/coal/step2.vue'
import Child3 from '@/views/test/coal/step3.vue'
import Child4 from '@/views/test/coal/step4.vue'
import Child5 from '@/views/test/coal/step5.vue'
import {listRegistration, getRegistration, updateRegistration, addRegistration} from "@/api/system/registration";
import {listBatch, getBatch, addBatch, updateBatch} from "@/api/system/batch";

export default {
  components: {},
  data() {
    return {
      steps: [{
        title: '忻州市',
      },
        {
          title: '唐山市',
        },
        {
          title: '秦皇岛市',
        },
        {
          title: '营口市',
        },
        {
          title: '大连市',
        },],
      coalNumber: '',
      form: {},
      t: {},
      current: 2,
      item: {content: "车牌号: 晋H 56SF8", isShow: false}
    }
  },
  methods: {
    changeStatus(item, status) {
      this.$set(item, "isShow", status);
    },
  },
  mounted() {
    this.change1 = true;
  },
}

</script>
<style scoped>
.box-card {
  width: 1200px;
  margin-left: 80px;
  margin-top: 0px;
}

.el-step >>> .el-step__line {
  border-top: 1px dashed #CCD1DE;
  height: 0;
  background-color: transparent;
}

.el-step >>> .el-step__line-inner {
  border-bottom: 1px dashed;
  height: 0;
  border-color: #1aff00;
  background-color: transparent;
}

.el-step ::v-deep {
  .el-step__title.is-process {
    color: orange;
  }

  .el-step__head.is-process {
    color: orange;

    .el-step__icon.is-text {
      background: #CCD1DE;
      color: orange;
      border-color: orange;
    }

    .el-step__line-inner {
      border-bottom: 1px dashed;
      height: 0;
      border-color: orange;
      background-color: transparent;
    }
  }
}

.size-icon {
  padding: 0 0 0 0;
  font-size: 50px;
}

</style>
