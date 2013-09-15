package io.github.uvpoblotzki.boot.web;

import org.junit.Test;

import java.util.Random;

import static io.github.uvpoblotzki.boot.web.Game.Result;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTests {


  @Test
  public void encodeGame() {
    Game game = new Game(42);
    int encodedGame = game.encode(123);
    assertEquals(81, encodedGame);
  }

  @Test
  public void decodeGame() {
    Game game = Game.decode("7b", "2A");
    assertEquals(Result.Match, game.checkGuess(81));
  }

  @Test
  public void correctGuess() {
    final int goal = 42;
    Game game = new Game(goal);
    assertEquals(Result.Match, game.checkGuess(goal));
  }

  @Test
  public void incorrectGuess() {
    final int goal = 42;
    Game game = new Game(goal);
    assertNotEquals(Result.Match, game.checkGuess(21));
  }

  @Test
  public void reset() {
    final int goal = 42;
    final int newGoal = 21;
    Game game = new Game(goal);
    Random random = mock(Random.class);
    when(random.nextInt(anyInt())).thenReturn(newGoal);
    game.setRandom(random);
    game.restart();

    assertEquals(Result.Match, game.checkGuess(newGoal));
  }
}
