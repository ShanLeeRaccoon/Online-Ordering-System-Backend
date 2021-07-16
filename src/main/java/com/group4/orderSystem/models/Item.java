package com.group4.orderSystem.models;


import com.fasterxml.jackson.annotation.JsonView;
import com.sun.xml.txw2.annotation.XmlNamespace;
import org.springframework.web.servlet.View;

import javax.persistence.*;

///Item model with constraint for database
@Entity
@Table(	name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column
    private String title;

    @Column
    private float price;

    @Column
    private int inStock;

    @Column
    private String description;

    @Column
    private String genre;

    @Column
    private int soldQty;

    @Column
    private String img;

    public Item() { };
    public Item(Long id, String title, float price, int inStock, String description, String genre, int soldQty, String img) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.inStock = inStock;
        this.description = description;
        this.genre = genre;
        this.soldQty = soldQty;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
