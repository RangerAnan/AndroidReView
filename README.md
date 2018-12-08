# AndroidReView

### 一、项目组件化
    1.创建一个config.gradle，配置参数myViewIsModule，是否为module，每次改变后需要重新sync

    2.创建module名为review_my_view，根据myViewIsModule的值，配置为application与library；配置清单文件与application

    3.在app中使用路由跳转review_my_view中的activity

##### 注意
    1.资源名冲突。module中的类、图片、xml都不能与app中的一致。

    2.module作为app时，需要独立依赖，共性的库统一到基础库中，application中注意必要的初始化。