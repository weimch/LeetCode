package sword_to_offer;

/**
 * P13RobotMove
 */
public class P13RobotMove {

    boolean canEnter(int posi, int posj, int k, boolean[][] visited){
        // 直接利用visted的长宽来判断行列数量，以此判断posi和posj是否合法
        if(posi < 0 || posi >= visited.length || posj < 0 || posj >= visited[0].length || visited[posi][posj]){
            return false;
        }
        // 坐标是否限制
        int sum = 0;
        int ti = posi, tj = posj;
        while(ti > 0 || tj > 0){
            sum += ti % 10 + tj % 10;
            ti /= 10;
            tj /= 10;
        }
        if(sum > k){
            return false;
        }
        visited[posi][posj] = true;
        return true;
    }

    void move(int posi, int posj, int k, boolean[][] visited){
        int upi = posi - 1, upj = posj;
        int downi = posi + 1, downj = posj;
        int lefti = posi, leftj = posj - 1;
        int righti = posi, rightj = posj + 1;
        if(canEnter(upi, upj, k, visited)){
            move(upi, upj, k, visited);
        }
        if(canEnter(downi, downj, k, visited)){
            move(downi, downj, k, visited);
        }
        if(canEnter(lefti, leftj, k, visited)){
            move(lefti, leftj, k, visited);
        }
        if(canEnter(righti, rightj, k, visited)){
            move(righti, rightj, k, visited);
        }
    }

    public int movingCount(int m, int n, int k) {
        // 使用回溯法，在方格已经被访问过或者坐标限制下回溯
        boolean[][] visited = new boolean[m][n];
        move(0, 0, k, visited);
        visited[0][0] = true;
        int count = 0;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(visited[i][j]){
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        P13RobotMove sol = new P13RobotMove();
        assert sol.movingCount(3, 1, 0) == 1;
        assert sol.movingCount(2, 3, 1) == 3;
    }
}