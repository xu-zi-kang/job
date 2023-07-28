<template>
  <div>
    <!-- 焦点区 -->
    <div class="main mar-20">
      <el-row :gutter="15">
        <el-col :span="16">
          <el-card style="min-height: 1000px">
            <div slot="header" class="clearfix">
              <span>推荐职位</span>
            </div>
            <ul class="post-list">
              <li v-for="(item, index) in randomPosts" :key="index">
                <a href="#">



                  <router-link :to="`/detail3/${item.id}`" target="_blank">
                    {{ item.name }}
                  </router-link>




                  <span style="float: right">
                    <el-button type="primary" @click="send(item.id, item.companyId)" size="mini" round>申请职位</el-button>
                    <el-button type="danger" @click="favor(item.id, item.companyId)" size="mini" round>收藏职位</el-button>
                    <router-link :to="`/detail3/${item.id}`" target="_blank">
                      <el-button type="text">职位描述</el-button>
                    </router-link>
                  </span>
                </a>
                <p>
                  <span>{{ item.salary }}</span>
                  <span>{{ item.type }}</span>
                  <span>{{ item.size }}</span>
                  <span>{{ item.companyName }}</span>
                </p>
              </li>
            </ul>
            <el-pagination background layout="prev, pager, next, total" @current-change="handleCurrentChange" :total="10">
            </el-pagination>
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
import { post_query } from "../api/front";
import { send_create } from "../api/send";
import { favor_create } from "../api/favor";
import local from "../store/local";
import { message } from "../utils/message";
import list from '../front/List2.vue';

export default {
  name: "Index",
  props: ['channelId'],
  components: {},
  data() {
    return {
      posts: [],
      total: 0,
      showChartFlag: false
    }
  },
  mounted() {
    this.getPostList();
  },
  computed: {
    randomPosts() {
      // 获取随机的 5 条数据
      const shuffledPosts = this.shuffleArray(this.posts);
      return shuffledPosts.slice(0, 10);
    }
  },
  methods: {
    handleCurrentChange(page) {
      // 处理分页逻辑
    },

    getPostList() {
      post_query({}).then(res => {
        this.posts = res.data;
        this.total = res.total;
      })
    },

    send(postId, companyId) {
      // 执行申请逻辑
    },
    favor(postId, companyId) {
      // 执行收藏逻辑
    },
    showChart() {
      this.showChartFlag = true;
    },
    shuffleArray(array) {
      // 洗牌算法
      for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
      }
      return array;
    }
  }
}
</script>

<style scoped>
</style>
