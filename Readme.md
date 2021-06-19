# 谷粒学院

## 项目简介
基于Vue.js+SpringBoot搭建的一个前后端分离的在线教育平台项目，分为前台系统和后台系统， B2C模式。

本项目是根据 [b站视频教程](https://www.bilibili.com/video/BV1y7411y7am) 完成的一个分布式项目

- [谷粒商城前端代码](https://github.com/Coding-Coder/guli-education-web)
- [谷粒商城后端代码](https://github.com/Coding-Coder/guli-education)

## 系统模块
<table>
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314174755805.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/>
      	</td>
    </tr>        
</table>

## 系统架构  
<table>
   <tr>
       <td><img src="https://img-blog.csdnimg.cn/20200314174813599.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
   </tr>        
</table>

## 项目涉及的技术栈

### 前端
- [Vue.js](https://cn.vuejs.org/)
- [Nuxt.js](https://nuxtjs.org/) (服务端渲染技术，基于Vue.js的轻量级应用框架)
- [vue-admin-template-master](https://github.com/aoaoms/vue-admin-template-master)
- [Element-UI](https://element.eleme.cn/#/zh-CN/component/layout)
- [webpack](https://webpack.docschina.org/)
- [node.js](https://nodejs.org/zh-cn/)
- [ECharts](https://echarts.apache.org/)
- 使用Es6的开发规范

### 后端
- [Mybatis-Plus](https://mp.baomidou.com/)
- [SpringBoot(2.2.1.RELEASE)](https://spring.io/projects/spring-boot/)
- [Spring Security](https://spring.io/projects/spring-cloud-security)
- [SpringCloud(Hoxton.RELEASE)](https://www.springcloud.cc/spring-reference.html)
- [SpringCloudAlibaba(0.2.2.RELEASE)](https://spring.io/projects/spring-cloud-alibaba)
- [Spring-Cloud-Alibaba-Nacos(服务发现+配置中心+消息总线)](https://nacos.io/zh-cn/index.html)
- [OpenFeign(服务调用)](https://spring.io/projects/spring-cloud-openfeign)
- [Hystrix(熔断器)](https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/1.3.5.RELEASE/single/spring-cloud-netflix.html#_circuit_breaker_hystrix_clients)
- [Spring-Cloud-Gateway(服务网关)](https://spring.io/projects/spring-cloud-gateway)
- [EasyExcel](https://www.yuque.com/easyexcel/doc/easyexcel)
- [OAuth2](https://oauth.net/2/)

### 数据库
- [MySQL](https://www.mysql.com/)
- [Redis](https://redis.io/)

### 其他
- [Nginx](http://nginx.org/)
- [Canal数据同步工具:把远程库的表内容同步到本地库中](https://github.com/alibaba/canal)
- [微信登录](https://open.weixin.qq.com/)
- [阿里云对象存储OSS](https://help.aliyun.com/document_detail/32008.htm?spm=a2c4g.11186623.2.6.4d4df2eeAielrM#concept-32008-zh)
- [阿里云视频点播VOD](https://help.aliyun.com/document_detail/57756.htm?spm=a2c4g.11186623.2.44.54d779ddQ3RkV9#multiTask1210)
- [阿里云短信服务SMS](https://help.aliyun.com/document_detail/102715.html?spm=5176.8195934.J_5834642020.6.61de4378h4ADZX)
- [阿里图标库iconfont](https://www.iconfont.cn/?spm=a313x.7781069.1998910419.d4d0a486a)

## 模块信息
|模块名称|模块描述|端口号|
|---|---|---|
|service-edu|主要服务api接口(主要是讲师和课程管理)|8001|
|service-oss|阿里云对象存储OSS|8002|
|service-vod|阿里云点播视频VOD|8003|
|service-cms|首页幻灯片banner显示|8004|
|service-msm|阿里云短信服务SMS|8005|
|service-ucenter|用户中心(用户登陆、注册、修改)|8006|
|service-order|订单支付|8007|
|service-statistics|统计分析|8008|
|service-acl|权限管理(教学，测试项目时不用启动)(鉴权，与common中spring_security模块连接)|8009|
|canal-client|canal数据同步工具(教学，测试项目时不用启动)|10000|
|api-gateway|服务网关(教学，测试项目时不用启动)|8222|

## 第三方中间件信息
|中间件|端口号|
|---|---|
|Nginx|9001|
|Nacos|8848|
|MySQL|3306|
|Redis|6379|

## 项目启动
1. 准备工作：启动MySQL(运行docs/sql内sql文件)、Redis、Nginx(配置docs/config/nginx.conf文件)、Nacos
2. 测试前台模块：启动模块guli-vue-front(端口3000)、service-edu、service-oss、service-vod、
service-cms、service-msm、service-ucenter、service-order
3. 测试后台管理模块：guli-vue-admin(端口9528)、service-edu、service-statistics

## 效果图
<table>
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314181540634.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
        <td><img src="https://img-blog.csdnimg.cn/20200314181406128.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
    </tr>  
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314181436204.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
        <td><img src="https://img-blog.csdnimg.cn/20200314181500673.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
    </tr>  
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314191228208.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
        <td><img src="https://img-blog.csdnimg.cn/20200314192146196.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
    </tr>  
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314191245350.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
        <td><img src="https://img-blog.csdnimg.cn/20200314192417849.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
    </tr>  
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314181540634.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
        <td><img src="https://img-blog.csdnimg.cn/20200314191305200.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
    </tr>  
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314191325241.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
        <td><img src="https://img-blog.csdnimg.cn/20200314191400367.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
    </tr>  
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314191416449.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
        <td><img src="https://img-blog.csdnimg.cn/20200314191434263.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
    </tr>  
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314191533613.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
        <td><img src="https://img-blog.csdnimg.cn/20200314191653808.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
    </tr>  
    <tr>
        <td><img src="https://img-blog.csdnimg.cn/20200314191708416.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
        <td><img src="https://img-blog.csdnimg.cn/20200314191611311.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JhaWR1XzMzMjY3MDc5,size_16,color_FFFFFF,t_70"/></td>
    </tr> 
</table>

## 部分中间件安装教程
### Nginx安装(window版)
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

### Nacos Server安装(window版)
1. [下载nacos-server-2.0.1(开发此项目时最新版)](https://github.com/alibaba/nacos/releases/tag/2.0.1)
2. 解压进入bin目录,修改startup.cmd文件中的`set MODE="standalone"`(新版本中默认为集群模式了)
3. cmd执行`startup.cmd`启动(也可以不进行第二步操纵，改用`startup.cmd -m standalone`命令)
4. 访问`http://localhost:8848/nacos`, 默认用户名密码都是"nacos"

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

### Spring Security权限框架介绍
1. Spring Security 主要包含两个部分：用户认证(Authentication) 和 用户授权(Authorization)
    - 用户认证(Authentication)
        - 进入用户登录时候，输入用户名和密码，查询数据库，输入用户名和密码是否正确，如果正确的话，则认证成功
    - 用户授权(Authorization)
        - 登录了系统，登录用户可能是不同的角色，不同的角色有不同的操作功能
2. Spring Security 本质上就是过滤器Filter，对请求进行过滤

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
- day10:P202-P221
- day11:P222-P239
- day12:P240-P272
- day13:P273-295
- day14:P296-P307
end at 2021-06-19 完结撒花