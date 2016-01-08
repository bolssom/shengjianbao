package com.blossom.workrecd.Dao;

/**
 * Created by zxw on 2015/12/21.
 */
public class JFC {

    public  String id;
    public  String author_name;
    public  String addtime;

    public JFC() {

    }

    public String getAddtime() {
        return addtime;
    }

    public void setADDtime(String addtime) {
        this.addtime = addtime;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public JFC(String id, String author_name, String addtime) {
        this.id = id;
        this.author_name = author_name;
        this.addtime = addtime;
    }


    @Override
    public String toString() {
        return "JFC{" +
                "id='" + id + '\'' +
                ", author_name='" + author_name + '\'' +
                ", addtime='" + addtime + '\'' +
                '}';
    }
}
