(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-59922396"],{"13be":function(e,t,a){},6159:function(e,t,a){"use strict";var l=function(){var e=this,t=e._self._c;return t("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,border:"","cell-style":{height:"38px",padding:"0"},"header-cell-style":{background:"#f2f2f2",height:"38px",padding:"0"}},on:{"selection-change":e.handleSelectionChange}},[e.isSelection?t("el-table-column",{attrs:{type:"selection",width:"55"}}):e._e(),e._l(e.tableCols,(function(a,l){return t("el-table-column",{key:l,attrs:{prop:a.prop,label:a.label,width:a.width,"show-overflow-tooltip":""},scopedSlots:e._u([{key:"default",fn:function(t){return[a.slot?e._t(a.slot,null,{data:t.row}):e._t("default",(function(){return[e._v(e._s(t.row[a.prop]))]}))]}}],null,!0)})}))],2)},s=[],i={name:"RTable",props:{tableData:{type:Array},tableCols:{type:Array},isSelection:{type:Boolean,default:!0}},data(){return{selection:[]}},methods:{handleSelectionChange(e){this.selection=e}}},r=i,o=a("2877"),c=Object(o["a"])(r,l,s,!1,null,"50e06f02",null);t["a"]=c.exports},"9f66":function(e,t,a){"use strict";a("13be")},b705:function(e,t,a){"use strict";a.d(t,"d",(function(){return s})),a.d(t,"a",(function(){return i})),a.d(t,"e",(function(){return r})),a.d(t,"b",(function(){return o})),a.d(t,"c",(function(){return c}));var l=a("b775");function s(e){return Object(l["a"])({url:"type/query",method:"post",data:e})}function i(e){return Object(l["a"])({url:"dict/create",method:"post",data:e})}function r(e){return Object(l["a"])({url:"dict/update",method:"post",data:e})}function o(e){return Object(l["a"])({url:"dict/delete",method:"post",params:{ids:e}})}function c(e){return Object(l["a"])({url:"dict/query",method:"post",data:e})}},df8c:function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e._self._c;return t("div",{staticStyle:{background:"#f2f2f2"}},[t("el-row",{attrs:{gutter:20}},[t("el-col",{attrs:{span:5}},[t("el-card",[t("ul",{staticClass:"type"},e._l(e.typeTableData,(function(a,l){return t("li",{key:l,class:e.active==l?"active":"",on:{click:function(t){return e.handleType(l,a.id)}}},[e._v(" "+e._s(a.name)+" ")])})),0)])],1),t("el-col",{attrs:{span:19}},[t("el-card",[t("div",{staticClass:"btn-panel"},[t("el-button",{attrs:{size:"small",type:"primary",icon:"el-icon-plus"},on:{click:e.create}},[e._v("新增")]),t("el-button",{attrs:{size:"small",type:"primary",icon:"el-icon-edit"},on:{click:e.update}},[e._v("修改")]),t("el-button",{attrs:{size:"small",type:"danger",icon:"el-icon-delete"},on:{click:e.del}},[e._v("删除")])],1),t("r-table",{ref:"mutipleTable",attrs:{"table-data":e.dictTableData,"table-cols":e.dictTableCols},scopedSlots:e._u([{key:"slot_status",fn:function(a){return[0==a.data.status?t("el-tag",{attrs:{type:"success",size:"mini"}},[e._v("正常")]):t("el-tag",{attrs:{type:"danger",size:"mini"}},[e._v("停用")])]}}])})],1),e.add.visible?t("Add",{attrs:{param:e.add,typeId:e.selectTypeId}}):e._e(),e.edit.visible?t("Edit",{attrs:{param:e.edit,typeId:e.selectTypeId}}):e._e()],1)],1)],1)},s=[],i=a("b705"),r=a("6159"),o=function(){var e=this,t=e._self._c;return t("el-dialog",{attrs:{title:"新增",visible:e.param.visible,"close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.param,"visible",t)},close:e.param.close}},[t("r-form",{ref:"myForm",attrs:{rules:e.rules,form:e.form,items:e.items,save:e.save}})],1)},c=[],n=a("714a"),d={name:"Add",components:{RForm:n["a"]},props:{param:{type:Object,default:()=>{}},typeId:{type:Number}},data(){return{form:{typeId:this.typeId,dictKey:"",dictVal:"",sort:10,status:0},rules:{dictKey:[{required:!0,message:"必填项不能为空"}],dictVal:[{required:!0,message:"必填项不能为空"}]},items:[{type:"text",label:"键名称",prop:"dictKey",name:"dictKey",placeholder:"请录入字典名称"},{type:"text",label:"键值",prop:"dictVal",name:"dictVal",placeholder:"请录入字典值"},{type:"text",label:"序号",prop:"sort",name:"sort",placeholder:"请录入序号"},{type:"select",label:"状态",prop:"status",name:"status",placeholder:"请选择状态",options:[{value:0,label:"正常"},{value:1,label:"删除"}]}]}},methods:{save(){let e=this.$refs["myForm"].validateForm();e&&Object(i["a"])(this.form).then(e=>{this.$message.success(e.msg),this.param.close(),this.param.callback()})}}},p=d,u=a("2877"),m=Object(u["a"])(p,o,c,!1,null,"207af9f8",null),b=m.exports,h=function(){var e=this,t=e._self._c;return t("el-dialog",{attrs:{title:"修改",visible:e.param.visible,"close-on-click-modal":!1},on:{"update:visible":function(t){return e.$set(e.param,"visible",t)},close:e.param.close}},[t("r-form",{ref:"myForm",attrs:{rules:e.rules,form:e.form,items:e.items,save:e.save}})],1)},y=[],f={name:"Add",components:{RForm:n["a"]},props:{param:{type:Object,default:()=>{}},typeId:{type:Number}},mounted(){this.form=JSON.parse(JSON.stringify(this.param.form))},data(){return{form:{id:"",typeId:this.typeId,dictKey:"",dictVal:"",sort:10,status:0},rules:{dictKey:[{required:!0,message:"必填项不能为空"}],dictVal:[{required:!0,message:"必填项不能为空"}]},items:[{type:"text",label:"键名称",prop:"dictKey",name:"dictKey",placeholder:"请录入字典名称"},{type:"text",label:"键值",prop:"dictVal",name:"dictVal",placeholder:"请录入字典值"},{type:"text",label:"序号",prop:"sort",name:"sort",placeholder:"请录入序号"},{type:"select",label:"状态",prop:"status",name:"status",placeholder:"请选择状态",options:[{value:0,label:"正常"},{value:1,label:"删除"}]}]}},methods:{save(){let e=this.$refs["myForm"].validateForm();e&&Object(i["e"])(this.form).then(e=>{this.$message.success(e.msg),this.param.close(),this.param.callback()})}}},v=f,g=Object(u["a"])(v,h,y,!1,null,"6b4ce78a",null),_=g.exports,T={name:"Dict",components:{Edit:_,Add:b,RTable:r["a"]},data(){return{typeTableData:[],active:0,selectTypeId:0,typeTableCols:[{prop:"name",label:"类型名称"}],dictTableData:[],dictTableCols:[{prop:"dictKey",label:"字典名称"},{prop:"dictVal",label:"字典值"},{prop:"status",label:"状态",slot:"slot_status"},{prop:"sort",label:"序号",width:100}],add:{visible:!1,close:this.close,callback:this.reload},edit:{visible:!1,close:this.close,callback:this.reload,form:null}}},mounted(){Object(i["d"])({}).then(e=>{this.typeTableData=e.data,this.selectTypeId=this.typeTableData[0].id}),this.list({typeId:this.selectTypeId})},methods:{create(){this.add.visible=!0},update(){let e=this.$refs["mutipleTable"].selection;1==e.length?(this.edit.visible=!0,this.edit.form=e[0]):this.$message.warning("请选择一条数据进行修改")},reload(){this.list({typeId:this.selectTypeId})},list(e){Object(i["c"])(e).then(e=>{this.dictTableData=e.data})},close(){this.add.visible=!1,this.edit.visible=!1},del(){let e=this.$refs["mutipleTable"].selection;e.length>0?this.$confirm("确定有删除吗？","删除提示").then(()=>{let t=e.map(e=>e.id),a=t.join(",");Object(i["b"])(a).then(e=>{this.$message.success(e.msg),this.reload()}).catch(()=>{})}):this.$message.warning("请选择要删除的数据")},handleType(e,t){this.active=e,this.selectTypeId=t,this.list({typeId:t})}}},k=T,w=(a("9f66"),Object(u["a"])(k,l,s,!1,null,"390e6609",null));t["default"]=w.exports}}]);
//# sourceMappingURL=chunk-59922396.11606b41.js.map