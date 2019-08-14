package com.ywy.jfinal.route;

import com.jfinal.config.Routes;
import com.ywy.jfinal.controller.BlogController;
import com.ywy.jfinal.controller.IndexController;

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
