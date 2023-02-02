class Solution {
    int[][] grid;
    boolean[][] seen;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows, cols;
    int result;
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        seen = new boolean[rows][cols];
        result = Integer.MIN_VALUE;
        int id = 2;
        Map<Integer, Integer> area = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(i, j, id);
                    result = Math.max(result, count);
                    area.put(id, count);
                    id++;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    int count = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] != 0) {
                            int island = grid[x][y];
                            if (!set.contains(island)) {
                                set.add(island);
                                count += area.get(island);
                            }
                        }
                    }
                    result = Math.max(result, count);
                }
            }
        }
        if (result == Integer.MIN_VALUE) return rows * cols == 1 ? 1 : 0;
        return result;
    }
    int dfs(int i, int j, int id) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1 || seen[i][j]) return 0;
        seen[i][j] = true;
        grid[i][j] = id;
        int count = 1;
        for (int[] dir : dirs) {
            count += dfs(i + dir[0], j + dir[1], id);
        }
        return count;
    }
}
