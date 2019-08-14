package com.ywy.jfinal.render;

import com.jfinal.render.ContentType;
import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class MyRender extends Render {
    protected static final String DEFAULT_CONTENT_TYPE = "text/plain";
    protected String text;
    protected String contentType;

    public MyRender(String text) {
        this.text = text;
        this.contentType = "text/plain";
    }

    public MyRender(String text, String contentType) {
        this.text = text;
        this.contentType = contentType;
    }

    public MyRender(String text, ContentType contentType) {
        this.text = text;
        this.contentType = contentType.value();
    }

    @Override
    public void render() {
        PrintWriter writer = null;
        try {
            response.setHeader("Pragma", "no-cache");    // HTTP/1.0 caches might not implement Cache-Control and might only implement Pragma: no-cache
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);


            String ct = getContentType();
            response.setContentType(ct);

            // 不包含 "charset" 时才调用该方法，否则该方法会覆盖掉 contentType 中的 "charset" 部分
            if (ct.indexOf("charset") == -1) {
                response.setCharacterEncoding(getEncoding());    // 与 contentType 分开设置
            }


            writer = response.getWriter();
            writer.write(text);
            // writer.flush();
        } catch (IOException e) {
            throw new RenderException(e);
        }
    }

    public String getContentType() {
        return this.contentType;
    }
}
