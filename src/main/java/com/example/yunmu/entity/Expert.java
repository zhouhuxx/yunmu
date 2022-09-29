package com.example.yunmu.entity;

public class Expert {
    private String no;
    private String name;
    private String sex;
    private byte[] photo;
    private float score;
    private String field;
    private String introduction;

    public void setNo(String no) {
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return introduction;
    }
}
