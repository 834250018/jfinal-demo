package com.ywy.jfinal.core.route;

import com.jfinal.config.Routes;
import com.ywy.jfinal.core.aop.AdminInterceptor;
import com.ywy.jfinal.core.route.controller.AdminController;
import com.ywy.jfinal.core.route.controller.UserController;

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
