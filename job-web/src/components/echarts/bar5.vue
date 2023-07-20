<!--柱状图-->
<template>
    <div class="echarts-bar">
<!--        <div id="main" style="width: 600px;height:600px;"></div>-->
<!--      <div id="mywordcloud" :style="{width: '100%', height: '300px'}" :data="worddata"></div>-->
      <div id="myEchart" :style="{width: '300px', height: '300px'}"></div>

    </div>


</template>

<script>
//import echarts from "echarts";
import * as echarts from "echarts";
import "echarts-wordcloud/dist/echarts-wordcloud";
import "echarts-wordcloud/dist/echarts-wordcloud.min";
export default {
  data(){
    return{
      image:"data:image/png;base64,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"
    }

  },
  mounted(){
    this. initEchart()
  },
  methods:{
    initEchart(){
      const echartDom = document.getElementById('myEchart')
      const myChart = echarts.init(echartDom)
      var options
      var maskImage = new Image();
      maskImage.src = this.image

      options  = {
        series: [{
          type: 'wordCloud',
          shape: 'circle',
          keepAspect: false,
          maskImage: maskImage,
          left: 'center',
          top: 'center',
          width: '100%',
          height: '90%',
          right: null,
          bottom: null,
          sizeRange: [4, 8],
          rotationRange: [-90, 90],
          rotationStep: 45,
          gridSize: 8,
          drawOutOfBound: false,
          layoutAnimation: true,
          textStyle: {
            fontFamily: 'sans-serif',
            fontWeight: 'bold',
            color: function () {
              return 'rgb(' + [
                Math.round(Math.random() * 160),
                Math.round(Math.random() * 160),
                Math.round(Math.random() * 160)
              ].join(',') + ')';
            }
          },
          emphasis: {
            // focus: 'self',
            textStyle: {
              textShadowBlur: 3,
              textShadowColor: '#333'
            }
          },
          //data属性中的value值却大，权重就却大，展示字体就却大
          data: [
            {name: 'Farrah',value: 366},
            {name: "汽车",value: 900},
            {name: "视频",value: 606},
            {name: "科技", "value": 452},
            {name: "美食", "value": 789},
            {name: "旅游", "value": 321},
            {name: "音乐", "value": 567},
            {name: "健康", "value": 245},
            {name: "时尚", "value": 678},
            {name: "体育", "value": 543},
            {name: "房地产", "value": 876},
            {name: "电影", "value": 432},
            {name: "教育", "value": 987},
            {name: "金融", "value": 345},
            {name: "游戏", "value": 654},
            {name: "新闻", "value": 789},
            {name: "艺术", "value": 456},
            {name: "文化", "value": 321},
            {name: "科学", "value": 567},
            {name: "历史", "value": 234},
            {name: "政治", "value": 678},
            {name: "环境", "value": 543},
            {name: "社交媒体", "value": 876},
            {name: "宠物", "value": 432},
            {name: "家居", "value": 987},
            {name: "美容", "value": 345},
            {name: "摄影", "value": 654},
            {name: "舞蹈", "value": 789},
            {name: "军事", "value": 456},
            {name: "自然", "value": 321},
            {name: "风景", "value": 567},
            {name: "人物", "value": 234},
            {name: "动物", "value": 678},
            {name: "编程", "value": 543},
            {name: "设计", "value": 876},
            {name: "旅行", "value": 432},
            {name: "心理学", "value": 987},
            {name: "医学", "value": 345},
            {name: "运动", "value": 654},
            {name: "购物", "value": 789},
            {name: "电视剧", "value": 456},
            {name: "文学", "value": 321},
            {name: "植物", "value": 567},
            {name: "天文学", "value": 234},
            {name: "烹饪", "value": 678},
            {name: "戏剧", "value": 543},
            {name: "法律", "value": 876},
            {name: "心理健康", "value": 432},
            {name: "音乐剧", "value": 987},
            {name: "化学", "value": 345}
          ]
        }]

      }
      myChart.setOption(options)

      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        myChart.resize();
      });
    }
  }
}


</script>
