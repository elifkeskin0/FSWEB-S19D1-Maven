package com.workintech.s18d2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vegetable", schema = "fsweb")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private boolean grownOnTree;

    public Vegetable() {
    }

    public Vegetable(Long id, String name, Double price, boolean grownOnTree) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.grownOnTree = grownOnTree;
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

    public boolean isGrownOnTree() {
        return grownOnTree;
    }

    public void setGrownOnTree(boolean grownOnTree) {
        this.grownOnTree = grownOnTree;
    }
}
