package edu.buet.cse.spring.interview.ch02.v3.service.impl;

import edu.buet.cse.spring.interview.ch02.v3.service.SortAlgorithm;

public class BubbleSortAlgorithm implements SortAlgorithm {

  @Override
  public void sort(int[] values) {
    if (values == null) {
      return;
    }

    for (int i = 0; i <= values.length - 1; i++) {
      for (int j = 0; j <= values.length - 2 - i; j++) {
        if (values[j] > values[j + 1]) {
          swap(values, j, j + 1);
        }
      }
    }
  }
}
