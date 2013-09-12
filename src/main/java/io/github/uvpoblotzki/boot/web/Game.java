package io.github.uvpoblotzki.boot.web;

public interface Game {

  /**
   * @return The current ongoing Game
   */
  Game currentGame();

  /**
   * Checks if guess matches.
   * @param guess players guess
   * @return {@code true} if guess matches
   */
  boolean correctGuess(int guess);

  /**
   * Restarts the game
   */
  void restart();

}
