package edu.buet.cse.spring.interview.ch02.v6.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.buet.cse.spring.interview.ch02.v6.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.v6.service.SearchService;
import edu.buet.cse.spring.interview.ch02.v6.service.SortAlgorithm;

@Component("myServiceProvider")
public class MyServiceProvider {
  private final Logger logger = LogManager.getLogger(getClass());

  // auto-wiring by type
  @Autowired
  private IntArrayGenerator intArrayGenerator;

  // auto-wiring by name
  @Autowired
  private SortAlgorithm bubbleSortAlgorithm;

  // auto-wiring by type
  @Autowired
  private SearchService searchService;

  public void runService() {
    int[] values = intArrayGenerator.generateValues();
    bubbleSortAlgorithm.sort(values);

    int index = searchService.search(values, 69);
    logger.info(String.format("The index is %d", index));
  }
}
