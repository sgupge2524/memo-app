/*-------------------------------------------- 
* 佐賀大学理工学部数理・情報部門 
*  ソフトウェア協同開発 第x回 xx演習 
* 作成者: 23238183 佐藤樹 
* 作成日: 2025/12/03 
* 説明:  
*-----------------------------------------------------------*/ 
package model;

/**
 *@author 23238183 佐藤樹
 *
 */
public class Note {
    int noteId;
    String text;
    
    public Note(int noteId, String text){
        this.noteId = noteId;
        this.text = text;
    }
    
    public int getNoteId() {
        return noteId;
    }
    
    public String getText() {
        return text;
    }

}
