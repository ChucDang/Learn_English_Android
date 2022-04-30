package thud.english_assistant.xuly.Topic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TopicDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Test_1.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_TOPIC = "TOPIC";
    public static final String TOPIC_ID = "ID";
    public static final String TOPIC_NAME = "NAME";
    public static final String TOPIC_IMG = "IMAGE";
    private static final String CREATE_TABLE_TOPIC
            = "Create Table " + TABLE_TOPIC + "("
            + TOPIC_ID + " Integer Primary Key Autoincrement, "
            + TOPIC_NAME + " Text, " + TOPIC_IMG + " Text)";
    public TopicDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TOPIC);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("Drop Table If Exists " + TABLE_TOPIC);
        onCreate(db);
    }
}
