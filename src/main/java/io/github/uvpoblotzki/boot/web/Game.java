package io.github.uvpoblotzki.boot.web;

import java.util.Random;

public class Game {

  public static enum Result {
    Lower, Higher, Match
  }

  private int goal;
  private static Random RANDOM = new Random();

  public Game() {
    randomGoal();
  }

  public Game(int goal) {
    this.goal = goal;
  }

  /**
   * Decodes the game as two hex integers. Both integers are XORed to decode the
   * Game goal.
   *
   * @param seedString seed for en- and decoding
   * @param encodedGuessString encoded goal
   * @return Decoded Game
   */
  public static Game decode(String seedString, String encodedGuessString) {
    int seed = Integer.parseInt(seedString, 16);
    int encodedGuess = Integer.parseInt(encodedGuessString, 16);

    return new Game(seed ^ encodedGuess);
  }

  /**
   * Simply encode the game goal using XOR and a seed value
   * @param seed Seed value
   * @return Encoded Game goal
   */
  public int encode(int seed) {
    return getGoal() ^ seed;
  }

  public Result checkGuess(int guess) {
    Result result = Result.Match;
    if (this.goal > guess) result = Result.Higher;
    if (this.goal < guess) result = Result.Lower;
    return result;
  }

  public void restart() {
    randomGoal();
  }

  private void randomGoal() {
    this.goal = RANDOM.nextInt(10);
  }

  public int getGoal() {
    return goal;
  }

  public void setGoal(int goal) {
    this.goal = goal;
  }

  protected void setRandom(Random random) {
    Game.RANDOM = random;
  }
}
