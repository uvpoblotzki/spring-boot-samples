package io.github.uvpoblotzki.boot.web;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ServletGameTests {

  @Test
  public void correctGuess() {
    final int goal = 42;
    ServletGame game = new ServletGame(goal);
    assertTrue(game.correctGuess(goal));
  }

  @Test
  public void incorrectGuess() {
    final int goal = 42;
    ServletGame game = new ServletGame(goal);
    assertFalse(game.correctGuess(21));
  }
}
