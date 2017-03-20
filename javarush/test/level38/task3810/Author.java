package com.javarush.task.task38.task3810;

import java.beans.Transient;
import java.lang.annotation.Retention;

public @interface Author {
    String value();
    Position position() default Position.OTHER;
}
