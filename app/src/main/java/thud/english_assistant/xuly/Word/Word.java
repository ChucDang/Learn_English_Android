package thud.english_assistant.xuly;

public class Word {
    private int id;
    private String name;
    private String meant;
    private Type type;
    enum Type{
        Noun, Verb, Adv, Adj, None
    }

    public Word(int id, String name, String meant, Type type) {
        this.id = id;
        this.name = name;
        this.meant = meant;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
