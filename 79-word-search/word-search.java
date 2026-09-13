class Solution {

    static boolean backtrack(char[][] board, String word,
                             int index, int row, int col) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found =
            backtrack(board, word, index + 1, row - 1, col) ||
            backtrack(board, word, index + 1, row + 1, col) ||
            backtrack(board, word, index + 1, row, col - 1) ||
            backtrack(board, word, index + 1, row, col + 1);

        board[row][col] = temp;

        return found;
    }

    public boolean exist(char[][] board, String word) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (backtrack(board, word, 0, row, col)) {
                    return true;
                }
            }
        }

        return false;
    }
}