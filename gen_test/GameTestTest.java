package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

class public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testInitialGameState() {
        assertEquals(0, game.getPlayerPosition());
        assertEquals(0, game.getScore());
        assertEquals(10, game.getEnemyPosition());
    }

    @Test
    public void testMovePlayerWithinBoundaries() {
        game.movePlayer(5);
        assertEquals(5, game.getPlayerPosition());

        game.movePlayer(-3);
        assertEquals(2, game.getPlayerPosition());

        game.movePlayer("right");
        assertEquals(3, game.getPlayerPosition());

        game.movePlayer("left");
        assertEquals(2, game.getPlayerPosition());
    }

    @Test
    public void testMovePlayerBeyondBoundaries() {
        game.movePlayer(-1);
        assertEquals(0, game.getPlayerPosition()); // Should not move below 0

        game.movePlayer(25);
        assertEquals(0, game.getPlayerPosition()); // Should not move beyond 20
    }

    @Test
    public void testMovePlayerWithInvalidCommand() {
        game.movePlayer("up");
        assertEquals(0, game.getPlayerPosition()); // Invalid command, no movement
    }

    @Test
    public void testScorePoints() {
        game.movePlayer(5);
        game.scorePoints();
        assertEquals(1 + 2 + 3 + 4 + 5, game.getScore() / 10); // Check positions counted
        
        game.movePlayer(10);
        game.scorePoints();
        assertEquals(5 + 6 + 7 + 8 + 9 + 10, game.getScore() / 10); // Check positions counted
    }

    @Test
    public void testCheckCollision() {
        game.movePlayer(10); // Move player to enemy position
        assertTrue(game.checkCollision());

        game.movePlayer(-1);
        assertFalse(game.checkCollision());
    }

    @Test
    public void testHandleCollision() {
        game.movePlayer(10);
        game.handleCollision();
        assertEquals(-50, game.getScore());

        game.handleCollision(); // No further collision penalty
        assertEquals(-50, game.getScore());
    }

    @Test
    public void testMoveEnemy() {
        game.moveEnemy();
        assertEquals(20, game.getEnemyPosition());
    }

    @Test
    public void testGamePerformance() {
        for (int i = 0; i < 1000000; i++) {
            game.movePlayer(i % 21);
            game.scorePoints();
            game.checkCollision();
            game.moveEnemy();
        }
    }
}