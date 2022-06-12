package edu.buet.cse.spring.interview.ch02.v7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import edu.buet.cse.spring.interview.ch02.v7.service.impl.MyServiceProvider;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

  @Autowired
  private ApplicationContext appContext;

  public static void main(String[] args) {
    SpringApplication.run(MyApplication.class, args);
  }

  @Override
  public void run(String... args) {
    MyServiceProvider myServiceProvider = appContext.getBean(MyServiceProvider.class);
    myServiceProvider.runService();
  }
}
