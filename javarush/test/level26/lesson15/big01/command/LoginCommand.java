package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        while (true) {
            String enter = ConsoleHelper.readString();
            String pinCode = ConsoleHelper.readString();
            boolean card = enter.matches("\\d+") && enter.length() == 12;
            boolean pinc = pinCode.matches("\\d+") && pinCode.length() == 4;
            if (card && pinc) {
                if (validCreditCards.containsKey(enter) && validCreditCards.getString(enter).equals(pinCode)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), enter));
                    break;
                }
                else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), enter));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }
            } else ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
        }
    }
}
