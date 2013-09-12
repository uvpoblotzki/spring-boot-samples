package io.github.uvpoblotzki.boot.web;

import org.springframework.context.annotation.Bean;

public class NumberGuesserApp {

  @Bean
  public Game getGame() {
    return new ServletGame();
  }

}
