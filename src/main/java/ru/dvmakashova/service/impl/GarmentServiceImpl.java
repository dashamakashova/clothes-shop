package ru.dvmakashova.service.impl;

import ru.dvmakashova.entity.Category;
import ru.dvmakashova.entity.Garment;
import ru.dvmakashova.ex.EntityNotFoundException;
import ru.dvmakashova.repository.GarmentRepository;
import ru.dvmakashova.service.GarmentService;

import java.util.List;

public class GarmentServiceImpl implements GarmentService {

    private final GarmentRepository repository;

    public GarmentServiceImpl(GarmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Garment add(String name, Category category, String size, int price, int quantity) {
        return repository.save(new Garment(name, category, size, price, quantity));
    }

    @Override
    public Garment getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public List<Garment> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id)) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public int sell(Long id, int amount) {
        Garment garment = getById(id);
        garment.sell(amount);
        repository.save(garment);
        return garment.getPrice() * amount;
    }

    @Override
    public Garment restock(Long id, int amount) {
        Garment garment = getById(id);
        garment.restock(amount);
        return repository.save(garment);
    }

    @Override
    public List<Garment> findNeedingRestock() {
        return repository.findAll().stream()
                .filter(garment -> garment.getStockLevel().needsRestock())
                .toList();
    }
}
