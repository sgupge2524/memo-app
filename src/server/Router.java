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
public class Router {
    public static RouteResult route(String requestLine) {
        if(requestLine == null) {
            return new RouteResult("notfound", "GET");
        }
        
        if(requestLine.startsWith("GET / ")) {
            return new RouteResult("index", "GET");
        }
        
        if(requestLine.startsWith("GET /notes")) {
            return new RouteResult("notes", "GET");
        }
        
        if(requestLine.startsWith("POST /notes")) {
            return new RouteResult("notes", "POST");
        }
        
        return new RouteResult("notfound", "GET");
    }

}
