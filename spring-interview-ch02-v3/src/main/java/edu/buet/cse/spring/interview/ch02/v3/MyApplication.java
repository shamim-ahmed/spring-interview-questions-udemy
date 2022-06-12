package edu.buet.cse.spring.interview.ch02.v3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import edu.buet.cse.spring.interview.ch02.v3.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.v3.service.SearchService;
import edu.buet.cse.spring.interview.ch02.v3.service.SortAlgorithm;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {
  private final Logger logger = LogManager.getLogger(MyApplication.class);

  @Autowired
  private ApplicationContext appContext;

  public static void main(String... args) {
    SpringApplication.run(MyApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    IntArrayGenerator intArrayGenerator =
        appContext.getBean("intArrayGenerator", IntArrayGenerator.class);
    SortAlgorithm sortAlgorithm = appContext.getBean("bubbleSortAlgorithm", SortAlgorithm.class);
    SearchService searchService = appContext.getBean("binarySearchService", SearchService.class);

    int[] values = intArrayGenerator.generateValues();
    sortAlgorithm.sort(values);

    int index = searchService.search(values, 69);
    logger.info(String.format("The index is %d%n", index));
  }
}
