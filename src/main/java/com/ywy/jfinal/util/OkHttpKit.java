package com.ywy.jfinal.util;

import com.jfinal.kit.JsonKit;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * @author ve
 * @date 2019/8/25 1:04
 */
public class OkHttpKit {

    public static String post(String url, String json, Map<String, String> headers) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(FormBody.create(MediaType.parse("application/json;charset=utf-8"), json));
        setHeaders(builder, headers);
        return execute(builder.build());
    }

    public static String post(String url, Map<String, String> params, Map<String, String> headers) {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(map2Body(params));
        setHeaders(builder, headers);
        return execute(builder.build());
    }

    private static RequestBody map2Body(Map<String, String> params) {
        FormBody.Builder builder = new FormBody.Builder();
        params.forEach((s, s2) -> {
            builder.add(s, s2);
        });
        return builder.build();
    }

    private static void setHeaders(Request.Builder builder, Map<String, String> headers) {
        headers.forEach((s, s2) -> {
            builder.header(s, s2);
        });
    }

    private static String execute(Request request) {
        OkHttpClient client = new OkHttpClient();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
//            log.error("post error");
            return JsonKit.toJson(e);
        }
    }
}
