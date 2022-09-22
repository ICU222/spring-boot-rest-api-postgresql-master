package com.sundo.springbootrestapipostgresql.entity;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Home {

    @Id
    private String name;
    @Column
    @NonNull
    private String area;

    public Home(String name, String area) {
        this.name = name;
        this.area = area;
    }

    public Home() {
    }

    public String getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(String area){ this.area = area;}
    @Override
    public String toString() {
        return "HomeArea" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
