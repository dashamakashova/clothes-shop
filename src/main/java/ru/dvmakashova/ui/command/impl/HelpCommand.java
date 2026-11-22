package ru.dvmakashova.ui.command.impl;

import ru.dvmakashova.ui.ConsoleHelper;
import ru.dvmakashova.ui.command.Command;
import ru.dvmakashova.ui.command.CommandResult;

import java.util.List;

public class HelpCommand implements Command {

    private static final String NAME = "help";

    private final List<Command> commands;
    private final ConsoleHelper helper;

    public HelpCommand(List<Command> commands, ConsoleHelper helper) {
        this.commands = commands;
        this.helper = helper;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return "Показать список команд";
    }

    @Override
    public String getUsage() {
        return NAME;
    }

    @Override
    public CommandResult execute(String[] args) {
        helper.println("Доступные команды:");
        for (Command command : commands) {
            helper.println("  " + command.getUsage() + " — " + command.getDescription());
        }
        return CommandResult.CONTINUE;
    }
}
