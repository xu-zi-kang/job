<template>
  <div>
    <r-query-form :form="form" :items="items" @search="search"></r-query-form>
    <div class="btn-panel">
      <el-button size="small" type="primary" icon="el-icon-plus" @click="create">填写问卷</el-button>
      <el-button size="small" type="primary" icon="el-icon-edit" @click="update">修改问卷</el-button>
      <el-button size="small" type="danger" icon="el-icon-delete" @click="del">删除问卷</el-button>
    </div>

    <div class="centered-text">
      <div class="larger-font hupo-font green-color">调查问卷内容</div>
    </div>

    <r-table ref="mutipleTable" :tableData="tableData" :tableCols="tableCols">
      <template slot="slot_resume" slot-scope="scope">
        <span v-if="scope.data.resume">{{ scope.data.resume.name }}</span>
        <span v-else>{{ scope.data.company }}</span>
      </template>
    </r-table>

    <r-pagination :page="page" :total="total" @handleCurrentChange="handleCurrentChange"></r-pagination>

    <Add v-if="add.visible" :param="add"></Add>
    <Edit v-if="edit.visible" :param="edit"></Edit>


    <div class="centered-text">
    <el-button class="larger-font2" type="primary" @click="showChart">点击进行职业预测</el-button>
    </div>
    <chart v-if="showChartFlag"></chart>

    <post-list v-if="showChartFlag"></post-list>

    <!-- 其他组件内容 -->
    <!-- <iframe src="https://yol.homes" width="1200px" height="800px"></iframe> -->
    <!-- <iframe src="https://www.16personalities.com/ch/%E4%BA%BA%E6%A0%BC%E6%B5%8B%E8%AF%95" width="100%" height="900px"></iframe> -->
  </div>
</template>

<script>
import { query } from "@/api/predict";
import Add from "./Add";
import Edit from "./Edit";
import { del } from "../../api/predict";
import RTable from "../../components/RTable";
import RPagination from "../../components/RPagination";
import RQueryForm from "../../components/RQueryForm";
import chart from '../../components/echarts/bar6.vue';
import postList from '../../front/PostList2.vue'

export default {
  name: "Predict",
  components: {
    RQueryForm,
    RPagination,
    Edit,
    Add,
    RTable,
    chart,
    postList
  },
  data() {
    return {
      tableData: [],
      tableCols: [
        { prop: 'id2', label: 'ID', width: 80 },
        { prop: 'id', label: '系统编号', width: 80 },
        { prop: 'sex', label: '性别' },
        { prop: 'profession', label: '专业' },
        { prop: 'job', label: '期望工作' },
        { prop: 'city', label: '期望城市' },
        { prop: 'company', label: '期望公司' },
        { prop: 'salary', label: '期望薪水' },
        { prop: 'score', label: '专业分数' },
      ],
      total: 0,
      page: 1,
      form: { name: '' },
      items: [
        { type: 'text', label: '期望工作', name: 'job', placeholder: '按期望工作查询' }
      ],
      add: {
        visible: false,
        close: this.close,
        callback: this.search
      },
      edit: {
        visible: false,
        close: this.close,
        callback: this.search,
        form: null
      },
      showChartFlag: false
    };
  },
  mounted() {
    this.list({});
  },
  methods: {
    handleCurrentChange(val) {
      this.page = val;
      let params = this.form;
      params.page = this.page;
      this.list(params);
    },
    search() {
      this.list(this.form);
    },
    list(params) {
      query(params).then(res => {
        this.tableData = res.data.map((item, index) => {
          return {
            ...item,
            id2: index + 1
          };
        });
        this.total = res.total;
      });
    },
    close() {
      this.add.visible = false;
      this.edit.visible = false;
    },
    create() {
      this.add.visible = true;
    },
    update() {
      let selections = this.$refs['mutipleTable'].selection;
      if (selections.length == 1) {
        this.edit.visible = true;
        this.edit.form = selections[0];
      } else {
        this.$message.warning("请选择一条数据进行修改");
      }
    },
    del() {
      let selections = this.$refs['mutipleTable'].selection;
      if (selections.length > 0) {
        this.$confirm("确定要删除吗？", "删除提示").then(() => {
          let arr = selections.map(item => item.id);
          let ids = arr.join(',');
          del(ids).then(res => {
            this.$message.success(res.msg);
            this.search();
          });
        }).catch(() => {});
      } else {
        this.$message.warning("请选择要删除的数据");
      }
    },
    showChart() {
      this.showChartFlag = true;
    }
  }
};
</script>

<style scoped>
.centered-text {
  text-align: center;
}

.larger-font {
  font-size: 60px;
  /* 调整字体大小的数值 */
}
.larger-font2 {
  font-size: 30px;
  /* 调整字体大小的数值 */
}

.kaiti-font {
  font-family: KaiTi, "楷体", serif;
}

.hupo-font {
  font-family: "华文琥珀", "STHupo", serif;
}

.green-color {
  color: green;
}
</style>
