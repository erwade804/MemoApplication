package edu.jsu.mcis.cs408.dbexample;

public class Memo {

    private int id;
    private String name;

    public Memo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Memo(String name) {
        this.name = name;
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



    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Name: ").append(name).append("\n");
        return s.toString();
    }

}