package edu.buet.cse.spring.interview.ch02.v6;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import edu.buet.cse.spring.interview.ch02.v6.service.impl.BubbleSortAlgorithm;
import edu.buet.cse.spring.interview.ch02.v6.service.impl.IntArrayGeneratorImpl;
import edu.buet.cse.spring.interview.ch02.v6.service.impl.SelectionSortAlgorithm;

@SpringBootTest
public class MyApplicationTests {

  @Autowired
  private ApplicationContext appContext;

  @Autowired
  private IntArrayGeneratorImpl intArrayGenerator;

  @Test
  public void testBubbleSort() {
    int[] values = intArrayGenerator.generateValues();

    BubbleSortAlgorithm bubbleSort = appContext.getBean(BubbleSortAlgorithm.class);
    bubbleSort.sort(values);

    for (int i = 0; i <= values.length - 2; i++) {
      assertTrue(values[i] <= values[i + 1], "Array is not sorted");
    }
  }

  @Test
  public void testSelectionSort() {
    int[] values = intArrayGenerator.generateValues();

    SelectionSortAlgorithm selectionSort = appContext.getBean(SelectionSortAlgorithm.class);
    selectionSort.sort(values);

    for (int i = 0; i <= values.length - 2; i++) {
      assertTrue(values[i] <= values[i + 1], "Array is not sorted");
    }
  }
}
