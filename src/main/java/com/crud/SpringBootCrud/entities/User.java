package com.crud.SpringBootCrud.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    public User(){
        super();

    }

    public User(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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
                ", address='" + address + '\'' +
                '}';
    }
}
