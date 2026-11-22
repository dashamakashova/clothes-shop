package ru.dvmakashova.ui.command;

import ru.dvmakashova.service.GarmentService;
import ru.dvmakashova.ui.ConsoleHelper;
import ru.dvmakashova.ui.GarmentPrinter;
import ru.dvmakashova.ui.command.impl.AddCommand;
import ru.dvmakashova.ui.command.impl.DeleteCommand;
import ru.dvmakashova.ui.command.impl.ExitCommand;
import ru.dvmakashova.ui.command.impl.GetCommand;
import ru.dvmakashova.ui.command.impl.HelpCommand;
import ru.dvmakashova.ui.command.impl.ListCommand;
import ru.dvmakashova.ui.command.impl.LowCommand;
import ru.dvmakashova.ui.command.impl.RestockCommand;
import ru.dvmakashova.ui.command.impl.SellCommand;

import java.util.ArrayList;
import java.util.List;

/** Создаёт все команды приложения. */
public class CommandFactory {

    private final GarmentService service;
    private final ConsoleHelper helper;

    public CommandFactory(GarmentService service, ConsoleHelper helper) {
        this.service = service;
        this.helper = helper;
    }

    public List<Command> createCommands() {
        GarmentPrinter printer = new GarmentPrinter(helper);

        List<Command> commands = new ArrayList<>();
        commands.add(new AddCommand(service, printer, helper));
        commands.add(new ListCommand(service, printer));
        commands.add(new GetCommand(service, printer));
        commands.add(new DeleteCommand(service, helper));
        commands.add(new SellCommand(service, printer, helper));
        commands.add(new RestockCommand(service, printer, helper));
        commands.add(new LowCommand(service, printer));
        // help печатает этот же список, поэтому он создаётся после остальных
        commands.add(new HelpCommand(commands, helper));
        commands.add(new ExitCommand(helper));
        return commands;
    }
}
