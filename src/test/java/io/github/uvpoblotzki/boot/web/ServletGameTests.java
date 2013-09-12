package io.github.uvpoblotzki.boot.web;

import org.junit.Test;

import java.util.Random;

import static io.github.uvpoblotzki.boot.web.Game.Result;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServletGameTests {

  @Test
  public void correctGuess() {
    final int goal = 42;
    ServletGame game = new ServletGame(goal);
    assertEquals(Result.Match, game.checkGuess(goal));
  }

  @Test
  public void incorrectGuess() {
    final int goal = 42;
    ServletGame game = new ServletGame(goal);
    assertNotEquals(Result.Match, game.checkGuess(21));
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

    assertEquals(Result.Match, game.checkGuess(newGoal));
  }
}
