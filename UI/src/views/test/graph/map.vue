
<template>
  <div class="baidumap" id="allmap"></div>
</template>
<script>
export default {
  data() {
    return {
      position_NKYYGS: {
        Name: '忻州市',
        address: '',
        phoneNumber: '',
        bdLNG: 112.74286015132837,
        bdLAT: 38.42148871204489
      }
    };
  },
  mounted() {
    this.baiduMap();
  },
  methods: {
    baiduMap() {
      let map = new BMap.Map('allmap'); // 创建地图实例
      map.enableScrollWheelZoom(true); //开启鼠标滚轮缩放
      map.addControl(new BMap.NavigationControl());
      map.addControl(new BMap.ScaleControl());
      map.addControl(new BMap.OverviewMapControl());
      map.addControl(new BMap.MapTypeControl());
      // map.setMapStyle({ style: 'midnight' }) //地图风格

      map.clearOverlays();
      //将数据遍历
      //自定义信息窗口内容
      var sContent =
        '<div style="width:300px;"><p style="font-size:16px;font-weight:bold;margin-top: 10px;color:#D07852">' +
        this.position_NKYYGS.Name +
        '</p><p style="font-size:13px;margin: 5px 0;">地址：' +
        this.position_NKYYGS.address +
        '</p><p style="font-size:13px;margin: 5px 0;">电话：' +
        this.position_NKYYGS.phoneNumber +
        '</p><p style="font-size:13px;margin: 5px 0;">坐标：' +
        this.position_NKYYGS.bdLNG +
        ',' +
        this.position_NKYYGS.bdLAT;
      ('</div>');
      var point = new BMap.Point(this.position_NKYYGS.bdLNG, this.position_NKYYGS.bdLAT); // 创建点坐标
      var marker = new BMap.Marker(point);
      map.addOverlay(marker);
      map.centerAndZoom(point, 10); // 初始化地图，设置中心点坐标和地图级别
      // //点击图标时候调用信息窗口
      var infoWindow = new BMap.InfoWindow(sContent);
      marker.addEventListener('click', function() {
        this.openInfoWindow(infoWindow);
      });
    }
  }
};
</script>
<style>
.baidumap {
  width: 500px;
  height: 400px;
}

/* 去除百度地图版权那行字 和 百度logo */
.baidumap > .BMap_cpyCtrl {
  display: none !important;
}
.baidumap > .anchorBL {
  display: none !important;
}
</style>
ff
