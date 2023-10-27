<template>
    <el-card v-if="show" class="card1">
    <div   style="margin-left: 20px;margin-top: 20px;">
        <el-steps :active="active" finish-status="success"  style="margin-left: 250px;" align-center :space="400">
            <el-step title="信息导入"></el-step>
            <el-step title="预览"></el-step>
        </el-steps>
        

        <el-form :inline="true" :model="coal" class="demo-form-inline" style="margin-left: 400px;margin-top: 25px;">
            <el-form-item label=" 煤炭批次编号">
                <el-input v-model="coal.number" placeholder="C120J145"></el-input>
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
                <el-date-picker v-model="value1" type="date" placeholder="选择日期" style="width: 200px;">
                </el-date-picker>
            </el-form-item>
        </el-col>
        <el-col span="6">
            <el-form-item label=" 采样地点">
                <el-input v-model="cyMessage.location" placeholder="山西忻州"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 采样人">
                
                <el-input v-model="cyMessage.person" placeholder="汤景"></el-input>
            </el-form-item></el-col>
        
        </el-form>
         </el-row>
         <el-row>
        <el-form :inline="true" :model="cyMessage" class="demo-form-inline" style="margin-left: 100px;margin-top: 5px;">
            <el-col span="6">
            <el-form-item label=" 样品粒度">
                <el-input v-model="cyMessage.SampleSize" placeholder="粒煤"></el-input>
            </el-form-item>
        </el-col><el-col span="6">
            <el-form-item label=" 采样标准号">
                <el-input v-model="cyMessage.standard" placeholder="GB475-2008"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 采样方式">
                <el-input v-model="cyMessage.methods" placeholder="连续采样法"></el-input>
            </el-form-item>
        </el-col><el-col span="6">
        <el-form-item>
                <el-button type="primary" @click="onSubmit">采样信息导入</el-button>
                
            </el-form-item></el-col>
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
                <el-input v-model="zbResult.water" placeholder="9.33" style="margin-left: 8px;"></el-input>
            </el-form-item>
        </el-col><el-col span="6">
            <el-form-item label=" 密度" style="margin-left: 10px;">
                <el-input v-model="zbResult.density" placeholder="4.10"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 基低位发热量">
                <el-input v-model="zbResult.heat" placeholder="4982"></el-input>
            </el-form-item></el-col></el-row>

        </el-form>
        <el-form :inline="true" :model="zbResult" class="demo-form-inline" style="margin-left: 100px;margin-top: 5px;">
            <el-row><el-col span="6">
            <el-form-item label=" 挥发分">
                <el-input v-model="zbResult.volatilize" placeholder="28.45"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 灰分" style="margin-left: 5px;">
                <el-input v-model="zbResult.grey" placeholder="23.26" style="margin-left: 1px;"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 电阻率" style="margin-left: 20px;">
                <el-input v-model="zbResult.resistance" placeholder="391" style="margin-left: 20px;"></el-input>
            </el-form-item></el-col>
        </el-row>

        </el-form>
        <el-form :inline="true" :model="zbResult" class="demo-form-inline" style="margin-left: 95px;margin-top: 5px;">
            <el-row><el-col span="6">
            <el-form-item label=" 检测时间">
                <el-input v-model="zbResult.time" placeholder="2023-1-21 11:02"></el-input>
            </el-form-item></el-col><el-col span="6">
            <el-form-item label=" 检测地">
                <el-input v-model="zbResult.location" placeholder="山西忻州"></el-input>
            </el-form-item></el-col>
            <el-col span="6">
        </el-col>
            <el-col span="6">
        <el-form-item>
                <el-button type="primary" @click="onSubmit">指标结果导入</el-button>
                
            </el-form-item></el-col>
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
                <el-date-picker v-model="value1" type="date" placeholder="2023-1-21" style="width: 200px;">
                </el-date-picker>
            </el-form-item>
            <el-form-item label=" 检测标准号">
                <el-input v-model="coal.standard" placeholder="GB475-2008-1"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary"@click="next" style="margin-left: 95px" >确认</el-button>
                <el-button type="second" @click="onSubmit" style="margin-left: 40px">取消</el-button>
            </el-form-item>

        </el-form>
    </div>
</el-card>

 <el-card  v-else class="card">
        <el-steps :active="active" finish-status="success" align-center :space="400" style="margin-left: 270px;margin-top: 20px;">
            <el-step title="信息导入"></el-step>
            <el-step title="预览"></el-step>
        </el-steps>
        


<table style="margin-top: 20px;">

<thead>
  <tr >
    <th  colspan="6" style="font-size: 25px;">煤炭检测报告</th>
  </tr>
</thead>
<tbody>
    <tr >
    <th  colspan="6">采样信息</th>
  </tr>
  <tr>
    <th>采样时间</th>
    <th>2023-1-21</th>
    <th>采样地点</th>
    <th>山西忻州</th>
    <th>采样人</th>
    <th>汤景</th>
  </tr>
  <tr>
    <th>样品粒度</th>
    <th>粒煤</th>
    <th>采样标准号</th>
    <th>GB475-2008</th>
    <th>采样方式</th>
    <th>连续采样法</th>
  </tr>
  <tr >
    <th  colspan="6">指标结果</th>
  </tr>
  <tr>
    <th>煤炭批次编号</th>
    <th>C120J145</th>
    <th>水分</th>
    <th>9.33</th>
    <th>密度</th>
    <th>4.10</th>
  </tr>
  <tr>
    <th>基低位发热量</th>
    <th>4982</th>
    <th>挥发分</th>
    <th>28.45</th>
    <th>灰分</th>
    <th>23.26</th>
  </tr>
  <tr>
    <th>电阻率</th>
    <th>391</th>
    <th>检测时间</th>
    <th>2023-10-19 11:02</th>
    <th>检测地</th>
    <th>山西忻州</th>
  </tr>
  <tr >
    <th  colspan="6">其它信息</th>
  </tr>
  <tr>
    <th  colspan="2">报告生成时间</th>
    <th>2023-10-19</th>
    <th  colspan="2">检测标准号</th>
    <th >GB475-2008-1</th>
  </tr>
</tbody>
   </table>
   <div>
   <el-button type="primary" @click="onSubmit" style="margin-left: 500px;margin-top: 50px">打印</el-button>
                <el-button type="second" @click="next" style="margin-left: 40px">取消</el-button>
   </div>
 </el-card>

</template>
<script>
export default {
    data() {
        return {
            name:"report",
            active: 0,
            show: true,
            formInline: {
                user: '',
                region: ''
            },
            coal:{
                number:'',
                standard:''
            },
            cyMessage: {
                time:'',
                location:'',
                person:'',
                SampleSize:'',
                standard:'',
                methods:'',
                weather:''  
            },
            zbResult: {
                water: '',
                density: '',
                heat:'',
                volatilize:'',
                grey:'',
                resistance:'',
                time:'',
                location:'',
                standard:''
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
        next() {
            if (this.active++ > 2) this.active = 0;
            this.show=!this.show

        },
       
        onSubmit() {
            console.log('submit!');
        }
    }
}
</script>
<style scoped>
.card {
    width: 1500px;
    height:1200px;
    margin: 1% 5%;
  }
  .card1 {
    width: 1500px;
    height:900px;
    margin: 1% 5%;
  }
  table{
    width: 70%;
     height: 800px;
     margin-left: 200px;
    border-collapse: collapse;
  }
  table caption{
    font-size: 2em;
    font-weight: bold;
    margin: 1em 0;
}
th,td{
    border: 1px solid #999;
    text-align: center;
    padding: 20px 0;
}








</style>

