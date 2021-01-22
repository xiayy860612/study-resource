package com.s2u2m.study.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectionSort {

    public void sort(int[] array) {
        var len = array.length;
        for(var i = 0; i < len - 1; i++) {
            int minIndex = i;
            for(var j = i + 1; j < len; j++) {
                if(array[j] < array[minIndex]) {     // 寻找最小的数
                    minIndex = j;                 // 将最小数的索引保存
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3, 38, 5, 44, 15, 36, 26, 27, 2, 46, 4, 19};
        new SelectionSort().sort(array);
        System.out.println(Arrays.stream(array).boxed().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
