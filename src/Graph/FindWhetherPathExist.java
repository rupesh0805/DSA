package Graph;


/*
Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall.
Note: There are only a single source and a single destination.


Soln:
DFS or BFS

Complexity:
Time Complexity: O(N2), The DFS algorithm explores all possible paths from the source cell to the destination cell.
In the worst case, the DFS algorithm can visit all the cells in the grid once (except walls, which are skipped).
Space Complexity: O(N2), The visited array requires O(n^2) space to keep track of visited cells.
Also, the recursive call stack during the DFS traversal can go up to O(n^2) in the worst case if the grid is filled with blank cells (value 3) with no walls (value 0) to halt the recursion.


 */

public class FindWhetherPathExist {

    //Function to find whether a path exists from the source to destination.

    public boolean dfs(int startx,int starty,int[][] grid,boolean[][] vis){

        if(startx<0 || startx>=grid.length || starty<0 || starty>=grid[0].length){
            return false;
        }
        if(grid[startx][starty]==0 || vis[startx][starty]){
            return false;
        }
        if(grid[startx][starty]==2){
            return true;
        }

        vis[startx][starty] = true;

        //Up, down,left,right
        int[] dirX = {-1,1,0,0};
        int[] dirY = {0,0,-1,1};

        for(int i=0;i<4;i++){
            int x = startx+dirX[i];
            int y = starty+dirY[i];

            boolean res = dfs(x,y,grid,vis);
            if(res==true){
                return true;
            }

        }
        return false;

    }

    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        int startx = -1;
        int starty = -1;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    startx = i;
                    starty = j;
                    break;
                }
            }
        }

        return dfs(startx,starty,grid,vis);

    }
}
