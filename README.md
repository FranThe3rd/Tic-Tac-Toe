# Tic-Tac-Toe Game Explanation

This Java code represents a simple Tic-Tac-Toe game implemented using the Swing library for the graphical user interface. It provides a graphical interface where two players can take turns marking X and O on a 3x3 grid until a player wins or the game ends in a draw. The code uses various classes and methods from the `java.awt` and `javax.swing` packages to create the game interface and handle user interactions.

## `TicBoard` Class

### Class Variables

- `frame`: A `JFrame` object representing the game window.
- `button_panel`: A `JPanel` object to hold the grid of buttons.
- `buttons`: An array of `JButton` objects representing the individual cells of the game board.
- `player1_turn`: A boolean indicating whether it's currently Player 1's turn.

### Constructor `TicBoard()`

- Initializes the game window.
- Creates the grid layout and initializes the array of buttons.
- Sets the appearance and behavior of the buttons.
- Calls the `firstTurn()` method to randomly determine the starting player.

### Method `actionPerformed(ActionEvent e)`

- Handles button clicks on the game board.
- Checks if it's Player 1 or Player 2's turn, then updates the button text and color accordingly.
- Calls the `check()` method after each move to determine if a player has won.

### Method `firstTurn()`

- Randomly assigns the first turn to either Player 1 or Player 2.

### Method `check()`

- Checks for a winning condition after each move.
- Compares the button texts to determine if any player has won.
- Calls `xWins()` or `oWins()` methods to handle the winning scenario.

### Method `xWins(int a, int b, int c)` and `oWins(int a, int b, int c)`

- Handles the winning condition for Player X or Player O.
- Changes the background color of the winning buttons to green.
- Disables all buttons to prevent further moves.

## Main Method

- Creates an instance of the `TicBoard` class to start the game.

