package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);

        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recursion(s, 0);

        s = "0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recursion(s, 0);

        s = "0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);

        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recursion(s, 0);

        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recursion(s, 0);

        s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recursion(s, 0);

        s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recursion(s, 0);

        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recursion(s, 0);

        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);

        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0);

        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);

        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0);

        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);

        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);

        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);

        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recursion(s, 0);

        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);

        s = "-(-2^(-2))+2+(-(-2^(-2)))";
        System.out.print(s + " expected output 2.5 10 actually ");
        solution.recursion(s, 0);

        s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);

        s = "(-2)*(-2)";
        System.out.print(s + " expected output 4 3 actually ");
        solution.recursion(s, 0);

        s = "(-2)/(-2)";
        System.out.print(s + " expected output 1 3 actually ");
        solution.recursion(s, 0);

        s = "sin(-30)";
        System.out.print(s + " expected output -0.5 2 actually ");
        solution.recursion(s, 0);

        s = "cos(-30)";
        System.out.print(s + " expected output 0.87 2 actually ");
        solution.recursion(s, 0);

        s = "tan(-30)";
        System.out.print(s + " expected output -0.58 2 actually ");
        solution.recursion(s, 0);

        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);

        s = "2+8*(9/4-1.5)^(1+1)";
        System.out.print(s + " expected output 6.5 6 actually ");
        solution.recursion(s, 0);

        s = "0.005 ";
        System.out.print(s + " expected output 0.01 0 actually ");
        solution.recursion(s, 0);

        s = "0.0049 ";
        System.out.print(s + " expected output 0 0 actually ");
        solution.recursion(s, 0);

        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recursion(s, 0);

        s = "0+0.304";
        System.out.print(s + " expected output 0.3 1 actually ");
        solution.recursion(s, 0);

        s = "0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);

        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recursion(s, 0);

        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recursion(s, 0);

        s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recursion(s, 0);

        s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recursion(s, 0);

        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recursion(s, 0);

        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);

        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0);

        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);

        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0);

        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);

        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);

        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);

        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recursion(s, 0);

        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);

        s = "-(-22+22*2)";
        System.out.print(s + "expected output -22 4 actually ");
        solution.recursion(s,0);

        s = "-2^(-2)";
        System.out.print(s + "expected output -0.25 3 actually ");
        solution.recursion(s,0);

    }

    public void recursion(final String expression, int countOperation) {
        int count = countOperation;
        String regexDigit = "((-?)(\\d+)(\\.\\d+)?)";
        String regexTrig = "(sin|cos|tan)" + regexDigit;

        String sub = expression.replaceAll(" ", "").replaceAll("\\-\\-", "+").replaceAll("\\+\\+", "+");


        //считаем количество унарных минусов
        if (countOperation == 0) {
            Matcher minus = Pattern.compile("(\\(|^)(-)").matcher(sub);
            while (minus.find()) {
                count++;
            }
        }

        // проверяем на наличие скобок
        Matcher m = Pattern.compile("(\\(([^()]+)\\))").matcher(sub);
        boolean mFinded = m.find();
        if (mFinded) {
            sub = m.group(2);
        }

        // проверяем возведения в степень
        Matcher m2 = Pattern.compile(regexDigit + "([\\^])" + regexDigit).matcher(sub);
        while (m2.find()) {
            double a1 = Double.parseDouble(m2.group(1));
            double b1 = Double.parseDouble(m2.group(6));
            String subResult = m2.group(0);
            double result = BigDecimal.valueOf(Math.pow(a1, b1)).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (a1 < 0) {
                subResult = String.valueOf(-(result));
            } else subResult = String.valueOf(result);
            sub = m2.replaceFirst(subResult);
            count++;
            m2.reset(sub);
        }

        // проверяем действия с высоким приоритетом
        m2 = Pattern.compile(regexDigit + "([\\*\\/])" + regexDigit).matcher(sub);
        while (m2.find()) {
            double a1 = Double.parseDouble(m2.group(1));
            double b1 = Double.parseDouble(m2.group(6));
            String operator = m2.group(5);
            double result = 0;
            switch (operator) {
                case "*":
                    result = BigDecimal.valueOf(a1 * b1).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();;
                    break;
                case "/":
                    result = BigDecimal.valueOf(a1 / b1).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
                    break;
            }
            sub = m2.replaceFirst(Double.toString(result));
            count++;
            m2.reset(sub);
        }

        //проверяем тригонометрические операции
        m2.usePattern(Pattern.compile(regexTrig));
        m2.reset(sub);
        while (m2.find()) {
            double a1 = Double.parseDouble(m2.group(2));
            double a2 = Math.toRadians(a1);
            String operator = m2.group(1);
            String subResult = m2.group(0);
            double result = 0;
            switch (operator) {
                case "sin":
                    result = BigDecimal.valueOf(Math.sin(a2)).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
                    break;
                case "cos":
                    result = BigDecimal.valueOf(Math.cos(a2)).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
                    break;
                case "tan":
                    result = BigDecimal.valueOf(Math.tan(a2)).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
                    break;
            }
            sub = m2.replaceFirst(Double.toString(result));
            count++;
            m2.reset(sub);
        }

        //проверяем операции с низким приоритетом
        m2.usePattern(Pattern.compile(regexDigit + "([\\+\\-])" + regexDigit));
        m2.reset(sub);
        while (m2.find()) {
            double a1 = Double.parseDouble(m2.group(1));
            double b1 = Double.parseDouble(m2.group(6));
            String operator = m2.group(5);
            double result = 0;
            switch (operator) {
                case "+":
                    result = BigDecimal.valueOf(a1 + b1).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();;
                    break;
                case "-":
                    result = BigDecimal.valueOf(a1 - b1).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();;
                    break;
            }
            sub = m2.replaceFirst(Double.toString(result));
            count++;
            m2.reset(sub);
        }

        //если было выражение в скобках, заменяем его на результат вычислений
        String newExpression;
        if (mFinded) {
            newExpression = m.replaceFirst(sub);
        }
        //иначе заменяем все выражение на результат вычислений
        else {
            newExpression = sub;
        }


        if (countOperation == count && !mFinded) {
            DecimalFormat format = new DecimalFormat("###.##", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            format.setDecimalSeparatorAlwaysShown(false);
            format.setRoundingMode(RoundingMode.HALF_UP);
            double result = Double.parseDouble(newExpression);
            System.out.println(format.format(result) + " " + count);
        }
        else recursion(newExpression, count);
    }

    public Solution() {

    }
}
