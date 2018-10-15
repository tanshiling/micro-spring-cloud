package com.bm.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @version V1.0
 * @Title: User
 * @Package com.bm.elasticsearch.entity
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/14 17:06
 */
//数据库+表
@Document(indexName = "userindex",type = "user")
public class User {

    @Id
    private Long id;
    private String name;
    private int age;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
