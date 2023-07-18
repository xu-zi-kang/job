<!--柱状图-->
<template>
    <div class="echarts-bar">
        <div id="main" style="width: 600px;height:400px;"></div>
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
                let myChart = this.$echarts.init(document.getElementById("main"));
                // 指定图表的配置项和数据
                let option = {
                  title: {
                    text: '当前掌握技能图',
                    subtext: '张三',
                    left: 'center'
                  },
                  tooltip: {
                    trigger: 'item'
                  },
                  legend: {
                    orient: 'vertical',
                    left: 'left'
                  },
                  series: [
                    {
                      name: '掌握情况',
                      type: 'pie',
                      radius: '50%',
                      data: [
                        { value: 1048, name: '后端知识' },
                        { value: 735, name: '前端知识' },
                        { value: 580, name: '代码编写' },
                        { value: 484, name: '职业培训' },
                        { value: 300, name: '影视剪辑' }
                      ],
                      emphasis: {
                        itemStyle: {
                          shadowBlur: 10,
                          shadowOffsetX: 0,
                          shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                      }
                    }
                  ]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        }
    }
</script>
