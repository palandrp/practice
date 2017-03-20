package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public static final class Constants {
        final static String messageSNA = "Server is not accessible for now.";
        final static String messageUUE = "User is not authorized.";
        final static String messageBUE = "User is banned.";
        final static String messageRE = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.messageSNA);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.messageSNA, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.messageUUE);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.messageUUE, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.messageBUE);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.messageBUE, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.messageRE);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.messageRE, cause);
        }
    }
}
