package com.s2u2m.study.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 将后面无序的部分插入到前面的有序部分
 */
public class InsertionSort {

    public void sort(int[] array) {
        var len = array.length;
        for (var i = 1; i < len; i++) {
            int preIndex = i - 1;
            int current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 38, 5, 44, 15, 36, 26, 27, 2, 46, 4, 19};
        new InsertionSort().sort(array);
        System.out.println(Arrays.stream(array).boxed().map(Object::toString).collect(Collectors.joining(" ")));
    }
}