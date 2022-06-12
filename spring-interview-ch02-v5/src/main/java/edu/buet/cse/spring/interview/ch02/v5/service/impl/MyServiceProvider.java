package edu.buet.cse.spring.interview.ch02.v5.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.buet.cse.spring.interview.ch02.v5.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.v5.service.SearchService;
import edu.buet.cse.spring.interview.ch02.v5.service.SortAlgorithm;

public class MyServiceProvider {
  private final Logger logger = LogManager.getLogger(getClass());

  private final IntArrayGenerator intArrayGenerator;
  private final SortAlgorithm sortAlgorithm;
  private final SearchService searchService;

  public MyServiceProvider(IntArrayGenerator intArrayGenerator, SortAlgorithm sortAlgorithm,
      SearchService searchService) {
    this.intArrayGenerator = intArrayGenerator;
    this.sortAlgorithm = sortAlgorithm;
    this.searchService = searchService;
  }

  public void runService() {
    int[] values = intArrayGenerator.generateValues();
    sortAlgorithm.sort(values);

    int index = searchService.search(values, 69);
    logger.info(String.format("The index is %d", index));
  }
}
