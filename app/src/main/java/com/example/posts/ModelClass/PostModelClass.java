package com.example.posts.ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PostModelClass {


    ArrayList<data> data;

    public ArrayList<PostModelClass.data> getData() {
        return data;
    }

    public void setData(ArrayList<PostModelClass.data> data) {
        this.data = data;
    }


    public class data {

        @SerializedName("id")
        @Expose
        private String id;


        @SerializedName("user_id")
        @Expose
        private String user_id;


        @SerializedName("title")
        @Expose
        private String title;


        @SerializedName("body")
        @Expose
        private String body;

        public data(String id, String user_id, String title, String body) {
            this.id = id;
            this.user_id = user_id;
            this.title = title;
            this.body = body;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}


