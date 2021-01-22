package com.s2u2m.study.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {

    public void sort(int[] array) {
        var len = array.length;
        for (var i = 0; i < len - 1; i++) {
            for (var j = 0; j < len - 1 - i; j++) {
                // 相邻元素两两对比, 大的元素往后移
                if (array[j] > array[j + 1]) {
                    var temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 38, 5, 44, 15, 36, 26, 27, 2, 46, 4, 19};
        new BubbleSort().sort(array);
        System.out.println(Arrays.stream(array).boxed().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
