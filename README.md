## 项目incubation

### 项目简介

```java
项目使用：springboot 2.1.7
数据库：mysql
数据库连接池：hikari
使用spring-data-jpa操作数据库api

自定义过滤器：cc.saxfore.incubation.filter.IncubationFilter

自定义拦截器：cc.saxfore.incubation.interceptor.InterceptorConfiguration/LoginInterceptor/ApiInterceptor

自定义监听器：cc.saxfore.incubation.listener.IBContextListener/IBSessionListener/IBRequestListener

自定义异常：cc.saxfore.incubation.exception.IBException/IBExceptionEnum
实现全局异常捕获：cc.saxfore.incubation.exception.IBGlobalExceptionHandler

自定义注解：cc.saxfore.incubation.annotation.IBApiURL

自定义切面：cc.saxfore.incubation.aspect.ControllerClassesAspect

自定义servlet：cc.saxfore.incubation.servlet.IBUserServlet

spring-data-jpa: cc.saxfore.incubation.repository.IBUserRepository
如果spring-data-jpa不能满足复杂查询条件，可以定义原生sql查询：
cc.saxfore.incubation.repository.IBUserRepository.IBUserNativeRepository
```

### 配置文件

```java
修改resource下的数据库链接，将 127.0.0.1:3306/incubation 修改为自己的数据库地址

spring.datasource.url=jdbc:mysql://127.0.0.1:3306/incubation?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=Asia/Shanghai
```

### 创建数据表

```mysql
/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : incubation

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 11/08/2019 17:48:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for IB_User
-- ----------------------------
DROP TABLE IF EXISTS `IB_User`;
CREATE TABLE `IB_User` (
  `id` varchar(36) PRIMARY KEY  NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `del_flag` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
```

### 启动项目

```java
在浏览器中依次访问以下地址查看效果：

http://127.0.0.1:9090/incubation/
http://127.0.0.1:9090/incubation/index

// 访问/view下的接口要么提供username&password，要么提供accessToken=incubation
http://127.0.0.1:9090/incubation/view/user/home?username=admin&password=admin
http://127.0.0.1:9090/incubation/view/user/home?username=admin&password=
http://127.0.0.1:9090/incubation/view/user/home?username=admin&password=&accessToken=incubation

// 访问/api接口必须携带accessToken=incubation参数
http://127.0.0.1:9090/incubation/api/user/1
http://127.0.0.1:9090/incubation/api/user/1?accessToken=incubation
http://127.0.0.1:9090/incubation/api/user/list?accessToken=incubation

// servlet
http://127.0.0.1:9090/incubation/servlet/user?username=admin&password=admin

// swagger
http://127.0.0.1:9090/incubation/swagger-ui.html#/
```

### 数据库报错

```java
请确定自己使用的数据库版本，根据版本高低自行决定使用何种数据库方言

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

