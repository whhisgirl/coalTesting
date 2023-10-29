<template>
  <el-card v-if="show" class="card1">
    <div style="margin-left: 20px;margin-top: 20px;">
      <el-steps :active="active" finish-status="success" style="margin-left: 250px;" align-center :space="400">
        <el-step title="信息导入"></el-step>
        <el-step title="预览"></el-step>
      </el-steps>


      <el-form :inline="true" :model="formInline" class="demo-form-inline" style="margin-left: 400px;margin-top: 25px;">
        <el-form-item label=" 煤炭批次编号">
          <el-input v-model="formInline.user" placeholder="请输入煤炭批次编号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="cyInsert">采样信息导入</el-button>
          <el-button type="primary" @click="zbInsert">指标结果导入</el-button>
        </el-form-item>
      </el-form>


      <div style="width: 100%; background:  #d2e9ff; border-radius: 10px">
        <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
          采样信息
        </p>
      </div>

      <el-row>
        <el-form :inline="true" :model="cyMessage" class="demo-form-inline" style="margin-left: 100px;margin-top: 25px;">
          <el-col span="6">
            <el-form-item label="采样时间">

              <el-input v-model="cyMessage.time" placeholder="" style="width: 200px;" :disabled="true"></el-input>


            </el-form-item>
          </el-col>
          <el-col span="6">
            <el-form-item label=" 采样地点">
              <el-input v-model="cyMessage.location" placeholder="" :disabled="true"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 采样人">

              <el-input v-model="cyMessage.person" placeholder="" :disabled="true"></el-input>
            </el-form-item></el-col>

        </el-form>
      </el-row>
      <el-row>
        <el-form :inline="true" :model="cyMessage" class="demo-form-inline" style="margin-left: 100px;margin-top: 5px;">
          <el-col span="6">
            <el-form-item label=" 样品粒度">
              <el-input v-model="cyMessage.SampleSize" placeholder="" :disabled="true"></el-input>
            </el-form-item>
          </el-col><el-col span="6">
            <el-form-item label=" 采样标准号">
              <el-input v-model="cyMessage.standard" placeholder="" :disabled="true"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 采样方式">
              <el-input v-model="cyMessage.methods" placeholder="" :disabled="true"></el-input>
            </el-form-item>
          </el-col><el-col span="6">
          </el-col>
        </el-form>
      </el-row>
      <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
        <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
          指标结果
        </p>
      </div>

      <el-form :inline="true" :model="zbResult" class="demo-form-inline" style="margin-left: 100px;margin-top: 25px;">
        <el-row>
          <el-col span="6">
            <el-form-item label=" 水分">
              <el-input v-model="zbResult.water" placeholder="" style="margin-left: 8px;" :disabled="true"></el-input>
            </el-form-item>
          </el-col><el-col span="6">
            <el-form-item label=" 密度" style="margin-left: 10px;">
              <el-input v-model="zbResult.density" placeholder="" :disabled="true"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 基低位发热量">
              <el-input v-model="zbResult.heat" placeholder="" :disabled="true"></el-input>
            </el-form-item></el-col></el-row>

      </el-form>
      <el-form :inline="true" :model="zbResult" class="demo-form-inline" style="margin-left: 100px;margin-top: 5px;">
        <el-row><el-col span="6">
            <el-form-item label=" 挥发分">
              <el-input v-model="zbResult.volatilize" placeholder="" :disabled="true"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 灰分" style="margin-left: 5px;">
              <el-input v-model="zbResult.grey" placeholder="" style="margin-left: 1px;" :disabled="true"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 电阻率" style="margin-left: 20px;">
              <el-input v-model="zbResult.resistance" placeholder="" style="margin-left: 20px;"
                :disabled="true"></el-input>
            </el-form-item></el-col>
        </el-row>

      </el-form>
      <el-form :inline="true" :model="zbResult" class="demo-form-inline" style="margin-left: 95px;margin-top: 5px;">
        <el-row><el-col span="6">
            <el-form-item label=" 检测时间">
              <el-input v-model="zbResult.time" placeholder="" :disabled="true"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 检测地">
              <el-input v-model="zbResult.location" placeholder="" :disabled="true"></el-input>
            </el-form-item></el-col>
          <el-col span="6">
          </el-col>
          <el-col span="6">
          </el-col>
        </el-row>

      </el-form>
      <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
        <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
          录入剩余信息
        </p>
      </div>

      <el-form :inline="true" :model="coal" class="demo-form-inline" style="margin-left: 95px;margin-top: 30px;">
        <el-form-item label=" 报告生成时间">
          <el-date-picker
            v-model="value1"
            type="datetime"
            placeholder="选择日期时间"
            value-format="yyyy-MM-dd HH:mm"
            format="yyyy-MM-dd HH:mm">
          </el-date-picker>
        </el-form-item>
        <el-form-item label=" 检测标准号">
          <el-input v-model="coal.standard" placeholder="请输入批次标准号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="next" style="margin-left: 95px">下一步</el-button>

        </el-form-item>

      </el-form>
    </div>
  </el-card>

  <el-card v-else class="card">
    <el-steps :active="active" finish-status="success" align-center :space="400"
      style="margin-left: 270px;margin-top: 20px;">
      <el-step title="信息导入"></el-step>
      <el-step title="预览"></el-step>
    </el-steps>



    <table style="margin-top: 20px;">

      <thead>
        <tr>
          <th colspan="6" style="font-size: 25px;">煤炭检测报告</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th colspan="6">采样信息</th>
        </tr>
        <tr>
          <th class="color">采样时间</th>
          <th>2023-1-21 14:03</th>
          <th class="color">采样地点</th>
          <th>山西忻州</th>
          <th class="color">采样人</th>
          <th>汤景</th>
        </tr>
        <tr>
          <th class="color">样品粒度</th>
          <th>粒煤</th>
          <th class="color">采样标准号</th>
          <th>GB475-2008</th>
          <th class="color"> 采样方式</th>
          <th>连续采样法</th>
        </tr>
        <tr>
          <th colspan="6">指标结果</th>
        </tr>
        <tr>
          <th class="color">煤炭批次编号</th>
          <th>C120J145</th>
          <th class="color">水分</th>
          <th>8.13</th>
          <th class="color">密度</th>
          <th>3.97</th>
        </tr>
        <tr>
          <th class="color">基低位发热量</th>
          <th>5235</th>
          <th class="color">挥发分</th>
          <th>28.30</th>
          <th class="color">灰分</th>
          <th>23.28</th>
        </tr>
        <tr>
          <th class="color">电阻率</th>
          <th>377</th>
          <th class="color">检测时间</th>
          <th>2023-1-21 11:02</th>
          <th class="color">检测地</th>
          <th>山西忻州</th>
        </tr>
        <tr>
          <th colspan="6">其它信息</th>
        </tr>
        <tr>
          <th colspan="2" class="color">报告生成时间</th>
          <th>2023-10-19 11:02</th>
          <th colspan="2" class="color">检测标准号</th>
          <th>GB475-2008-1</th>
        </tr>
      </tbody>
    </table>
    <div>
      <el-button type="primary" @click="open" style="margin-left: 550px;margin-top: 50px">打印</el-button>
      <el-button type="second" @click="next()" style="margin-left: 40px">上一步</el-button>
      <el-button type="second" @click="back()" style="margin-left: 40px">返回首页</el-button>
    </div>
  </el-card>
