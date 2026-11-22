package ru.dvmakashova;

import ru.dvmakashova.repository.GarmentRepository;
import ru.dvmakashova.repository.impl.InMemoryGarmentRepository;
import ru.dvmakashova.service.GarmentService;
import ru.dvmakashova.service.impl.GarmentServiceImpl;
import ru.dvmakashova.ui.ConsoleHelper;
import ru.dvmakashova.ui.ConsoleUI;
import ru.dvmakashova.ui.command.CommandFactory;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GarmentRepository repository = new InMemoryGarmentRepository();
        GarmentService service = new GarmentServiceImpl(repository);

        ConsoleHelper helper = new ConsoleHelper(new Scanner(System.in, StandardCharsets.UTF_8));
        ConsoleUI ui = new ConsoleUI(new CommandFactory(service, helper).createCommands(), helper);
        ui.start();
    }
}
