<template>
  <div class="coal-batch-wrapper">

    <el-card class="coal-batch-card">
      <div slot="header" class="coal-batch-card-header">当前煤炭批次指标结果</div>
      <div class="coal-batch-card-content">
        <div class="coal-batch-card-column">
          <div class="coal-batch-card-row">
            <div class="coal-batch-card-label">水：</div>
            <div class="coal-batch-card-input"><el-input v-model="water"></el-input></div>
          </div>
          <div class="coal-batch-card-row">
            <div class="coal-batch-card-label">电阻率：</div>
            <div class="coal-batch-card-input"><el-input v-model="resistivity"></el-input></div>
          </div>
          <div class="coal-batch-card-row">
            <div class="coal-batch-card-label">挥发分：</div>
            <div class="coal-batch-card-input"><el-input v-model="volatile"></el-input></div>
          </div>
          <div class="coal-batch-card-row">
            <div class="coal-batch-card-label">检测时间：</div>
            <div class="coal-batch-card-input"><el-input v-model="detectionTime"></el-input></div>
          </div>
        </div>
        <div class="coal-batch-card-column">
          <div class="coal-batch-card-row">
            <div class="coal-batch-card-label">密度：</div>
            <div class="coal-batch-card-input"><el-input v-model="density"></el-input></div>
          </div>
          <div class="coal-batch-card-row">
            <div class="coal-batch-card-label">基低位发热量：</div>
            <div class="coal-batch-card-input"><el-input v-model="heatingValue"></el-input></div>
          </div>
          <div class="coal-batch-card-row">
            <div class="coal-batch-card-label">灰分：</div>
            <div class="coal-batch-card-input"><el-input v-model="ashContent"></el-input></div>
          </div>
          <div class="coal-batch-card-row">
            <div class="coal-batch-card-label">检测地：</div>
            <div class="coal-batch-card-input"><el-input v-model="detectionPlace"></el-input></div>
          </div>
        </div>
      </div>
      <div class="coal-batch-card-footer">
        <el-button type="primary" @click="showClassificationResult">查看分类结果</el-button>
      </div>

    </el-card>
    <el-card v-if="showClassificationDialog" class="classification-result-card">
      <div slot="header" class="classification-result-card-header">
        <span>分类结果</span>
        <el-button type="text" icon="el-icon-arrow-left" class="back-btn" @click="closeClassificationDialog">
          <span slot="default">返回</span>
        </el-button>
      </div>
      <div class="classification-result-card-content">
        <div class="classification-result-card-row">
          <div class="classification-result-card-label">按灰分划分，是：</div>
          <div class="classification-result-card-input"><el-input v-model="resultByAshContent"></el-input></div>
        </div>
        <div class="classification-result-card-row">
          <div class="classification-result-card-label">按挥发分划分，是：</div>
          <div class="classification-result-card-input"><el-input v-model="resultByVolatile"></el-input></div>
        </div>
        <div class="classification-result-card-row">
          <div class="classification-result-card-label">按基低位发热量划分，是：</div>
          <div class="classification-result-card-input"><el-input v-model="resultByHeatingValue"></el-input></div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<style scoped>
.coal-batch-wrapper {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
}

.coal-batch-card {
  width: 50%;
  margin: 1% 1%;
}
.coal-batch-card-header {
  font-size: 18px;
  font-weight: bold;
  text-align: center;
  font-family: Arial, sans-serif;
  color: #333;
}
.coal-batch-card-content {
  display: flex;
  justify-content: space-between;
}

.classification-result-card-row {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.classification-result-card-label {
  width: 200px;
  font-weight: bold;
  font-family: Arial, sans-serif;
  font-size: 14px;
  color: #333;
}

.classification-result-card-input {
  flex: 1;
}

.coal-batch-card-column {
  display: flex;
  flex-direction: column;
  width: 50%;
}
.coal-batch-card-row {
  display: flex;
  align-items: center;
  margin-bottom: 50px;
}
.coal-batch-card-label {
  width: 100px;
  font-weight: bold;
  font-family: Arial, sans-serif;
  font-size: 16px;
  color: #333;
}
.coal-batch-card-input {
  flex: 1;
}
.el-input {
  margin-bottom: 10px;
}

.coal-batch-card-footer {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
}

.classification-result-card {
  width: 50%;
  display: flex;
  flex-direction: column;
  margin: 1% 1%;
}

.classification-result-card-header {
  font-size: 18px;
  font-weight: bold;
  text-align: center;
  font-family: Arial, sans-serif;
  color: #333;
}

.classification-result-card-content {
  padding: 20px;
}

.back-btn {
  float: right;
  font-size: 14px;
  padding: 10px 20px;
  border-radius: 4px;
  background-color: #409EFF;
  color: #fff;
}
.box-card {
  margin: 1% 1%;
  width: 98%;
}
</style>

<script>
export default {
  data() {
    return {
      water: '',
      resistivity: '',
      volatile: '',
      detectionTime: '',
      density: '',
      heatingValue: '',
      ashContent: '',
      detectionPlace: '',
      resultByAshContent: '',
      resultByVolatile: '',
      resultByHeatingValue: '',
      showClassificationDialog: false
    }
  },
  methods: {
    showClassificationResult() {
      this.showClassificationDialog = true;
    },
    closeClassificationDialog() {
      this.showClassificationDialog = false;
    }
  }
}
</script>

<style scoped>
.container {
  margin: 20px;
}

.form-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 10px;
}

.form-item {
  border: 1px solid #ccc;
  padding: 10px;
  text-align: center;
}

.form-item label {
  display: block;
  margin-bottom: 5px;
}

.form-item input {
  width: 100%;
  box-sizing: border-box;
  padding: 5px;
  border-radius: 3px;
  border: 1px solid #ccc;
  outline: none;
  background-color: #f7f7f7;
  font-size: 14px;
  line-height: 1.5em;
  color: #333;
}

.category-buttons {
  margin: 20px 0;
  text-align: center;
}

.category-buttons button {
  padding: 5px 10px;
  margin-right: 10px;
}

.category-buttons button.active {
  background-color: blue;
  color: white;
}

.bottom-buttons {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.category-buttons button.blue {
  background-color: blue;
  color: white;
}

.update-button {
  background-color: blue;
  color: white;
  padding: 5px 10px;
  margin-right: 10px;
}

.reset-button button {
  padding: 5px 10px;
}

.box-card {
  margin: 1% 1%;
  width: 98%;
}
</style>
