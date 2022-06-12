package edu.buet.cse.spring.interview.ch02.service.impl;

import org.springframework.stereotype.Component;

import edu.buet.cse.spring.interview.ch02.service.SearchService;

@Component(value = "binarySearchService")
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
