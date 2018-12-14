package com.myexample.demo.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    private String cupSize;
    private Integer age;

    public Girl() {
    }

    public Girl(String cupSize, Integer age) {
        this.cupSize = cupSize;
        this.age = age;
    }

    public Girl(Integer id,String cupSize,Integer age){
        this.id=id;
        this.cupSize = cupSize;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Girl girl = (Girl) o;
        return Objects.equals(id, girl.id) &&
                Objects.equals(cupSize, girl.cupSize) &&
                Objects.equals(age, girl.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cupSize, age);
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
