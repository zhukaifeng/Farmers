package com.osiris.farmers.model;

public class TypeSampleTitle {

    private String name;
    private boolean select;

    @Override
    public int hashCode() {
        String in=name;
        return in.hashCode();

    }

    @Override
    public boolean equals(Object obj) {
        TypeSampleTitle type=(TypeSampleTitle)obj;
        return type.getName().equals(name);

       // return super.equals(obj);
    }

    public TypeSampleTitle(String name, boolean select) {
        this.name = name;
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
