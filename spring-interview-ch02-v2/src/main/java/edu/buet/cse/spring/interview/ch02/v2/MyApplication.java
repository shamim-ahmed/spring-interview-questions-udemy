package edu.buet.cse.spring.interview.ch02.v2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.interview.ch02.v2.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.v2.service.SearchService;
import edu.buet.cse.spring.interview.ch02.v2.service.SortAlgorithm;

public class MyApplication {
  private static final Logger logger = LogManager.getLogger(MyApplication.class);

  public static void main(String... args) {
    ClassPathXmlApplicationContext appContext =
        new ClassPathXmlApplicationContext("/spring-beans.xml");
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
