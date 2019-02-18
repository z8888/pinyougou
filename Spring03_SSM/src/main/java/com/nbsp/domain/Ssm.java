package com.nbsp.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Ssm implements Serializable {
    private Integer id;
    private String name;
    private Character sex;
    private Integer money;

    @Override
    public String toString() {
        return "Ssm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
