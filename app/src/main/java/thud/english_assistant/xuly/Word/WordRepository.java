package thud.english_assistant.xuly.Word;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class WordRepository {
    private WordDbHelper wordDbHelper;
    private SQLiteDatabase db;
    private String[] allColumns = { WordDbHelper.WORD_ID,WordDbHelper.ofTopic,
            WordDbHelper.WORD_NAME,WordDbHelper.WORD_MEANT, WordDbHelper.WORD_TYPE};
    public WordRepository(Context context) {

        wordDbHelper = new WordDbHelper(context);
        db = wordDbHelper.getWritableDatabase();
    }
    public void insertListWord(List<Word> words){

        for (Word i: words
        ) {
            insertWord(i);

        }
    }
    public void insertWord(Word word) {
        if(!KiemTra_Word(word.getName(),word.getType(), word.getTopic())){
            db = wordDbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(WordDbHelper.ofTopic, word.getTopic());
            values.put(WordDbHelper.WORD_NAME, word.getName());
            values.put(WordDbHelper.WORD_MEANT, word.getMeant());
            values.put(WordDbHelper.WORD_TYPE, word.getType());
            db.insert(WordDbHelper.TABLE_WORD, null, values);
        }else{
            Log.i("Thông báo","Đã tồn tại word trong Database");
        }
    }
    public int updateWord(String _name,String _meant, String _topic){
        ContentValues values = new ContentValues();
        values.put(WordDbHelper.WORD_NAME, _name);
        values.put(WordDbHelper.WORD_MEANT, _meant);
        String whereClause = WordDbHelper.WORD_NAME+"=? AND "+ WordDbHelper.ofTopic+"=?";
        String[] whereArgs = new String[] {
                _name,
                _topic
        };
        return db.update(WordDbHelper.TABLE_WORD, values,
                whereClause, whereArgs);
    }
    public int deleteWord(String _name, String _type, String _topic) {
        String whereClause = WordDbHelper.WORD_NAME+"=? AND "+ WordDbHelper.ofTopic+"=?";
        String[] whereArgs = new String[] {
                _name,
                _topic
        };
        return db.delete(WordDbHelper.TABLE_WORD,
                whereClause, whereArgs);
    }
    private Word cursorToWord(Cursor cursor) {
        Word word = new Word();
        word.setTopic(cursor.getString(1));
        word.setName(cursor.getString(2));
        word.setMeant(cursor.getString(3));
        word.setType(cursor.getString(4));
        return word;
    }
    public List<Word> ListAllWord() {
        List<Word> words= new ArrayList<>();
        Cursor cursor = db.query(WordDbHelper.TABLE_WORD,
                allColumns, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Word values = cursorToWord(cursor);
                words.add(values);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return words;
    }
    public List<Word> ListAllWordByTopic(String topic) {
        List<Word> words= new ArrayList<>();
        String whereClause =WordDbHelper.WORD_TYPE+  "="+topic;
        Cursor cursor = db.query(WordDbHelper.TABLE_WORD,
                allColumns, whereClause, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Word values = cursorToWord(cursor);
                words.add(values);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return words;
    }
    public Boolean KiemTra_Word(String name, String type, String topic) {

        Boolean daco = false;
        List<Word> lst_word = ListAllWord();
        int i = 0;
        while ((! daco) && (i < lst_word.size())){
            if (lst_word.get(i).getName().equalsIgnoreCase(name)&&lst_word.get(i).getType().equalsIgnoreCase(type))
                daco = true;
            else
                i++;
        }
        return daco;
    }
    public void close(){
        db.close();
        wordDbHelper.close();
    }
}
