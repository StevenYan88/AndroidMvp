### 手写一个Mvp架构

![mvp.png](https://upload-images.jianshu.io/upload_images/1472453-1bc275d03ff98305.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

**MVP架构说明**

- Model，模型层，即数据模型，用于获取和存储数据。
- View，视图层，即Activity/Fragment
- Presenter，控制层，负责业务逻辑

View层 接收到用户操作事件，通知到Presenter，Presenter进行逻辑处理，然后通知Model更新数据，Model 把更新的数据给到Presenter，Presenter再通知到 View 更新界面。

**主要用的知识点**：  

1. 泛型构建基类BaseView、BaseModel， 抽离，充分的解耦；
2. 利用JDK提供动态代理创建View，因为V层都是接口；
3. 动态创建Model；
4. 解决View一对多Presenter，利用依赖注入的方式，手写一个运行时依赖注入框架；




