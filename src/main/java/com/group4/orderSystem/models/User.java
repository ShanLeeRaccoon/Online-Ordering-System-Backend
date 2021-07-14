package com.group4.orderSystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "user")
public class User {
    @Id
    Long id;

    @Column
    String email;

    @Column
    String name;
}
