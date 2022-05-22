/*
     store the row number and column number as x corrdinate and y corrdinate to indicate the location 
*/
public class coordinates
{
    private int row,col;
    public coordinates(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    public String toString()
    {
        return "("+row+","+col+")";
    }
}