</template>
<script>
export default {
  data() {
    return {
      name: "report",
      active: 0,
      show: true,
      test: '',
      value1: '',
      formInline: {
        user: '',
        region: ''
      },
      coal: {
        number: '',
        standard: ''
      },
      cyMessage: {
        time: '',
        location: '',
        person: '',
        SampleSize: '',
        standard: '',
        methods: '',
        weather: ''
      },
      zbResult: {
        water: '',
        density: '',
        heat: '',
        volatilize: '',
        grey: '',
        resistance: '',
        time: '',
        location: '',
        standard: ''
      },
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      }
    };

  },

  methods: {
    open() {
      this.$message('打印成功');
      window.print();
    },
    next() {
      if (this.active++ > 2) this.active = 0;
      this.show = !this.show

    },
    openVn() {
      const h = this.$createElement;
      this.$message({
        message: h('p', null, [
          h('span', null, '内容可以是 '),
          h('i', { style: 'color: teal' }, 'VNode')
        ])
      });
    },

    onSubmit() {
      console.log('submit!');
    },
    cyInsert() {
      this.cyMessage.time = "2023-08-09 14:24"
      this.cyMessage.location = "山西忻州";
      this.cyMessage.person = "汤景";
      this.cyMessage.SampleSize = "粒煤";
      this.cyMessage.standard = "GB475-2008";
      this.cyMessage.methods = "连续采样法";
      this.$forceUpdate()
    },
    zbInsert() {
      this.zbResult.water = "8.13";
      this.zbResult.density = "3.97";
      this.zbResult.heat = "5235";
      this.zbResult.volatilize = "28.30";
      this.zbResult.grey = "23.28";
      this.zbResult.resistance = "377";
      this.zbResult.time = "2023-1-21 11:02";
      this.zbResult.location = "山西忻州";

      this.$forceUpdate()
    },
    back() {
      this.$router.push({ path: "/index" });
    },

  }
}
</script>



<style scoped>
.card {
  width: 1500px;
  height: 1200px;
  margin: 1% 5%;
}

.card1 {
  width: 1500px;
  height: 900px;
  margin: 1% 5%;
}

.color {
  background-color: #dad8d8;
}

table {
  width: 70%;
  height: 800px;
  margin-left: 200px;
  border-collapse: collapse;
}

table caption {
  font-size: 2em;
  font-weight: bold;
  margin: 1em 0;
}

th,
td {
  border: 1px solid #999;
  text-align: center;
  padding: 20px 0;
}
</style>

