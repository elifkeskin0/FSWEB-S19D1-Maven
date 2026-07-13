package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {
    private final VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable getById(Long id) {
        validateId(id);
        return vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException("Vegetable could not be found with id: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        validateVegetable(vegetable);
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetable = getById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    private void validateId(Long id) {
        if (id == null || id < 0) {
            throw new PlantException("Id must be greater than or equal to zero", HttpStatus.BAD_REQUEST);
        }
    }

    private void validateVegetable(Vegetable vegetable) {
        if (vegetable == null || vegetable.getName() == null || vegetable.getName().isBlank()
                || vegetable.getPrice() == null) {
            throw new PlantException("Vegetable data is missing", HttpStatus.BAD_REQUEST);
        }
    }
}
