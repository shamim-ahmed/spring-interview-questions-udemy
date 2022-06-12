package edu.buet.cse.spring.interview.ch02.v3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.buet.cse.spring.interview.ch02.v3.service.IntArrayGenerator;
import edu.buet.cse.spring.interview.ch02.v3.service.SearchService;
import edu.buet.cse.spring.interview.ch02.v3.service.SortAlgorithm;
import edu.buet.cse.spring.interview.ch02.v3.service.impl.BinarySearchService;
import edu.buet.cse.spring.interview.ch02.v3.service.impl.BubbleSortAlgorithm;
import edu.buet.cse.spring.interview.ch02.v3.service.impl.IntArrayGeneratorImpl;
import edu.buet.cse.spring.interview.ch02.v3.service.impl.SelectionSortAlgorithm;

@Configuration
@ComponentScan(basePackages = {"edu.buet.cse.spring.interview.ch02.v3"})
public class BeanConfiguration {

  @Bean
  public SearchService binarySearchService() {
    return new BinarySearchService();
  }

  @Bean
  public SortAlgorithm bubbleSortAlgorithm() {
    return new BubbleSortAlgorithm();
  }

  @Bean
  public SortAlgorithm selectionSortAlgorithm() {
    return new SelectionSortAlgorithm();
  }

  @Bean
  public IntArrayGenerator intArrayGenerator() {
    return new IntArrayGeneratorImpl();
  }
}
