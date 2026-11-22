package ru.dvmakashova.service;

import ru.dvmakashova.entity.Category;
import ru.dvmakashova.entity.Garment;

import java.util.List;

public interface GarmentService {

    Garment add(String name, Category category, String size, int price, int quantity);

    Garment getById(Long id);

    List<Garment> getAll();

    void delete(Long id);

    /** Продаёт изделия со склада и возвращает сумму продажи. */
    int sell(Long id, int amount);

    Garment restock(Long id, int amount);

    /** Изделия, которые закончились или скоро закончатся. */
    List<Garment> findNeedingRestock();
}
