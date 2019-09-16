package com.ywy.jfinal.core.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.render.JsonRender;
import com.jfinal.render.Render;
import com.ywy.jfinal.exception.BusException;
import com.ywy.jfinal.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 响应拦截器
 *
 * @author ve
 * @data 2019/8/13 18:24
 */
//@Slf4j
public class ResponseInterceptor implements Interceptor {


    private static Logger log = LoggerFactory.getLogger(ResponseInterceptor.class);

    @Override
    public void intercept(Invocation inv) {
        try {
            inv.invoke();
            Render render = inv.getController().getRender();
            if (render instanceof JsonRender) {
                inv.getController().renderJson(new ResponseVO("200", null, ((JsonRender) render).getJsonText()));
            }
        } catch (BusException e) {
            // 业务异常封装成响应VO
            log.info(e.getMessage());
            inv.getController().renderJson(new ResponseVO(e.getCode(), e.getMsg(), null));
        } catch (RuntimeException e) {
            // 代码异常封装成响应VO,内容为null
            log.error(e.getMessage(), e);
            inv.getController().renderJson(new ResponseVO("500", "", null));
        }
    }
}
