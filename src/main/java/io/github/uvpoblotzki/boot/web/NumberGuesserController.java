package io.github.uvpoblotzki.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("guesser")
public class NumberGuesserController {

  private Game game;

  @RequestMapping(method = RequestMethod.POST)
  public Hint match(@RequestParam(required = true) int guess) {
    return new Hint(getGame().currentGame().correctGuess(guess), "");
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
