package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social/"));
    }

    public static void getSite(URL url) {
        try {
            String host = url.getHost();
            int port = url.getDefaultPort();
            String path = url.getPath();
            Socket clientSocket = new Socket(host, port);

            StringBuilder request = new StringBuilder("GET ");
            request.append(url.getPath());
            if (url.getQuery() != null)
                request.append("?").
                        append(url.getQuery());
            request.append(" HTTP/1.1" + "\r\n")
                    .append("Host: ").append(url.getHost()).append("\r\n")
                    .append("User-Agent: Mozilla/5.0\r\n");

            System.out.println(request.toString());

            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(request.toString().getBytes());
            outputStream.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}