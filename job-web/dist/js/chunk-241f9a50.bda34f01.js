(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-241f9a50"],{"49e5":function(t,e,a){"use strict";a.d(e,"d",(function(){return n})),a.d(e,"a",(function(){return o})),a.d(e,"b",(function(){return s})),a.d(e,"c",(function(){return i}));var r=a("b775");function n(t){return Object(r["a"])({url:"student/update",method:"post",data:t})}function o(t){return Object(r["a"])({url:"student/delete",method:"post",params:{ids:t}})}function s(t){return Object(r["a"])({url:"student/query",method:"post",data:t})}function i(t){return Object(r["a"])({url:"student/info",method:"post",data:t})}},b705:function(t,e,a){"use strict";a.d(e,"d",(function(){return n})),a.d(e,"a",(function(){return o})),a.d(e,"e",(function(){return s})),a.d(e,"b",(function(){return i})),a.d(e,"c",(function(){return c}));var r=a("b775");function n(t){return Object(r["a"])({url:"type/query",method:"post",data:t})}function o(t){return Object(r["a"])({url:"dict/create",method:"post",data:t})}function s(t){return Object(r["a"])({url:"dict/update",method:"post",data:t})}function i(t){return Object(r["a"])({url:"dict/delete",method:"post",params:{ids:t}})}function c(t){return Object(r["a"])({url:"dict/query",method:"post",data:t})}},ba55:function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t._self._c;return e("div",[e("r-form",{ref:"myForm",attrs:{rules:t.rules,form:t.form,items:t.items,save:t.save}}),e("chart")],1)},n=[],o=(a("14d9"),a("714a")),s=a("49e5"),i=a("b705"),c=function(){var t=this;t._self._c;return t._m(0)},l=[function(){var t=this,e=t._self._c;return e("div",{staticClass:"echarts-bar"},[e("div",{staticStyle:{width:"600px",height:"400px"},attrs:{id:"main"}})])}],u={name:"echarts-bar",data(){return{}},mounted(){this.drawChart()},updated(){},computed:{},methods:{drawChart(){let t=this.$echarts.init(document.getElementById("main")),e={title:{text:"当前掌握技能图",subtext:"张三",left:"center"},tooltip:{trigger:"item"},legend:{orient:"vertical",left:"left"},series:[{name:"掌握情况",type:"pie",radius:"50%",data:[{value:1048,name:"后端知识"},{value:735,name:"前端知识"},{value:580,name:"代码编写"},{value:484,name:"职业培训"},{value:300,name:"影视剪辑"}],emphasis:{itemStyle:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]};t.setOption(e)}}},d=u,p=a("2877"),h=Object(p["a"])(d,c,l,!1,null,null,null),m=h.exports,f={name:"StudentInfo",components:{RForm:o["a"],chart:m},data(){return{form:{id:"",name:"",birthday:"",college:"",education:"",phone:"",sex:"",photo:"",graduateDate:""},rules:{name:[{required:!0,message:"必填项不能为空"}]},items:[{type:"text",label:"姓名",prop:"name",name:"name",placeholder:"请输入名称"},{type:"date",label:"出生日期",prop:"birthday",name:"birthday",placeholder:"出生日期"},{type:"text",label:"毕业院校",prop:"college",name:"college",placeholder:"毕业院校"},{type:"select",label:"学历",prop:"education",name:"education",placeholder:"学历",options:[]},{type:"text",label:"电话",prop:"phone",name:"phone",placeholder:"电话"},{type:"select",label:"性别",prop:"sex",name:"sex",placeholder:"性别",options:[]},{type:"file",label:"照片",prop:"photo",name:"photo",placeholder:"照片"},{type:"date",label:"毕业时间",prop:"graduateDate",name:"graduateDate",placeholder:"毕业时间"}]}},mounted(){this.getDictList1(2),this.getDictList2(1),this.getInfo()},methods:{getDictList1(t){Object(i["c"])({typeId:t}).then(t=>{let e=[];t.data.forEach(t=>{let a={value:t.dictKey,label:t.dictVal};e.push(a)}),this.items.forEach(t=>{"select"==t.type&&"education"==t.name&&(t.options=e)})})},getDictList2(t){Object(i["c"])({typeId:t}).then(t=>{let e=[];t.data.forEach(t=>{let a={value:t.dictKey,label:t.dictVal};e.push(a)}),this.items.forEach(t=>{"select"==t.type&&"sex"==t.name&&(t.options=e)})})},getInfo(){Object(s["c"])().then(t=>{this.form=t.data})},save(){let t=this.$refs["myForm"].validateForm();t&&Object(s["d"])(this.form).then(t=>{this.$message.success(t.msg),this.param.close(),this.param.callback()})}}},b=f,y=Object(p["a"])(b,r,n,!1,null,"941c7130",null);e["default"]=y.exports}}]);
//# sourceMappingURL=chunk-241f9a50.bda34f01.js.map