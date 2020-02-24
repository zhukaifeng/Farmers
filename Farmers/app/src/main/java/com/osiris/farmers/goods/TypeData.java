package com.osiris.farmers.goods;

import java.util.List;

public class TypeData {


    /**
     * result : 0
     * message : 1
     * data : ["商品类别"]
     */

    private int result;
    private String message;
    private List<String> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
