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
        // TODO
        return false;
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        // TODO
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        // TODO
        return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        // TODO
        return false;
    }

    // Is there a conflict in the asterissqv when we fill in d?
    // Delete this comment and add your asterissqvConflict method in its place.

    // Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        // TODO
        return new int[] { -1, -1 };
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
