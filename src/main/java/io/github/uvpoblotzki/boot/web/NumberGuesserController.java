package io.github.uvpoblotzki.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("guesser")
@Controller
@EnableAutoConfiguration
public class NumberGuesserController {

  @Autowired
  private Game game;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public Hint match(@RequestParam(required = true) int guess) {
    boolean isCorrenctMatch = getGame().currentGame().correctGuess(guess);
    return new Hint(isCorrenctMatch, isCorrenctMatch? "Super, your guess is correct": "Try again!");
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public static void main(String[] args) {
    SpringApplication.run(NumberGuesserApp.class, args);
  }

}
