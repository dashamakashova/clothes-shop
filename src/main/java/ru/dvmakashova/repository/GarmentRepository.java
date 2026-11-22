package ru.dvmakashova.repository;

import ru.dvmakashova.entity.Garment;

import java.util.List;
import java.util.Optional;

public interface GarmentRepository {

    Garment save(Garment garment);

    Optional<Garment> findById(Long id);

    List<Garment> findAll();

    boolean deleteById(Long id);
}
