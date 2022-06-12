package edu.buet.cse.spring.interview.ch02.v2.service.impl;

import edu.buet.cse.spring.interview.ch02.v2.service.SearchService;

public class BinarySearchService implements SearchService {
  @Override
  public int search(int[] values, int n) {
    int result = -1;
    int i = 0;
    int j = values.length - 1;

    while (i <= j) {
      int mid = (i + j) / 2;

      if (n == values[mid]) {
        result = mid;
        break;
      }

      if (n < values[mid]) {
        j = mid - 1;
      }

      if (n > values[mid]) {
        i = mid + 1;
      }
    }

    return result;
  }
}
