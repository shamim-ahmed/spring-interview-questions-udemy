package edu.buet.cse.spring.interview.ch02.v3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.buet.cse.spring.interview.ch02.v3.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.v3.service.SearchService;
import edu.buet.cse.spring.interview.ch02.v3.service.SortAlgorithm;

public class MyApplication {
  private static final Logger logger = LogManager.getLogger(MyApplication.class);

  public static void main(String... args) {
    AnnotationConfigApplicationContext appContext =
        new AnnotationConfigApplicationContext(BeanConfiguration.class);
    IntArrayGenerator intArrayGenerator =
        appContext.getBean("intArrayGenerator", IntArrayGenerator.class);
    SortAlgorithm sortAlgorithm = appContext.getBean("bubbleSortAlgorithm", SortAlgorithm.class);
    SearchService searchService = appContext.getBean("binarySearchService", SearchService.class);

    int[] values = intArrayGenerator.generateValues();
    sortAlgorithm.sort(values);

    int index = searchService.search(values, 69);
    logger.info(String.format("The index is %d%n", index));
    appContext.close();
  }
}
