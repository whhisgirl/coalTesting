<template>
  <div>
    <el-card class="box-card">
      <div style="width: 100%; background: #d2e9ff; border-radius: 10px">
        <p style="
            font-family: Arial;
            font-size: 16px;
            font-weight: 600;
            display: inline-block;
            margin-left: 20px;
          ">
          司机实时行程
        </p>
      </div>
      <br>
      <br>
      <div class="map-container">
        <div id="map" class="map"></div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  mounted() {
    this.initMap();
  },

  methods: {
    initMap() {
      // 初始化地图
      const map = new BMap.Map("map");
      const point = new BMap.Point(116.404, 39.915);
      map.centerAndZoom(point, 5);
      map.enableScrollWheelZoom(true);

      // 添加山西省忻州市和辽宁省大连市的点标记
      const start = new BMap.Point(112.731, 39.014); // 山西省忻州市的坐标
      const end = new BMap.Point(121.618, 38.914); // 辽宁省大连市的坐标
      const startMarker = new BMap.Marker(start);
      const endMarker = new BMap.Marker(end);
      map.addOverlay(startMarker);
      map.addOverlay(endMarker);

      // 绘制司机路线
      const driving = new BMap.DrivingRoute(map, {
        renderOptions: { map: map, autoViewport: true, polylineOptions: { strokeColor: 'blue', strokeWeight: 6 } }
      });
      driving.search(start, end);

      function drawTruckIcon(context, x, y, width, height) {
        // 车厢
        context.fillStyle = 'black';
        context.fillRect(x, y - height / 2, width, height);

        // 车头
        const cabinHeight = height * 0.6;
        context.fillStyle = 'blue';
        context.fillRect(x + width, y - cabinHeight / 2, width * 0.2, cabinHeight);

        // 轮子
        const wheelRadius = height * 0.2;
        const wheelY = y + height / 2;
        const wheelOffsetX = width * 0.15;
        context.beginPath();
        context.arc(x + wheelOffsetX, wheelY, wheelRadius, 0, Math.PI * 2);
        context.arc(x + width - wheelOffsetX, wheelY, wheelRadius, 0, Math.PI * 2);
        context.fillStyle = 'gray';
        context.fill();

        // 车轮中心
        const wheelCenterRadius = height * 0.05;
        context.fillStyle = 'white';
        context.beginPath();
        context.arc(x + wheelOffsetX, wheelY, wheelCenterRadius, 0, Math.PI * 2);
        context.arc(x + width - wheelOffsetX, wheelY, wheelCenterRadius, 0, Math.PI * 2);
        context.fill();


        const hoodWidth = width * 0.2;
        const hoodHeight = height * 0.4;
        const hoodX = x + width;
        const hoodY = y - cabinHeight / 2 - hoodHeight / 2;
        context.fillStyle = 'black';
        context.fillRect(hoodX, hoodY, hoodWidth, hoodHeight);


        const frontWidth = hoodWidth * 0.6;
        const frontHeight = hoodHeight * 0.7;
        const frontX = hoodX + hoodWidth;
        const frontY = hoodY + hoodHeight / 2;
        context.beginPath();
        context.moveTo(frontX, frontY);
        context.lineTo(frontX + frontWidth, frontY - frontHeight / 2);
        context.lineTo(frontX + frontWidth, frontY + frontHeight / 2);
        context.closePath();
        context.fillStyle = 'black';
        context.fill();


        const lightRadius = height * 0.1;
        const lightOffsetX = hoodWidth * 0.3;
        const lightOffsetY = -hoodHeight * 0.2;
        const lightX = hoodX + lightOffsetX;
        const lightY = hoodY + hoodHeight / 2 + lightOffsetY;
        context.beginPath();
        context.arc(lightX, lightY, lightRadius, 0, Math.PI * 2);
        context.fillStyle = 'yellow';
        context.fill();
      }

      const truckCanvas = document.createElement('canvas');
      truckCanvas.width = 50;
      truckCanvas.height = 50;
      const truckCtx = truckCanvas.getContext('2d');
      drawTruckIcon(truckCtx, 0, 25, 50, 25);

      const truckIconUrl = truckCanvas.toDataURL();
      const truckPoint = new BMap.Point(115.9753, 39.3957); // 货车当前位置坐标
      const truckIcon = new BMap.Icon(truckIconUrl, new BMap.Size(50, 50));

      const truckMarker = new BMap.Marker(truckPoint, { icon: truckIcon, offset: new BMap.Size(-15, -10) }); // 设置图标偏移量使其居中显示
      map.addOverlay(truckMarker);
    }
  }
};
</script>

<style scoped>
.map-container {
  width: 100%;
  height: 800px;
}

.map {
  width: 100%;
  height: 100%;
}

.box-card {
  margin: 1% 1%;
  width: 98%;
}
</style>
