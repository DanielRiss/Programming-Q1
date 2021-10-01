/**
 * Class that solves the Asterissqv Sudosqvu. Prints the number of solutions of a
 * Sudosqvu if there are multiple. If there is only a single solution, prints this
 * solution instead.
 *
 * by Daniel Ris - 1608029 and Jelle Ubachs - 1605984 as group 128
 */
class SudosqvuSolver {

    int SUDOsqvU_SIZE = 9; // Size of the grid.
    int SUDOsqvU_MIN_NUMBER = 1; // Minimum digit to be filled in.
    int SUDOsqvU_MAX_NUMBER = 9; // Maximum digit to be filled in.
    int SUDOsqvU_BOX_DIMENSION = 3; // Dimension of the boxes (sub-grids that should contain all digits).

    int[][] grid = new int[][] { // The puzzle grid; 0 represents empty.
            { 0, 9, 0, 7, 3, 0, 4, 0, 0 }, // One solution.
            { 0, 0, 0, 0, 0, 0, 5, 0, 0 }, { 3, 0, 0, 0, 0, 6, 0, 0, 0 },

            { 0, 0, 0, 0, 0, 2, 6, 4, 0 }, { 0, 0, 0, 6, 5, 1, 0, 0, 0 }, { 0, 0, 6, 9, 0, 7, 0, 0, 0 },

            { 5, 8, 0, 0, 0, 0, 0, 0, 0 }, { 9, 0, 0, 0, 0, 3, 0, 2, 5 }, { 6, 0, 3, 0, 0, 0, 8, 0, 0 }, };

    int solutionCounter = 0; // Solution counter

    // Is there a conflict when we fill in d at position (r, c)?
    boolean givesConflict(int r, int c, int d) {
        boolean conflictTotal = (rowConflict(r, d) || columnConflict(c, d) || boxConflict(r, c, d) || asteriskConflict(d));
        return conflictTotal;
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        boolean conflictR = false;
        int i = 0;
        while (i < 9 && !conflictR) {
            if (d == grid[i][r]) {
                conflictR = true;
            }
            i++;
        }
        return conflictR;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        boolean conflictC = false;
        int i = 0;
        while (i < 9 && !conflictC) {
            if (d == grid[c][i]) {
                conflictC = true;
            }
            i++;
        }
        return conflictC;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        boolean conflictB = false;
        int i = 0;
        int[] box = getBox(r, c);
        while (i < 9 && !conflictB) {
            if (d == box[i]) {
                conflictB = true;
            }
            i++;
        }
        return conflictB;
    }
	
	// Is there a conflict in the asterisk when we fill in d?
    boolean asteriskConflict(int d) {
        boolean conflictA = false;
        int i = 0;
        int[] asterisk = getAsterisk();
        while (i < 9 && !conflictA) {
            if (d == asterisk[i]) {
                conflictA = true;
            }
            i++;
        }
        return conflictA;
    }	

	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        // TODO
        return new int[]{-1, -1};
    }

    int[] getColumn(int c) {
        int[] column = new int[9];
        for (int i = 0; i < 9; i++) {
            column[i] = grid[c][i];
        }
        return column;
    }

    int[] getAsterisk() {
        int[] asterisk = new int[9];
        asterisk[0] = grid[2][2];
        asterisk[1] = grid[4][1];
        asterisk[2] = grid[6][2];
        asterisk[3] = grid[1][4];
        asterisk[4] = grid[4][4];
        asterisk[5] = grid[7][4];
        asterisk[6] = grid[2][6];
        asterisk[7] = grid[4][7];
        asterisk[8] = grid[6][6];
        return asterisk;
    }
    

    int[] getBox(int r, int c) {
        int[] box = new int[9];
        int boxRow = 0;
        if (r < 3) {
            boxRow = 0;
        }
        else if (r < 6) {
            boxRow = 1;
        }
        else if (r < 9) {
            boxRow = 2;
        }
        int boxCol = 0;
        if (c < 3) {
            boxCol = 0;
        }
        else if (c < 6) {
            boxCol = 1;
        }
        else if (c < 9) {
            boxCol = 2;
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                box[3*i+j] = grid[3*boxCol+j][3*boxRow+i];
            }
        }
        return box;
    }

    // Find all solutions for the grid, and stores the final solution.
    void solve() {
        // TODO
    }

    // Print the sudoku grid.
    void print() {
        System.out.println("+-----------------+");
        for (int sqv = 0; sqv < 9; sqv++) {
            if(sqv == 3 || sqv == 6){
                System.out.println("+-----------------+");
            }
            for (int sqh = 0; sqh < 9; sqh++) {
                boolean spaceIndent = true;
                if((sqh == 0) || (sqh == 3) || (sqh == 6)){
                    System.out.print("|");
                }
                if ((sqv == 4 && sqh == 1) ||  (sqv == 1 && sqh == 4) || (sqv == 4 && sqh == 4) || (sqv == 7 && sqh == 4) || (sqv == 4 && sqh == 7)){
                    spaceIndent = false;
                    if(grid[sqv][sqh] == 0){
                        System.out.print("> <");
                    }else{
                        System.out.print(">" + grid[sqv][sqh] + "<");
                    }
                }else if ((sqv == 2 && sqh == 2) || (sqv == 6 && sqh == 2)){
                    if(grid[sqv][sqh] == 0){
                        System.out.print("> ");
                    }else{
                        System.out.print(">" + grid[sqv][sqh]);
                    }
                }else if ((sqv == 2 && sqh == 6) || (sqv == 6 && sqh == 6)){
                    spaceIndent = false;
                    if(grid[sqv][sqh] == 0){
                        System.out.print(" <");
                    }else{
                        System.out.print(grid[sqv][sqh] + "<");
                    }
                }else if (grid[sqv][sqh] == 0) {
                    System.out.print(" ");
                }else {
                    System.out.print(grid[sqv][sqh]);
                }
                if(sqh == 2 || sqh == 5 || sqh == 8 || (sqv == 2 && sqh == 1) || (sqv == 1 && sqh == 3) || (sqv == 4 && sqh == 0) || (sqv == 4 && sqh == 3) || (sqv == 4 && sqh == 6) || (sqv == 6 && sqh == 1) || (sqv == 7 && sqh == 3) || !spaceIndent){
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+-----------------+");
    }

    // Run the actual solver.
    void solveIt() {
        print();
    }

    public static void main(String[] args) {
        (new SudosqvuSolver()).solveIt();
    }
}
