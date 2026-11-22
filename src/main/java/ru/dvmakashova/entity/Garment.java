package ru.dvmakashova.entity;

import ru.dvmakashova.ex.NotEnoughStockException;
import ru.dvmakashova.ex.ValidationException;
import ru.dvmakashova.util.StringUtils;

/** Изделие собственного производства. */
public class Garment {

    private Long id;
    private final String name;
    private final Category category;
    private final String size;
    private final int price;
    private int quantity;

    public Garment(String name, Category category, String size, int price, int quantity) {
        if (StringUtils.isNullOrBlank(name)) {
            throw new ValidationException("Название не может быть пустым");
        }
        if (category == null) {
            throw new ValidationException("Категория обязательна");
        }
        if (StringUtils.isNullOrBlank(size)) {
            throw new ValidationException("Размер не может быть пустым");
        }
        if (price <= 0) {
            throw new ValidationException("Цена должна быть больше нуля");
        }
        if (quantity < 0) {
            throw new ValidationException("Количество не может быть отрицательным");
        }
        this.name = name;
        this.category = category;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
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

    public Category getCategory() {
        return category;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public StockLevel getStockLevel() {
        return StockLevel.of(quantity);
    }

    public void sell(int amount) {
        checkPositive(amount);
        if (amount > quantity) {
            throw new NotEnoughStockException(amount, quantity);
        }
        quantity -= amount;
    }

    public void restock(int amount) {
        checkPositive(amount);
        quantity += amount;
    }

    private static void checkPositive(int amount) {
        if (amount <= 0) {
            throw new ValidationException("Количество должно быть больше нуля");
        }
    }
}
