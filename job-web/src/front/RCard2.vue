<template>
    <el-card>
        <div slot="header" class="clearfix">
            <span>更多职业</span>
        </div>
        <ul class="hot">
            <li v-for="(item,index) in posts.slice(0,7)" :key="index">
              <router-link :to="`/detail3/${item.id}`" target="_blank">
                {{ item.name }}
              </router-link>
            </li>
        </ul>
    </el-card>
</template>

<script>
    import {article_query} from "../api/front";
    import {channel_detail} from "../api/front";
    import { post_query } from "../api/front";

    export default {
        name: "RCard",
        props: ['channelId'],
        data() {
            return {
              posts: [],
              total: 0
            }
        },
        mounted() {
          this.getPostList();
        },
        methods: {
            getChannel() {
                channel_detail(this.channelId).then(res => {
                    this.channelName = res.data.name;
                })
            },

          getPostList() {
            post_query({}).then(res => {
              this.posts = res.data;
              this.total = res.total;
            })
          },

            getArticles() {
                article_query({channelId:this.channelId}).then(res => {
                    this.articles = res.data;
                })
            }
        }
    }
</script>

<style scoped>

</style>