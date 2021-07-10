package com.group4.orderSystem.models;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.servlet.View;

import javax.persistence.*;

///Item model with constraint for database
@Entity
@Table(	name = "item")
public class Item {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
