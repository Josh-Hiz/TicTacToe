package TicTacToeBoard;

import java.awt.Color;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JMenu;

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
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(3, 3));
        setBoard();
        board.add(panel);
    }

    private void initBoard() {

        board = new JFrame();
        panel = new JPanel();

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
        int index = 0;

        protected boolean check(int moves){
            //Columns
            for(int c = 0; c < 3; c++) {
                if (grid[c][0] == grid[c][1] && grid[c][0] == grid[c][2]) {
                    gameRunning = false;
                    JOptionPane.showMessageDialog(null, "Game Over!");
                }
            }

            //Verticals
            for(int c = 0; c < 3; c++) {
                if (grid[0][c] == grid[1][c] && grid[0][c] == grid[2][c]) {
                    gameRunning = false;
                    JOptionPane.showMessageDialog(null, "Game Over!");
                }
            }

            //Check diagonals
            if(grid[0][0] == grid[1][1] && grid[0][0] == grid [2][2]) {
                gameRunning = false;
                JOptionPane.showMessageDialog(null, "Game Over!");
            } else if(grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]) {
                gameRunning = false;
                JOptionPane.showMessageDialog(null, "Game Over!");
            }
            //Check draw if game goes to 9 moves
            if(moves == 9) {
                gameRunning = false;
                JOptionPane.showMessageDialog(null, "Draw!");
            }
            return gameRunning;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int turns = 0;
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    while(gameRunning){
                        if(e.getSource() == grid[r][c]){
                            if(index % 2 == 0){
                                grid[r][c].setBackground(Color.orange);
                            } else {
                                grid[r][c].setBackground(Color.blue);
                            }
                            index++;
                            turns++;
                            check(turns);
                        }
                    }
                }
            }
        }
    }
}
