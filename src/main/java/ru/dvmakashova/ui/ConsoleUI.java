package ru.dvmakashova.ui;

import ru.dvmakashova.ex.AppException;
import ru.dvmakashova.ui.command.Command;
import ru.dvmakashova.ui.command.CommandResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Читает строки из консоли и передаёт их командам. */
public class ConsoleUI {

    private static final String PROMPT = "> ";
    private static final String SEPARATOR_REGEX = "\\s+";
    private static final int COMMAND_NAME_INDEX = 0;
    private static final int FIRST_ARG_INDEX = 1;

    private final Map<String, Command> commands = new HashMap<>();
    private final ConsoleHelper helper;

    public ConsoleUI(List<Command> commandList, ConsoleHelper helper) {
        this.helper = helper;
        for (Command command : commandList) {
            commands.put(command.getName(), command);
        }
    }

    public void start() {
        helper.println("Магазин одежды собственного производства. Введите help для списка команд.");
        CommandResult result = CommandResult.CONTINUE;
        while (result == CommandResult.CONTINUE) {
            helper.print(PROMPT);
            if (!helper.hasNextLine()) {
                return;
            }
            result = handleLine(helper.readLine());
        }
    }

    private CommandResult handleLine(String line) {
        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            return CommandResult.CONTINUE;
        }
        String[] words = trimmed.split(SEPARATOR_REGEX);
        Command command = commands.get(words[COMMAND_NAME_INDEX].toLowerCase());
        if (command == null) {
            helper.printError("Неизвестная команда. Введите help для списка команд.");
            return CommandResult.CONTINUE;
        }
        String[] args = Arrays.copyOfRange(words, FIRST_ARG_INDEX, words.length);
        return execute(command, args);
    }

    private CommandResult execute(Command command, String[] args) {
        try {
            return command.execute(args);
        } catch (AppException e) {
            helper.printError(e.getMessage());
            return CommandResult.CONTINUE;
        }
    }
}
