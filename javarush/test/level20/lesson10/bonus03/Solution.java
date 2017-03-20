package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> a = detectAllWords(crossword, "home", "same");
        for (Word b : a) {
            System.out.println(b);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        int wordsCount = words.length;
        List<Word> list = new ArrayList<>();

        // loop for each word in words[]
        for (int i = 0; i < wordsCount; i++) {
            int wordLength = words[i].length();
            char first = words[i].charAt(0);
            Word thisWord = searchFirstLetter(crossword, words[i]);
            list.add(thisWord);
        }
        return list;
    }

    public static Word searchFirstLetter(int[][] crossword, String word) {
        for (int x = 0; x < crossword.length; x++) {
            for (int y = 0; y < crossword[x].length; y++) {
                if (crossword[x][y] == word.charAt(0)) {
                    Word thisWord = checkWord(crossword, word, x, y);
                    if (thisWord != null) return thisWord;
                }
            }
        }
        return null;
    }

    public static Word checkWord(int[][] cross, String word, int x, int y) {
        Word result = new Word(word);
        int count = 0;

        try {
            for (int i = x, j = y, k = 0; k < word.length(); k++, j++) {
                if (cross[i][j] == word.charAt(k)) {
                    count++;
                    if (count == word.length()) {
                        result.setStartPoint(y, x);
                        result.setEndPoint(j, i);
                        return result;
                    }
                } else break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        count = 0;

        try {
        for (int i = x, j = y, k = 0; k < word.length(); k++, i++) {
            if (cross[i][j] == word.charAt(k)) {
                count++;
                if (count == word.length()) {
                    result.setStartPoint(y, x);
                    result.setEndPoint(j, i);
                    return result;
                }
            }
            else break;
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        count = 0;

        try {
        for (int i = x, j = y, k = 0; k < word.length(); k++, j++, i++) {
            if (cross[i][j] == word.charAt(k)) {
                count++;
                if (count == word.length()) {
                    result.setStartPoint(y, x);
                    result.setEndPoint(j, i);
                    return result;
                }
            }
            else break;
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        count = 0;

        try {
        for (int i = x, j = y, k = 0; k < word.length(); k++, j--) {
            if (cross[i][j] == word.charAt(k)) {
                count++;
                if (count == word.length()) {
                    result.setStartPoint(y, x);
                    result.setEndPoint(j, i);
                    return result;
                }
            }
            else break;
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        count = 0;

        try {
        for (int i = x, j = y, k = 0; k < word.length(); k++, i--) {
            if (cross[i][j] == word.charAt(k)) {
                count++;
                if (count == word.length()) {
                    result.setStartPoint(y, x);
                    result.setEndPoint(j, i);
                    return result;
                }
            }
            else break;
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        count = 0;

        try {
        for (int i = x, j = y, k = 0; k < word.length(); k++, j--, i--) {
            if (cross[i][j] == word.charAt(k)) {
                count++;
                if (count == word.length()) {
                    result.setStartPoint(y, x);
                    result.setEndPoint(j, i);
                    return result;
                }
            }
            else break;
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        count = 0;

        try {
        for (int i = x, j = y, k = 0; k < word.length(); k++, j++, i--) {
            if (cross[i][j] == word.charAt(k)) {
                count++;
                if (count == word.length()) {
                    result.setStartPoint(y, x);
                    result.setEndPoint(j, i);
                    return result;
                }
            }
            else break;
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        count = 0;

        try {
        for (int i = x, j = y, k = 0; k < word.length(); k++, j--, i++) {
            if (cross[i][j] == word.charAt(k)) {
                count++;
                if (count == word.length()) {
                    result.setStartPoint(y, x);
                    result.setEndPoint(j, i);
                    return result;
                }
            }
            else break;
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
