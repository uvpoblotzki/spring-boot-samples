package io.github.uvpoblotzki.boot.web;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NumberGuesserControllerTests {

  @Test
  public void correctGuess() {
    NumberGuesserController controller = new NumberGuesserController();
    Game game = mock(Game.class);
    when(game.currentGame()).thenReturn(game);
    when(game.checkGuess(anyInt())).thenReturn(Game.Result.Match);
    controller.setGame(game);

    assertTrue(controller.match(42).isMatch());
  }

}
