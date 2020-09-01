package com.deshmukh.recyclerviewexample;

public class DataModel {
    String name;
    String age;
    String roll_no;

    public DataModel(String name, String age, String roll_no) {
        this.name = name;
        this.age = age;
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }
}
