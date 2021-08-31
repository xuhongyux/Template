package com.xiayu.array;

/**
 * @author xuhongyu
 * @describe 463. 岛屿的周长
 * <p>
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * @create 2020-12-07-12:25
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int grid[][] = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int grid1[][] = {{1, 1}, {1, 1}};
        solution_1(grid);
    }

    /**
     * 暴力迭代检查每个判断每个岛屿附件时候上下左右是否有岛屿
     *
     * @param grid
     */
    private static void solution_1(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //如果这个一块是岛
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    if (i < n - 1 && grid[i + 1][j] != 1) {
                        cnt++;
                    }
                    if (j < m - 1 && grid[i][j + 1] != 1) {
                        cnt++;
                    }
                    if (i > 0 && grid[i - 1][j] != 1) {
                        cnt++;
                    }
                    if (j > 0 && grid[i][j - 1] != 1) {
                        cnt++;
                    }
                    ans += cnt;
                }
            }
        }
        System.out.println(ans);
    }
}
