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

  /**
   * Creates a new Game
   * @return The new Game is returned as JSON
   */
  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public Game create() {
    return new Game();
  }

  @RequestMapping(method = RequestMethod.GET)
  public String index() {
    return "game";
  }

  /**
   * Make a guess for the Game
   *
   * @param encodedGame Encoded Game {@link #create()}
   * @param guess Your guess
   * @return Hit if your guess was correct
   */
  @RequestMapping("/{encodedGame}/guess")
  @ResponseBody
  public Hint match(
      @PathVariable("encodedGame") String encodedGame,
      @RequestParam(required = true) int guess) {
    Result result = Game.decode(encodedGame).checkGuess(guess);
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
