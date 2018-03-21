package com.runkevich8.gmail.test.homework.hw9;


public class User {

    private String name;
    private String surName;
    private String age;
    private String imageUrl;
    private boolean gender;

    public User(String name, String surName, String age, String imageUrl, boolean gender) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.imageUrl = imageUrl;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
