/*-------------------------------------------- 
* 佐賀大学理工学部数理・情報部門 
*  ソフトウェア協同開発 第x回 xx演習 
* 作成者: 23238183 佐藤樹 
* 作成日: 2025/12/03 
* 説明:  
*-----------------------------------------------------------*/ 
package repository;

import java.util.ArrayList;
import model.Note;

/**
 *@author 23238183 佐藤樹
 *
 */
public class NoteRepository {
    
    private ArrayList<Note> notes = new ArrayList<>();
    private int currentId = 0;
    
    public NoteRepository() {
        //最初の一件だけは、currentIdの始まりがわからないのでこのプログラムを起動する。
        notes.add(new Note(currentId++, "最初のメモ"));
    }
    
    public void add(String text) {
        notes.add(new Note(currentId++, text));
    }
    
    public ArrayList<Note> findAll(){
        return notes;
    }
    
    

}
