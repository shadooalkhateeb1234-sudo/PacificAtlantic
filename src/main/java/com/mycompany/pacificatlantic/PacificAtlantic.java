/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pacificatlantic;
import java.util.*;
import javax.swing.SwingUtilities;

public class PacificAtlantic {
    private static final int[][] DIRECTIONS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights, boolean[][] rivers, boolean[][] deserts) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, rivers, deserts);//first col
            dfs(heights, atlantic, i, n - 1, rivers, deserts);//final col
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, rivers, deserts);//first row
            dfs(heights, atlantic, m - 1, j, rivers, deserts);//final row
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j,
                     boolean[][] rivers, boolean[][] deserts) {
        int m = heights.length;
        int n = heights[0].length;

        visited[i][j] = true;

        for (int[] dir : DIRECTIONS) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            if (visited[x][y] || deserts[x][y]) continue;

            if (heights[x][y] >= heights[i][j] || rivers[x][y]) {
                dfs(heights, visited, x, y, rivers, deserts);
            }
        }
    }

    public static void main(String[] args) {
        PacificAtlantic  solution = new PacificAtlantic ();

        int[][] heights = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };

        boolean[][] rivers = {
        {false, false, false, false, true},
        {false, false, false, false, false},
        {false, false, true, false, false},
        {false, false, false, false, false},
        {false, false, false, false, false}
        };

        boolean[][] deserts = {
        {false, false, false, false, false},
        {false, true, false, false, false},
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, false, false, false, true}
        };

        List<List<Integer>> result = solution.pacificAtlantic(heights, rivers, deserts);
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
       SwingUtilities.invokeLater(WaterFlow ::new);  
   
    }
}
