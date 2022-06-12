package edu.buet.cse.spring.interview.ch02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.buet.cse.spring.interview.ch02.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.service.SearchService;
import edu.buet.cse.spring.interview.ch02.service.SortAlgorithm;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

  @Autowired
  private IntArrayGenerator intArrayGenerator;
  
  @Autowired
  @Qualifier(value = "bubbleSortAlgorithm")
  private SortAlgorithm sortAlgorithm;

  @Autowired
  @Qualifier(value = "binarySearchService")
  private SearchService searchService;

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public void run(String... args) {

    int[] values = intArrayGenerator.generateValues();
    sortAlgorithm.sort(values);

    int index = searchService.search(values, 69);
    logger.info(String.format("The index is %d", index));
  }

  public static void main(String[] args) {
    SpringApplication.run(MyApplication.class, args);
  }
}
