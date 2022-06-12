package edu.buet.cse.spring.interview.ch02.v5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buet.cse.spring.interview.ch02.v5.service.impl.MyServiceProvider;

public class MyApplication {

  public static void main(String... args) {
    ClassPathXmlApplicationContext appContext =
        new ClassPathXmlApplicationContext("/spring-beans.xml");
    MyServiceProvider serviceProvider = appContext.getBean(MyServiceProvider.class);
    serviceProvider.runService();
    appContext.close();
  }
}
