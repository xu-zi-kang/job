<template>
  <el-dialog title="修改" :visible.sync="param.visible" @close="param.close" :close-on-click-modal="false">
    <r-form ref="myForm" :rules="rules" :form="form" :items="items" :save="save"></r-form>
  </el-dialog>
</template>

<script>
import {update} from "../../api/company";
import RForm from "../../components/RForm";

export default {
  name: "Edit",
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
        id: '',
        name: '',
        account: '',
        password: '',
        contact: '',
        telephone: ''
      },
      rules: {
        name: [{required: true, message: "必填项不能为空"}],
        account: [{required: true, message: "必填项不能为空"}],
        password: [{required: true, message: "必填项不能为空"}],
        contact: [{required: true, message: "必填项不能为空"}],
        telephone: [{required: true, message: "必填项不能为空"}],
      },
      items: [
        {type: 'text', label: '公司', prop: 'name', name: 'name', placeholder: '请录入公司名'},
        {type: 'text', label: '用户名', prop: 'account', name: 'account', placeholder: '请录入用户名'},
        {type: 'password', label: '密码', prop: 'password', name: 'password', placeholder: '请录入密码'},
        {type: 'text', label: '创始人', prop: 'contact', name: 'contact', placeholder: '请录入创始人'},
        {type: 'text', label: '手机号', prop: 'telephone', name: 'telephone', placeholder: '请录入手机号'},
      ]
    }
  },
  mounted() {
    this.form = JSON.parse(JSON.stringify(this.param.form));
  },
  methods: {
    save() {
      let flag = this.$refs['myForm'].validateForm();
      if (flag) {
        //执行保存
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