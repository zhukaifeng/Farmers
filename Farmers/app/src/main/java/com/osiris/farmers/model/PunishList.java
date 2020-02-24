package com.osiris.farmers.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PunishList {


    /**
     * result : 0
     * message : 1
     * pageNum : 2
     * data : [{"id":1,"name":"1","tupian":"111.png","marketId":"20","marketName":"观音山新城菜市场"},{"id":2,"name":"2","tupian":"222.png","marketId":"20","marketName":"观音山新城菜市场"}]
     */

    private int result;
    private String message;
    private int pageNum;
    private List<DataBean> data;

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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * id : 1
         * name : 1
         * tupian : 111.png
         * marketId : 20
         * marketName : 观音山新城菜市场
         */

        private int id;
        private String name;
        private String tupian;
        private String marketId;
        private String marketName;

        protected DataBean(Parcel in) {
            id = in.readInt();
            name = in.readString();
            tupian = in.readString();
            marketId = in.readString();
            marketName = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

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

        public String getTupian() {
            return tupian;
        }

        public void setTupian(String tupian) {
            this.tupian = tupian;
        }

        public String getMarketId() {
            return marketId;
        }

        public void setMarketId(String marketId) {
            this.marketId = marketId;
        }

        public String getMarketName() {
            return marketName;
        }

        public void setMarketName(String marketName) {
            this.marketName = marketName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeString(tupian);
            dest.writeString(marketId);
            dest.writeString(marketName);
        }
    }
}
