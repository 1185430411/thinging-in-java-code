package com.jay.model;

public class Person {

    private String name;

    public Person(){
        System.out.println("Person类的构造方法");
    }

    public Person(String name) {
        this.name = name;
    }

    public void sing(String song){
        System.out.println("唱歌"+song);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
