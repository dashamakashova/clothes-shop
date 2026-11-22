package ru.dvmakashova.ui.command;

public interface Command {

    /** Слово, которым команда вызывается в консоли. */
    String getName();

    String getDescription();

    /** Как вызывать команду, например «sell <id> <amount>». */
    String getUsage();

    CommandResult execute(String[] args);
}
