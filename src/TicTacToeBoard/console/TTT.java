package TicTacToeBoard.console;


import java.util.Scanner;

//Proof of concept class, the terminal version of TicTacToe!
public class TTT {

    private static boolean gameStart = true;

    //Initialize board layout
    private static char[][] board = { {'1', '|', '2', '|', '3'},
            {'-', '+', '-', '+', '-'},
            {'4', '|', '5', '|', '6'},
            {'-', '+', '-', '+', '-'},
            {'7', '|', '8', '|', '9'},
    };

    private static int turns = 0;

    //Prints board
    private static void printBoard() {

        for(char[] i : board) {
            for(char c : i) {
                System.out.print(c);
            }
            System.out.println(" ");
        }
    }

    private static void updateBoard() {
        printBoard();
    }

    private static void place() {
        Scanner scan = new Scanner(System.in);
        int position = 0;
        //Disgusting amount of if statements TODO: Make it into a switch so time complexity goes way the hell down
        while(gameStart && isEmpty() == true) {
            position = scan.nextInt();

            if(position == 1) {
                if(turns % 2 == 0) {
                    board[0][0] = 'X';
                } else {
                    board[0][0] = 'O';
                }
            } else if(position == 2) {
                if(turns % 2 == 0) {
                    board[0][2] = 'X';
                } else {
                    board[0][2] = 'O';
                }
            } else if(position == 3) {
                if(turns % 2 == 0) {
                    board[0][4] = 'X';
                } else {
                    board[0][4] = 'O';
                }
            } else if(position == 4) {
                if(turns % 2 == 0) {
                    board[2][0] = 'X';
                } else {
                    board[2][0] = 'O';
                }
            } else if(position == 5) {
                if(turns % 2 == 0) {
                    board[2][2] = 'X';
                } else {
                    board[2][2] = 'O';
                }
            } else if(position == 6) {
                if(turns % 2 == 0) {
                    board[2][4] = 'X';
                } else {
                    board[2][4] = 'O';
                }
            } else if(position == 7) {
                if(turns % 2 == 0) {
                    board[4][0] = 'X';
                } else {
                    board[4][0] = 'O';
                }
            } else if(position == 8) {
                if(turns % 2 == 0) {
                    board[4][2] = 'X';
                } else {
                    board[4][2] = 'O';
                }
            } else if(position == 9) {
                if(turns % 2 == 0) {
                    board[4][4] = 'X';
                } else {
                    board[4][4] = 'O';
                }
            } else {
                System.out.println("Invalid Number or Spot already taken");
            }

            turns++;
            updateBoard();
            isOver(turns);
        }
    }

    //Check if spot is empty
    private static boolean isEmpty() {
        for(int i = 0; i <= 4; i += 2) {
            for(int j = 0; j <= 4; j += 2) {
                if(board[i][j] != 'O' && board[i][j] != 'X') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isOver(int moves) {
        //Check columns
        for(int c = 0; c <= 4; c += 2) {
            if(board[0][c] == board[2][c] && board[0][c] == board [4][c]) {
                gameStart = false;
                System.out.println("Game Over");
            }
        }
        //Check rows
        for(int c = 0; c <= 4; c += 2) {
            if(board[c][0] == board[c][2] && board[c][0] == board [c][4]) {
                gameStart = false;
                System.out.println("Game Over");
            }
        }
        //Check diagonals
        if(board[0][0] == board[2][2] && board[0][0] == board [4][4]) {
            gameStart = false;
            System.out.println("Game Over");
        } else if(board[0][4] == board[2][2] && board[0][4] == board[4][0]) {
            gameStart = false;
            System.out.println("Game Over");
        }
        //Check draw if game goes to 9 moves
        if(moves == 9) {
            gameStart = false;
            System.out.println("Draw!");
        }
        return gameStart;
    }

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Welcome to J-Tic-Tac-Toe, press 1 to start the game");

            if(scan.nextInt() == 1) {
                System.out.println("Please pick a number from 1-9 on the board, the first player who goes uses X's, and the 2nd player uses O's");
                printBoard();
                place();
            } else {
                System.out.println("Invalid Number");
            }
        }
    }

}
