(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5498b29d"],{"7e6e":function(t,e,s){t.exports=s.p+"img/manage-bg.d30045d0.png"},a09b:function(t,e,s){},a55b:function(t,e,s){"use strict";s.r(e);var a=function(){var t=this,e=t._self._c;return e("div",[t._m(0),e("div",{staticClass:"login-container"},[e("div",{staticClass:"login-main"},[t._m(1),e("div",{staticClass:"box"},[e("div",{staticClass:"title"},[t._v("系统登录")]),e("el-form",{ref:"loginForm",attrs:{model:t.form,rules:t.rules}},[e("el-form-item",{attrs:{prop:"account"}},[e("el-input",{staticClass:"login-user",attrs:{placeholder:"请输入用户名"},model:{value:t.form.account,callback:function(e){t.$set(t.form,"account",e)},expression:"form.account"}})],1),e("el-form-item",{attrs:{prop:"password"}},[e("el-input",{staticClass:"login-pwd",attrs:{type:"password",placeholder:"请输入密码"},model:{value:t.form.password,callback:function(e){t.$set(t.form,"password",e)},expression:"form.password"}})],1),e("el-form-item",[e("el-select",{attrs:{placeholder:"请选择类型"},model:{value:t.form.type,callback:function(e){t.$set(t.form,"type",e)},expression:"form.type"}},t._l(t.options,(function(t){return e("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1),e("el-form-item",[e("el-button",{staticClass:"login-btn",attrs:{type:"primary",loading:!1},on:{click:t.login}},[t._v("登录")])],1)],1)],1)])]),e("div",{staticClass:"login-footer"},[t._v(" 本网站信息未经书面许可不得转载，浏览器推荐使用Chrome、FireFox、IE8.0以上版本 ")])])},o=[function(){var t=this,e=t._self._c;return e("div",{staticClass:"login-header"},[e("div",{staticClass:"login-main"},[e("div",{staticClass:"system-title"},[t._v(" 毕业生就业工作预测平台 ")])])])},function(){var t=this,e=t._self._c;return e("div",{staticClass:"show"},[e("img",{attrs:{src:s("7e6e")}})])}],l=(s("14d9"),{name:"Login",data(){return{form:{account:"admin",password:"123",type:0},options:[{label:"管理员",value:0},{label:"企业",value:1},{label:"学生",value:2}],rules:{account:[{required:!0,message:"用户名不能为空"}],password:[{required:!0,message:"密码不能为空"}]}}},methods:{login(){this.$refs["loginForm"].validate(t=>{t&&this.$store.dispatch("login",this.form).then(t=>{200==t.code&&this.$router.push("/index")})})}}}),i=l,r=(s("f86c"),s("2877")),n=Object(r["a"])(i,a,o,!1,null,"41533bca",null);e["default"]=n.exports},f86c:function(t,e,s){"use strict";s("a09b")}}]);
//# sourceMappingURL=chunk-5498b29d.bfed2b3e.js.map