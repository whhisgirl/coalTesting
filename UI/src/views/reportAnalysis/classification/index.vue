<template>
  <div class="container">
    <h2>当前煤炭批次指标结果</h2>
    <hr>

    <div class="form-grid">
      <div class="form-item">
        <label for="water">水</label>
        <input type="text" id="water" v-model="water" readonly/>
      </div>
      <div class="form-item">
        <label for="density">密度</label>
        <input type="text" id="density" v-model="density" readonly/>
      </div>
      <div class="form-item">
        <label for="calorificValue">基低位发热量</label>
        <input type="text" id="calorificValue" v-model="calorificValue" readonly/>
      </div>
      <div class="form-item">
        <label for="volatileMatter">挥发分</label>
        <input type="text" id="volatileMatter" v-model="volatileMatter" readonly/>
      </div>
      <div class="form-item">
        <label for="ashContent">灰分</label>
        <input type="text" id="ashContent" v-model="ashContent" readonly/>
      </div>
      <div class="form-item">
        <label for="resistivity">电阻率</label>
        <input type="text" id="resistivity" v-model="resistivity" readonly/>
      </div>
      <div class="form-item">
        <label for="testingTime">检测时间</label>
        <input type="text" id="testingTime" v-model="testingTime" readonly/>
      </div>
      <div class="form-item">
        <label for="testingLocation">检测地</label>
        <input type="text" id="testingLocation" v-model="testingLocation" readonly/>
      </div>
      <div class="form-item">
        <label for="tester">检测人</label>
        <input type="text" id="tester" v-model="tester" readonly/>
      </div>
    </div>

    <hr>
    <br>
    <br>
    <br>
    <br>
    <br>


    <div class="category-buttons">
      <button @click="toggleSubCategory" :class="{ active: showSubCategoryButtons }">分类</button>
    </div>

    <div v-if="showSubCategoryButtons">
      <div class="category-buttons">
        <button @click="changeSubCategory('低热量煤')" :class="{ active: subCategory === '低热量煤', blue: subCategory === '低热量煤' }">低热量煤</button>
        <button @click="changeSubCategory('中热量煤')" :class="{ active: subCategory === '中热量煤', blue: subCategory === '中热量煤' }">中热量煤</button>
        <button @click="changeSubCategory('高热量煤')" :class="{ active: subCategory === '高热量煤', blue: subCategory === '高热量煤' }">高热量煤</button>
      </div>
    </div>

    <div class="bottom-buttons">
      <button class="update-button" @click="updateBatch">批次更新</button>
      <button class="reset-button" @click="resetForm">重置</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      category: '',
      subCategory: '',
      water: '',
      density: '',
      calorificValue: '',
      volatileMatter: '',
      ashContent: '',
      resistivity: '',
      testingTime: '',
      testingLocation: '',
      tester: '',
      showSubCategoryButtons: false,
    };
  },
  methods: {
    toggleSubCategory() {
      this.showSubCategoryButtons = !this.showSubCategoryButtons;
    },
    changeSubCategory(subCategory) {
      this.subCategory = subCategory;
    },
    updateBatch() {
// 执行批次更新逻辑
      console.log('Batch Updated');
    },
    resetForm() {
// 执行重置表单逻辑
      console.log('Form Reset');
    }
  }
};
</script>

<style>
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
