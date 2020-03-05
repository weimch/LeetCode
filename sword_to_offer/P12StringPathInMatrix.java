package sword_to_offer;

/**
 * P12StringPathInMatrix
 */
public class P12StringPathInMatrix {

    boolean help(char[][] board, String word, boolean[][] visited, int posi, int posj, int posw){
        // 按照上下左右的顺序来遍历子节点，直到posw==length(成功)，所有子节点都遍历完(失败)
        if(posw == word.length()){
            return true;
        }
        int upi = posi - 1, upj = posj;
        int downi = posi + 1, downj = posj;
        int lefti = posi, leftj = posj - 1;
        int righti = posi, rightj = posj + 1;
        if(upi >= 0 && !visited[upi][upj] && board[upi][upj] == word.charAt(posw)){
                visited[upi][upj] = true;
                if(help(board, word, visited, upi, upj, posw + 1)){
                    return true;
                }
                visited[upi][upj] = false;
        }
        if(downi < board.length && !visited[downi][downj] && board[downi][downj] == word.charAt(posw)){
            visited[downi][downj] = true;
            if(help(board, word, visited, downi, downj, posw + 1)){
                return true;
            }
            visited[downi][downj] = false;
        }
        if(leftj >= 0 && !visited[lefti][leftj] && board[lefti][leftj] == word.charAt(posw)){
            visited[lefti][leftj] = true;
            if(help(board, word, visited, lefti, leftj, posw + 1)){
                return true;
            }
            visited[lefti][leftj] = false;
        }
        if(rightj < board[0].length && !visited[righti][rightj] && board[righti][rightj] == word.charAt(posw)){
            visited[righti][rightj] = true;
            if(help(board, word, visited, righti, rightj, posw + 1)){
                return true;
            }
            visited[righti][rightj] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return true;
        }
        // 使用回溯法
        // 在递归中，如果有下一个路径，则继续递归过程，直到满足字符串，如果没有下一个路径，则回溯
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(help(board, word, visited, i, j, 1)){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P12StringPathInMatrix sol = new P12StringPathInMatrix();
        // 功能测试
        // test1: 矩阵多行多列 - 存在路径
        assert sol.exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED");
        // test2: 矩阵多行多列 - 不存在路径
        assert !sol.exist(new char[][]{{'a','b'}, {'c','d'}}, "abcd");
        // 边界值测试
        // test3: 矩阵只有一行
        assert sol.exist(new char[][]{{'a','b', 'c'}}, "bc");
        // test4: 矩阵只有一列
        assert sol.exist(new char[][]{{'a'},{'b'},{'c'}}, "bc");
        // test5: 矩阵中所有字母均相同
        assert sol.exist(new char[][]{{'a','a','a'},{'a','a','a'}}, "aaaa");
    }
}