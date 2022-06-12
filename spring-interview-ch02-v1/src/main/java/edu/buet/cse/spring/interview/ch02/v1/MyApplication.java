package edu.buet.cse.spring.interview.ch02.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import edu.buet.cse.spring.interview.ch02.v1.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.v1.service.SearchService;
import edu.buet.cse.spring.interview.ch02.v1.service.SortAlgorithm;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.buet.cse.spring.interview.ch02.v1"})
public class MyApplication implements CommandLineRunner {

  @Autowired
  private IntArrayGenerator intArrayGenerator;
  
  @Autowired
  @Qualifier("bubbleSortAlgorithm")
  private SortAlgorithm sortAlgorithm;

  @Autowired
  @Qualifier("binarySearchService")
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
