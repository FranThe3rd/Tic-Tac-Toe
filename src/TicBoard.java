import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicBoard implements ActionListener {

    JFrame frame = new JFrame();
    JPanel button_panel = new JPanel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;


    /**
     * Constructs a TicBoard object and initializes the game board.
     */
    TicBoard() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        button_panel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Apple Casual", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this::actionPerformed);
        }

        frame.add(button_panel);
        firstTurn();



    }

    /**
     * Handles the action performed by the buttons on the game board.
     *
     * @param e the ActionEvent object representing the button click
     */

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        check();
                    }
                } else {
                    if (Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        check();
                    }
                }
            }

        }
    }

    /**
     * Sets the first turn randomly for player 1 or player 2.
     */

    private void firstTurn() {

        int randomNum = (int) (Math.random() * 2 + 1);

        player1_turn = randomNum == 1;

    }

    /**
     * Checks for a winning condition after each move.
     * If there is a winner, it highlights the winning buttons and disables all buttons.
     */

    public void check() {

        if ((Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[1].getText(), "X")) &&
                (Objects.equals(buttons[2].getText(), "X"))) {
            xWins(0, 1, 2);
        }
        if ((Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X"))) {
            xWins(3, 4, 5);
        }
        if ((Objects.equals(buttons[6].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))) {
            xWins(6, 7, 8);
        }

        if ((Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[3].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))) {
            xWins(0, 3, 6);
        }

        if ((Objects.equals(buttons[1].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[7].getText(), "X"))) {
            xWins(1, 4, 7);
        }

        if ((Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[5].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))) {
            xWins(2, 5, 8);
        }

        if ((Objects.equals(buttons[0].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[8].getText(), "X"))) {
            xWins(0, 4, 8);
        }

        if ((Objects.equals(buttons[2].getText(), "X")) &&
                (Objects.equals(buttons[4].getText(), "X")) &&
                (Objects.equals(buttons[6].getText(), "X"))) {
            xWins(2, 4, 6);
        }

        /// _______________________________________________________

        if ((Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[2].getText(), "O"))) {
            oWins(0, 1, 2);
        }
        if ((Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O"))) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "O") &&
                (Objects.equals(buttons[7].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))) {
            oWins(6, 7, 8);
        }

        if ((buttons[0].getText() == "O") &&
                (Objects.equals(buttons[3].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))) {
            oWins(0, 3, 6);
        }

        if ((Objects.equals(buttons[1].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[7].getText(), "O"))) {
            oWins(1, 4, 7);
        }

        if ((Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[5].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))) {
            oWins(2, 5, 8);
        }

        if ((Objects.equals(buttons[0].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[8].getText(), "O"))) {
            oWins(0, 4, 8);
        }

        if ((Objects.equals(buttons[2].getText(), "O")) &&
                (Objects.equals(buttons[4].getText(), "O")) &&
                (Objects.equals(buttons[6].getText(), "O"))) {
            oWins(2, 4, 6);
        }

    }

    /**
     * Handles the winning condition for 'X'.
     *
     * @param a the index of the first winning button
     * @param b the index of the second winning button
     * @param c the index of the third winning button
     */
    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }

    /**
     * Handles the winning condition for 'O'.
     *
     * @param a the index of the first winning button
     * @param b the index of the second winning button
     * @param c the index of the third winning button
     */
    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }

    }

