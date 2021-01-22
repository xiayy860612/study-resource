package com.s2u2m.study.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {
    public void sort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1; // (left + right) / 2

        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);

    }

    private void merge(int[] array, int left, int mid, int right) {
        // 将值按顺序放入中间数组, 最后再将中间数据拷贝回去
        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid)   temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        System.arraycopy(temp, 0, array, left, temp.length);
    }

    public static void main(String[] args) {
        int[] array = new int[] {3, 38, 5, 44, 15, 36, 26, 27, 2, 46, 4, 19};
        new MergeSort().sort(array, 0, array.length - 1);
        System.out.println(Arrays.stream(array).boxed().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
