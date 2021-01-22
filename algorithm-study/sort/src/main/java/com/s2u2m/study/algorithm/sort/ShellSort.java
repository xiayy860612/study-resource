package com.s2u2m.study.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 通过增量序列进行排序
 */
public class ShellSort {
    public void sort(int[] array) {
        var len = array.length;
        for (var gap = (int) Math.floor(len * 1.0/2); gap > 0; gap = (int) Math.floor(gap * 1.0/2)) {
            for (int i = gap; i < len; ++i) {
                int pre = i - gap;
                int cur = array[i];
                while (pre >= 0 && array[pre] > cur) {
                    array[pre + gap] = array[pre];
                    pre -= gap;
                }
                array[pre + gap] = cur;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3, 38, 5, 44, 15, 36, 26, 27, 2, 46, 4, 19};
        new ShellSort().sort(array);
        System.out.println(Arrays.stream(array).boxed().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
