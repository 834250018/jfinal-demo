package com.ywy.jfinal;

import com.jfinal.config.*;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import com.ywy.jfinal.core.aop.AdminInterceptor;
import com.ywy.jfinal.core.aop.MyHandler;
import com.ywy.jfinal.core.aop.ParamsInterceptor;
import com.ywy.jfinal.core.aop.ResponseInterceptor;
import com.ywy.jfinal.core.route.AdminRoutes;
import com.ywy.jfinal.core.route.FrontRoutes;
import com.ywy.jfinal.core.route.controller.*;
import com.ywy.jfinal.model.User;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class DemoConfig extends JFinalConfig {

    public static void main(String[] args) {
//        JFinal.start("src/main/webapp", 80, "/", 5);
        // 使用undertow.txt
//        UndertowServer.start(DemoConfig.class);

        // 更多配置
        UndertowServer.create(DemoConfig.class)
//                .onStart(builder -> {
//                    builder.setServerOption(UndertowOptions.paramName, paramValue);
//                })
                .configWeb(builder -> {
//                    builder.addFilter("myFilter", "");
//                    builder.addFilterUrlMapping("myFIlter", "/*");
//                    builder.addFilterInitParam("myFilter", "key", "value");
                    // 配置 Servlet
//                    builder.addServlet("myServlet", "com.abc.MyServlet");
//                    builder.addServletMapping("myServlet", "*.do");
//                    builder.addServletInitParam("myServlet", "key", "value");

                    // 配置 Listener
//                    builder.addListener("com.abc.MyListener");

                    builder.addWebSocketEndpoint("com.ywy.jfinal.core.websocket.MyWebSocket");
                })
                .start();
    }

    @Override
    public void configConstant(Constants me) {
        // 开启对组件Controller Interceptor Validator的注入
        me.setInjectDependency(true);

        // 开启对超类的注入.不开启时可以在超类中通过Aop.get(...)进行注入
        me.setInjectSuperClass(true);
        // 配置使用MixedJson
        me.setJsonFactory(new MixedJsonFactory());
    }

    @Override
    public void configRoute(Routes me) {
        me.setBaseViewPath("/src/main/resources"); // 配置渲染模板路径,不影响控制器路径
        me.setMappingSuperClass(true)
                .add(new FrontRoutes())
                .add(new AdminRoutes())
                .add("/hello", HelloController.class)
                .add("controller32", Controller3_2.class)
                .add("controller33", Controller3_3.class)
                .add("controller34", Controller3_4.class)
                .add("controller35", Controller3_5.class)
                .add("controller37", Controller3_7.class)
                .add("controller310", Controller3_10.class);
    }

    @Override
    public void configEngine(Engine me) {

    }

    @Override
    public void configPlugin(Plugins me) {
        // 配置ActiveRecordPlugin
        /*final String url = "jdbc:mysql://127.0.0.1:3306/test";
        final String username = "root";
        final String password = "root";
        DruidPlugin dp = new DruidPlugin(url, username, password);
        me.add(dp);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.addMapping("user", User.class);
        me.add(arp);*/
    }

    @Override
    public void configInterceptor(Interceptors me) {
        // 配置全局拦截器
        // 响应拦截器优先
        me.add(new ResponseInterceptor());
        // 权限拦截器
        me.add(new AdminInterceptor());
        // 参数校验拦截器
        me.add(new ParamsInterceptor());
    }

    @Override
    public void configHandler(Handlers me) {
        // 配置适配器
        me.add(new MyHandler());
    }

    @Override
    public void onStart() {
        System.out.println("启动完成");

        User user = new User().set("id", "id1").set("name", "小红").set("real_name", "翠花");
        System.out.println();

    }

    @Override
    public void onStop() {
        System.out.println("关闭之后");
        // 可以做一些持久化操作
    }
}
