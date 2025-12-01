/*-------------------------------------------- 
* 佐賀大学理工学部数理・情報部門 
*  ソフトウェア協同開発 第x回 xx演習 
* 作成者: 23238183 佐藤樹 
* 作成日: 2025/12/01 
* 説明:  
*-----------------------------------------------------------*/ 
package server;

/**
 *@author 23238183 佐藤樹
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Server starting...");
        
        HttpServer server = new HttpServer(8080);
        server.start();
    }

}
