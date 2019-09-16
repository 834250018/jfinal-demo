package com.ywy.jfinal.core.route.controller;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.ywy.jfinal.model.User;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class Controller3_10 extends Controller {

    public void index() {
        // session仅用于单机服务,不支持集群与分布式
        setSessionAttr("user", new User());

        // getFile获取表单中上传的文件,默认保存到项目路径/upload/
        UploadFile file = getFile();
        System.out.println();
        // 使用完之后把缓存文件删除
        file.getFile().delete();

        // 把入参丢回去,无论什么类型,丢回去就变成String
        keepPara();
        // keepModel 与 keepBean可以返回源类型
    }
}
