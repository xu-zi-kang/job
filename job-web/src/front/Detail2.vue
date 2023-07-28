<template>
  <div v-title :data-title="post.name">

    <!--        <div class="main mar-20">-->
    <!--            <el-breadcrumb>-->
    <!--                <el-breadcrumb-item :to="{path:'/'}">首页</el-breadcrumb-item>-->
    <!--                <el-breadcrumb-item>-->
    <!--                    <router-link :to="`/list/${channel.id}`">{{channel.name}}</router-link>-->
    <!--                </el-breadcrumb-item>-->
    <!--                <el-breadcrumb-item>正文</el-breadcrumb-item>-->
    <!--            </el-breadcrumb>-->
    <!--        </div>-->

    <!-- 焦点区 -->
    <div class="main mar-20">
      <el-row :gutter="15">
        <el-col :span="16">
          <el-card style="min-height: 1000px">
            <div slot="header" class="clearfix">
              <span>职位描述及要求</span>
            </div>

            <div class="content">
              <div class="title">{{post.name}}</div>

              <div class="txt">
                <mavon-editor :value="post.description"
                              :toolbarsFlag="false"
                              :subfield="false"
                              :shortCut="false"
                              :autofocus="false"
                              :ishljs="true"
                              :boxShadow="false"
                              fontSize="16px"
                              previewBackground="#FFFFFF"
                              defaultOpen="preview" />
              </div>



            </div>


          </el-card>
        </el-col>
        <el-col :span="8">
          <r-card :channelId="18"></r-card>
        </el-col>
      </el-row>
    </div>

  </div>
</template>

<script>
import '../assets/css/styles.css'

import {article_detail2, post_query} from "../api/front";
import {post_detail} from "../api/front";

import Vue from 'vue'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import RCard from "./RCard2";
// use
Vue.use(mavonEditor)

export default {
  name: "Index",
  components: {RCard},
  data() {
    return {
      article: {},
      post: {}
    }
  },
  // 钩子函数
  mounted() {
    //this.getArticle(this.$route.params.id);
    this.getPostDetail(this.$route.params.id);
  },
  methods: {
    getArticle(title) {
      article_detail2(title).then(res => {
        this.article = res.data;
      })
    },
    getPostDetail(id) {
      post_detail(id).then(res => {
        this.post = res.data;
      })
    }

  }
}
</script>

<style scoped>

</style>