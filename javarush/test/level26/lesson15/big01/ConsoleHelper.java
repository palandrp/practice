package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = null;
        try {
            result = in.readLine();
            if (result.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        }
        catch (IOException ignored) {
        }
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        while (true) {
            String in = readString();
            if (in.length() == 3) return in.toUpperCase();
            else writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        writeMessage(res.getString("choose.denomination.and.count.format"));
        while (true) {
            String in = readString();
            String[] arr = in.split(" ");
            if (arr.length == 2 && arr[0].matches("\\d+") && arr[1].matches("\\d+")) {
                return arr;
            }
            else writeMessage(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation()  throws InterruptOperationException{
        String message = res.getString("choose.operation") + "\n" +
                "1 :" + res.getString("operation.INFO") + "\n" +
                "2 :" + res.getString("operation.DEPOSIT") + "\n" +
                "3 :" + res.getString("operation.WITHDRAW") + "\n" +
                "4 :" + res.getString("operation.EXIT");
        writeMessage(message);
        Operation result;
        while (true) {
            try {
                result = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                return result;
            } catch (IllegalArgumentException e) {
                System.out.println(message);
            }
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
