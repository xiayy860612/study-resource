package com.s2u2m.study.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {

    public void sort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        sort(array, begin, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = end;
        // 快慢指针, 找出pivot的位置
        int slow = begin;
        for (int fast = begin; fast < end; fast++) {
            if (array[fast] < array[pivot]) {
                int temp = array[slow]; array[slow] = array[fast]; array[fast] = temp;
                slow++;
            }
        }
        int temp = array[pivot]; array[pivot] = array[slow]; array[slow] = temp;
        return slow;
    }

    public static void main(String[] args) {
        int[] array = new int[] {3, 38, 5, 44, 15, 36, 26, 27, 2, 46, 4, 19};
        new QuickSort().sort(array, 0, array.length - 1);
        System.out.println(Arrays.stream(array).boxed().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
