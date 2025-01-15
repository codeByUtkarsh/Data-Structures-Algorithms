class Pair {
    int first;
    int second;
    int third;

    public Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        int[] src = { 0, 0 };
        int[] dest = { n - 1, n - 1 };
        int ans = -1;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (int) (1e9);
            }
        }
        dist[src[0]][src[1]] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, src[0], src[1]));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int upDis = curr.first;
            int upRow = curr.second;
            int upCol = curr.third;
            if (upRow == dest[0] && upCol == dest[1])
                            return upDis;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nrow = upRow + i;
                    int ncol = upCol + j;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] != 1
                            && (upDis + 1) < dist[nrow][ncol]) {
                        if (nrow == dest[0] && ncol == dest[1])
                            return upDis + 1;
                        dist[nrow][ncol] = upDis + 1;
                        q.add(new Pair(upDis + 1, nrow, ncol));
                    }
                }
            }
        }
        return ans;
    }
}