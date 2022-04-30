package thud.english_assistant;

public class Topic {
    private int id;
    private String name_topic;
    private String img;

    public Topic(int id, String name_topic, String img) {
        this.id = id;
        this.name_topic = name_topic;
        this.img = img;
    }
    public Topic() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_topic() {
        return name_topic;
    }

    public void setName_topic(String name_topic) {
        this.name_topic = name_topic;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
