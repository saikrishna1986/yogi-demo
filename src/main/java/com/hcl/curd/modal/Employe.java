package com.hcl.curd.modal;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Entity
public class Employe {

    @Id
    @Column(name="id")
    Integer id;
    @Column(name="name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employe() {
    }

    public Employe(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
