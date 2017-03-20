package com.javarush.task.task39.task3913;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseHelper {
    private final static String REGEX_DATE = "((\\d{1,2}\\.){1,2})(\\d{4}) (\\d{1,2}\\:){1,2}(\\d{1,2})";
    private final static String REGEX_IP = "(\\d{1,3}\\.){3}(\\d{1,3})";
    private final static String REGEX_NAME = "(\\.\\d{1,3}\\s+)([\\s\\S]+?)(\\s+\\d{2}.)";
    private final static String REGEX_EVENT = "LOGIN|DOWNLOAD_PLUGIN|WRITE_MESSAGE|SOLVE_TASK|DONE_TASK";
    private final static String REGEX_STATUS = "OK|FAILED|ERROR";

    public static Date parseDate(String s) {
        Matcher m = Pattern.compile(REGEX_DATE).matcher(s);
        m.find();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = new Date();
        try {
            date = sdf.parse(m.group(0));
        } catch (ParseException ignored) {}
        return date;
    }

    public static String parseIP(String s) {
        Matcher m = Pattern.compile(REGEX_IP).matcher(s);
        m.find();
        String ip = m.group(0);
        return ip;
    }

    public static String parseName(String s) {
        Matcher m = Pattern.compile(REGEX_NAME).matcher(s);
        m.find();
        String name = m.group(2);
        return name;
    }

    public static Event parseEvent(String s) {
        Matcher m = Pattern.compile(REGEX_EVENT).matcher(s);
        m.find();
        Event event = Event.valueOf(m.group(0));
        return event;
    }

    public static Status parseStatus(String s) {
        Matcher m = Pattern.compile(REGEX_STATUS).matcher(s);
        m.find();
        Status status = Status.valueOf(m.group(0));
        return status;
    }
}
