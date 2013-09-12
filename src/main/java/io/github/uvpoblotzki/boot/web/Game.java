package io.github.uvpoblotzki.boot.web;

public interface Game {

  public static enum Result {
    Lower, Higher, Match
  }

  /**
   * @return The current ongoing Game
   */
  Game currentGame();

  /**
   * Checks if guess matches.
   * @param guess players guess
   * @return {@code Result#Match} if guess matches, {@code Result#Lower}
   * if guess is to high or {@code Result#Higher} if to low.
   */
  Result checkGuess(int guess);

  /**
   * Restarts the game
   */
  void restart();

}
