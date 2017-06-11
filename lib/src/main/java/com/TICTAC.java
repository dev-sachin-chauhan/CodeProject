package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Sachin_Chauhan on 5/7/2016.
 */

/**
 * 1. There are two scenarios initially
 * -Human makes the first move.
 * -Computer makes the first move.
 * 2.0 Loop unitl Draw(No space available)
 * 2.1  Human makes the move
 * Accept his input
 * 2.2 Computer makes his move
 * -Check for last winning move for computer.
 * -Check for last winning move for Human if yes block him.
 * -Check if computer can make fork. if yes move.
 * -Check if human can fork if yes then block him.
 * -If center is available make the move
 * -if opposite corner available of humans move, block that move
 * -check for any corner position, if yes make that move
 * -Move Last any empyt space left
 * <p/>
 * Time Complexity of Computer Move is of Big O is O(1)
 * because there are no variable inputs and condtions checks are constants
 * <p/>
 * Space Complexity is also Big O is O(1)
 * Becuase there in no variable space, Space is constant of Tic Tac Toe board.
 * for board only 9*4 bytes used.
 *
 * @see #play_TIC_TAC_TOE_Game
 */

public class TICTAC {

    //TIC-TAC-TOE Board
    private int TT[][] = new int[3][3];


    /**
     * The TIC-TAC-TOE game
     * <p/>
     * return
     * 1 for computer wins
     * -1 for human wins
     * 0 for draw
     **/

    int play_TIC_TAC_TOE_Game() {

        Random rand = new Random();


        //To decide the frist move randomly.
        int chance = rand.nextInt(2);

        while (!isDraw()) {

            if (chance == 0) {
                getComputerMove();

                if (checkforwin(1)) {//check win for computer
                    printTT();
                    System.out.println("Computer Wins");
                    return 1;
                }

                chance = 1; //To toggle the chance for human.
            } else {
                getHumanMove();

                if (checkforwin(-1)) {//check win for human.
                    printTT();
                    System.out.println("Human Wins");
                    return -1;
                }

                chance = 0; //To toogle the chance for computer
            }

            printTT();

        }
        System.out.println("Match Draw");
        return 0;

    }

    /**
     * To get the Computer winning or drawing move.
     */
    private void getComputerMove() {
        int pos[] = new int[2];

        if (checkForLastWinningMove(1, pos)) { //Check for last winning move for computer
            //Set the position
            TT[pos[0]][pos[1]] = 1;
            return;
        } else if (checkForLastWinningMove(-1, pos)) { //Check for last winning move for Human

            //Prevent that position from human to win.
        } else if (isforkPossible(1, pos)) {  //Check if computer can make fork

        } else if (isforkPossible(-1, pos)) { //check if human can fork if yes then block him

        } else if (TT[1][1] == 0) {// If center is available make the move
            pos[0] = 1;
            pos[1] = 1;
        } else if (oppositeCornerMoveforComp(pos)) {// if opposite corner available of humans move, make that move

        } else if (anyCornerMove(pos)) { // check for any corner position, make that move

        } else {//Move Last any empyt space left

            if (TT[0][1] == 0) {
                pos[0] = 0;
                pos[1] = 1;
            } else if (TT[1][2] == 0) {
                pos[0] = 1;
                pos[1] = 2;
            } else if (TT[2][1] == 0) {
                pos[0] = 2;
                pos[1] = 1;
            } else {
                pos[0] = 1;
                pos[1] = 0;
            }

        }
        //Set the position
        TT[pos[0]][pos[1]] = 1;

    }

    /**
     * To get the human move from console
     */
    private void getHumanMove() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pos[] = new int[2];
        String line = new String();
        try {
            line = br.readLine();
        } catch (Exception e) {
            //handle exvpetion
        }
        String position[] = line.split(" ");
        pos[0] = Integer.parseInt(position[0]);
        pos[1] = Integer.parseInt(position[1]);

