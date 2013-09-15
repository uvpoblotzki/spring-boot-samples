package io.github.uvpoblotzki.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static io.github.uvpoblotzki.boot.web.Game.Result;

@RequestMapping("/guesser")
@Controller
public class NumberGuesserController {

  @Autowired
  private Game game;

  @RequestMapping(method = RequestMethod.POST, value = "/{seed}-{encodedGoal}")
  @ResponseBody
  public Hint match(
      @PathVariable("seed") String seed,
      @PathVariable("encodedGoal") String encodedGoal,
      @RequestParam(required = true) int guess) {
    Result result = Game.decode(seed, encodedGoal).checkGuess(guess);
    boolean isCorrenctMatch = (result == Result.Match);
    String hint = "Super, your guess is correct";
    if (result == Result.Lower) hint = "Too high!";
    if (result == Result.Higher) hint = "Too low!";
    return new Hint(isCorrenctMatch, hint);
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

}
