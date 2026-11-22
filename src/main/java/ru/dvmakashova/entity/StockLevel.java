package ru.dvmakashova.entity;

/** Сколько изделий осталось на складе. */
public enum StockLevel {
    OUT_OF_STOCK("нет в наличии"),
    LOW("заканчивается"),
    IN_STOCK("в наличии");

    private static final int LOW_LIMIT = 3;

    private final String title;

    StockLevel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    /** Нужно ли шить новую партию. */
    public boolean needsRestock() {
        return this != IN_STOCK;
    }

    public static StockLevel of(int quantity) {
        if (quantity <= 0) {
            return OUT_OF_STOCK;
        }
        if (quantity <= LOW_LIMIT) {
            return LOW;
        }
        return IN_STOCK;
    }
}
