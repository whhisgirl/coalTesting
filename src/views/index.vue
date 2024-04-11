<template>
  <div style=" min-height: 100%;  " align="middle" class="myDiv">
    <div class="head"><h1 style="margin-left: 0px; font-size: 22px; color: white; font-weight: 700; margin-top: 3px; background-color:rgba(0, 0, 0, 0);">一体化煤质智能检测分析平台</h1></div>
    <el-row :gutter="20">
      <el-col :span="11" :offset="1">
        <div v-if="show"  class="myRadio">
          <div @click="goinspect" style="margin-top:50px;height:250px;font-size: 2.0em;color: #FFFFFF;background: #1ab394;">
            <div class="miniBox">
              <i class="el-icon-s-order"></i>
              <div style="width: 150px">煤质指标分析</div>
            </div>
          </div>
        </div>
        <div v-if="show2" class="myRadio">
            <div @click="goinspect"  style="margin-top:50px;height:515px;font-size: 2.0em;color: #FFFFFF;background: #1ab394;">
            <div class="mediaBox">
              <i class="el-icon-s-order"></i>
              <div style="width: 150px">煤质指标分析</div>
            </div>
          </div>
        </div>
        <div v-if="show" class="myRadio">
          <div @click="godriver" style="height:250px;font-size: 2.0em;color: #FFFFFF;background: #f26522;">
            <div class="miniBox">
              <i class="el-icon-truck"></i>
              <div style="width: 150px">司机信息详情</div>
            </div>
          </div>
        </div>
      </el-col>
      <el-col :span="11">
        <div class="myRadio">
          <div @click="gomainten" style="margin-top:50px;height:250px;font-size: 2.0em;color: #FFFFFF;background:#FFCE35;">
            <div class="miniBox">
              <i class="el-icon-s-tools"></i>
              <div style="width: 150px">煤质对比分析</div>
            </div>
          </div>
        </div>

        <div class="myRadio">
          <div @click="goaudit" style="height:250px;font-size: 2.0em;color: #FFFFFF;background: #3FBDFF;">
            <div class="miniBox">
              <i class="el-icon-s-custom"></i>
              <div style="width: 150px">煤质异常分析</div>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
    <el-row style="background: rgb(10, 24, 98)">
      <el-col :span="22" :offset="1">
        <div class="myRadio">
          <div @click="logout" style="height:150px;font-size: 2.0em;color: #FFFFFF;background:#FF6A6A;">
            <div style="padding-top: 40px">
              <i class="el-icon-switch-button"></i>
              <div>退出</div>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import { getToken } from "@/utils/auth";
export default {
  props:['message2'],
  data() {
    return {
      loading: "",
      param: {
        token: "",
      },
      ruleForm:{},
      disabled: false,
//上传
      upload: {
// 是否禁用上传
        isUploading: false,
// 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
// 上传的地址
        url: process.env.VUE_APP_BASE_API + "/common/upload",
      },
      showType:{
        name:null,
        url:null,
      },
      fileList:[],
      uploadFileList:[],
      beforeList:[],
      afferentList:null,
      show: localStorage.getItem("username")=="zhaotianming"?true :false,
      show2:localStorage.getItem("username")=="admin"?true :false,
      roleSelectOptions: [{
        "label": "巡检员",
        "value": 1
      }, {
        "label": "维保管理员",
        "value": 2
      }, {
        "label": "审核人员",
        "value": 3
      }, {
        "label": "维保人员",
        "value": 4
      }],
      formData: {
        title: undefined,
        roleSelect: 4,
      },
    };
  },
  created() {

  },
  mounted(){
    this.$store.dispatch('app/toggleSideBarHide', true);
    document.querySelector('.navbar').style.display = "none";
    document.querySelector('.tags-view-container').style.display = "none"
  },
  methods: {
    goinspect(){
      this.$router.push({
        path: "/coalAnalyse",
      });
    },
    goaudit(){
      this.$router.push({
        path: "/coalTransportationAnalysisApp",
      });
    },
    godriver(){
      this.$router.push({
        path: "/coalDriverApp",
      });
    },
    gomainten(){
      this.$router.push({
        path: "/reportAnalysisApp",
      });
    },
    async logout() {
      this.$confirm('确定注销并退出系统吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        customClass:"notice"
      }).then(() => {
        this.$store.dispatch('LogOut').then(() => {
          /*location.href = '/login';*/
          this.$router.push({
            path: "/login",
          });
        })
      }).catch(() => {});
    }

  },
};
</script>
<style scoped>
.miniBox{
  padding-top: 60px;
}
.mediaBox{
  padding-top: 180px;
}
.myRow {
  font-size: 30px;

  border: none;
  float: left;
  outline: medium;

}
.myRadio {
  width: 100%;
  height: 100%;
  border: none;
  background-color:rgb(10, 24, 98);
  margin-bottom: 10%;
  margin-top: 2%;
}
.head {
  width:100%;
  width:100%;
  position: relative;
  height: 55px;
  background-size: 100%;
  /*text-align: center;*/
  /* background: rgb(10, 24, 98) url(../assets/images/app_header1.png) no-repeat bottom; */
  background: rgb(10, 24, 98) url(../assets/images/header.png) no-repeat bottom;
}
.myDiv {
  width: 100%;
  height: 100%;
  background-size:100% auto ,100% auto;
  background-color:rgb(10, 24, 98);
  min-height: calc(100vh);
  position: absolute;
}

.head h1 {
  display: inline-block;
  font-size: 1.0em;
  color: #bde4ff;

}



</style>
<style>
.notice{
  width:80%;
}
</style>
