package edu.buet.cse.spring.interview.ch02.v4.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.buet.cse.spring.interview.ch02.v4.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.v4.service.SearchService;
import edu.buet.cse.spring.interview.ch02.v4.service.SortAlgorithm;

@Component("myServiceProvider")
public class MyServiceProvider {
  private final Logger logger = LogManager.getLogger(getClass());
  
  private final IntArrayGenerator intArrayGenerator;
  private final SortAlgorithm sortAlgorithm;
  private final SearchService searchService;

  @Autowired
  public MyServiceProvider(@Qualifier("intArrayGenerator") IntArrayGenerator intArrayGenerator,
      @Qualifier("bubbleSortAlgorithm") SortAlgorithm sortAlgorithm,
      @Qualifier("binarySearchService") SearchService searchService) {
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
