package ru.dvmakashova.ex;

public class NotEnoughStockException extends AppException {

    public NotEnoughStockException(int requested, int available) {
        super("Недостаточно на складе: нужно " + requested + ", есть " + available);
    }
}
