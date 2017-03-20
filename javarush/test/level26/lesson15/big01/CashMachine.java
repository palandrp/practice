package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args) {
        try {
            CommandExecutor.execute(Operation.LOGIN);
            Locale.setDefault(Locale.ENGLISH);
            Operation task;
            do {
                task = ConsoleHelper.askOperation();
                CommandExecutor.execute(task);
            } while (task != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }
    }

}
