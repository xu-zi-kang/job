<template>

    <el-container class="container">
        <Sidebar @handleMenuItem="handleMenuItem"></Sidebar>
        <el-container>
            <el-header>
                <Navbar></Navbar>
            </el-header>
            <el-main>

                <el-breadcrumb separator-class="el-icon-arrow-right">

                    <el-breadcrumb-item :to="{ path: '' }"><a href="/index">首页</a></el-breadcrumb-item>
                    <el-breadcrumb-item>{{menuName}}</el-breadcrumb-item>

                </el-breadcrumb>
<!--              <router-view class="rv"></router-view>-->

<!--              <div v-if="ass === '/index'">-->
<!--                <chart></chart>-->
<!--              </div>-->


              <template v-if="aas === '/index'">
                <div class="rv">
                    <chart></chart>
                </div>
              </template>


              <template v-else>
                <router-view class="rv"></router-view>
            </template>



            </el-main>
        </el-container>
    </el-container>


</template>

<script>
    import Sidebar from '../components/Sidebar'
    import Navbar from '../components/Navbar'
    import chart from '../components/echarts/bar.vue'
    //import chart1 from '../components/echarts/bar1.vue'

    export default {
        name: "Index",
        components: {
            Sidebar, Navbar,chart
        },
        data() {
            return {
                isCollapse: true,
                menuName: '',
              aas: ''
            }
        },
      created() {
          console.log(this.$route)
        this.aas = this.$route.fullPath;
      },


      watch: {
        $route: {
          handler(val,old_val){
            console.log(val)
            this.aas = val.fullPath;
          },
          immediate: false,
          deep: true
        }
      },



      methods: {
            handleMenuItem(item) {
                this.menuName = item.name
            }
        }
    }
</script>

<style scoped>
    .container {
        width: 100%;
        height: 100%;
        background-color: pink;
    }

    .el-header {
        padding: 0;
    }

    .el-main {
        padding: 0;
        background-color: #f2f2f2;
    }

    .el-breadcrumb {
        background-color: #ffffff;
        height: 40px;
        line-height: 40px;
        border-bottom: 1px solid #e2dddd;
        padding-left: 10px;
        box-sizing: border-box;
    }

    .rv {
        background-color: #ffffff;
        margin: 10px;
        padding: 10px;
        border-radius: 3px;
    }
</style>
