package com.ywy.jfinal.util;

import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;
import org.junit.Test;

/**
 * model generator
 *
 * @author ve
 * @data 2019/9/17 9:42
 */
public class ModellGenerator {

    final String TEST_DIR = "src/test/java";

    final String MODEL_DIR = "com/ywy/jfinal/model";
    final String SLASH = "/";

    @Test
    public void generator() {

        // 配置数据源
        final String url = "jdbc:mysql://127.0.0.1:3306/test";
        final String username = "root";
        final String password = "root";
        DruidPlugin dp = new DruidPlugin(url, username, password);
        dp.start();

        // base model所使用的包名
        String baseModelPkg = "com.ywy.jfinal.model.base";
        // base model文件保存路径
        String baseModelDir = TEST_DIR + SLASH + MODEL_DIR + SLASH + "base";

        // model所使用的包名
        String modelPkg = "com.ywy.jfinal.model";
        // model文件保存路径
        String modelDir = TEST_DIR + SLASH + MODEL_DIR;
        Generator generator = new Generator(dp.getDataSource(), baseModelPkg, baseModelDir, modelPkg, modelDir);
        generator.setGenerateRemarks(true);
        generator.generate();

        /* todo 生成完成之后,需要
            1.整合_MappingKit.java中的代码到DemoConfig中
            2.移动model跟base model文件到对应目录
            若出现cannot access XXX,重启idea
        */
    }
}
