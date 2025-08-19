package com.mc.algorithm.d_datastructure;

import java.util.ArrayList;

public class Run {

  public static void main(String[] args) {
    System.out.println(init());
    testGet();
    testRemove();
    testForEach();
  }

  private static void testForEach() {
    _ArrayList<Integer> list = init();
  }

  private static void testRemove() {
    _ArrayList<Integer> list = init();

    for (int i = 5; i < 8; i++) {
      list.remove(i);
    }
    System.out.println(list);
  }

  private static void testGet() {
    _ArrayList<Integer> list = init();
    for (int i = 5; i < 8; i++) {
      System.out.println(list.get(i));
    }

  }

  private static _ArrayList<Integer> init() {
    _ArrayList<Integer> list = new _ArrayList<Integer>();
    for (int i = 0; i < 15; i++) {
      list.add(i);
    }
    return list;
  }
}
