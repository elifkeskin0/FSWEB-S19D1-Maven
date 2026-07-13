package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getVegetables() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getVegetablesDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> searchByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id) {
        return vegetableService.delete(id);
    }
}
