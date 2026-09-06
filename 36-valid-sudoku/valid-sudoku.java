class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for(int i = 0; i < 9 ; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9 ; c++){
                char ch = board[r][c];
                if(ch == '.') continue;
                int b = (r / 3) * 3 + (c / 3);
                if(row[r].contains(ch) ||
                col[c].contains(ch) ||
                boxes[b].contains(ch)){
                    return false;
                }
                row[r].add(ch);
                col[c].add(ch);
                boxes[b].add(ch);
            }
        }
        return true;
    }
}