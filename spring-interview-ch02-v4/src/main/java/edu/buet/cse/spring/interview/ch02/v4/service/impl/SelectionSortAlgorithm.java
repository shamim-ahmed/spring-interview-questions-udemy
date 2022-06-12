package edu.buet.cse.spring.interview.ch02.v4.service.impl;

import org.springframework.stereotype.Component;

import edu.buet.cse.spring.interview.ch02.v4.service.SortAlgorithm;

@Component(value = "selectionSortAlgorithm")
public class SelectionSortAlgorithm implements SortAlgorithm {

  @Override
  public void sort(int[] values) {
    if (values == null) {
      return;
    }

    for (int i = 0; i <= values.length - 2; i++) {
      int minValue = values[i];
      int minIndex = i;

      for (int j = i + 1; j <= values.length - 1; j++) {
        if (values[j] < minValue) {
          minValue = values[j];
          minIndex = j;
        }
      }

      if (minIndex != i) {
        swap(values, i, minIndex);
      }
    }
  }
}
