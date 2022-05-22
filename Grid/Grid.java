// recursion problems
// exhaust every possibilities a.k.a backtracking
public class Grid
{
    private boolean[][] g;
    public Grid(boolean[][] grid)
    {
        this.g = grid;
    }
    //true = Black grid
    //false = White grid
    public void alter(boolean[][] grid,int row, int col)
    {
        //check if it is inside the 2D array and not out of bound and it is white grid
        boolean safe = (row>=0&&row<g.length) &&
            (col>=0&&col<g[row].length) &&
            !(g[row][col] == false);
        if(safe) // yes, the right black grid
        {
            grid[row][col] = false; //change from black grid to white grid
            alter(grid,row,col-1); // search left
            alter(grid,row,col+1); // search right
            alter(grid,row-1,col); // search up
            alter(grid,row+1,col); // search down
        }
    }
    public int countConponent(){
        boolean[][] copy = g;
        return countConponent(copy,0,0);//begin from [0][0]
    }
    public int countConponent(boolean[][] grid,int row,int col)
    {
        if(col==g[row].length){
            row++;
            col = 0;
        }
        if(row>=g.length){
            return 0;
        }
        if(g[row][col]) // black grid
        {
            alter(grid,row,col);
            return 1+countConponent(grid,row,col+1);
        }else{ // white grid
            return 0+countConponent(grid,row,col+1);
        }
    }

    public String toString()
    {
        String print ="";
        for(int i=0;i<g.length;i++)
        {
            if(g[i][0]){print+="T";}
            else{print+="F";}
            for(int j=1;j<g[i].length;j++)
            {
                if(g[i][j]){print+=","+"T";}
                else{print+=","+"F";}
            }
            print+="\n";
        }
        return print;
    }
}