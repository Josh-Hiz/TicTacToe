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

public class Board extends JPanel{

    private JToggleButton[][] grid = new JToggleButton[3][3];
    private final int BOARD_WIDTH = 800;
    private final int BOARD_HEIGHT = 600;

    static Icon oIcon = new ImageIcon("TicTacToeBoard/assets/Icon-72@2x.png");
    static Icon xIcon = new ImageIcon("TicTacToeBoard/assets/Icon-73@2x.png");
    JFrame board;

    JPanel panel;

    public Board(){
        initBoard();
    }

    private void makePanel(){
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(3,3));
        setBoard();
        board.add(panel);
    }

    private void initBoard(){

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

    private void setBoard(){

        //Loop through 2D array
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                grid[row][col] = new JToggleButton();
                grid[row][col].setBackground(Color.BLACK);
                grid[row][col].setForeground(Color.white);
                grid[row][col].putClientProperty("row", row);
                grid[row][col].putClientProperty("column",col);
                grid[row][col].addActionListener(new ButtonListener());
                panel.add(grid[row][col]);
            }
        }
    }

    protected class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            JToggleButton button = (JToggleButton) e.getSource();

            //Just to see if I can set the icon after click
            if(button.isSelected()){
                button.setIcon(Board.oIcon);
            }

            //Test to see if I can get some sort of output in console after each toggle button is clicked
            //But for some reason I can't change the icons? why?
            System.out.println("clicked column " + button.getClientProperty("column")
                    + ", row " + button.getClientProperty("row"));
        }

    }

}
