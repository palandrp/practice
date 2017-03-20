package com.javarush.task.task38.task3804;

/**
 * Created by Naatsms on 20.02.2017.
 */
public class ExceptionFactory {

    public static Throwable getException(Enum en) {
        if (en == null) return new IllegalArgumentException();
        String message = en.toString().replaceAll("_", " ");
        message = message.replace(message.substring(1), message.substring(1).toLowerCase());
        String name = en.getClass().getSimpleName();
        switch (name) {
            case "ExceptionApplicationMessage":
                return new Exception(message);
            case "ExceptionDBMessage":
                return new RuntimeException(message);
            case "ExceptionUserMessage":
                return new Error(message);
            default: return new IllegalArgumentException();
        }
    }

}
