package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        List<LogEntry> list = getAllEntries(logDir);
        Set<String> set = new HashSet<>();
        for (LogEntry entry : list) {
            if (after == null && before == null) set.add(entry.ip);
            else if (after == null) {
                if (entry.date.compareTo(before) <= 0) set.add(entry.ip);
            } else if (before == null) {
                if (entry.date.compareTo(after) >= 0) set.add(entry.ip);
            } else if (entry.date.compareTo(after) >= 0 && entry.date.compareTo(before) <= 0) set.add(entry.ip);
        }
        return set.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        List<LogEntry> list = getAllEntries(logDir);
        return list.stream()
                .filter(s -> {
                    if (after == null && before == null) return true;
                    if (before == null) return s.date.compareTo(after) >= 0;
                    if (after == null) return s.date.compareTo(before) <= 0;
                    else return (s.date.compareTo(before) <= 0 && s.date.compareTo(after) >= 0);
                })
                .map(s -> s.ip)
                .distinct()
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        List<LogEntry> list = getAllEntries(logDir);
            return list.stream()
                .filter(s -> {
                    if (after == null && before == null) return true;
                    if (before == null) return s.date.compareTo(after) >= 0;
                    if (after == null) return s.date.compareTo(before) <= 0;
                    else return (s.date.compareTo(before) <= 0 && s.date.compareTo(after) >= 0);
                })
                .filter(s -> s.username.equals(user))
                .map(s -> s.ip)
                .distinct()
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        List<LogEntry> list = getAllEntries(logDir);
        return list.stream()
                .filter(s -> {
                    if (after == null && before == null) return true;
                    if (before == null) return s.date.compareTo(after) >= 0;
                    if (after == null) return s.date.compareTo(before) <= 0;
                    else return (s.date.compareTo(before) <= 0 && s.date.compareTo(after) >= 0);
                })
                .filter(s -> s.event.equals(event))
                .map(s -> s.ip)
                .distinct()
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        List<LogEntry> list = getAllEntries(logDir);
        return list.stream()
                .filter(s -> {
                    if (after == null && before == null) return true;
                    if (before == null) return s.date.compareTo(after) >= 0;
                    if (after == null) return s.date.compareTo(before) <= 0;
                    else return (s.date.compareTo(before) <= 0 && s.date.compareTo(after) >= 0);
                })
                .filter(s -> s.status.equals(status))
                .map(s -> s.ip)
                .distinct()
                .collect(Collectors.toSet());
    }

    private List<LogEntry> getAllEntries(Path dir) {
        List<String> list = new LinkedList<>();
        try {
            List<Path> files = Files.list(logDir).collect(Collectors.toList());
            for (Path path : files) {
                if (path.getFileName().toString().endsWith(".log")) list.addAll(Files.readAllLines(path));
            }
        } catch (IOException ignored) {}

        List<LogEntry> entries = new ArrayList<>();

        for (String s : list) {
            String name = ParseHelper.parseName(s);
            String ip = ParseHelper.parseIP(s);
            Date date = ParseHelper.parseDate(s);
            Event event = ParseHelper.parseEvent(s);
            Status status = ParseHelper.parseStatus(s);
            LogEntry entry = new LogEntry(ip, name, date, event, status);
            entries.add(entry);
        }

        return entries;
    }


    public class LogEntry {
        private String ip;
        private String username;
        private Date date;
        private Event event;
        private Status status;

        public LogEntry(String ip, String username, Date date, Event event, Status status) {
            this.ip = ip;
            this.username = username;
            this.date = date;
            this.event = event;
            this.status = status;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "ip='" + ip + '\'' +
                    ", username='" + username + '\'' +
                    ", date=" + date +
                    ", event=" + event +
                    ", status=" + status +
                    '}';
        }
    }
}