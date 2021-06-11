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
- OAuth2

### 数据库
- MySQL
- Redis

### 其他
- Nginx
- 微信登录:[微信·开放平台](https://open.weixin.qq.com/)
- 阿里云对象存储OSS:[阿里云对象存储OSS-Java SDK文档](https://help.aliyun.com/document_detail/32008.htm?spm=a2c4g.11186623.2.6.4d4df2eeAielrM#concept-32008-zh)
- 阿里云视频点播VOD:[阿里云视频点播VOD-Java SDK文档](https://help.aliyun.com/document_detail/57756.htm?spm=a2c4g.11186623.2.44.54d779ddQ3RkV9#multiTask1210)
- 阿里云短信服务SMS:[阿里云短信服务SMS-Java SDK文档](https://help.aliyun.com/document_detail/102715.html?spm=5176.8195934.J_5834642020.6.61de4378h4ADZX)

## 模块信息
|模块名称|模块描述|端口号|
|---|---|---|
|service-edu|讲师课程管理|8001|
|service-oss|阿里云对象存储OSS|8002|
|service-vod|阿里云点播视频VOD|8003|
|service-cms|首页banner显示|8004|
|service-msm|阿里云短信服务SMS|8005|
|service-ucenter|用户中心|8006|

## 第三方中间件信息
|中间件|端口号|
|---|---|
|Nginx|9001|
|Nacos|8848|
|MySQL|3306|
|Redis|6379|

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

## Nacos Server安装(window版)
1. [下载nacos-server-2.0.1(开发此项目时最新版)](https://github.com/alibaba/nacos/releases/tag/2.0.1)
2. 解压进入bin目录,修改startup.cmd文件中的`set MODE="standalone"`(新版本中默认为集群模式了)
3. cmd执行`startup.cmd`启动(也可以不进行第二步操纵，改用`startup.cmd -m standalone`命令)
4. 访问`http://localhost:8848/nacos`, 默认用户名密码都是"nacos"

## 其他链接
[阿里图标库iconfont](https://www.iconfont.cn/?spm=a313x.7781069.1998910419.d4d0a486a)

## 单点登录三种常见方式

### 1.session广播机制实现
基于session复制

### 2.使用cookie+redis实现：
- 1.在项目的任意模块进行登录，登录之后，把数据存到2个地方
    - 1.redis中(key：生成唯一随机值(ip、用户id等等)；value:用户数据)
    - 2.cookie(把redis中生成的key放到cookie中)
- 2.访问项目中的其他模块，请求时携带cookie
    - 服务端获取到cookie值，到redis中根据key进行查询，如果查询到数据就直接登录

### 3.使用token(令牌)实现
- 1.在项目的任意模块进行登录，登录之后，按照规则生成token值，并返回(可以通过cookie或者地址栏返回)
- 2.再去访问项目其他模块，每次访问都在地址栏带着token
- 3.服务端获取到token值，可以对token进行解析，如果可以取到用户信息就直接登录
        
注：token是什么？按照一定的规则生成字符串，字符串可以包含用户信息(自包含令牌)，然后对这个字符串进行编码和加密。

一般采用通用的规则，如官方规则JWT，JWT就是官方给我们规定好了规则

#### JWT的组成
由三部分组成：
- JWT头信息(header)
- 有效载荷(playload,可以包含用户信息)
- 签名哈希(signature,防伪)

`signature=HMACSHA256(baser64UrlEncode(header)+"."+baser64UrlEncode(payload),'加盐secret')`
`JWT=baser64UrlEncode(header)+"."+baser64UrlEncode(payload)+"."+signature`

## 个人学习进度
start at 2021-05-31
- day01:P1-P23
- day02:P24-P56
- day03:P57-P78
- day04:P79-P99
- day05:P100-P114
- day06:P115-P144(注意观影顺序P144与P143顺序反了)
- day07:P143-P168(注意观影顺序P148与P147顺序反了)
- day08:P169-P185
- day09:P186-P201
- day10:P202-P