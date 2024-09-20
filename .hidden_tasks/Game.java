public class Game {
    private int playerPosition;
    private int score;
    private int enemyPosition;

    // Initializes the game state.
    public Game() {
        this.playerPosition = 0; // Start player at position 0
        this.score = 0;          // Initial score
        this.enemyPosition = 10; // Enemy starts at position 10
    }

    /**
     * Moves the player by a certain number of steps.
     * Ensures the player remains within boundaries 0 to 20.
     *
     * @param steps Number of steps to move the player.
     */
    public void movePlayer(int steps) {
        int newPosition = this.playerPosition + steps;
        if (newPosition >= 0 && newPosition <= 20) {
            this.playerPosition = newPosition;
        }
    }

    /**
     * Overloaded method to move the player using a string command.
     * The command could be "left" or "right" for moving the player.
     *
     * @param command String command for movement.
     */
    public void movePlayer(String command) {
        if ("left".equals(command)) {
            movePlayer(-1);
        } else if ("right".equals(command)) {
            movePlayer(1);
        }
    }

    /**
     * Updates the score based on the player's current position.
     * The score increases by 10 for each step made by the player.
     */
    public void scorePoints() {
        int position = 0;
        while (position <= this.playerPosition) {
            this.score += 10;
            position++;
        }
    }

    /**
     * Checks if the player collides with the enemy.
     *
     * @return true if there is a collision, false otherwise.
     */
    public boolean checkCollision() {
        return this.playerPosition == this.enemyPosition;
    }

    /**
     * Handles collision events between the player and the enemy.
     * Decreases score by 50 if there is a collision.
     */
    public void handleCollision() {
        if (checkCollision()) {
            this.score -= 50;
        }
    }

    /**
     * Moves the enemy in increments of 2.
     * Simulates enemy movement over time.
     */
    public void moveEnemy() {
        for (int i = 1; i <= 5; i++) {
            this.enemyPosition += 2;
        }
    }

    /**
     * Main method to run and test the game logic.
     */
    public static void main(String[] args) {
        Game myGame = new Game();
        myGame.movePlayer(5);
        myGame.scorePoints();
        myGame.moveEnemy();
        System.out.println("Player Position: " + myGame.playerPosition);
        System.out.println("Score: " + myGame.score);
        System.out.println("Enemy Position: " + myGame.enemyPosition);
        myGame.handleCollision();
        System.out.println("Final Score after collision check: " + myGame.score);
    }
}