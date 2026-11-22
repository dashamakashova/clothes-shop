package ru.dvmakashova.ui.command.impl;

import ru.dvmakashova.ex.ValidationException;
import ru.dvmakashova.service.GarmentService;
import ru.dvmakashova.ui.GarmentPrinter;
import ru.dvmakashova.ui.command.Command;
import ru.dvmakashova.ui.command.CommandResult;
import ru.dvmakashova.util.NumberParser;

public class GetCommand implements Command {

    private static final String NAME = "get";
    private static final int ARGS_COUNT = 1;
    private static final int ID_INDEX = 0;

    private final GarmentService service;
    private final GarmentPrinter printer;

    public GetCommand(GarmentService service, GarmentPrinter printer) {
        this.service = service;
        this.printer = printer;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return "Показать изделие по id";
    }

    @Override
    public String getUsage() {
        return "get <id>";
    }

    @Override
    public CommandResult execute(String[] args) {
        if (args.length != ARGS_COUNT) {
            throw new ValidationException("Использование: " + getUsage());
        }
        printer.print(service.getById(NumberParser.parseLong(args[ID_INDEX])));
        return CommandResult.CONTINUE;
    }
}
