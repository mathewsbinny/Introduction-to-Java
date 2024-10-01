package EightQueensProblem;

public class EightQueens{
    public static final int SIZE = 8; // size of chessboard
    public int[] queens = {-1,-1,-1,-1,-1,-1,-1, -1}; //-1 indicates no queen placed in ith row

    public void start() {
        search(); // search for solution
    }

    private boolean search() {
        int k = 0;
        while (k>=0 && k<SIZE) {
            //looking for a position in kth row to place queen
            int j = findPosition(k);
            if (j<0) {
                queens[k] = -1;
                k--; //backtrack to previous row
            } else {
                queens[k] = j;
                k++;
            }
        }
        if (k==-1) {
            return false; //no solution
        } else {
            return true; //solution found
        }
    }

    public int findPosition(int k) {
        int start = queens[k] + 1; //search for new placement
        for (int j=start; j<SIZE; j++) {
            if (isValid(k,j)) {
                return j; //(k,j) is the place to put the queen now
            }

        }
        return -1;
    }

    public boolean isValid(int row, int column) {
        for (int i=1; i<=row; i++) {
            if (queens[row-i] == column             //check column
                || queens[row-i] == column-1        //check up-left diagonal
                || queens[row-i] == column+1) {     //check up-right diagonal
                return false; //there is conflict
            }
        }
        return true; //there is no conflict
    }
}
