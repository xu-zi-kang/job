(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d224930"],{e15c:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e._self._c;return t("div",[t("div",{staticClass:"btn-panel"},[t("el-button",{attrs:{size:"small",type:"primary",icon:"el-icon-plus"},on:{click:e.create}},[e._v("新增")]),t("el-button",{attrs:{size:"small",type:"primary",icon:"el-icon-edit"},on:{click:e.update}},[e._v("修改")]),t("el-button",{attrs:{size:"small",type:"danger",icon:"el-icon-delete"},on:{click:e.del}},[e._v("删除")])],1),t("el-tree",{attrs:{data:e.data,props:e.defaultProps},on:{"node-click":e.handleNodeClick}}),e.add.visible?t("Add",{attrs:{param:e.add}}):e._e(),e.edit.visible?t("Edit",{attrs:{param:e.edit}}):e._e()],1)},r=[],l=a("b775");function i(){return Object(l["a"])({url:"profession/tree",method:"post"})}function o(e){return Object(l["a"])({url:"profession/query",method:"post",data:e})}function n(e){return Object(l["a"])({url:"profession/create",method:"post",data:e})}function d(e){return Object(l["a"])({url:"profession/update",method:"post",data:e})}function c(e){return Object(l["a"])({url:"profession/delete",method:"post",params:{ids:e}})}var m=function(){var e=this,t=e._self._c;return t("el-dialog",{attrs:{title:"新增",visible:e.param.visible,"close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.param,"visible",t)},close:e.param.close}},[t("r-form",{ref:"myForm",attrs:{rules:e.rules,form:e.form,items:e.items,save:e.save}})],1)},p=[],u=(a("14d9"),a("714a")),h={name:"Add",components:{RForm:u["a"]},props:{param:{type:Object,default:()=>{}}},data(){return{form:{name:"",parentId:""},rules:{name:[{required:!0,message:"必填项不能为空"}]},items:[{type:"text",label:"行业类别",prop:"name",name:"name",placeholder:"请录入行业类别"},{type:"select",label:"上级类别",prop:"parentId",name:"parentId",placeholder:"请录入上级名称",options:[]}]}},created(){o({}).then(e=>{let t=e.data.filter(e=>0==e.parentId);console.log(t),t.forEach(e=>{let t={value:e.id,label:e.name};this.items[1].options.push(t)})})},methods:{save(){let e=this.$refs["myForm"].validateForm();e&&n(this.form).then(e=>{this.$message.success(e.msg),this.param.close(),this.param.callback()})}}},f=h,b=a("2877"),v=Object(b["a"])(f,m,p,!1,null,"7243fb0f",null),y=v.exports,g=function(){var e=this,t=e._self._c;return t("el-dialog",{attrs:{title:"修改",visible:e.param.visible,"close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.param,"visible",t)},close:e.param.close}},[t("r-form",{ref:"myForm",attrs:{rules:e.rules,form:e.form,items:e.items,save:e.save}})],1)},k=[],I={name:"Edit",components:{RForm:u["a"]},props:{param:{type:Object,default:()=>{}}},mounted(){let e=JSON.parse(JSON.stringify(this.param.form));this.form={id:e.id,name:e.label,parentId:e.parentId}},data(){return{form:{name:"",parentId:""},rules:{name:[{required:!0,message:"必填项不能为空"}]},items:[{type:"text",label:"行业类别",prop:"name",name:"name",placeholder:"请录入行业类别"},{type:"select",label:"上级类别",prop:"parentId",name:"parentId",placeholder:"请录入上级名称",options:[]}]}},created(){let e=JSON.parse(JSON.stringify(this.param.form));this.form={id:e.id,name:e.name,parentId:e.parentId},o({}).then(e=>{let t=e.data.filter(e=>0==e.parentId);console.log(t),t.forEach(e=>{let t={value:e.id,label:e.name};this.items[1].options.push(t)})})},methods:{save(){let e=this.$refs["myForm"].validateForm();e&&d(this.form).then(e=>{this.$message.success(e.msg),this.param.close(),this.param.callback()})}}},O=I,_=Object(b["a"])(O,g,k,!1,null,"5050d99f",null),j=_.exports,N=a("3fa5"),F={components:{Edit:j,Add:y},data(){return{data:[],selectNode:null,defaultProps:{children:"children",label:"label",parentId:"parentId",id:"id"},add:{visible:!1,close:this.close,callback:this.tree},edit:{visible:!1,close:this.close,callback:this.tree,form:{}}}},mounted(){this.tree()},methods:{handleNodeClick(e){this.edit.form=e,this.selectNode=e},tree(){i().then(e=>{this.data=e.data})},create(){this.add.visible=!0},update(){this.edit.visible=!0},del(){this.selectNode?this.$confirm("确定有删除吗？","删除提示").then(()=>{c(this.selectNode.id).then(e=>{this.$message.success(e.msg),this.tree()})}).catch(()=>{}):N["a"].warning("请选择要删除的节点")},close(){this.add.visible=!1,this.edit.visible=!1}}},$=F,w=Object(b["a"])($,s,r,!1,null,"595408de",null);t["default"]=w.exports}}]);
//# sourceMappingURL=chunk-2d224930.de6203cb.js.map