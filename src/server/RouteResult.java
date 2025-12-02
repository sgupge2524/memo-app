/*-------------------------------------------- 
* 佐賀大学理工学部数理・情報部門 
*  ソフトウェア協同開発 第x回 xx演習 
* 作成者: 23238183 佐藤樹 
* 作成日: 2025/12/02 
* 説明:  
*-----------------------------------------------------------*/ 
package server;

/**
 *@author 23238183 佐藤樹
 *
 */
public class RouteResult {
    
    public String target;
    public String method;
    
    public RouteResult(String target, String method) {
        this.target = target;
        this.method = method;
    }

}
