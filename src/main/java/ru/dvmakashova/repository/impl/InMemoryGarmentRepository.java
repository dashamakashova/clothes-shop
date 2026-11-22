package ru.dvmakashova.repository.impl;

import ru.dvmakashova.entity.Garment;
import ru.dvmakashova.repository.GarmentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Хранит изделия в памяти. Ключ мапы — id изделия. */
public class InMemoryGarmentRepository implements GarmentRepository {

    private static final long FIRST_ID = 1;

    private final Map<Long, Garment> garments = new HashMap<>();
    private long nextId = FIRST_ID;

    @Override
    public Garment save(Garment garment) {
        if (garment.getId() == null) {
            garment.setId(nextId);
            nextId++;
        }
        garments.put(garment.getId(), garment);
        return garment;
    }

    @Override
    public Optional<Garment> findById(Long id) {
        return Optional.ofNullable(garments.get(id));
    }

    @Override
    public List<Garment> findAll() {
        List<Garment> result = new ArrayList<>(garments.values());
        result.sort((first, second) -> first.getId().compareTo(second.getId()));
        return result;
    }

    @Override
    public boolean deleteById(Long id) {
        return garments.remove(id) != null;
    }
}
