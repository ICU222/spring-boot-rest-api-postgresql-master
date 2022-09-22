package com.sundo.springbootrestapipostgresql.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Info {

    @Id
    private  String name;
    @Column
    private String id;

    public Info(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Info() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id){ this.id = id;}
    @Override
    public String toString() {
        return "Info" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
