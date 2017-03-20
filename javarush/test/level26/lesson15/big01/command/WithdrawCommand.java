package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String cur = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator mn = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(cur);
        Map<Integer, Integer> result;
        while (true) {
            int needAmount = 0;
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            while (true) {
                try {
                    needAmount = Integer.parseInt(ConsoleHelper.readString());
                    if (mn.isAmountAvailable(needAmount)) break;
                    else throw new NotEnoughMoneyException();
                } catch (NotEnoughMoneyException e) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                } catch (IllegalArgumentException e) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                }
            }
            try {
                result = mn.withdrawAmount(needAmount);
                break;
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
        for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
            ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
        }
    }
}
