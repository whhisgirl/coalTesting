
<template>
  <div>
    <el-form style="margin-top: 5%;margin-left: 80px;margin-right: 80px;" label-width="100px" >
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="水分" prop="field101">
            <el-input v-model="formData.field101" disabled="true" placeholder="请输入水分" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="灰分" prop="field102">
            <el-input v-model="formData.field102"  disabled="true" placeholder="请输入灰分" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="挥发分" prop="field103">
            <el-input v-model="formData.field103" disabled="true" placeholder="请输入挥发分" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="密度" prop="field104">
            <el-input v-model="formData.field104" disabled="true" placeholder="请输入密度" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8" :offset="1">
          <el-form-item label="电阻率" prop="field105">
            <el-input v-model="formData.field105" disabled="true" placeholder="请输入电阻率" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8" :offset="4">
          <el-form-item label="基低位发热量" prop="field106">
            <el-input v-model="formData.field106" disabled="true" placeholder="请输入基低位发热量" clearable :style="{width: '100%'}">
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
export default {
  name: "step4",
  components: {},
  props: [],
  data() {
    return {
      formData: {
        field101:'9.10',
        field102:'23.92',
        field103:'28.11',
        field104: '4.13',
        field105: '381',
        field106: '4400',
      },
      rules: {
        mobile: [{
          required: true,
          message: 'C2023092503',
          trigger: 'blur'
        }],
        field101: [{
          required: true,
          message: '9.10',
          trigger: 'blur'
        }],
        field102: [{
          required: true,
          message: '23.92',
          trigger: 'blur'
        }],
        field103: [{
          required: true,
          message: '28.11',
          trigger: 'blur'
        }],
        field104: [{
          required: true,
          message: '4.13',
          trigger: 'blur'
        }],
        field105: [{
          required: true,
          message: '381',
          trigger: 'blur'
        }],
        field106: [{
          required: true,
          message: '4400',
          trigger: 'blur'
        }],
      },
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>


<style scoped>
.el-row{
  margin-bottom: 30px;
}
</style>
