import java.util.*;
public class StringSMatrixM_Part2
{
    public static void main()
    {
        String s = "BCBX";
        char M[][] = {{'A','B','A','A'},
                {'B','C','D','A'},
                {'A','B','C','B'},
                {'E','X','D','Z'},
                {'A','B','A','A'},
                {'B','C','C','A'},
                {'E','D','C','B'},
                {'E','X','D','Z'}};
        report(M,s);
    }

    public static void report(char[][] M, String s)
    {
        ArrayList<coordinates> list = new ArrayList();
        if(report(M,s,0,0,0,list,new coordinates(0,0)))
        {
            System.out.println("answer = Yes"+"\norigin = "+list.get(0)+"\n"+list);
        }else
        {
            System.out.println("hey, answer = no");
        }       
    }

    public static boolean report(char[][] M, String s,int row,int col,int index, ArrayList<coordinates> list, coordinates corr)
    {
        // FOUND all of them
        if(index == s.length())
        {
            return true;
        }
        // out of bound 
        if(!isSafe(M,row,col))
        {
            return false;
        }
        // switch to next row when it reaches the last column of the row
        if(col == M[row].length)
        {
            row++;
            col = 0;
        }

        // equal char and prevent it goes back
        if(M[row][col]==s.charAt(index) && !list.contains(corr))
        {
            list.add(new coordinates(row,col));
            index++;
            if(report(M,s,row+1,col,index,list,new coordinates(row+1,col))) //searching down
            {
                return true;
            }
            if(report(M,s,row-1,col,index,list,new coordinates(row-1,col))) // searching up
            {
                return true;
            }
            if(report(M,s,row,col+1,index,list,new coordinates(row,col+1))) // searching right
            {
                return true;
            }
            if(report(M,s,row,col-1,index,list,new coordinates(row,col-1))) // searching left
            {
                return true;
            }
            // empty the last element of the list 
            if (index > 1) {
                list.remove(list.size()-1);
                return false;
            }        
            // no match -> reset cursor of string to 0 and empty list
            index = 0;
            list.clear();
            // not equal char
        }else//if (M[row][col]!=s.charAt(index)) // not equal
        {
            return false;
        }
        // traverse the entire 2D array next column
        return report(M,s,row,col+1,index,list,new coordinates(row,col+1));
    }
    //post: a char[][] and row index and column index
    //post: guarantee will not go out of bound at all
    public static boolean isSafe(char M[][],int row, int col)
    {
        return (row>=0&&row<M.length) && (col>=0&&col<M[row].length);
    }
}
