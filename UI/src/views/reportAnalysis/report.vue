<template>
    <div style="margin-left: 200px;margin-top: 20px;">
        <el-steps :active="active" finish-status="success" align-center :space="400">
            <el-step title="模板下载"></el-step>
            <el-step title="信息导入"></el-step>
            <el-step title="预览"></el-step>
        </el-steps>
        <el-button style="margin-top: 9px; margin-left: 1000px" @click="next">下一步</el-button>

        <el-form :inline="true" :model="coal" class="demo-form-inline" style="margin-left: 400px;margin-top: 25px;">
            <el-form-item label=" 煤炭批次编号">
                <el-input v-model="coal.number" placeholder="C120J145"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">采样信息导入</el-button>
                <el-button type="primary" @click="onSubmit">指标结果导入</el-button>
            </el-form-item>
        </el-form>
        <p style="background-color:#409EFF;width: 1500px; " align="center" > 采样信息</p>

        <el-form :inline="true" :model="cyMessage" class="demo-form-inline" style="margin-left: 100px;margin-top: 25px;">
            <el-form-item label="采样时间">
                <el-date-picker v-model="value1" type="date" placeholder="选择日期" style="width: 200px;">
                </el-date-picker>
            </el-form-item>
            <el-form-item label=" 采样地点">
                <el-input v-model="cyMessage.location" placeholder="A矿区"></el-input>
            </el-form-item>
            <el-form-item label=" 采样人">
                <el-input v-model="cyMessage.person" placeholder="王强"></el-input>
            </el-form-item>

        </el-form>
        <el-form :inline="true" :model="cyMessage" class="demo-form-inline" style="margin-left: 100px;margin-top: 5px;">
            <el-form-item label=" 样品粒度">
                <el-input v-model="cyMessage.SampleSize" placeholder="粒煤"></el-input>
            </el-form-item>
            <el-form-item label=" 采样标准号">
                <el-input v-model="cyMessage.standard" placeholder="GB475-2008"></el-input>
            </el-form-item>
            <el-form-item label=" 采样方式">
                <el-input v-model="cyMessage.methods" placeholder="连续采样法"></el-input>
            </el-form-item>

        </el-form>
        <el-form :inline="true" :model="cyMessage" class="demo-form-inline" style="margin-left: 100px;margin-top: 5px;">
            <el-form-item label=" 采样天气">
                <el-input v-model="cyMessage.weather" placeholder="晴天"></el-input>
            </el-form-item>

        </el-form>
        <p style="background-color:#409EFF;width: 1500px;" align="center"> 指标结果</p>

        <el-form :inline="true" :model="zbResult" class="demo-form-inline" style="margin-left: 100px;margin-top: 25px;">
            <el-form-item label=" 水分">
                <el-input v-model="zbResult.water" placeholder="9.33" style="margin-left: 8px;"></el-input>
            </el-form-item>
            <el-form-item label=" 密度" style="margin-left: 10px;">
                <el-input v-model="zbResult.density" placeholder="4.10"></el-input>
            </el-form-item>
            <el-form-item label=" 基低位发热量">
                <el-input v-model="zbResult.heat" placeholder="4982"></el-input>
            </el-form-item>

        </el-form>
        <el-form :inline="true" :model="zbResult" class="demo-form-inline" style="margin-left: 100px;margin-top: 5px;">
            <el-form-item label=" 挥发分">
                <el-input v-model="zbResult.volatilize" placeholder="28.45"></el-input>
            </el-form-item>
            <el-form-item label=" 灰分" style="margin-left: 5px;">
                <el-input v-model="zbResult.grey" placeholder="23.26" style="margin-left: 1px;"></el-input>
            </el-form-item>
            <el-form-item label=" 电阻率" style="margin-left: 20px;">
                <el-input v-model="zbResult.resistance" placeholder="391" style="margin-left: 20px;"></el-input>
            </el-form-item>

        </el-form>
        <el-form :inline="true" :model="zbResult" class="demo-form-inline" style="margin-left: 95px;margin-top: 5px;">
            <el-form-item label=" 检测时间">
                <el-input v-model="zbResult.time" placeholder="2023-1-21 11:02"></el-input>
            </el-form-item>
            <el-form-item label=" 检测地">
                <el-input v-model="zbResult.location" placeholder="A矿区"></el-input>
            </el-form-item>

        </el-form>
        <p style="background-color:#409EFF;width: 1500px;" align="center"> 录入剩余信息</p>
        
        <el-form :inline="true" :model="coal" class="demo-form-inline" style="margin-left: 95px;margin-top: 5px;">
            <el-form-item label=" 报告生成时间">
                <el-date-picker v-model="value1" type="date" placeholder="2023-1-21" style="width: 200px;">
                </el-date-picker>
            </el-form-item>
            <el-form-item label=" 检测标准号">
                <el-input v-model="coal.standard" placeholder="请输入内容"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit" style="margin-left: 95px">确认</el-button>
                <el-button type="second" @click="onSubmit" style="margin-left: 40px">重置</el-button>
            </el-form-item>

        </el-form>

    </div>
</template>
<script>
export default {
    data() {
        return {
            active: 0,
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
            }
        };
        
    },

    methods: {
        next() {
            if (this.active++ > 2) this.active = 0;

        },
        onSubmit() {
            console.log('submit!');
        }
    }
}
</script>

