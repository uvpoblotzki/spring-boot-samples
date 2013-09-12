package io.github.uvpoblotzki.boot.web;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

  @Test
  public void reset() {
    final int goal = 42;
    final int newGoal = 21;
    ServletGame game = new ServletGame(goal);
    Random random = mock(Random.class);
    when(random.nextInt(anyInt())).thenReturn(newGoal);
    game.setRandom(random);
    game.restart();

    assertTrue(game.correctGuess(newGoal));
  }
}
