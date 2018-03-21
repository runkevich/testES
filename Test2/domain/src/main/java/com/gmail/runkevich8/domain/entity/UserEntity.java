package com.gmail.runkevich8.domain.entity;



public class UserEntity {

    private String username;
    private int age;
    private String profileUrl;
    private boolean gender;

    public UserEntity(String userName, int age, String profileUrl){

    }

    public UserEntity(String username, int age, String profileUrl,boolean gender) {
        this.username = username;
        this.age = age;
        this.profileUrl = profileUrl;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
