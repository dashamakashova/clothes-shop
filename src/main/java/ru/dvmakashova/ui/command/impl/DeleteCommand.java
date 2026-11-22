package ru.dvmakashova.ui.command.impl;

import ru.dvmakashova.ex.ValidationException;
import ru.dvmakashova.service.GarmentService;
import ru.dvmakashova.ui.ConsoleHelper;
import ru.dvmakashova.ui.command.Command;
import ru.dvmakashova.ui.command.CommandResult;
import ru.dvmakashova.util.NumberParser;

public class DeleteCommand implements Command {

    private static final String NAME = "delete";
    private static final int ARGS_COUNT = 1;
    private static final int ID_INDEX = 0;

    private final GarmentService service;
    private final ConsoleHelper helper;

    public DeleteCommand(GarmentService service, ConsoleHelper helper) {
        this.service = service;
        this.helper = helper;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return "Снять изделие с продажи";
    }

    @Override
    public String getUsage() {
        return "delete <id>";
    }

    @Override
    public CommandResult execute(String[] args) {
        if (args.length != ARGS_COUNT) {
            throw new ValidationException("Использование: " + getUsage());
        }
        long id = NumberParser.parseLong(args[ID_INDEX]);
        service.delete(id);
        helper.println("Изделие #" + id + " удалено");
        return CommandResult.CONTINUE;
    }
}
