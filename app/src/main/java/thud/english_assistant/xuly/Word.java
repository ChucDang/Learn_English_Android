package thud.english_assistant.xuly;

public class Word {
    private int id;
    private String name;
    private String meant;
    private Types_Of_Word type;

    public Word(int id, String name, String meant, Types_Of_Word type) {
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

    public Types_Of_Word getType() {
        return type;
    }

    public void setType(Types_Of_Word type) {
        this.type = type;
    }
}
