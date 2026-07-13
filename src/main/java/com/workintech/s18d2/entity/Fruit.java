package com.workintech.s18d2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fruit", schema = "fsweb")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FruitType fruitType;

    public Fruit() {
    }

    public Fruit(Long id, String name, Double price, FruitType fruitType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.fruitType = fruitType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }
}
