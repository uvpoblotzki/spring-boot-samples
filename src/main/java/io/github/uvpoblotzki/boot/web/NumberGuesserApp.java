package io.github.uvpoblotzki.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableAutoConfiguration
@ComponentScan(basePackages = "io.github.uvpoblotzki.boot.web")
public class NumberGuesserApp {

  @Bean
  public Game getGame() {
    return new Game();
  }

  @Bean
  public InternalResourceViewResolver defaultViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    return resolver;
  }

  public static void main(String[] args) {
    SpringApplication.run(NumberGuesserApp.class, args);
  }

}
