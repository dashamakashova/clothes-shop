package ru.dvmakashova.entity;

import ru.dvmakashova.ex.ValidationException;

import java.util.Arrays;

public enum Category {
    T_SHIRT("Футболка"),
    SHIRT("Рубашка"),
    HOODIE("Худи"),
    JEANS("Джинсы"),
    DRESS("Платье"),
    JACKET("Куртка");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Category parse(String text) {
        try {
            return valueOf(text.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Неизвестная категория: " + text
                    + ". Доступные: " + Arrays.toString(values()));
        }
    }
}
