package com.example.TanTanDemo;

/**
 * Created by ChenHao on 2014-12-02 下午3:50.
 *
 * @modify:
 */
public class CardModel {
    private String name;
    private int age;
    private int pictures;

    public String getName() {
        return name;
    }

    public int getPictures() {
        return pictures;
    }

    public void setPictures(int pictures) {
        this.pictures = pictures;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CardModel() {

    }

    public CardModel(String name, int age, int pictures) {
        this.name = name;
        this.age = age;
        this.pictures = pictures;
    }

}
