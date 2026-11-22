package ru.dvmakashova.util;

import ru.dvmakashova.ex.ValidationException;

public final class NumberParser {

    private NumberParser() {
    }

    public static long parseLong(String text) {
        try {
            return Long.parseLong(text);
        } catch (NumberFormatException e) {
            throw new ValidationException("Ожидалось целое число, а получено: " + text);
        }
    }

    public static int parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new ValidationException("Ожидалось целое число, а получено: " + text);
        }
    }
}
