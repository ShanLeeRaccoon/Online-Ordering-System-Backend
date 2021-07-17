package com.group4.orderSystem.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class OrderForm {

    @Id
    @SequenceGenerator(
            name = "orderForm_sequence",
            sequenceName = "orderForm_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderForm_sequence"
    )
    private Long id;
    private Integer quantity;
    private String status;
    @Transient
    private LocalDate purchaseTime;
    @Transient
    private Float total;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;



    public OrderForm() {
    }

    public OrderForm(Long id, Integer quantity, String status, Item item, User user) {
        this.id = id;
        this.quantity = quantity;
        this.status = status;
        this.item = item;
        this.user = user;
    }

    public OrderForm(Integer quantity, String status, Item item, User user) {
        this.quantity = quantity;
        this.status = status;
        this.item = item;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getPurchaseTime() {
        return LocalDate.now();
    }

    public void setPurchaseTime(LocalDate purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Float getTotal() {
        return this.quantity * item.getPrice();
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

