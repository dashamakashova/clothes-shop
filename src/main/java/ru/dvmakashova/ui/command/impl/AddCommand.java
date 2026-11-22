package ru.dvmakashova.ui.command.impl;

import ru.dvmakashova.entity.Category;
import ru.dvmakashova.entity.Garment;
import ru.dvmakashova.ex.ValidationException;
import ru.dvmakashova.service.GarmentService;
import ru.dvmakashova.ui.ConsoleHelper;
import ru.dvmakashova.ui.GarmentPrinter;
import ru.dvmakashova.ui.command.Command;
import ru.dvmakashova.ui.command.CommandResult;
import ru.dvmakashova.util.NumberParser;

public class AddCommand implements Command {

    private static final String NAME = "add";
    private static final int ARGS_COUNT = 5;
    private static final int NAME_INDEX = 0;
    private static final int CATEGORY_INDEX = 1;
    private static final int SIZE_INDEX = 2;
    private static final int PRICE_INDEX = 3;
    private static final int QUANTITY_INDEX = 4;

    private final GarmentService service;
    private final GarmentPrinter printer;
    private final ConsoleHelper helper;

    public AddCommand(GarmentService service, GarmentPrinter printer, ConsoleHelper helper) {
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
        return "Добавить изделие (название без пробелов, категория: T_SHIRT, SHIRT, HOODIE, JEANS, DRESS, JACKET)";
    }

    @Override
    public String getUsage() {
        return "add <name> <category> <size> <price> <quantity>";
    }

    @Override
    public CommandResult execute(String[] args) {
        if (args.length != ARGS_COUNT) {
            throw new ValidationException("Использование: " + getUsage());
        }
        Garment garment = service.add(
                args[NAME_INDEX],
                Category.parse(args[CATEGORY_INDEX]),
                args[SIZE_INDEX],
                NumberParser.parseInt(args[PRICE_INDEX]),
                NumberParser.parseInt(args[QUANTITY_INDEX]));
        helper.println("Изделие добавлено:");
        printer.print(garment);
        return CommandResult.CONTINUE;
    }
}
