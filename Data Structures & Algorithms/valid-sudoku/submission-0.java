class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean isAllRowValid = isRowValid(board);
        boolean isAllColumnValid = isColumnValid(board);
        boolean boxesValid = isBoxesValid(board);

        System.out.println(isAllRowValid);
        System.out.println(isAllColumnValid);
        System.out.println(boxesValid);

        return isAllRowValid && isAllColumnValid && boxesValid;
    }

    boolean isRowValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            List<Character> list = new ArrayList<>();
            for (int col = 0; col < 9; col++) {
                char ch = board[i][col];
                if (ch != '.' && list.contains(ch)) {
                    return false;
                }

                list.add(ch);
            }
            
        }
        return true;
    }

    boolean isColumnValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            List<Character> list = new ArrayList<>();

            for (int row = 0; row < 9; row++) {
                char ch = board[row][i];
                if (ch != '.' && list.contains(ch)) {
                    return false;
                }

                list.add(ch);
            }
        }

        return true;
    }

    boolean isBoxesValid(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean isValidMatrix = isValidMatrix(i, j, board);

                if (!isValidMatrix) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean isValidMatrix(int row, int col, char[][] board) {
        List<Character> list = new ArrayList<>();

        for(int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char ch = board[i][j];

                if (ch != '.' && list.contains(ch)) {
                    return false;
                }
                list.add(ch);
            }
        }

        return true;
    }


}
