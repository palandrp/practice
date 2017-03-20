package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        final int median = (array.length % 2 == 0)
                ? (array[array.length / 2] + array[array.length / 2 - 1]) / 2
                :  array[array.length / 2];

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int distanse1 = Math.abs(median - o1);
                int distanse2 = Math.abs(median - o2);
                if (distanse1 != distanse2) return distanse1 - distanse2;
                else return o1 - o2;
            }
        });
        return array;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 7, 7, 8, 9, 10};
        Integer[] arr2 = sort(arr);
        for (Integer i : arr2) {
            System.out.println(i);
        }
    }

}
