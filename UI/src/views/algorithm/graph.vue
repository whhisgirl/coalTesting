<template>
  <div class="root">
    <div id="container" class="graph"></div>
  </div>
</template>

<script>
import G6 from "@antv/g6";
import {initGraph} from "@/api/casedata/casedata";
import request from "@/utils/request";

export default {
  name: "mainIndexGraph",
  methods:{
    init(val){
      return request();
    },
    getInitGraphMag() {
      this.initParams.params["types"] = this.typeList
      this.init(this.initParams.params).then(res => {
        let data = this.formatGraphData(res)
        console.log("处理后的数据")
        console.log(data)
        this.treeData = data;
        this.createTree();
      })
    },
    formatGraphData(val) {
      //第一层 案例
      let res = {
        "id": "煤炭",
        "value": "煤炭",
        "num": "",
        "children": [],
        "size": 100,
        "level": 0,
        "style": {
          "stroke": "rgba(255,255,255,0)",
          "fill": "rgba(255,255,255,0)",
          "cursor" : "pointer",
          "color":"white"
        },
        "labelCfg": {
          "position": 'bottom',
          "offset": 10,
          "style": {
            fill: "#ffffff",
            fontSize: 15
          }
        },

        "icon": {
          show: true,
          img: require('@/assets/radicalTree/10.png'),
          width: 85,
          height: 80,
          "cursor" : "pointer"

        }
      }
      let that = this

      //第三层 属性值
      this.typeList.forEach(function (item, index) {
        let listEnd = []
        if (item === 'fault_list') {
          //故障件
          let border = 6;
          // val[item].forEach(function (o, i) {
          //   let kk = Object.keys(o)[0]
          //   let vv = Object.values(o)[0]
          //   //对属性为空时  数据进行处理 直接略过
          //   if (kk === "" || vv === "" || kk === null || vv === null || typeof (kk) == "undefined" || typeof (vv) == "undefined") {
          //     border++
          //   }else {
          //     if(i<border){
          listEnd.push({
            "id":'姓名',
            "value": '姓名',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer",
              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'车牌',
            "value": '车牌',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer",
              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'信用记录',
            "value": '信用记录',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'行程记录',
            "value": '行程记录',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          })
          // }
          // }

          // })
        } else if (item === 'event_nature') {
          //其他属性
          let border = 6;

          // val[item].forEach(function (o, i) {
          //   let label = o.label;
          //   let num = o.num;
          //
          //   //对属性为空时  数据进行处理 直接略过
          //   if (label === "" || num === "" || label === null || num === null || typeof (label) == "undefined" || typeof (num) == "undefined") {
          //     border++
          //   }else{
          //     if(i<border){
          listEnd.push({
              "id": '水分',
              "value": '水分',
              "num": '',
              "size": 30,
              "style": {
                "stroke": that.strokeColorList[item],
                "fill": that.colorList[item],
                "cursor": "pointer"
                // "shadowColor": "skyBlue",
                // "shadowBlur":20,
              },

              "labelCfg": {
                "style": {
                  fill: "#ffffff",
                  fontSize: 12
                },

                "position": 'bottom',
                "offset": 10,
              },
              "level": 2

            },{
              "id": '灰分',
              "value": '灰分',
              "num": '',
              "size": 30,
              "style": {
                "stroke": that.strokeColorList[item],
                "fill": that.colorList[item],
                "cursor": "pointer"
                // "shadowColor": "skyBlue",
                // "shadowBlur":20,
              },

              "labelCfg": {
                "style": {
                  fill: "#ffffff",
                  fontSize: 12
                },

                "position": 'bottom',
                "offset": 10,
              },
              "level": 2

            },
            {
              "id": '挥发分',
              "value": '挥发分',
              "num": '',
              "size": 30,
              "style": {
                "stroke": that.strokeColorList[item],
                "fill": that.colorList[item],
                "cursor": "pointer"
                // "shadowColor": "skyBlue",
                // "shadowBlur":20,
              },

              "labelCfg": {
                "style": {
                  fill: "#ffffff",
                  fontSize: 12
                },

                "position": 'bottom',
                "offset": 10,
              },
              "level": 2

            },{
              "id": '电阻率',
              "value": '电阻率',
              "num": '',
              "size": 30,
              "style": {
                "stroke": that.strokeColorList[item],
                "fill": that.colorList[item],
                "cursor": "pointer"
                // "shadowColor": "skyBlue",
                // "shadowBlur":20,
              },

              "labelCfg": {
                "style": {
                  fill: "#ffffff",
                  fontSize: 12
                },

                "position": 'bottom',
                "offset": 10,
              },
              "level": 2

            },{
              "id": '基低位发热量',
              "value": '基低位发热量',
              "num": '',
              "size": 30,
              "style": {
                "stroke": that.strokeColorList[item],
                "fill": that.colorList[item],
                "cursor": "pointer"
                // "shadowColor": "skyBlue",
                // "shadowBlur":20,
              },

              "labelCfg": {
                "style": {
                  fill: "#ffffff",
                  fontSize: 12
                },

                "position": 'bottom',
                "offset": 10,
              },
              "level": 2

            },{
              "id": '密度',
              "value": '密度',
              "num": '',
              "size": 30,
              "style": {
                "stroke": that.strokeColorList[item],
                "fill": that.colorList[item],
                "cursor": "pointer"
                // "shadowColor": "skyBlue",
                // "shadowBlur":20,
              },

              "labelCfg": {
                "style": {
                  fill: "#ffffff",
                  fontSize: 12
                },

                "position": 'bottom',
                "offset": 10,
              },
              "level": 2

            })

          //     }
          //   }
          //
        } // })
        else if(item === 'fault_model') {
          let border = 6;
          // val[item].forEach(function (o, i) {
          //   let kk = Object.keys(o)[0]
          //   let vv = Object.values(o)[0]
          //   //对属性为空时  数据进行处理 直接略过
          //   if (kk === "" || vv === "" || kk === null || vv === null || typeof (kk) == "undefined" || typeof (vv) == "undefined") {
          //     border++
          //   }else {
          //     if(i<border){
          listEnd.push({
            "id":'电力行业',
            "value": '电力行业',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'建筑行业',
            "value": '建筑行业',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'化工工业',
            "value": '化工工业',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'钢铁冶炼',
            "value": '钢铁冶炼',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'生活用煤',
            "value": '生活用煤',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          })
        }
        else if(item === 'type') {
          let border = 6;
          // val[item].forEach(function (o, i) {
          //   let kk = Object.keys(o)[0]
          //   let vv = Object.values(o)[0]
          //   //对属性为空时  数据进行处理 直接略过
          //   if (kk === "" || vv === "" || kk === null || vv === null || typeof (kk) == "undefined" || typeof (vv) == "undefined") {
          //     border++
          //   }else {
          //     if(i<border){
          listEnd.push({
            "id":'按发热量划分',
            "value": '按发热量划分',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'按灰分划分',
            "value": '按灰分划分',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'按挥发分划分',
            "value": '按挥发分划分',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          })
        }
        else if(item === 'belong_system') {
          let border = 6;
          // val[item].forEach(function (o, i) {
          //   let kk = Object.keys(o)[0]
          //   let vv = Object.values(o)[0]
          //   //对属性为空时  数据进行处理 直接略过
          //   if (kk === "" || vv === "" || kk === null || vv === null || typeof (kk) == "undefined" || typeof (vv) == "undefined") {
          //     border++
          //   }else {
          //     if(i<border){
          listEnd.push({
            "id":'忻州宏远矿区',
            "value": '忻州宏远矿区',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'红池矿区',
            "value": '红池矿区',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          },{
            "id":'南岭矿区',
            "value": '南岭矿区',
            "num": '',
            "size": 30,
            "style": {
              "stroke": that.strokeColorList[item],
              "fill": that.colorList[item],
              "cursor" : "pointer"

              // "shadowColor": "skyBlue",
              // "shadowBlur":20,
            },
            "labelCfg": {
              "style": {
                fill: "#ffffff",
                fontSize: 12
              },
              "position": 'bottom',
              "offset": 10,
            },
            "level": 2
          })
        }
        console.log(res);
        //第二层 属性名
        res["children"].push({
          "id": that.typeNameList[item] ,
          // "id": that.typeNameList[item] + "(" + listEnd.length + ")",
          "value": item,
          // "collapsed": true,
          "num": "",
          "children": listEnd,
          "size": 60,
          "level": 1,
          "style": {
            "stroke": "rgba(255,255,255,0)",
            "fill": "rgba(255,255,255,0)",
            "cursor" : "pointer"

          },
          "labelCfg": {
            "style": {
              fill: "#ffffff",
              fontSize: 12
            },

            "position": 'bottom',
            "offset": 10,
          },
          "icon": that.iconList[item]
        });

      })
      return res;
    },
    createTree() {
      const container = document.getElementById('container');
      const width = container.scrollWidth;
      // const width = this.defaultWidth;
      const height = container.scrollHeight+135;
      // const height = container.scrollHeight || 500;
      // const height = this.defaultHeight;

      const graph = new G6.TreeGraph({
        container: 'container',
        width,
        height,
        // linkCenter: true,
        modes: {
          default: [
            {
              type: 'collapse-expand',
              onChange: function onChange(item, collapsed) {
                const data = item.get('model');
                data.collapsed = collapsed;
                return true;
              },
            },
            'drag-canvas',
            'zoom-canvas',
          ],
        },
        defaultNode: {
          size: 0,
        },
        layout: {
          type: 'dendrogram',
          // type: 'compactBox',
          direction: 'LR',
          preventOverlap: true,

          nodeSep: 10,
          rankSep: 150,
          radial: true,
        },
      });

      graph.node(function (node) {
        return {
          label: node.id,
        };
      });

      graph.data(this.treeData);
      graph.render();
      graph.fitView();

      const that = this;
      graph.on('node:click', function (e) {

        let model = e.item.getModel();
        let neighbors = e.item.getNeighbors();
        const fatherModel = neighbors[0].getModel();
        console.log(model);
        console.log(e.item);

        //点击根节点
        if (model.level === 0) {
          //变颜色
          that.allRedLine.forEach(id=>{
            let edge = graph.findById(id);
            //将边变为红色
            graph.updateItem(edge, {
              // 节点的样式
              style: {
                "stroke": "red",
                // lineWidth: 10
                // "shadowBlur":0,
              },
            });
          })
        }
        //点击第一层节点
        if (model.level === 1) {
          graph.fitView();
          let edges = e.item.getEdges();
          for (let i = 0; i < edges.length; i++) {
            const nodeId = edges[i].getTarget().getModel().id;

            if (that.conditionList.indexOf(nodeId) !== -1) {
              //将边变为红色
              graph.updateItem(edges[i], {
                // 节点的样式
                style: {
                  "stroke": "red",
                  // "shadowBlur":0,
                },
              });
            }
          }

        }
        //当点击到第二层节点时
        if (model.level === 2) {
          // alert(model.value)
          let value = model.value;
          that.$router.push({
            path:'/graphManage/defineLayout',
            // query: {
            //   value: value
            // }
          })

          // that.$router.push({
          //   name: '/casedata',
          //   params: {
          //     // msg: row.id
          //   }
          // })
          //选中效果
          // model.style.stroke = "red";
          //查找条件Map
          let list = that.conditionMap.get(fatherModel.value);
          //如果不存在条件数组
          if (typeof (list) == 'undefined') {
            list = [];
          }
          //压入搜索条件
          let index = list.indexOf(model.value);
          if (index === -1) {
            list.push(model.value);
          } else {
            list.splice(index,1);
          }
          that.conditionMap.set(fatherModel.value, list);
          //压入显示数组
          let number = that.conditionList.indexOf(model.id);

          //获取边
          let edges = e.item.getEdges();
          let edge = edges[0];
          //如果条件数组中不存在
          if (number===-1) {
            that.conditionList.push(model.id);
            graph.updateItem(e.item, {
              // 节点的样式
              style: {
                "shadowColor": "blue",
                "shadowBlur":30,
              },
            });

            //将边变为红色
            graph.updateItem(edge, {
              // 节点的样式
              style: {
                "stroke": "red",
                // lineWidth: 10
                // "shadowBlur":0,
              },
            });
            //压入红边列表
            that.allRedLine.push(edge.getModel().id);

            //将上层的边也变为红色
            if(that.redLineSingal[fatherModel.value]===0){
              let n1 = e.item.getNeighbors("source");
              let e1 = n1[0].getInEdges();
              // console.log("e1",e1);
              //压入红边列表
              that.allRedLine.push(e1[0].getModel().id);

              //将上层的边变为红色
              graph.updateItem(e1[0], {
                // 节点的样式
                style: {
                  "stroke": "red",
                  // lineWidth: 10
                  // "shadowBlur":0,
                },
              });
            }
            that.redLineSingal[fatherModel.value]++;
          }else{
            //存在说明是 反选删除
            that.conditionList.splice(number,1);
            graph.updateItem(e.item, {
              // 节点的样式
              style: {
                "shadowColor": "blue",
                "shadowBlur":0,
              },
            });

            //将边变为默认颜色
            graph.updateItem(edge, {
              // 节点的样式
              style: {
                "stroke": "#b6b6b6",
                // "shadowBlur":0,
              },
            });
            //将该边移除 红边列表
            let rindex1 = that.allRedLine.indexOf(edge.getModel().id);
            that.allRedLine.splice(rindex1,1);

            if(that.redLineSingal[fatherModel.value]===1){
              let n1 = e.item.getNeighbors("source");
              let e1 = n1[0].getInEdges();
              // console.log("e1",e1);

              //将该边移除 红边列表
              let rindex = that.allRedLine.indexOf(e1[0].getModel().id);
              that.allRedLine.splice(rindex,1);

              //将上层的边变为红色
              graph.updateItem(e1[0], {
                // 节点的样式
                style: {
                  "stroke": "#b6b6b6",
                  // lineWidth: 10
                  // "shadowBlur":0,
                },
              });
            }
            that.redLineSingal[fatherModel.value]--;

          }

        }

      })

      if (typeof window !== 'undefined')
        window.onresize = () => {
          if (!graph || graph.get('destroyed')) return;
          if (!container || !container.scrollWidth || !container.scrollHeight) return;
          graph.changeSize(container.scrollWidth, container.scrollHeight);
        };
    },

  },
  data() {
    return{
      //第一层边
      redLineSingal: {
        type: 0,
        fault_list: 0,
        fault_model: 0,
        event_nature: 0,
        belong_system: 0,
        professional_field: 0
      },
      //所有变红的边 id
      allRedLine: [],
      //存储搜索条件 供搜索案例时使用
      conditionMap: new Map(),
      //条件列表
      conditionList: [],

      defaultHeight: null,
      defaultWidth: null,
      initParams: {
        params: {
          types: []
        }
      },
      typeList: ['fault_list','type',  'fault_model', 'event_nature', 'belong_system'],
      typeNameList: {
        'type': '种类',
        'fault_list': '司机',
        'fault_model': '用途',
        'event_nature': '指标',
        'belong_system': '矿区',
      },
      iconList: {
        'fault_list': {
          show: true,
          img: require('@/assets/radicalTree/3.png'),
          width: 70,
          height: 70,
          "cursor": "pointer"

        },
        'type': {
          show: true,
          img: require('@/assets/radicalTree/type.svg'),
          width: 50,
          height: 50,
          "cursor": "pointer"
        },

        'fault_model': {
          show: true,
          img: require('@/assets/radicalTree/cause.svg'),
          width: 50,
          height: 50,
          "cursor": "pointer"

        },
        'event_nature': {
          show: true,
          img: require('@/assets/radicalTree/4.png'),
          width: 40,
          height: 40,
          "cursor": "pointer"

        },
        'belong_system': {
          show: true,
          img: require('@/assets/radicalTree/5.png'),
          width: 50,
          height: 50,
          "cursor": "pointer"

        },
      },
      colorList: {
        'type': 'rgba(250,200,88,0.5)',
        'fault_list': 'rgba(154,96,180,0.5)',
        'fault_model': 'rgba(234,124,204,0.5)',
        'event_nature': 'rgba(252,132,82,0.5)',
        'belong_system': 'rgba(145,204,117,0.5)',
      },
      strokeColorList: {
        'type': 'rgba(250,200,88,1)',
        'fault_list': 'rgba(154,96,180,1)',
        'fault_model': 'rgba(234,124,204,1)',
        'event_nature': 'rgba(252,132,82,1)',
        'belong_system': 'rgba(145,204,117,1)',
      },

    }
  },
  mounted() {
    let wh = this.$getViewportSize()
    this.getInitGraphMag()
  }
}
</script>

<style scoped>
.root {
  height: calc(90vh - 120px);
  width: 100%;
}
.graph {
  height: 100%;
  width: 100%;
  /*border: 1px solid black*/
  /*display: inline-block;*/
  /*position: relative;*/
  /*top: -105%;*/
  /*right: -40%*/
}
</style>

