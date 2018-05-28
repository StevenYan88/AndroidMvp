# Mvp架构


![image](https://upload-images.jianshu.io/upload_images/1472453-d0a56fc0d9c67413.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/416)

**大家在开始设计mvp时，或者看别人的项目用了mvp，先脑子里面记住这张架构图。**

**主要用的技术**：

1. 泛型构建基类BaseView、BaseModel， 抽离，充分的解耦
2. 利用JDK提供的源码动态代理创建View，因为V层都是接口
3. 动态创建Model
4. 解决View一对多Presenter，利用依赖注入的方式
