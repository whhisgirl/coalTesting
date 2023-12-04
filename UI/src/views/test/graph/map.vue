
<template>
  <div class="baidumap" id="allmap"></div>
</template>
<script>
export default {
  data() {
    return {
      position_NKYYGS: {
        Name: '忻州宏远矿区',
        address: '',
        phoneNumber: '',
        bdLNG: 112.74286015132837,
        bdLAT: 38.42148871204489
      },
      position_NKYYDS: {
        Name: '红池矿区',
        address: '',
        phoneNumber: '',
        bdLNG: 112.74286015132837,
        bdLAT: 38.42148871204489
      },
      position_NKYYFS: {
        Name: '南岭矿区',
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
      var sContent2 =
        '<div style="width:300px;"><p style="font-size:16px;font-weight:bold;margin-top: 10px;color:#D07852">' +
        this.position_NKYYDS.Name +
        '</p><p style="font-size:13px;margin: 5px 0;">地址：' +
        this.position_NKYYDS.address +
        '</p><p style="font-size:13px;margin: 5px 0;">电话：' +
        this.position_NKYYDS.phoneNumber +
        '</p><p style="font-size:13px;margin: 5px 0;">坐标：' +
        this.position_NKYYDS.bdLNG +
        ',' +
        this.position_NKYYDS.bdLAT;
      ('</div>');
      var point2 = new BMap.Point(this.position_NKYYDS.bdLNG, this.position_NKYYDS.bdLAT); // 创建点坐标
      var marker2 = new BMap.Marker(point2);
      map.addOverlay(marker2);
      map.centerAndZoom(point2, 10); // 初始化地图，设置中心点坐标和地图级别
      // //点击图标时候调用信息窗口
      var infoWindow2 = new BMap.InfoWindow(sContent2);
      marker.addEventListener('click', function() {
        this.openInfoWindow(infoWindow2);
      });
      var sContent3 =
        '<div style="width:300px;"><p style="font-size:16px;font-weight:bold;margin-top: 10px;color:#D07852">' +
        this.position_NKYYFS.Name +
        '</p><p style="font-size:13px;margin: 5px 0;">地址：' +
        this.position_NKYYFS.address +
        '</p><p style="font-size:13px;margin: 5px 0;">电话：' +
        this.position_NKYYFS.phoneNumber +
        '</p><p style="font-size:13px;margin: 5px 0;">坐标：' +
        this.position_NKYYFS.bdLNG +
        ',' +
        this.position_NKYYFS.bdLAT;
      ('</div>');
      var point3 = new BMap.Point(this.position_NKYYFS.bdLNG, this.position_NKYYFS.bdLAT); // 创建点坐标
      var marker3 = new BMap.Marker(point3);
      map.addOverlay(marker3);
      map.centerAndZoom(point3, 10); // 初始化地图，设置中心点坐标和地图级别
      // //点击图标时候调用信息窗口
      var infoWindow3 = new BMap.InfoWindow(sContent3);
      marker.addEventListener('click', function() {
        this.openInfoWindow(infoWindow3);
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
