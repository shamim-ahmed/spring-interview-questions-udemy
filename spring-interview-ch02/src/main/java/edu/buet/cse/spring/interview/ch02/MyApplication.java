package edu.buet.cse.spring.interview.ch02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import edu.buet.cse.spring.interview.ch02.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.service.SearchService;
import edu.buet.cse.spring.interview.ch02.service.SortAlgorithm;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

  @Autowired
  private ApplicationContext appContext;

  @Autowired
  private IntArrayGenerator intArrayGenerator;

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public void run(String... args) {
    SortAlgorithm sortAlgorithm = appContext.getBean("BubbleSort", SortAlgorithm.class);
    SearchService searchService = appContext.getBean("BinarySearchService", SearchService.class);

    int[] values = intArrayGenerator.generateValues();
    sortAlgorithm.sort(values);

    int index = searchService.search(values, 69);
    logger.info(String.format("The index is %d", index));
  }

  public static void main(String[] args) {
    SpringApplication.run(MyApplication.class, args);
  }
}
