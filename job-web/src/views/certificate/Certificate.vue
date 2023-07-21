<template>
    <div>
        <r-query-form :form="form" :items="items" @search="search"></r-query-form>
        <div class="btn-panel">
            <el-button size="small" type="primary" icon="el-icon-plus" @click="create">新增</el-button>
            <el-button size="small" type="primary" icon="el-icon-edit" @click="update">修改</el-button>
            <el-button size="small" type="danger" icon="el-icon-delete" @click="del">删除</el-button>
        </div>

        <r-table ref="mutipleTable" :tableData="tableData" :tableCols="tableCols">
            <template slot="slot_resume" slot-scope="scope">
              <span v-if="scope.data.resume">{{ scope.data.resume.name }}</span>
              <span v-else>none</span>
            </template>
        </r-table>
        <r-pagination :page="page" :total="total" @handleCurrentChange="handleCurrentChange"></r-pagination>

        <Add v-if="add.visible" :param="add"></Add>
        <Edit v-if="edit.visible" :param="edit"></Edit>
    </div>
</template>

<script>
    import {query} from "@/api/certificate";
    import Add from "./Add";
    import Edit from "./Edit";
    import {del} from "../../api/certificate";
    import RTable from "../../components/RTable";
    import RPagination from "../../components/RPagination";
    import RQueryForm from "../../components/RQueryForm";

    export default {
        name: "Certificate",
        components: {RQueryForm, RPagination, Edit, Add, RTable},
        data() {
            return {
                tableData: [],
                tableCols: [
                  {prop: 'id2', label: 'ID', width: 80},
                  {prop: 'id', label: '系统编号', width: 80},
                    {prop: 'resumeId', label: '简历', slot: 'slot_resume'},
                    {prop: 'name', label: '证书名称'},
                    {prop: 'obtainDate', label: '获得时间'},
                    {prop: 'file', label: '附件'}
                ],
                total: 0,
                page: 1,
                form: {
                    name: ''
                },
                items: [
                    {type: 'text', label: '证书名称', name: 'name', placeholder: '按证书名称查询'}
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
                }
            }
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
                  //我使用map()方法遍历res.data，并为每个数据项创建一个新对象，其中的id值使用索引加1来表示。这样就可以将按照顺序排列的id显示在页面上，而不是使用数据库中的id数据。
                  // 对数据进行处理
                  this.tableData = res.data.map((item, index) => {
                    return {
                      ...item,
                      id2: index + 1 // 使用索引加1作为新的id值
                    };
                  });
                  const emptyResumeData = res.data.filter(item => !item.resume);
                  this.tableData = [...this.tableData, ...emptyResumeData];
                    this.total = res.total;
                })
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
                    this.$confirm("确定有删除吗？", "删除提示").then(() => {
                        let arr = selections.map(item => item.id);
                        let ids = arr.join(',');
                        del(ids).then(res => {
                            this.$message.success(res.msg);
                            this.search();
                        })
                    }).catch(() => {
                    })
                } else {
                    this.$message.warning("请选择要删除的数据");
                }
            }
        }
    }
</script>

<style scoped>

</style>