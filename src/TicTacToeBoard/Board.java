package TicTacToeBoard;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {

    private final JButton[][] grid = new JButton[3][3];

    protected int turns = 0;

    private JFrame board;

    private JPanel panel;

    public Board() {
        initBoard();
    }

    private void makePanel() {
        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(3, 3));
        setBoard();
        board.add(panel);
    }

    private void initBoard() {

        int BOARD_WIDTH = 800;
        int BOARD_HEIGHT = 600;

        board = new JFrame();

        board.setTitle("JTicTacToe");

        board.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        board.setResizable(false);
        board.setLocationRelativeTo(null);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        makePanel();

        board.setVisible(true);

    }

    private void setBoard() {

        //Loop through 2D array
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = new JButton();
                grid[row][col].setOpaque(true);
                grid[row][col].setBorderPainted(false);
                grid[row][col].addActionListener(new ButtonListener());
                panel.add(grid[row][col]);
            }
        }
        validate();
    }


    protected class ButtonListener implements ActionListener {

        Color defaultColor = new Color(238, 238, 238);


        protected void check(int moves) {
            //Rows
            for (int c = 0; c < 3; c++) {
                if (!defaultColor.equals(grid[c][0].getBackground()) && grid[c][0].getBackground() == grid[c][1].getBackground() && grid[c][0].getBackground() == grid[c][2].getBackground()) {
                    grid[c][0].setBackground(Color.green);
                    grid[c][1].setBackground(Color.green);
                    grid[c][2].setBackground(Color.green);

                    JOptionPane.showMessageDialog(null, "Game Over!");
                }
            }
            //Verticals
            for (int c = 0; c < 3; c++) {
                if (!defaultColor.equals(grid[0][c].getBackground()) && grid[0][c].getBackground() == grid[1][c].getBackground() && grid[0][c].getBackground() == grid[2][c].getBackground()) {
                    grid[0][c].setBackground(Color.green);
                    grid[1][c].setBackground(Color.green);
                    grid[2][c].setBackground(Color.green);

                    JOptionPane.showMessageDialog(null, "Game Over!");
                }
            }

            //Check diagonals
            if (!defaultColor.equals(grid[0][0].getBackground()) && grid[0][0].getBackground() == grid[1][1].getBackground() && grid[0][0].getBackground() == grid[2][2].getBackground()) {
                grid[0][0].setBackground(Color.green);
                grid[1][1].setBackground(Color.green);
                grid[2][2].setBackground(Color.green);

                JOptionPane.showMessageDialog(null, "Game Over!");
            }

            if (!defaultColor.equals(grid[0][2].getBackground()) && grid[0][2].getBackground() == grid[1][1].getBackground() && grid[0][2].getBackground() == grid[2][0].getBackground()) {
                grid[0][2].setBackground(Color.green);
                grid[1][1].setBackground(Color.green);
                grid[2][0].setBackground(Color.green);

                JOptionPane.showMessageDialog(null, "Game Over!");
            }

            //Check draw if game goes to 9 moves
            if (moves == 9) {
                JOptionPane.showMessageDialog(null, "Draw!");
            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int col = 0; col < 3; col++) {
                for (int row = 0; row < 3; row++) {
                    if (e.getSource() == grid[col][row]) {
                        turns++;
                        if (turns % 2 == 0) {
                            grid[col][row].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[col][row].setBackground(Color.blue);
                            check(turns);
                        }
                        System.out.println(turns);
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Invalid");
        }
    }
}

