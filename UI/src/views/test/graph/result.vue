<template>
  <div class="root">
    <div id="container1" class="graph"></div>
  </div>
</template>
<script>
import G6 from '@antv/g6';

export default {
  name: "container1",
  methods: {
    createTree() {
      const container = document.getElementById('container1');
      const width = container.scrollWidth;
      const height = container.scrollHeight-330;
      const graph = new G6.Graph({
        container: container,
        width: width,
        height: height,
        layout: {
          type: 'force',
          preventOverlap: true,
          linkDistance: (d) => {
            if (d.source.id === 'node0' || d.source.id === 'node1' || d.source.id === 'node2') {
              return 150;
            }
            return 300;
          },
          nodeStrength: (d) => {
            if (d.isLeaf) {
              return -50;
            }
            return -10;
          },
          edgeStrength: (d) => {
            if (d.source.id === 'node1' || d.source.id === 'node2' || d.source.id === 'node3') {
              return 0.7;
            }
            return 0.1;
          },
        },
        defaultNode: {
          color: '#5B8FF9',
        },
        modes: {
          default: ['drag-canvas', 'zoom-canvas'],
        },
      });


      const nodes = this.nodes;
      graph.data({
        nodes,
        edges: this.edges.map(function (edge, i) {
          edge.id = 'edge' + i;
          return Object.assign({}, edge);
        }),
      });
      graph.render();
      graph.on('node:click', (evt) => {
        const node = evt.item; // 获取被点击的节点
        const model = node.getModel(); // 获取节点的数据模型
        if (model.label == '异常批次') {
          this.$router.push({path: '/comAnalysis/CompareCoal/dealMore'});
        }
        if(model.label=='司机信用'){
          this.$router.push({path: '/comAnalysis/CompareCoal/driverCredit'});
        }
      });

      if (typeof window !== 'undefined')
        window.onresize = () => {
          if (!graph || graph.get('destroyed')) return;
          if (!container || !container.scrollWidth || !container.scrollHeight) return;
          graph.changeSize(container.scrollWidth, container.scrollHeight);
        };
    },
  },
  data() {
    return {
      show1:false,
      show2:false,
      nodes: [
        {id: 'node0', size: 70, type: 'rect', color: '#f9f65b', label: '忻州宏远矿区', style: {fill: '#fff4c6'}},
        {id: 'node1', size: 70, type: 'rect', color: '#f9f65b', label: '信用记录', style: {fill: '#fff4c6'}},
        {id: 'node2', size: 70, type: 'rect', color: '#f9f65b', label: '行程记录', style: {fill: '#fff4c6'}},
        {
          id: 'node3', size: 150, label: '煤质异常记录', labelCfg: {
            position: 'center',
            style: {
              fontSize: 20,
              fontWeight: 400,
            }
          }
        },

        {id: 'node4', size: 90, isLeaf: true, label: '司机信用'},
        {id: 'node5', size: 90, isLeaf: true,label: '异常批次'},

      ],
      edges: [
        {source: 'node0', target: 'node1'},
        {source: 'node0', target: 'node2'},
        {source: 'node0', target: 'node3'},
        {source: 'node1', target: 'node3'},
        {source: 'node2', target: 'node3'},
        {source: 'node3', target: 'node5'},
        {source: 'node3', target: 'node4'},
        {source: 'node1', target: 'node2'},

      ],
    };
  },
  mounted() {
    this.$getViewportSize()
    this.createTree();
  }
}
</script>
<style scoped>
#container1 {
  position: absolute;

  width: 50%;
  height: 100%
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

.root {
  height: calc(90vh - 120px);
  width: 100%;
}
</style>
