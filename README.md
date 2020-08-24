# BLAPI
## 功能 & 事项
**BLAPI** 是对哔哩哔哩客户端自带接口的**Java**实现，搭建初衷是为有相关需求**（例如搭建bilibili第三方客户端、数据统计等）**的用户们提供便利。
为了更好地激励二次创作，本库采用**GPL 3.0**的条款完全开源。

### 方法
本接口提供的方法有**B站本身提供的原始方法**

**示例**
```java
Video video = new Video(2);//创建Video对象av2
System.out.println(video.getDescription());//输出av2的简介

/* console:
 * www    */
```

本接口提供的方法也有**库中提供的原创方法**

**示例**
```java
Video video = new Video("BV17x411w7KC");//创建Video对象BV17x411w7KC
System.out.println(video.getParsedDuration());//输出BV17x411w7KC所有分P时长的字符串形式

/* console:
 * 40:12  */
```

### 鸣谢
所有接口列表皆参考自[社会易姐QwQ](https://space.bilibili.com/293793435/ "社会易姐QwQ的bilibili个人空间")搭建的文档[哔哩哔哩-API收集整理](https://github.com/SocialSisterYi/bilibili-API-collect "项目地址")。
该库依赖于由Google开发的[gson](https://github.com/google/gson "在GitHub上的gson")库，主要应用于构造类时的json解析。

在此对为此项目铺设了垫脚石的所有项目作者致以诚挚的感谢。

## 原理 & 问答
在使用**BLAPI**的时候，可能会出现若干的疑问，此栏便是为此准备。

### 刷新的实质
每个对象背后都有若干个底层对象，刷新便是对底层对象的重写，该进程需要请求多个接口。每个类对应的接口是相同的，若同时构造或刷新同一类型的对象也会导致接口屏蔽（412）。

### 如何联系
**QQ：**318278289
**Q群：**878414752

### 架构
```seq
Note left of 用户:正常情况下的新建与刷新
用户->库: 请求新建对象或刷新对象
库->GSON: 初始化GSON
库->请求器: 请求接口信息
请求器->接口: 提交请求
接口-->请求器: 返回信息
请求器-->库: 返回初步处理后的信息
库->GSON: 将信息送至GSON处理
GSON-->库: 返回构造完成的底层对象
库-->用户: 对象新建成功
Note left of 用户:正常情况下的获取信息
用户->库: 请求类的详细信息
库-->用户: 从底层对象中获取并返回
Note left of 用户:412情况下的新建与刷新
用户->库: 请求新建对象或刷新对象
库->GSON: 初始化GSON
库->请求器: 请求接口信息
请求器->接口: 提交请求
接口-->请求器: 返回错误信息
请求器-->库: 返回RequestBlockedException
库-->用户: 返回RequestBlockedException
```
