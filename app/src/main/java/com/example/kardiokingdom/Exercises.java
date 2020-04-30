package com.example.kardiokingdom;

public class Exercises {

    private int id;
    private String name;
    private String descr;
    private byte[] gif;

    public Exercises(String name, String desc, byte[] gif, int id) {
        this.name = name;
        this.descr = desc;
        this.gif = gif;
        this.id = id;
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

    public String getDesc() {
        return descr;
    }

    public void setDesc(String desc) {
        this.descr = desc;
    }

    public byte[] getGif() {
        return gif;
    }

    public void setGif(byte[] gif) {
        this.gif = gif;
    }

}
