<!--柱状图-->
<template>
    <div class="echarts-bar">
        <div id="main5" style="width: 600px;height:600px;"></div>
    </div>
</template>

<script>
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
                let myChart = this.$echarts.init(document.getElementById("main5"));
                // 指定图表的配置项和数据
                let option = {
                  title: {
                    text: '项目经历'
                  },
                  legend: {},
                  tooltip: {
                    trigger: 'axis',
                    showContent: false
                  },
                  dataset: {
                    source: [
                      ['product', '2012', '2013', '2014', '2015'],
                      ['瑞吉外卖', 56.5, 82.1, 88.7, 70.1, 53.4, 85.1],
                      ['东湖健康', 51.1, 51.4, 55.1, 53.3, 73.8, 68.7],
                      ['谷粒商城', 40.1, 62.2, 69.5, 36.4, 45.2, 32.5],
                      ['可视化大窗', 25.2, 37.1, 41.2, 18, 33.9, 49.1]
                    ]
                  },
                  xAxis: { type: 'category' },
                  yAxis: { gridIndex: 0 },
                  grid: { top: '55%' },
                  series: [
                    {
                      type: 'line',
                      smooth: true,
                      seriesLayoutBy: 'row',
                      emphasis: { focus: 'series' }
                    },
                    {
                      type: 'line',
                      smooth: true,
                      seriesLayoutBy: 'row',
                      emphasis: { focus: 'series' }
                    },
                    {
                      type: 'line',
                      smooth: true,
                      seriesLayoutBy: 'row',
                      emphasis: { focus: 'series' }
                    },
                    {
                      type: 'line',
                      smooth: true,
                      seriesLayoutBy: 'row',
                      emphasis: { focus: 'series' }
                    },
                    {
                      type: 'pie',
                      id: 'pie',
                      radius: '30%',
                      center: ['50%', '25%'],
                      emphasis: {
                        focus: 'self'
                      },
                      label: {
                        formatter: '{b}: {@2012} ({d}%)'
                      },
                      encode: {
                        itemName: 'product',
                        value: '2012',
                        tooltip: '2012'
                      }
                    }
                  ]
                };
              myChart.on('updateAxisPointer', function (event) {
                const xAxisInfo = event.axesInfo[0];
                if (xAxisInfo) {
                  const dimension = xAxisInfo.value + 1;
                  myChart.setOption({
                    series: {
                      id: 'pie',
                      label: {
                        formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                      },
                      encode: {
                        value: dimension,
                        tooltip: dimension
                      }
                    }
                  });
                }
              });
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        }
    }
</script>
