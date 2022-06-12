package edu.buet.cse.spring.interview.ch02.v1.service.impl;

import org.springframework.stereotype.Component;

import edu.buet.cse.spring.interview.ch02.v1.service.SortAlgorithm;

@Component(value = "bubbleSortAlgorithm")
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
