package thud.english_assistant.xuly.Topic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TopicRepository {
    private TopicDbHelper myTopicDbHelper;
    private SQLiteDatabase db;
    private String[] allColumns = { TopicDbHelper.TOPIC_ID,
            TopicDbHelper.TOPIC_NAME, TopicDbHelper.TOPIC_IMG};
    public TopicRepository(Context context) {

        myTopicDbHelper = new TopicDbHelper(context);
        db = myTopicDbHelper.getWritableDatabase();
    }
    public void insertListTopic(List<Topic> topics){

        for (Topic i: topics
             ) {
            insertTopic(i);
        }
    }
    public void insertTopic(Topic topic) {

        if(!KiemTra_Topic(topic.getName_topic())){
            Log.i("Thông báo",topic.getName_topic());
            db = myTopicDbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(TopicDbHelper.TOPIC_NAME, topic.getName_topic());
            values.put(TopicDbHelper.TOPIC_IMG, topic.getImg());
            db.insert(TopicDbHelper.TABLE_TOPIC, null, values);
            Log.i("Thông báo","Thêm topic thành công");
        }else{
            Log.i("Thông báo","Đã tồn tại topic trong Database");
        }
    }
    public int updateTopic(String _name){
        ContentValues values = new ContentValues();
        values.put(TopicDbHelper.TOPIC_NAME, _name);
        return db.update(TopicDbHelper.TABLE_TOPIC, values,
                TopicDbHelper.TOPIC_NAME + " = " + _name, null);
    }
    public int deleteTopic(String name) {
        return db.delete(TopicDbHelper.TABLE_TOPIC,
                TopicDbHelper.TOPIC_NAME + " = " + name, null);
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
        Cursor cursor = db.query(TopicDbHelper.TABLE_TOPIC,
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
    public Boolean KiemTra_Topic(String nametopic) {

        Boolean daco = false;
        List<Topic> lst_topic = ListAllTopic();
        int i = 0;
        while ((! daco) && (i < lst_topic.size())){
            if (lst_topic.get(i).getName_topic().equals(nametopic))
                daco = true;

            else
                i++;
        }
        return daco;
    }
    public void close(){
        db.close();
        myTopicDbHelper.close();
    }

}
