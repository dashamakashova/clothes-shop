package ru.dvmakashova.ex;

public class EntityNotFoundException extends AppException {

    public EntityNotFoundException(Long id) {
        super("Изделие с id=" + id + " не найдено");
    }
}
