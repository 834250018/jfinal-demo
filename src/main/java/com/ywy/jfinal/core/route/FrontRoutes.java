package com.ywy.jfinal.core.route;

import com.jfinal.config.Routes;
import com.ywy.jfinal.core.route.controller.BlogController;
import com.ywy.jfinal.core.route.controller.IndexController;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class FrontRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/view/front");
        add("index", IndexController.class);
        add("/blog", BlogController.class);
    }
}
