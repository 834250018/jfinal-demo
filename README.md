## JFinal-demo
[官方文档](https://www.jfinal.com/doc/ 'jfinal-doc')

JFinal 是基于Java 语言的极速 web 开发框架，其核心设计目标是开发迅速、代码量少、学习简单、功能强大、轻量级、易扩展、Restful。在拥有Java语言所有优势的同时再拥有ruby、python等动态语言的开发效率。(百度百科)

此demo是根据官方文档整理出来,仅供参考

### 起步

1. 引入jfinal跟undertow依赖
    ```
        <!-- jfinal-undertow -->
        <dependency>
            <groupId>com.jfinal</groupId>
            <artifactId>jfinal-undertow</artifactId>
            <version>1.7</version>
        </dependency>
        <!-- jfinal -->
        <dependency>
            <groupId>com.jfinal</groupId>
            <artifactId>jfinal</artifactId>
            <version>4.3</version>
        </dependency>
    ```
2. 启动类继承JFinalConfig并实现其方法
    ```
    public class DemoConfig extends JFinalConfig {

       // 重写所有的父类抽象方法,下文会具体描述
    
	    public void configConstant(Constants me){}
	
    	public void configRoute(Routes me){}
	
	    public void configEngine(Engine me){}
	
	    public void configPlugin(Plugins me){}
	
    	public void configInterceptor(Interceptors me){}
	
    	public void configHandler(Handlers me){}
    }
    ```
3. main函数
    ```
       public static void main(String[] args) {
          UndertowServer.start(DemoConfig.class);
      }
    ```
4. 配置路由,打印helloWorld
    ```
    在启动类DemoConfig的configRoute中配置路由
    me.add("/hello", HelloController.class)
    ```
5. HelloController.class
    ```
        public void index() {
         renderText("hello world");
     }
    ```
    
6. 启动项目,访问路由
    ```
    localhost/hello
    ```
### 其他:
* 1.启动本项目需要mysql:localhost:3306 root root
且需要一个test数据库,有一个user表字段为id name real_name
* 2.或者注释掉DemoConfig.java中的configPlugin中的所有内容
    ```
	Jenkins 基于docker自动构建job
	// todo 更新工作空间的代码
	rm -rf build
	mkdir build
	cp target/jfinal-demo-release.zip build/jfinal-demo-release.zip
	cp -f Dockerfile build/Dockerfile
	docker rm -f demo
	docker rmi demo
	docker build -t demo build
	docker run -u root -itd --name demo --restart=always -p 8078:80 demo
    ```

### 日志
` 2019/9/27 整理了一个检验参数的拦截器,模仿jsr303,当前仅有一个NotBlank,具体看Controller3_3`
