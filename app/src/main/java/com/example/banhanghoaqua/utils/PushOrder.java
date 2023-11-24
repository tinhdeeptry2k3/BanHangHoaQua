package com.example.banhanghoaqua.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PushOrder {
    private String bot_token;
    private String chat_id;

    private String api_url;

    public PushOrder()
    {
        this.bot_token = "6594283040:AAHW4vFYiNXhJKmdjlSolsMnn5LwAsGsZDA";
        this.chat_id = "6297153610";
        this.api_url = "https://api.telegram.org/bot" + this.bot_token + "/sendMessage";
    }

    public void send(String message) throws IOException {
        // Tạo URL
        URL url = new URL(this.api_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Thiết lập phương thức là POST
        connection.setRequestMethod("POST");

        // Cho phép gửi dữ liệu
        connection.setDoOutput(true);

        // Tạo nội dung tin nhắn
        String postData = "chat_id=" + this.chat_id + "&text=" + message;
        byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);

        // Thiết lập header cho request
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));

        // Gửi dữ liệu
        try (OutputStream os = connection.getOutputStream()) {
            os.write(postDataBytes);
        }

    }

}
