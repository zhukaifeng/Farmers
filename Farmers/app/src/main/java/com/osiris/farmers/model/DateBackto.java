package com.osiris.farmers.model;

public class DateBackto {

    private int id;
    private String name;
    private String type;
    private String info;

    public DateBackto(int id, String name, String type, String info) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.info = info;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
