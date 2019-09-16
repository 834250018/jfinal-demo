package com.ywy.jfinal.core.aop;

import com.jfinal.aop.Aop;
import com.jfinal.aop.AopManager;
import com.jfinal.aop.Inject;
import com.ywy.jfinal.service.TestService;
import com.ywy.jfinal.service.UserService;
import com.ywy.jfinal.service.impl.UserServiceImpl;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class AOP4_5 {

    @Inject
    TestService testService;

    // 不能通过@Inject注入接口
//    @Inject
//    UserService userService;

    // Aop注入实现类
    static UserServiceImpl userServiceImpl = Aop.get(UserServiceImpl.class);

    public void aop() {
        UserServiceImpl userServiceimpl = Aop.get(UserServiceImpl.class);
        Class<UserServiceImpl> userServiceImplClass = Aop.inject(UserServiceImpl.class);

        // 配置关联映射之后可以注入接口
        AopManager.me().addMapping(UserService.class, UserServiceImpl.class);
        UserService userService = Aop.get(UserService.class);
        System.out.println();

        // 单例注入,可以使用有参构造,上面代码已经注入过,不能继续注入
//        UserServiceImpl userServiceImpl = new UserServiceImpl("aaa","bbb");
//        AopManager.me().addSingletonObject(userServiceImpl);
//        AopManager.me().addMapping(UserService.class, UserServiceImpl.class);
//        UserService userService1 = Aop.get(UserService.class);
    }
}
