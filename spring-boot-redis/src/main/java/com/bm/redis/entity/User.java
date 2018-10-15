package com.bm.redis.entity;

/**
 * @version V1.0
 * @Title: User
 * @Package com.bm.redis.entity
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/8 16:00
 */
public class User {

    private int id;
    private String name;
    private int age;


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
