# mm_ComicWeb
关于漫画网站
## 一、环境准备
```
使用到的框架：SpringMVC+Mybatis
使用到的图片服务器（自搭内网）：www.mmdephotos.com 该服务器用来存储图片
```

## 二、概念设计
![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/E-R图.png)
## 三、数据库设计
### 书籍表
书籍表存储的是一本书的具体信息

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/book表.png)

### 分类表
分类表存储的整个网站拥有的分类

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/分类表.png)


### 章节表
章节存储的书籍包含的所有章节信息

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/章节表.png)

### 用户表
用户表存储的是每一个用户的信息

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/user表.png)

### 收藏表
收藏表存储的是用户收藏了哪些书籍

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/收藏表.png)



### 订单表
订单表存储的是每张订单的创建人，创建时间，总价等

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/订单表.png)

### 订单详情表
订单详情表存储的是每张订单的详细信息

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/订单详情表.png)

### 购物车表
购物车表存储的是每条加入购物车的信息

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/购物车表.png)



### 管理员表
管理员表存储的是管理员的信息

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/管理员表.png)

## 三、功能设计
该系统分为前台和后台
### 1、前台功能分析
#### （1）登录注册功能
若已有该系统账号，可直接通过该账号登录；若没有，游客可以通过注册功能注册账号，之后通过该账号登录系统。
#### （2）漫画书展示功能
登录用户和非登录用户都可直接访问网站浏览漫画信息，包括书名，封面图，分类，简介，章节内容。
#### （3）电子漫画在线阅读功能
登录用户和非登录用户可以直接通过网站阅读漫画。
#### （4）纸质漫画购买功能
纸质漫画需要有加入购物车，形成订单，并购买功能
#### （5）个人中心
登录用户有个人中心功能，在个人中心页面，可以查看个人信息，修改个人信息，修改密码，查看我的收藏，并可以取消收藏；查看我的订单，并取消我的订单的功能。
#### （6）收藏功能
登录用户有收藏书籍的功能，点击我的收藏，就可以收藏该书籍。
### 2、后台功能分析
（1）书籍的新增功能，上架功能，下架功能，搜索功能
（2）分类的新增功能，删除功能
（3）用户的新增功能，删除功能，搜索功能

## 四、效果

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/详情.png)

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/章节.png)

![image](https://github.com/liuxiaofeii/mm_ComicWeb/raw/master/picture/后台.png)


