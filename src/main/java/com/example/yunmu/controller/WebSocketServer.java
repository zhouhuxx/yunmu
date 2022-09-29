package com.example.yunmu.controller;
import com.alibaba.fastjson.JSON;
import com.example.yunmu.entity.Message;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/ws/{id}")
@Component
public class WebSocketServer {
    private static final Map<String, Session> map = new ConcurrentHashMap<>();
    private String id;

    @OnOpen
    public void onOpen(Session session, @PathParam("id") String id) {
        this.id = id;
        map.put(id, session);
    }

    @OnClose
    public void onClose(Session session) {
        map.remove(id);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        Message message1 = JSON.parseObject(message, Message.class);
        Session toSession = map.get(message1.getRecipient());
        sendMessage(toSession, message);
    }

    @OnError
    public void onError(Session session, Throwable e) {
        e.printStackTrace();
    }

    public void sendMessage(Session toSession, String message) {
        toSession.getAsyncRemote().sendText(message);
    }
}













