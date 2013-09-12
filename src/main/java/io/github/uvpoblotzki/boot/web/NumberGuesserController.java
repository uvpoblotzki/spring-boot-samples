package io.github.uvpoblotzki.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/guesser")
@Controller
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

}
