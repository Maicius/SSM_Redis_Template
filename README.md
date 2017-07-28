# spring_mvc_mybatis_maven模板

>基于maven的Java web项目框架模板，  
>使用spring + spring_mvc + mybatis + spring-data-redis 等框架   
>各种配置文件都已写好  
>并实现了一个简单的登陆注册功能  
>可用于在IDEA上快速构建web项目或入门学习

>更多 spring_mvc教程demo:  
>https://github.com/Maicius/Spring_course

# Build and Run
> - 本项目使用maven作为管理工具
> - 默认数据库为redis,并使用spring-data-redis对redis进行了封装
> - 如需使用mysql和mybatis
> - 请回退到 2017-7-21日前版本
# 一些可能到错误（针对mac）：

### 1.pom.xml里某些包出现无法找到对应版本
>解决方法：update maven
### 2.maven成功引入所有的包，但报 class not found之类但错误 
>原因：包损坏（可能是下载过程中突然断网引起的）
>解决方法：进入 .m2 目录删除repository，重新下载所有的包
### 3.maven更新和下载速度过慢
>解决方法：将中心仓库的镜像替换为阿里云镜像,在用户目录下打开 .m2 目录下setting.xml，
将<mirror></mirror>替换为下面内容：

    <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>
    </mirror>
