package com.ywy.jfinal.route;

import com.jfinal.config.Routes;
import com.ywy.jfinal.controller.AdminController;
import com.ywy.jfinal.controller.UserController;
import com.ywy.jfinal.interceptor.AdminInterceptor;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class AdminRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/view/admin");
        addInterceptor(new AdminInterceptor());
        add("/admin", AdminController.class);
        add("/admin/user", UserController.class);
    }
}
