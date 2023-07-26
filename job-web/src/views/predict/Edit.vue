<template>
    <el-dialog title="新增" :visible.sync="param.visible" @close="param.close" :close-on-click-modal="false">
        <r-form ref="myForm" :rules="rules" :form="form" :items="items" :save="save"></r-form>
    </el-dialog>
</template>

<script>
    import {update} from "@/api/predict";
    import {query} from "@/api/resume";
    import RForm from "@/components/RForm";

    export default {
        name: "Add",
        components: {RForm},
        props: {
            param: {
                type: Object,
                default: () => {
                }
            }
        },
        data() {
            return {
                form: {
                  sex: '',
                  profession: '',
                  job: '',
                  city: '',
                  company: '',
                  salary: '',
                  score: '',
                },
                rules: {
                  sex: [{required: true, message: '必填项不能为空'}],
                  profession: [{required: true, message: '必填项不能为空'}],
                  job: [{required: true, message: '必填项不能为空'}],
                  city: [{required: true, message: '必填项不能为空'}],
                  company: [{required: true, message: '必填项不能为空'}],
                  salary: [{required: true, message: '必填项不能为空'}],
                  score: [{required: true, message: '必填项不能为空'}],
                },
                items: [
                  {type: 'text', label: '性别', prop: 'sex', name: 'sex', placeholder: '性别'},
                  {type: 'text', label: '所学专业', prop: 'profession', name: 'profession', placeholder: '所学专业'},
                  {type: 'text', label: '期望的工作', prop: 'job', name: 'job', placeholder: '期望的工作岗位'},
                  {type: 'text', label: '期望的城市', prop: 'city', name: 'city', placeholder: '期望发展的城市'},
                  {type: 'text', label: '期望的公司', prop: 'company', name: 'company', placeholder: '期望的公司'},
                  {type: 'text', label: '期望的薪资', prop: 'salary', name: 'salary', placeholder: '期望的薪资'},
                  {type: 'text', label: '专业课分数', prop: 'score', name: 'score', placeholder: '专业课分数'},
                ]
            }
        },
        mounted() {
            this.form = JSON.parse(JSON.stringify(this.param.form));
            query({}).then(res => {
                let arr = [];
                res.data.forEach(item => {
                    let param = {value: item.id, label: item.name}
                    arr.push(param)
                })
                this.items[0].options = arr;
            });
        },
        methods: {
            save() {
                let flag = this.$refs['myForm'].validateForm();
                if (flag) {
                    update(this.form).then(res => {
                        this.$message.success(res.msg);
                        this.param.close();
                        this.param.callback();
                    })
                }
            }
        }
    }
</script>

<style scoped>

</style>