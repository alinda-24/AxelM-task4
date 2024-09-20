# Simple Game: Player vs. Enemy

A fundamental reason why video games are engaging is their ability to combine repetitive actions with dynamic gameplay. You might have played games where you control a character to avoid enemies or collect points. Computers excel at keeping track of scores, moving characters, and calculating interactions without faltering. This concept of _"iteration"_ or _"looping"_ is essential in dynamic gameplay. This week, your task is to create a simple game application in Java where a player can move around, collect points, and interact with enemies.

### 📝 Preparation

- Review the [lecture slides on iteration in games](https://example.com/iteration_in_games).
- Read and answer all questions in:
  - [Module 7: Game Loop Basics](https://example.com/game_loop_basics)
  - [Module 8: Interaction in Games](https://example.com/interaction_in_games)

### ✅ Learning Goals

This week's learning goals include:

* `boolean` expressions and operators
* `while` loops
* `for` loops
* Using JShell to try your Java program
* Function overloading

### 🚨 Troubleshooting Guide

If you have any questions or problems, follow this procedure:

1. Look at this week's [posted issues](https://example.com/issues). Are other students asking about your problem?
2. If not, post a question yourself by creating a [New Issue](https://example.com/issues/new). Add a descriptive title, beginning with "Task _x_: _summary of problem here_"
3. Ask a TA in person during the [weekly lab](https://example.com/lab-schedule). Check your schedule to see when the next lab is.

We encourage you to discuss with your course friends, **but do not share answers!** Similarly, use of any AI services 🤖 to explain concepts is encouraged, **but please do not submit AI-generated solutions** - you must be able to explain your solutions under examination.

### 🏛 Assignment

This task involves creating a basic game application where a player can move, collect points, and avoid enemies. The game will integrate fundamental concepts of `boolean` expressions, loops, and method overloading to manage different interactions and game mechanics.

#### Exercise 1: Setting up the Game Environment

Create a new Java file named `Game.java`. This file will contain the game logic including player's movement, scoring, and enemy interactions.

```java
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
}
```

#### Exercise 2: Player Movement

Add a method to your `Game` class that allows the player to move around.

```java
public void movePlayer(int steps) {
    this.playerPosition += steps;
}
```

Use `boolean` expressions and update the method to ensure the player remains within defined boundaries (e.g., 0 to 20).

#### Exercise 3: Scoring System with While Loop

Add a method to update the score based on the player's position using a `while` loop.

```java
public void scorePoints() {
    int position = 0;
    while (position <= this.playerPosition) {
        // Increase score for each position stepped through
        this.score += 10;
        position++;
    }
}
```

#### Exercise 4: Enemy Interaction

Create a method to determine if the player collides with an enemy. Use `boolean` expressions to handle collisions and apply a penalty on collision.

```java
public boolean checkCollision() {
    return this.playerPosition == this.enemyPosition;
}

public void handleCollision() {
    if (checkCollision()) {
        // Colliding with enemy decreases score
        this.score -= 50;
    }
}
```

#### Exercise 5: Looping with Enemy using For-Loop

Modify the enemy's position using a `for` loop to simulate enemy movement over time.

```java
public void moveEnemy() {
    // Enemy moves in steps of 2
    for (int i = 1; i <= 5; i++) {
        this.enemyPosition += 2;
    }
}
```

#### Exercise 6: Overloading for Game Interactions

Implement function overloading for player movement to handle string commands or integers.

```java
// Moves the player based on string command
public void movePlayer(String command) {
    if ("left".equals(command)) {
        movePlayer(-1);
    } else if ("right".equals(command)) {
        movePlayer(1);
    }
}
```

#### Exercise 7: Use JShell

Use JShell to experiment and test individual methods of your `Game` class. Ensure each method behaves as expected by entering expressions like:

```java
jshell> /open Game.java
jshell> Game myGame = new Game();
jshell> myGame.movePlayer(5);
```

### Final Words

By completing these exercises, you'll have a basic game where a player's position and interactions are handled using key Java programming concepts. Make sure to test and expand on each feature and use JShell to verify your methods. Happy coding! 🕹️