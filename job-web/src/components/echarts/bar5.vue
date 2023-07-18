<!--柱状图-->
<template>
    <div class="echarts-bar">
        <div id="main" style="width: 600px;height:600px;"></div>
    </div>
</template>

<script>
import * as echarts from 'echarts/core';
import { TooltipComponent } from 'echarts/components';
import { TreeChart } from 'echarts/charts';
import { CanvasRenderer } from 'echarts/renderers';
import $ from "core-js/internals/queue";

echarts.use([TooltipComponent, TreeChart, CanvasRenderer]);

var ROOT_PATH = 'https://echarts.apache.org/examples';

var chartDom = document.getElementById('main');
var myChart = echarts.init(chartDom, 'dark');
var option;
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


              myChart.showLoading();
              $.get(ROOT_PATH + '/data/asset/data/flare.json', function (data) {
                myChart.hideLoading();
                data.children.forEach(function (datum, index) {
                  index % 2 === 0 && (datum.collapsed = true);
                });
                myChart.setOption(
                    (option = {
                      tooltip: {
                        trigger: 'item',
                        triggerOn: 'mousemove'
                      },
                      series: [
                        {
                          type: 'tree',
                          data: [data],
                          top: '1%',
                          left: '7%',
                          bottom: '1%',
                          right: '20%',
                          symbolSize: 7,
                          label: {
                            position: 'left',
                            verticalAlign: 'middle',
                            align: 'right',
                            fontSize: 9
                          },
                          leaves: {
                            label: {
                              position: 'right',
                              verticalAlign: 'middle',
                              align: 'left'
                            }
                          },
                          emphasis: {
                            focus: 'descendant'
                          },
                          expandAndCollapse: true,
                          animationDuration: 550,
                          animationDurationUpdate: 750
                        }
                      ]
                    })
                );
              });

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        }
    }
</script>
