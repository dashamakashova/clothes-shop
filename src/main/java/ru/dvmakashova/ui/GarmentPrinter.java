package ru.dvmakashova.ui;

import ru.dvmakashova.entity.Garment;

import java.util.List;

/** Показывает изделия пользователю. */
public class GarmentPrinter {

    private final ConsoleHelper helper;

    public GarmentPrinter(ConsoleHelper helper) {
        this.helper = helper;
    }

    public void print(Garment garment) {
        helper.println(String.format("#%d | %s «%s» | размер %s | %d руб. | %d шт. (%s)",
                garment.getId(),
                garment.getCategory().getTitle(),
                garment.getName(),
                garment.getSize(),
                garment.getPrice(),
                garment.getQuantity(),
                garment.getStockLevel().getTitle()));
    }

    public void printAll(List<Garment> garments) {
        if (garments.isEmpty()) {
            helper.println("Изделий нет");
            return;
        }
        for (Garment garment : garments) {
            print(garment);
        }
    }
}
