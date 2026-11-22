package ru.dvmakashova.ui.command.impl;

import ru.dvmakashova.service.GarmentService;
import ru.dvmakashova.ui.GarmentPrinter;
import ru.dvmakashova.ui.command.Command;
import ru.dvmakashova.ui.command.CommandResult;

public class ListCommand implements Command {

    private static final String NAME = "list";

    private final GarmentService service;
    private final GarmentPrinter printer;

    public ListCommand(GarmentService service, GarmentPrinter printer) {
        this.service = service;
        this.printer = printer;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return "Показать все изделия";
    }

    @Override
    public String getUsage() {
        return NAME;
    }

    @Override
    public CommandResult execute(String[] args) {
        printer.printAll(service.getAll());
        return CommandResult.CONTINUE;
    }
}
