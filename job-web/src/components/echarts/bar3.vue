<!--柱状图-->
<template>
    <div class="echarts-bar">
        <div id="main4" style="width: 600px;height:400px;"></div>
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
                let myChart = this.$echarts.init(document.getElementById("main4"));
                // 指定图表的配置项和数据
                let option = {
                  title: {
                    text: '培训经历'
                  },
                  tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c}%'
                  },
                  toolbox: {
                    feature: {
                      dataView: { readOnly: false },
                      restore: {},
                      saveAsImage: {}
                    }
                  },
                  legend: {
                    data: ['企业实习', '学校培训', '自主学习', '网课视频', '其他']
                  },
                  series: [
                    {
                      name: '培训经历占比：',
                      type: 'funnel',
                      left: '10%',
                      top: 60,
                      bottom: 60,
                      width: '80%',
                      min: 0,
                      max: 100,
                      minSize: '0%',
                      maxSize: '100%',
                      sort: 'descending',
                      gap: 2,
                      label: {
                        show: true,
                        position: 'inside'
                      },
                      labelLine: {
                        length: 10,
                        lineStyle: {
                          width: 1,
                          type: 'solid'
                        }
                      },
                      itemStyle: {
                        borderColor: '#fff',
                        borderWidth: 1
                      },
                      emphasis: {
                        label: {
                          fontSize: 20
                        }
                      },
                      data: [
                        { value: 60, name: '自主学习' },
                        { value: 40, name: '网课视频' },
                        { value: 20, name: '其他' },
                        { value: 80, name: '学校培训' },
                        { value: 100, name: '企业实习' }
                      ]
                    }
                  ]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        }
    }
</script>
