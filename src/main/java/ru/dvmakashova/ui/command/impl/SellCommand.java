package ru.dvmakashova.ui.command.impl;

import ru.dvmakashova.ex.ValidationException;
import ru.dvmakashova.service.GarmentService;
import ru.dvmakashova.ui.ConsoleHelper;
import ru.dvmakashova.ui.GarmentPrinter;
import ru.dvmakashova.ui.command.Command;
import ru.dvmakashova.ui.command.CommandResult;
import ru.dvmakashova.util.NumberParser;

public class SellCommand implements Command {

    private static final String NAME = "sell";
    private static final int ARGS_COUNT = 2;
    private static final int ID_INDEX = 0;
    private static final int AMOUNT_INDEX = 1;

    private final GarmentService service;
    private final GarmentPrinter printer;
    private final ConsoleHelper helper;

    public SellCommand(GarmentService service, GarmentPrinter printer, ConsoleHelper helper) {
        this.service = service;
        this.printer = printer;
        this.helper = helper;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return "Продать изделие со склада";
    }

    @Override
    public String getUsage() {
        return "sell <id> <amount>";
    }

    @Override
    public CommandResult execute(String[] args) {
        if (args.length != ARGS_COUNT) {
            throw new ValidationException("Использование: " + getUsage());
        }
        long id = NumberParser.parseLong(args[ID_INDEX]);
        int total = service.sell(id, NumberParser.parseInt(args[AMOUNT_INDEX]));
        helper.println("Продано на сумму " + total + " руб.");
        printer.print(service.getById(id));
        return CommandResult.CONTINUE;
    }
}
