<!--柱状图-->
<template>
  <div class="echarts-bar">
    <div id="main6" style="width: 600px;height:400px;"></div>
  </div>
</template>

<script>

import * as echarts from "echarts";

import "../../components/echarts/china.js";

export default {
  name: 'echarts-bar',
  data () {
    return {
    }
  },
  mounted () {
    this.drawChart();
  },
  updated () {
  },
  computed: {
  },
  methods: {
    drawChart() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("main6"));
      // 指定图表的配置项和数据
      var option = {
        title: {
          text: '简历投递'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {},
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'value',
          boundaryGap: [0, 0.01]
        },
        yAxis: {
          type: 'category',
          data: ['小米的java工程师', '腾讯的C++工程师', '华为的php工程师', '蔚来的go工程师', '立场的java工程师', '大宇宙的产品经理']
        },
        series: [
          {
            name: '2015',
            type: 'bar',
            data: [11, 24, 24, 24]
          },
          {
            name: '2016',
            type: 'bar',
            data: [12, 45, 48, 24]
          },
          {
            name: '2017',
            type: 'bar',
            data: [31, 45, 24, 24]
          },
          {
            name: '2018',
            type: 'bar',
            data: [47,  45, 13, 24, 24]
          },
          {
            name: '2019',
            type: 'bar',
            data: [32, 43,35, 36, 24]
          },
          {
            name: '2020',
            type: 'bar',
            data: [37, 45, 54,  24]
          }
        ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    }
  }
}
</script>
