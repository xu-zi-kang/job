<template>
  <swiper class="swiper" :options="swiperOption">
    <swiper-slide>
      <img src="../assets/images/4.png" width="800px" height="360px">
    </swiper-slide>
    <swiper-slide>
      <img src="../assets/images/1.png" width="700px" height="360px">
    </swiper-slide>
    <swiper-slide>
      <img src="../assets/images/2.png" width="700px" height="360px">
    </swiper-slide>
    <!--        <swiper-slide>-->
    <!--            <img src="../assets/images/3.png" width="700px" height="360px">-->
    <!--        </swiper-slide>-->

    <swiper-slide>
      <img src="../assets/images/5.png" width="800px" height="360px">
    </swiper-slide>
    <swiper-slide>
      <img src="../assets/images/6.png" width="800px" height="360px">
    </swiper-slide>
    <div class="swiper-pagination" slot="pagination"></div>
  </swiper>
</template>

<script>
// vue-awesome-swiper
import {Swiper, SwiperSlide} from 'vue-awesome-swiper';
import 'swiper/css/swiper.css'

export default {
  name: "RSwiper",
  components: {Swiper, SwiperSlide},
  data() {
    return {
      swiperOption: {
        pagination: {
          el: '.swiper-pagination'
        },
        autoplay: {
          delay: 1000
        } // 添加autoplay属性
      }
    }
  }
}
</script>

<style scoped>

</style>