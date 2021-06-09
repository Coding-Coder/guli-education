# 谷粒学院项目简介
基于Vue.js+SpringBoot搭建的一个前后端分离的在线教育平台项目

本项目是根据 [b站视频教程](https://www.bilibili.com/video/BV1y7411y7am) 完成的一个分布式项目

## 项目涉及的技术栈

### 前端
- Vue.js
- [Nuxt.js](https://nuxtjs.org/) (服务端渲染技术，基于Vue.js的轻量级应用框架)
- vue-admin-template-master
- Element-UI:[Element-UI官方文档](https://element.eleme.cn/#/zh-CN/component/layout)
- webpack
- node.js
- 使用Es6的开发规范

### 后端
- SpringBoot(2.2.1.RELEASE)
- SpringCloud(Hoxton.RELEASE)
- SpringCloudAlibaba(0.2.2.RELEASE)
- Mybatis-Plus
- EasyExcel
- Feign(服务调用)
- Gateway(服务网关)
- Hystrix(熔断器)
- Spring-Cloud-Alibaba-Nacos(服务发现+配置中心+消息总线)

### 数据库
- MySQL

### 其他
- Nginx
- 阿里云对象存储OSS:[阿里云对象存储OSS-Java SDK文档](https://help.aliyun.com/document_detail/32008.htm?spm=a2c4g.11186623.2.6.4d4df2eeAielrM#concept-32008-zh)
- 阿里云视频点播VOD:[阿里云视频点播VOD-Java SDK文档](https://help.aliyun.com/document_detail/57756.htm?spm=a2c4g.11186623.2.44.54d779ddQ3RkV9#multiTask1210)

## 模块信息
|模块名称|模块描述|端口号|
|---|---|---|
|Nginx||9001|
|Nacos||8848|
|service-edu|讲师课程管理|8001|
|service-oss|阿里云对象存储OSS|8002|
|service-vod|阿里云点播视频VOD|8003|
|service-cms|首页banner显示|8004|

## Nginx安装(window版)
[下载](http://nginx.org/en/download.html) 解压即可使用

### Nginx相关命令(window版)
```shell script
# 启动Nginx
nginx.exe
# 停止Nginx
nginx.exe -s stop
# 重新加载
nginx.exe -s reload
```

## Nacos Server安装
1. [下载nacos-server-2.0.1(开发此项目时最新版)](https://github.com/alibaba/nacos/releases/tag/2.0.1)
2. 解压进入bin目录,修改startup.cmd文件中的`set MODE="standalone"`(新版本中默认为集群模式了)
3. cmd执行`startup.cmd`启动(也可以不进行第二步操纵，改用`startup.cmd -m standalone`命令)
4. 访问`http://localhost:8848/nacos`, 默认用户名密码都是"nacos"

## 其他链接
[阿里图标库iconfont](https://www.iconfont.cn/?spm=a313x.7781069.1998910419.d4d0a486a)

## 个人学习进度
start at 2021-05-31
- day01:P1-P23
- day02:P24-P56
- day03:P57-P78
- day04:P79-P99
- day05:P100-P114
- day06:P115-P144(注意观影顺序P144与P143顺序反了)
- day07:P143-P168(注意观影顺序P148与P147顺序反了)
- day08:P169-P