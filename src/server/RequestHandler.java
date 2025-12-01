package server;

import java.io.*;
import java.net.Socket;

public class RequestHandler implements Runnable {

    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
            );

            // リクエストの1行目(例: GET / HTTP/1.1)
            String requestLine = reader.readLine();
            System.out.println("Request: " + requestLine);

            // シンプルなレスポンス
            String response = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/plain\r\n"
                    + "Content-Length: 11\r\n"
                    + "\r\n"
                    + "Hello World";

            writer.write(response);
            writer.flush();

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
