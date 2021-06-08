### 阿里云vod-upload.jar 安装到本地maven仓库
- 1.手动下载jar包
- 2.执行maven命令
```shell script
mvn install:install-file -DgroupId=com.aliyun -DartifactId=aliyun-sdk-vod-upload -Dversion=1.4.11 -Dpackaging=jar -Dfile=aliyun-java-vod-upload-1.4.11.jar
```
- 3.注意事项：一定要用cmd而不是powershell，powershell会失败。
- 4.[powershell执行mvn install:install-file失败原因](https://blog.csdn.net/without_mercy/article/details/81474648)
- 5.[参考链接](https://blog.csdn.net/Airuiliya520/article/details/109017091)
