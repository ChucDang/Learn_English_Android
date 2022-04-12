package thud.english_assistant.xuly;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import thud.english_assistant.Topic;

public class TopicRepository {
    private DbHelper myDbHelper;
    private SQLiteDatabase db;
    private String[] allColumns = { DbHelper.TOPIC_ID,
            DbHelper.TOPIC_NAME, DbHelper.TOPIC_IMG};
    public TopicRepository(Context context) {
        myDbHelper = new DbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }

    public TopicRepository() {

    }

    public long insertTopic(Topic topic) {
        db = myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbHelper.TOPIC_NAME, topic.getName_topic());
        values.put(DbHelper.TOPIC_IMG, topic.getImg());
        return db.insert(DbHelper.TABLE_TOPIC, null, values);
    }
    public int updateTopic(int _id, String _name, String _img){
        ContentValues values = new ContentValues();
        values.put(DbHelper.TOPIC_NAME, _name);
        values.put(DbHelper.TOPIC_IMG, _img);
        return db.update(DbHelper.TABLE_TOPIC, values,
                DbHelper.TOPIC_ID + " = " + _id, null);
    }
    public int deleteTopic(int _id) {
        return db.delete(DbHelper.TABLE_TOPIC,
                DbHelper.TOPIC_ID + " = " + _id, null);
    }
    private Topic cursorToTopic(Cursor cursor) {
        Topic topic = new Topic();
        topic.setId(cursor.getInt(0));
        topic.setName_topic(cursor.getString(1));
        topic.setImg(cursor.getString(2));

        return topic;
    }
    public List<Topic> ListAllTopic() {
        List<Topic> lst_topic= new ArrayList<Topic>();
        Cursor cursor = db.query(DbHelper.TABLE_TOPIC,
                allColumns, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Topic values = cursorToTopic(cursor);
                lst_topic.add(values);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return lst_topic;
    }
    public Boolean KiemTra_Topic(int ms) {
        Boolean daco = false;
        List<Topic> lst_topic = ListAllTopic();
        int i = 0;
        while ((! daco) && (i < lst_topic.size()))
            if (lst_topic.get(i).getId() == ms)
                daco = true;
            else
                i++;
        return daco;
    }
    public void close(){
        db.close();
        myDbHelper.close();
    }

}
