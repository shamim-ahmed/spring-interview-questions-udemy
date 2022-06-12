package edu.buet.cse.spring.interview.ch02.v1.service;

public interface SortAlgorithm {
  void sort(int[] values);
  
  default void swap(int[] values, int i, int j) {
    int temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  }
}
