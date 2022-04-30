package thud.english_assistant.xuly.Word;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class WordDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Test_1_1.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_WORD = "WORD";
    public static final String WORD_ID = "ID";
    public static final String ofTopic ="ofTOPIC";
    public static final String WORD_NAME = "NAME";
    public static final String WORD_MEANT = "MEANT";
    public static final String WORD_TYPE = "TYPE";

    private static final String CREATE_TABLE_WORD
            = "Create Table " + TABLE_WORD + "("
            + WORD_ID + " Integer Primary Key Autoincrement, "+ ofTopic +" Text NOT NULL REFERENCES TABLE_TOPIC (name_topic),"
            + WORD_NAME + " Text, "+ WORD_MEANT+" Text, " + WORD_TYPE + " Text)";
    public WordDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE_WORD);
        }catch (Exception e){
            Log.i("Thông Báo","Lỗi db.excecute WordDBHelper");
        }

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("Drop Table If Exists " + TABLE_WORD);
        onCreate(db);
    }
}
