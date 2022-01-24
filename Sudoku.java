/***
 * Name: CHEUNG King Hung
 * ID:21237379
 * Section: 2
 *
 * Disclaimer: I have not committed any form of plagiarism. I did not disclose any
 *             part of my code to my classmate. I did not upload my code to any 
 *             website or public repository. 
 *
 * Shall you have any problem in doing the assignment, please feel free to ask 
 * questions on Piazza. However, NEVER post your code there.
 */

import java.io.File;
import java.util.Scanner;

public class Sudoku {
    public static void main(String[] argv) {
        new Sudoku().runOnce();
    }

    /**
     * Convert a 3D array to a 9x9 array that is more ready to be printed or to be validated.
     *
     * @param array Should be a 3D array where each of the array[i] should be a 3x3 array box.
     *              There are totally 9 of these array boxes, listed from
     *              top-left [0], top-middle [1], top-right [2]
     *              center-left [3], center-middle [4], center-right [5],
     *              bottom-left [6], bottom-middle [7], bottom-right [8]
     * @return Returns a 9x9 int array that contains the digits inside the sudoku board. Each of the array[i]
     *              should contains the number on i-th row, scanned from left to right.
     */
    int[][] arrayTo2D(int [][][] array) {
        //TODO
        int [][] twoDimensionArray = new int[9][9];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    twoDimensionArray[i / array[i].length * array[i][j].length + j][i % array[i].length * array[i][j].length + k] = array[i][j][k];
                }
            }
        }
        return twoDimensionArray;
    }


    /**
     * Check if there is any duplicate inside a box Logic
     *
     * @param cellsOfBox a 3x3 box of a Sudoku. Each cell should contain the number 0 to 9
     * @return true if no problem (may not be fully filled up), or false if any one of the number 
     *         1 to 9 is repeated inside the box. The number 0, can be repeated.
     */
    boolean checkBoxLogic(int[][] cellsOfBox) {
	    //TODO
        //done
        int[] count = new int[10];
        boolean isOk = true;
        for (int i = 0; i < cellsOfBox.length; i++) {
            for (int j = 0; j < cellsOfBox[i].length; j++) {
                switch (cellsOfBox[i][j]){
                    case 1:
                        count[1]++;
                        break;
                    case 2:
                        count[2]++;
                        break;
                    case 3:
                        count[3]++;
                        break;
                    case 4:
                        count[4]++;
                        break;
                    case 5:
                        count[5]++;
                        break;
                    case 6:
                        count[6]++;
                        break;
                    case 7:
                        count[7]++;
                        break;
                    case 8:
                        count[8]++;
                        break;
                    case 9:
                        count[9]++;
                        break;
                    case 0:
                        count[0]++;
                        break;
                    default:
                }
            }
            for (int j = 1; j < count.length; j++) {
                if (count[j] > 1) {
                    isOk = false;
                    break;
                }
            }
        }
        return isOk;
    }

    /**
     * Check if there is any duplicate on a line.
     *
     * @param cellsOfLine an array that contains 9 cells which may contain the number 0 to 9.
     * @return true if no problem (may not be fully filled up), or false if any one of the number 
     *         1 to 9 is repeated on the line. The number 0, can be repeated.
     */
    boolean checkLineLogic(int[] cellsOfLine) {
	    // TODO
        int[] count = new int[10];
        boolean isOk = true;
        for (int i:cellsOfLine) {
            switch (i){
                case 1:
                    count[1]++;
                    break;
                case 2:
                    count[2]++;
                    break;
                case 3:
                    count[3]++;
                    break;
                case 4:
                    count[4]++;
                    break;
                case 5:
                    count[5]++;
                    break;
                case 6:
                    count[6]++;
                    break;
                case 7:
                    count[7]++;
                    break;
                case 8:
                    count[8]++;
                    break;
                case 9:
                    count[9]++;
                    break;
                case 0:
                    count[0]++;
                    break;
                default:
                }
            }
        for (int j = 1; j < count.length; j++) {
            if (count[j] > 1) {
                isOk = false;
                break;
            }
        }
        return isOk;
    }

    /**
     * Check problems of the entire grid
     * @param cells 3D array that being checked.
     * @return true if no problem (not need to be fully filled)
     */
    boolean isValid(int[][][] cells) {
	    //TODO
        boolean isOk = true;
        int[][] twoDArray = arrayTo2D(cells);
        for (int[] ints : twoDArray) {
            if (!checkLineLogic(ints))
                isOk = false;
        }
        for (int[][] sudoku : cells) {
            if (!checkBoxLogic(sudoku))
                isOk =  false;
        }
        return isOk;

    }


    /**
     * Check if the sudoku completes
     * @param cells 3D array that being checked.
     * @return true if the sudoku puzzle is completely filled and valid, 
     *         false if otherwise.
     */
    boolean checkWin(int[][][] cells) {
	    //TODO
        boolean isOk = true;
        if (!isValid(cells)){
            isOk = false;
        }
        else{
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    for (int k = 0; k < cells[i][j].length; k++) {
                        if (cells[i][j][k] == 0){
                            isOk = false;
                        }
                    }
                }
            }
        }
        return isOk;
    }

    /**
     * This method should prompt the user to enter a filename and accept the user's input.
     * It is possible that the user input an invalid filename or the there isn't such filename.
     * This method does not valid the user's inputs.
     *
     * @return a filename picked by user.
     */
    String filePicking() {
        //TODO
        System.out.print("Please enter a filename: ");
        Scanner sc = new Scanner(System.in);
        String filename = "";
        filename = sc.next();
        return filename;
    }


    /**
     * Print the Help Menu. Please try to understand the switch case in runOnce and 
     * Provide a one line comment about the purpose of each symbol.
     */
    void printHelpMenu() {
	    //TODO
        System.out.println("Help Menu:");
        System.out.println("------------------");
        System.out.println("q\t\tQuit the program");
        //System.out.println("This is part of the solution. Please work on your own");
        System.out.println("------------------");
        System.out.println("w\t\tMove to upper cell");
        System.out.println("------------------");
        System.out.println("a\t\tMove to left cell");
        System.out.println("------------------");
        System.out.println("s\t\tMove to lower cell");
        System.out.println("------------------");
        System.out.println("d\t\tMove to Right cell");
        System.out.println("------------------");
        System.out.println("c\t\tGet hits");
        System.out.println("------------------");
        System.out.println(".\t\tClean current cell");
        System.out.println("------------------");
        System.out.println("1-9\tInput number into cell");

    }


    /**
     * To print the Sudoku in a nicer looking way. All horizontal borders should be printed with the char \u2500. All vertical border should
     * be printed with the char \u2502. All cross-point should be printed with the symbol \u253c. The highlighted cell, (at the position indicated by row and col),
     * should be \u25aa if it is empty or should be \u2081, \u2082,..., \u2089 depends on the value of that cell. Please refer to the sample program
     * and see how the program should work.
     *
     * @param cells 3D cells that is going to be printed.
     * @param row the row of where the highlighted cell is.
     * @param col the col of where the highlighted cell is.
     */
    void advancePrint(int[][][] cells, int row, int col) {
        //TODO
        int[][] twoDArray = arrayTo2D(cells);
        for (int i = 0; i < twoDArray.length; i++) {
            if (i % 3 ==0){
                System.out.print("\u253c");
                for (int j = 0; j < 3; j++) {
                    System.out.print("\t\u2500\t\u2500\t\u2500\t\u253c");
                }
                System.out.println();
            }
            for (int j = 0; j < twoDArray[i].length; j++) {
                if (j % 3 ==0){
                    System.out.print("\u2502\t");
                }

                if (twoDArray[i][j] == 0 && row == i && col == j){
                    System.out.print('\u25aa');
                    System.out.print("\t");
                }else if (twoDArray[i][j] == 0){
                    System.out.print('\u2800');
                    System.out.print("\t");
                }else if (row == i && col == j){
                    char c = '\u2080';
                    for (int k = 0; k < twoDArray[i][j]; k++) {
                        c++;
                    }
                    System.out.print(c);
                    System.out.print("\t");
                }else {
                    System.out.print(twoDArray[i][j]+"\t");
                }

            }
            System.out.println("\u2502");
        }
        System.out.print("\u253c");
        for (int j = 0; j < 3; j++) {
            System.out.print("\t\u2500\t\u2500\t\u2500\t\u253c");
        }
        System.out.println();
    }

    /**
     * To write a number into the sudoku 3D array with the given row, col and char s.
     *
     * @param row indicate which row (0-8) that the cells is going to be marked
     * @param col indicates which col (0-8) that the cells is going to be marked
     * @param cells the 3D array that is going to be marked.
     * @param s a number '0' to '9'
     */
    void mark(int row, int col, int[][][] cells, char s) {
        //TODO
        try {
            cells[(row / 3 * 3) + col /3][row % 3][col % 3] = Integer.parseInt(String.valueOf(s));
        }catch (NumberFormatException e){
            return;
        }
    }

   /**
     * To compare if the original cells are kept in the cells
     *
     * For example, cell 1 1 in original cell is 5. This number should not be overwritten by
     * the player during the game. Otherwise the player can win the game easily. This method
     * simply check if the givens cells in the original cells are preserved.
     *
     * @param cells the cells to be checked
     * @param originals the original cells
     * @return true if the number in original cells is kept in cells.
     */
    boolean same(int[][][]cells, int[][][]originals) {
        //TODO
        boolean isOk = true;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                for (int k = 0; k < cells[i][j].length; k++) {
                    if (originals[i][j][k] != 0 && originals[i][j][k] != cells[i][j][k]){
                        isOk =  false;
                    }
                }
            }
        }
        return isOk;
    }



    /**
     * The implementation of this method is given. It is completed. This methods calls another method arrayTo2D.
     * You need to implement arrayTo2D.
     *
     * @param array A 3D array where each of the array[i] is a box of 3x3 sudoku.
     */
    void simplePrint(int[][][] array) {
        int[][] twoDArray = arrayTo2D(array);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++)
                System.out.print(twoDArray[row][col] == 0 ? ' ' : (char) (twoDArray[row][col] + '0'));
            System.out.println();
        }

    }

    /**
     * This method is given. This method is finished.
     *
     * Load a cells from a file. Each file should contain 9 lines of 9 digits.
     * An empty cell will be notated by a 0
     * @param cells after reading the digits, the 2D int array should store the sudoku puzzle from the file
     * @param filename the filename should be pointed to a file stored under the project directory
     *
     * @return return true if file read successfully, false if other wise (e.g. in correct number of character per line, insufficient number of lines etc...
     */
    boolean loadCells(int[][][] cells, String filename) {
        try (Scanner s = new Scanner(new File(filename))) {
            int line = 0;
            while (s.hasNextLine()) {
                //suppose there are 9 lines
                if (line >= 9)
                    throw new Exception("Incorrect number of lines");
                String txt = s.next();
                if (txt.length() != 9)
                    throw new Exception("Incorrect number of characters");
                for (int i = 0; i < 9; i++)
                    cells[(line / 3) * 3 + i / 3][line % 3][i % 3] = txt.charAt(i) - '0';
                line++;
            }
        } catch (Exception e) {
            System.out.println("Error in reading file: " + e);
            return false;
        }
        return true;
    }



    /**
     * This method is given, don't modify it.
     */
    void runOnce() {
        int[][][] cells = new int[9][3][3];

        if (loadCells(cells, filePicking()) == false) {
            System.out.println("The file is not loaded successfully. You may want to check your filePicking method " +
                                "or see if the file is really placed properly in your project directory.");
            cells[0] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; //some weird syntax that is not taught in this course.
            cells[4] = new int[][]{{1, 0, 3}, {4, 5, 6}, {0, 8, 9}};
            cells[8] = new int[][]{{4, 0, 3}, {1, 5, 6}, {0, 8, 2}};
        }

        //backup the originalCells
        int[][][] originalCells = new int[9][3][3];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    originalCells[i][j][k] = cells[i][j][k];

        simplePrint(cells);
        Scanner scanner = new Scanner(System.in);

        int row = 0, col = 0;
        boolean quit = false;
        advancePrint(cells, row, col);
        for (char s = scanner.next().charAt(0); !quit ;) {

            switch (s) {
                case 'a': col = (col + 8) % 9; break;
                case 's': row = (row + 1) % 9; break;
                case 'w': row = (row + 8) % 9; break;
                case 'd': col = (col + 1) % 9; break;
                case '.': mark(row, col, cells, '0'); break;
                case 'c':
                    if (!isValid(cells))
                        System.out.println("The puzzle is invalid!");
                    else if (!same(cells, originalCells))
                        System.out.println("This is not the same as the original");
                    else
                        System.out.println("So far so good!");
                    break;
                case 'q':
                    quit = true;
                    System.out.println("Quit");
                    continue;
                case 'h':
                    //print help menu
                    printHelpMenu();
                    break;
                default:
                    if (s >= '0' && s <= '9') {
                        mark(row, col, cells, s);
                    }
            }
            advancePrint(cells, row, col);
            if (checkWin(cells) && same(cells, originalCells)) {
                System.out.println("Yeah! you have solved the puzzle!");
                break;
            }
            s = scanner.next().charAt(0);
        }
        
    }
}
