## 开箱即用的大学生职业预测系统


<p align="center">
   <a target="_blank" href="https://github.com/yx159247/MP_take_out">
      <img src="https://img.shields.io/hexpm/l/plug.svg"/>
      <img src="https://img.shields.io/badge/JDK-1.8+-green.svg"/>
      <img src="https://img.shields.io/badge/springboot-2.7.1-green"/>
      <img src="https://img.shields.io/badge/vue-2.6.11-green"/>
      <img src="https://img.shields.io/badge/mysql-8.0.29-green"/>
      <img src="https://img.shields.io/badge/mybatis--plus-3.5.2-green"/>
      <img src="https://img.shields.io/badge/redis-6.x-green"/>
      <img src="https://img.shields.io/badge/minio-8.3.7-green"/>
      <img src="https://img.shields.io/badge/quarz-2.3.2-green"/>
      <img src="https://img.shields.io/badge/shiro-1.9.0-green"/>
      <img src="https://img.shields.io/badge/easypoi-4.1.0-green"/>
      <img src="https://img.shields.io/badge/knife4j-2.0.9-green"/>
   </a>
</p>



![256755778-f548d009-cc1f-493c-8c5d-078b521c3536](https://github.com/xu-zi-kang/job/assets/108520582/c8740331-8f5c-43ab-967e-26d0cc157aff)



</div>

## 演示网站
前台网站：[http://localhost:8080](http://localhost:8080/)

后端接口：[http://211.149.215.153:8001/admin/index.html](http://localhost:8888/job/doc.html)http://localhost:8888/job/doc.html

管理员账户：admin  密码：123
企业账户：xiaomi 密码：123
学生账户：张三 密码： 123

## 技术栈

后端技术栈：mysql + springboot2.3.7.RELEASE + jwt + redis  等

前端技术栈：vue + js + css 等

网站：bootstrap 响应式

### 环境

node版本8以上

MySQL 8.0及以上数据库

Redis

## 使用


修改job-admin/src/main/resources/application.yml下自己的数据库用户名和密码

修改job-admin/src/main/resources/application.yml下Redis的相关配置信息



创建数据库job

在job数据库下导入项目根目录下job.sql文件

启动job-admin/src/main/java/top/ludonghuang/JobAdminApplication.java文件中的JobAdminApplication.java，开启后台服务


运行项目

![256757998-4222647f-f5d5-49ca-b128-0646c56a55bd](https://github.com/xu-zi-kang/job/assets/108520582/92c84400-aecd-4a31-b0d3-dd2d6b8124c6)


在终端打开job-web，并输入

```bash
npm install
npm run serve
```


浏览器打开 [http://localhost:8080](http://localhost:8080/)

登录账号：admin，密码： 123

## 界面截图

**后台**

**学生端**

![256759549-19066b89-8cd0-441f-a217-b43ffc32b790](https://github.com/xu-zi-kang/job/assets/108520582/fda87e16-a7bd-491a-b645-783e23691a2c)

![256759992-efff9de9-147c-4fa7-b89a-8fa83b7119db](https://github.com/xu-zi-kang/job/assets/108520582/724d8933-75a4-44ad-9842-1df2c67175b5)

![256760037-c12e0775-cf56-4192-9e87-06272698792c](https://github.com/xu-zi-kang/job/assets/108520582/6559c034-0515-4a7f-ba4c-80dde8c0e39b)

![256760087-f7336288-c573-4e20-a85d-ecd89c975dad](https://github.com/xu-zi-kang/job/assets/108520582/3ed2a83e-968c-4e1a-9742-5903bdc110b5)

![256760132-e399d7d2-3c74-45e9-b81f-dc3bffaa0416](https://github.com/xu-zi-kang/job/assets/108520582/3dd8c538-9b77-446e-85a7-86b8f4a51cb1)

![256760184-22fa28f4-7071-4e91-a898-543a582efa01](https://github.com/xu-zi-kang/job/assets/108520582/72298210-6b62-45cd-9860-d6810fed277e)

![256760234-6a11bb2c-9f26-4b08-93d6-be2e5236e420](https://github.com/xu-zi-kang/job/assets/108520582/21a1e16a-7e8d-4500-9fdd-eb71d2128b6d)

![256760283-80f3350c-54e0-4096-97ee-36e624443b27](https://github.com/xu-zi-kang/job/assets/108520582/728b7ad5-1a93-4096-bc71-1bdc59e2fded)

![256760324-ba17afe7-0528-4697-ae39-f27ffc2602f1](https://github.com/xu-zi-kang/job/assets/108520582/94fddbe0-0a9f-47fa-9c83-ac1e58d5d71b)

![256760420-d4b1805b-41f2-45e1-81a9-d38222d8da22](https://github.com/xu-zi-kang/job/assets/108520582/b1a1030f-846a-48c1-ad9d-3d029274b487)

![256760475-2c5c9f92-75f3-4413-b566-bb514a5f8539](https://github.com/xu-zi-kang/job/assets/108520582/24891051-44cf-4212-bb03-b112c0a1ba08)

![256760519-4cfc0c29-23a5-43df-807c-781cfb17ad7b](https://github.com/xu-zi-kang/job/assets/108520582/529005e3-d2d4-424b-a12b-7bf45e6d68dd)



**管理员端**

![256764155-f825bdbd-d4c0-4ea9-9242-cc1721872258](https://github.com/xu-zi-kang/job/assets/108520582/6a26068f-1019-4112-8575-0b14c6e7defe)

![256764211-0d2959d9-3894-4fca-b9ec-c32ec2732eec](https://github.com/xu-zi-kang/job/assets/108520582/bfdd767b-39bf-49eb-9c3c-4e89b72a247a)

![256764261-a4f1ba59-2fac-4143-9efb-9ec85b9b95f7](https://github.com/xu-zi-kang/job/assets/108520582/1e00b6cc-72cd-4c41-95fd-589abf0a5324)

![256764647-94880a1f-8c51-4725-90bb-3e201bdbd21b](https://github.com/xu-zi-kang/job/assets/108520582/e3e57abf-ec5d-4014-881a-398191c8530f)

![256764699-28fe78e1-c446-4874-b88c-c072f86301b4](https://github.com/xu-zi-kang/job/assets/108520582/cf47cd5e-68c5-4156-aa85-0b1db7062d0c)

![256764736-a848e4ea-d309-4138-bfdc-6b74c1e4382c](https://github.com/xu-zi-kang/job/assets/108520582/2b372ca0-fc1f-47c9-acc3-731406685022)

![256764779-8478b19a-3cb0-4774-bd3d-a72b9cc2ad0b](https://github.com/xu-zi-kang/job/assets/108520582/edbac862-0c14-4905-bdb0-006879b05750)


**企业端**

![256764945-e261993e-fc9a-43ef-8418-323b5eee1275](https://github.com/xu-zi-kang/job/assets/108520582/638913c9-2727-46d8-a19f-9f9fd2ee6bac)


**首页**

![256765080-d820a89d-3dd2-4c9c-afb5-e78943b64765](https://github.com/xu-zi-kang/job/assets/108520582/4a59cfd8-d05d-47f8-9695-237b6066a56a)

![256765118-fd512b5d-fba3-4b8a-a82c-f53eb770defb](https://github.com/xu-zi-kang/job/assets/108520582/5c096b43-5933-419f-b5e7-228fba256cc5)

![256765185-239f8f34-c2c4-4080-ac18-359dbda975b9](https://github.com/xu-zi-kang/job/assets/108520582/3a9e8fb9-98fb-4fde-b3eb-4ea4e1c32a32)



## 网站功能

# 用户管理功能需求分析
![image](https://github.com/xu-zi-kang/job/assets/108520582/32d5b6a1-5572-4e9a-9387-59d6fdd9045b)


# 学生员功能需求分析
![image](https://github.com/xu-zi-kang/job/assets/108520582/81fdc30c-e654-41e2-ba6c-80577f5698fe)


# 企业单位功能需求分析
![image](https://github.com/xu-zi-kang/job/assets/108520582/c554926c-1a17-4bea-8bfa-d8cf4780fd29)






## 感谢支持

如果对您有帮助，您可以点右上角 "Star" 支持一下 谢谢！ ^_^






































