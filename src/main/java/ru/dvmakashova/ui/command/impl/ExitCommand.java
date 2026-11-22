package ru.dvmakashova.ui.command.impl;

import ru.dvmakashova.ui.ConsoleHelper;
import ru.dvmakashova.ui.command.Command;
import ru.dvmakashova.ui.command.CommandResult;

public class ExitCommand implements Command {

    private static final String NAME = "exit";

    private final ConsoleHelper helper;

    public ExitCommand(ConsoleHelper helper) {
        this.helper = helper;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return "Выйти из программы";
    }

    @Override
    public String getUsage() {
        return NAME;
    }

    @Override
    public CommandResult execute(String[] args) {
        helper.println("До свидания!");
        return CommandResult.EXIT;
    }
}
