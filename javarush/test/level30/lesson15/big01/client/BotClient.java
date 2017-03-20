package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int number = (int) (Math.random() * 100);
        return "date_bot_" + number;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
            ConsoleHelper.writeMessage(message);
            String[] data = message.split(": ");
            if (data.length < 2) return;
            switch (data[1]) {
                case "дата":
                    dateFormat.applyPattern("d.MM.YYYY");
                    break;
                case "день":
                    dateFormat.applyPattern("d");
                    break;
                case "месяц":
                    dateFormat.applyPattern("MMMM");
                    break;
                case "год":
                    dateFormat.applyPattern("YYYY");
                    break;
                case "время":
                    dateFormat.applyPattern("H:mm:ss");
                    break;
                case "час":
                    dateFormat.applyPattern("H");
                    break;
                case "минуты":
                    dateFormat.applyPattern("m");
                    break;
                case "секунды":
                    dateFormat.applyPattern("s");
                    break;
                default:
                    return;
            }
            sendTextMessage("Информация для " + data[0] + ": " + dateFormat.format(Calendar.getInstance().getTime()));
        }
    }

}
