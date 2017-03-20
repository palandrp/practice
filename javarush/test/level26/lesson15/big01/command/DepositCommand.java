package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        String currency = ConsoleHelper.askCurrencyCode();
        String[] nums = ConsoleHelper.getValidTwoDigits(currency);
        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency).addAmount(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
    }
}
