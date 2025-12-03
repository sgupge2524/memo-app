package server;

import java.io.*;
import java.net.Socket;

import repository.NoteRepository;
import model.Note;

public class RequestHandler implements Runnable {

    private Socket socket;
    private NoteRepository repository;

    public RequestHandler(Socket socket, NoteRepository repository) {
        this.socket = socket;
        this.repository = repository;
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
            
            // Router（ルーティング）を呼ぶ
            RouteResult route = Router.route(requestLine);
            
            String body;

            if(route.target.equals("index")) {
                body = "Welcom to My Memo App!";
            }
            
            else if(route.target.equals("notes") && route.method.equals("GET")) {
                var list = repository.findAll();
                
                StringBuilder sb = new StringBuilder();
                sb.append("【メモ一覧】\n");
                
                for(Note n : list) {
                    sb.append(n.getNoteId() + ":" + n.getText() + "\n");
                }
                body = sb.toString();

            }
            
            else if(route.target.equals("notes") && route.method.equals("POST")) {
                // Content-Length を読み取る
                int contentLength = 0;
                String line;
                while(!(line = reader.readLine()).equals("")) {
                    if(line.startsWith("Content-Length:")) {
                        contentLength = Integer.parseInt(line.substring(15).trim());
                    }
                }
                
                // 本文を読み取る
                char[] buf = new char[contentLength];
                reader.read(buf);
                String requestBody = new String(buf);
                
                System.out.println("POST body = " + requestBody);
                
                repository.add(requestBody);
                
                body = "メモ追加（受け取ったデータ）: " + requestBody;
            }
            else {
                body = "404 Not Found";
            }

            String response =
                "HTTP/1.1 200 OK\r\n"
              + "Content-Type: text/plain; charset=utf-8\r\n"
              + "Content-Length:" + body.getBytes("UTF-8").length + "\r\n"
              + "\r\n"
              + body;


            writer.write(response);
            writer.flush();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