        //Set the position
        TT[pos[0]][pos[1]] = -1;

    }


    /**
     * check if there is last wining move
     */
    private boolean checkForLastWinningMove(final int player, int[] pos) {

        //Check for row;
        for (int i = 0; i < 3; i++) {
            int ctr = 0;
            int col = -1;
            for (int j = 0; j < 3; j++) {
                if (TT[i][j] == player) {
                    ctr++;
                } else if (TT[i][j] == 0) {
                    col = j;
                }
            }
            if (ctr == 2 && col != -1) {
                pos[0] = i;
                pos[1] = col;
                return true;
            }
        }

        //Check for columns
        for (int i = 0; i < 3; i++) {
            int ctr = 0;
            int row = -1;
            for (int j = 0; j < 3; j++) {
                if (TT[j][i] == player) {
                    ctr++;
                } else if (TT[j][i] == 0) {
                    row = j;
                }
            }
            if (ctr == 2 && row != -1) {
                pos[0] = row;
                pos[1] = i;
                return true;
            }
        }

        //Check for Diagonals
        int ctr = 0;
        int row = -1;
        for (int i = 0; i < 3; i++) {
            if (TT[i][i] == player) {
                ctr++;
            } else if (TT[i][i] == 0) {
                row = i;
            }
        }
        if (ctr == 2 && row != -1) {
            pos[0] = row;
            pos[1] = row;
            return true;
        }

        ctr = 0;
        row = -1;
        for (int i = 0; i < 3; i++) {
            if (TT[i][2 - i] == player) {
                ctr++;
            } else if (TT[i][2 - i] == 0) {
                row = i;
            }
        }
        if (ctr == 2) {
            pos[0] = row;
            pos[1] = 2 - row;
            return true;
        }

        return false;
    }

    /**
     * Check for fork
     */
    private boolean isforkPossible(int player, int[] pos) {
        //Fork is possible if there are two straight line possible with  corner common point

        //check for first row
        int ctr = 0;
        boolean flag = false;
        for (int i = 0; i < 3; i++) {

            if (TT[0][i] == 0) {
                ctr++;
            } else if (TT[0][i] == player) {
                flag = true;
            }
        }
        if (ctr == 2 && flag) {
            if (TT[0][0] == 0) {
                //check first col
                ctr = 0;
                flag = false;
                for (int i = 0; i < 3; i++) {

                    if (TT[i][0] == 0) {
                        ctr++;
                    } else if (TT[i][0] == player) {
                        flag = true;
                    }
                }
                if (ctr == 2 && flag) {
                    pos[0] = 0;
                    pos[1] = 0;
                    return true;
                }
                //check for left diagonal
                ctr = 0;
                flag = false;
                for (int i = 0; i < 3; i++) {

                    if (TT[i][i] == 0) {
                        ctr++;
                    } else if (TT[i][i] == player) {
                        flag = true;
                    }
                }
                if (ctr == 2 && flag) {
                    pos[0] = 0;
                    pos[1] = 0;
                    return true;
                }
            }
            if (TT[0][2] == 0) {
                //check last col
                ctr = 0;
                flag = false;
                for (int i = 0; i < 3; i++) {

                    if (TT[i][2] == 0) {
                        ctr++;
                    } else if (TT[i][2] == player) {
                        flag = true;
                    }
                }
                if (ctr == 2 && flag) {
                    pos[0] = 0;
                    pos[1] = 2;
                    return true;
                }
                //check for right diagonal
                ctr = 0;
                flag = false;
                for (int i = 0; i < 3; i++) {

                    if (TT[i][2 - i] == 0) {
                        ctr++;
                    } else if (TT[i][2 - i] == player) {
                        flag = true;
                    }
                }
                if (ctr == 2 && flag) {
                    pos[0] = 0;
                    pos[1] = 2;
                    return true;
                }
            }
        }
        //check for last row
        ctr = 0;
        flag = false;
        for (int i = 0; i < 3; i++) {

            if (TT[2][i] == 0) {
                ctr++;
            } else if (TT[2][i] == player) {
                flag = true;
            }
        }
        if (ctr == 2 && flag) {
            if (TT[2][0] == 0) {
                //check first col
                ctr = 0;
                flag = false;
                for (int i = 0; i < 3; i++) {

                    if (TT[i][0] == 0) {
                        ctr++;
                    } else if (TT[i][0] == player) {
                        flag = true;
                    }
                }
                if (ctr == 2 && flag) {
                    pos[0] = 2;
                    pos[1] = 0;
                    return true;
                }

                //check for right diagonal
                ctr = 0;
                flag = false;
                for (int i = 0; i < 3; i++) {

                    if (TT[i][2 - i] == 0) {
                        ctr++;
                    } else if (TT[i][2 - i] == player) {
                        flag = true;
                    }
                }
                if (ctr == 2 && flag) {
                    pos[0] = 2;
                    pos[1] = 0;
                    return true;
                }
            } else if (TT[2][2] == 0) {
                //check last col
                ctr = 0;
                flag = false;
                for (int i = 0; i < 3; i++) {

                    if (TT[i][2] == 0) {
                        ctr++;
                    } else if (TT[i][2] == player) {
                        flag = true;
                    }
                }
                if (ctr == 2 && flag) {
                    pos[0] = 2;
                    pos[1] = 2;
                    return true;
                }

                //check for left diagonal
                ctr = 0;
                flag = false;
                for (int i = 0; i < 3; i++) {

                    if (TT[i][i] == 0) {
                        ctr++;
                    } else if (TT[i][i] == player) {
                        flag = true;
                    }
                }
                if (ctr == 2 && flag) {
                    pos[0] = 2;
                    pos[1] = 2;
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * opposite corner move against the opponent.
     */
    private boolean oppositeCornerMoveforComp(int[] pos) {
        if (TT[0][0] == 0 && TT[2][2] == -1) {
            pos[0] = 0;
            pos[1] = 0;
            return true;
        } else if (TT[0][2] == 0 && TT[2][0] == -1) {
            pos[0] = 0;
            pos[1] = 2;
            return true;
        } else if (TT[2][2] == 0 && TT[0][0] == -1) {
            pos[0] = 2;
            pos[1] = 2;
            return true;
        } else if (TT[2][0] == 0 && TT[0][2] == -1) {
            pos[0] = 2;
            pos[1] = 0;
            return true;
        }
        return false;
    }

    /**
     * Any corner position
     */
    private boolean anyCornerMove(int[] pos) {
        if (TT[0][0] == 0) {
            pos[0] = 0;
            pos[1] = 0;
            return true;
        } else if (TT[0][2] == 0) {
            pos[0] = 0;
            pos[1] = 2;
            return true;
        } else if (TT[2][2] == 0) {
            pos[0] = 2;
            pos[1] = 2;
            return true;
        } else if (TT[2][0] == 0) {
            pos[0] = 2;
            pos[1] = 0;
            return true;
        }
        return false;
    }

    /**
     * To check for draw
     * true for draw
     */
    private boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (TT[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * To print TT
     */
    private void printTT() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(TT[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Check for win base on player parameter
     * Time Complexity O(n2);
     */
    boolean checkforwin(int player) {

        //Check for row;
        for (int i = 0; i < 3; i++) {
            int ctr = 0;
            for (int j = 0; j < 3; j++) {
                if (TT[i][j] == player) {
                    ctr++;
                }
            }
            if (ctr == 3) {
                return true;
            }
        }

        //Check for columns
        for (int i = 0; i < 3; i++) {
            int ctr = 0;
            for (int j = 0; j < 3; j++) {
                if (TT[j][i] == player) {
                    ctr++;
                }
            }
            if (ctr == 3) {
                return true;
            }
        }

        //Check for Diagonals
        int ctr = 0;
        for (int i = 0; i < 3; i++) {
            if (TT[i][i] == player) {
                ctr++;
            }
        }
        if (ctr == 3) {
            return true;
        }

        ctr = 0;
        for (int i = 0; i < 3; i++) {
            if (TT[i][2 - i] == player) {
                ctr++;
            }
        }
        if (ctr == 3) {
            return true;
        }
        return false;
    }
}
