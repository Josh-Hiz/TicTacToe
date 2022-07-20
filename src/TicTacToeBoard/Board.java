package TicTacToeBoard;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {

    boolean gameRunning = true;

    private JButton[][] grid = new JButton[3][3];
    private final int BOARD_WIDTH = 800;
    private final int BOARD_HEIGHT = 600;

    JFrame board;

    JPanel panel;

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

        Color defaultColor = new Color(238,238,238);

        protected boolean check(int moves) {
            //Rows
            for (int c = 0; c < 3; c++) {
                 if (!defaultColor.equals(grid[c][0].getBackground()) && grid[c][0].getBackground() == grid[c][1].getBackground() && grid[c][0].getBackground() == grid[c][2].getBackground()) {
                    gameRunning = false;
                    JOptionPane.showMessageDialog(null, "Game Over!");
                }
            }
            //Verticals
            for (int c = 0; c < 3; c++) {
                if (!defaultColor.equals(grid[0][c].getBackground()) && grid[0][c].getBackground() == grid[1][c].getBackground() && grid[0][c].getBackground() == grid[2][c].getBackground()) {
                        gameRunning = false;
                        JOptionPane.showMessageDialog(null, "Game Over!");
                }
            }

            //Check diagonals
            if (!defaultColor.equals(grid[0][0].getBackground()) && grid[0][0].getBackground() == grid[1][1].getBackground() && grid[0][0].getBackground() == grid[2][2].getBackground()) {
                gameRunning = false;
                JOptionPane.showMessageDialog(null, "Game Over!");}

             if (!defaultColor.equals(grid[0][2].getBackground()) && grid[0][2].getBackground() == grid[1][1].getBackground() && grid[0][2].getBackground() == grid[2][0].getBackground()) {
                gameRunning = false;
                JOptionPane.showMessageDialog(null, "Game Over!");
            }
//            Check draw if game goes to 9 moves
            if(moves == 9) {
                gameRunning = false;
                JOptionPane.showMessageDialog(null, "Draw!");
            }

            return gameRunning;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
             int turns = 0;
                    if (e.getSource() == grid[0][0]) {
                        turns += 1;
                        if (turns % 2 == 0) {
                            grid[0][0].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[0][0].setBackground(Color.blue);
                            check(turns);
                        }
                    } else if (e.getSource() == grid[0][1]) {
                        turns += 1;
                        if (turns % 2 == 0) {
                            grid[0][1].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[0][1].setBackground(Color.blue);
                            check(turns);
                        }
                    } else if (e.getSource() == grid[0][2]) {
                        turns += 1;
                        if (turns % 2 == 0) {
                            grid[0][2].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[0][2].setBackground(Color.blue);
                            check(turns);
                        }
                    } else if (e.getSource() == grid[1][0]) {
                        turns += 1;
                        if (turns % 2 == 0) {
                            grid[1][0].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[1][0].setBackground(Color.blue);
                            check(turns);
                        }
                    } else if (e.getSource() == grid[1][1]) {
                        turns += 1;
                        if (turns % 2 == 0) {
                            grid[1][1].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[1][1].setBackground(Color.blue);
                            check(turns);
                        }
                    } else if (e.getSource() == grid[1][2]) {
                        turns += 1;
                        if (turns % 2 == 0) {
                            grid[1][2].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[1][2].setBackground(Color.blue);
                            check(turns);
                        }
                    } else if (e.getSource() == grid[2][0]) {
                        turns += 1;
                        if (turns % 2 == 0) {
                            grid[2][0].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[2][0].setBackground(Color.blue);
                            check(turns);
                        }
                    } else if (e.getSource() == grid[2][1]) {
                        turns += 1;
                        if (turns % 2 == 0) {
                            grid[2][1].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[2][1].setBackground(Color.blue);
                            check(turns);
                        }
                    } else if (e.getSource() == grid[2][2]) {
                        turns += 1;
                        if (turns % 2 == 0) {
                            grid[2][2].setBackground(Color.orange);
                            check(turns);
                        } else {
                            grid[2][2].setBackground(Color.blue);
                            check(turns);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid");
                }
                    System.out.println(turns);
            }
        }
    }

