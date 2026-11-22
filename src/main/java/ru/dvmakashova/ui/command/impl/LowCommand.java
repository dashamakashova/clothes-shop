package ru.dvmakashova.ui.command.impl;

import ru.dvmakashova.service.GarmentService;
import ru.dvmakashova.ui.GarmentPrinter;
import ru.dvmakashova.ui.command.Command;
import ru.dvmakashova.ui.command.CommandResult;

public class LowCommand implements Command {

    private static final String NAME = "low";

    private final GarmentService service;
    private final GarmentPrinter printer;

    public LowCommand(GarmentService service, GarmentPrinter printer) {
        this.service = service;
        this.printer = printer;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return "Что пора шить: изделия, которых мало или нет";
    }

    @Override
    public String getUsage() {
        return NAME;
    }

    @Override
    public CommandResult execute(String[] args) {
        printer.printAll(service.findNeedingRestock());
        return CommandResult.CONTINUE;
    }
}
