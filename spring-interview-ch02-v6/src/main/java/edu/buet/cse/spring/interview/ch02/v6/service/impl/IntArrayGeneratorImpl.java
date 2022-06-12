package edu.buet.cse.spring.interview.ch02.v6.service.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import edu.buet.cse.spring.interview.ch02.v6.service.IntArrayGenerator;

@Component("intArrayGenerator")
public class IntArrayGeneratorImpl implements IntArrayGenerator {
  private static final int MAX = 100;
  private static final int SIZE = 25;
  private static final long SEED = 7L;

  @Override
  public int[] generateValues() {
    int[] values = new int[SIZE];
    Random randomGenerator = new Random(SEED);

    for (int i = 0; i < values.length; i++) {
      values[i] = 1 + randomGenerator.nextInt(MAX);
    }

    return values;
  }
}
