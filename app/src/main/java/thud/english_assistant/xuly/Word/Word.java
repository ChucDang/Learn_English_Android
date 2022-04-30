package thud.english_assistant.xuly.Word;

import thud.english_assistant.xuly.Topic.Topic;

public class Word {
    private int id;
    private String topic;
    private String name;
    private String meant;
    private String type;

    public Word() {
        name = topic = meant = "";
        type = "None";
    }

    public Word(String topic, String name, String meant, String type) {
        this.topic = topic;
        this.name = name;
        this.meant = meant;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeant() {
        return meant;
    }

    public void setMeant(String meant) {
        this.meant = meant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
