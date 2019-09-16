package com.ywy.jfinal.core.websocket;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
@ServerEndpoint("/testws.ws")
public class MyWebSocket {

    @OnMessage
    public void message(String message, Session session) {
        session.getAsyncRemote().sendText("444");
        for (Session s : session.getOpenSessions()) {
            s.getAsyncRemote().sendText(message);
        }
    }
}
