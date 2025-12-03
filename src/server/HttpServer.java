/*-------------------------------------------- 
* 佐賀大学理工学部数理・情報部門 
*  ソフトウェア協同開発 第x回 xx演習 
* 作成者: 23238183 佐藤樹 
* 作成日: 2025/12/01 
* 説明:  
*-----------------------------------------------------------*/ 
package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

import repository.NoteRepository;

/**
 *@author 23238183 佐藤樹
 *
 */
public class HttpServer {
    
    private int port;
    private NoteRepository repository;
    
    public HttpServer(int port) {
        this.port = port;
        this.repository = new NoteRepository();
    }
    
    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started on port " + port);
            
            while(true) {
                Socket socket = serverSocket.accept();
                new Thread(new RequestHandler(socket, repository)).start();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
