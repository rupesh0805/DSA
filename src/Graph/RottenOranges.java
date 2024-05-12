package Graph;

import java.util.LinkedList;
import java.util.Queue;


/*
Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten.
A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.
 */

/*
Soln -> Counting 1 and 2, and pushing 2 in queue, pop decrement the count.
 */

class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}


class RottenOranges
{

    //Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Pair> q = new LinkedList<>();

        int count_12 = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]>0){
                    count_12++;
                }
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }
            }
        }

        int timer=0;

        //Up Down Left Right
        int[] dirX = {0,0,-1,1};
        int[] dirY = {-1,1,0,0};

        while(!q.isEmpty()){
            int size = q.size();
            boolean hasRotten = false;

            for(int k=0;k<size;k++){
                Pair cell = q.poll();
                count_12--;
                int x = cell.x;
                int y = cell.y;

                for(int i=0;i<4;i++){
                    int newX = x+dirX[i];
                    int newY = y+dirY[i];
                    if((newX>=0 && newX<row) && (newY>=0 && newY<col)){
                        if(!visited[newX][newY] && grid[newX][newY]==1){
                            q.offer(new Pair(newX,newY));
                            visited[newX][newY]=true;
                            hasRotten = true;
                        }
                    }
                }
            }
            if(!hasRotten){
                break;
            }
            timer++;
        }
        //If queue still has elements, that means it is not possible to rot anymore
        return count_12==0 ? timer : -1;
    }
}
