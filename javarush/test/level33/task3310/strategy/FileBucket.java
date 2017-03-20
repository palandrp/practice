package com.javarush.task.task33.task3310.strategy;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try
        {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        }
        catch (IOException e) {}
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            return 0L;
        }
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(entry);
        } catch (IOException ignored) {}
    }

    public Entry getEntry() {
        if (getFileSize() == 0) return null;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return (Entry) ois.readObject();
        } catch (IOException|ClassNotFoundException ignored) {}
        return null;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException ignored) {}
    }



}
