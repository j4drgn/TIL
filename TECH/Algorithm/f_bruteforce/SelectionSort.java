package com.mc.algorithm.f_bruteforce;

import com.mc.algorithm.util.SortUtil;

public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = SortUtil.createRandamIntArray(100000);
    SortUtil.checkTime(() -> {
      selectionSort(arr);
//      System.out.println(arr);
    });
  }

  private static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIndex = indexOfmin(arr, i);
      SortUtil.swap(arr, i, minIndex);
    }

  }

  private static int indexOfmin(int[] arr, int pointer) {
    int min = pointer;
    for (int i = pointer + 1; i < arr.length; i++) {
      if (arr[min] > arr[i]) {
        min = i;
      }
    }
    return min;
  }

}
