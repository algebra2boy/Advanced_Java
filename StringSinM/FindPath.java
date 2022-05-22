import java.util.*;
public class FindPath
{
    public static void main()
    {
        String s = "ABAA";
        char M[][] = {{'A','B','A','A'},
                {'B','C','D','A'},
                {'A','B','C','B'},
                {'E','X','D','Z'},
                {'A','B','A','A'},
                {'B','C','C','A'},
                {'E','D','C','B'},
                {'E','X','D','Z'}};
        traverseMatrix(M,s);
    }

    public static void traverseMatrix(char arr[][], String s)
    {
        traverseMatrix(arr,s,0,0);
    }

    private static void traverseMatrix(char arr[][], String s, int row,int col) 
    { 
        if(row==arr.length) // base case 
        {   
            System.out.println("Doesn't exist");
            return;  
        }
        if(col==arr[0].length) // last column
        {
            col = 0;
            traverseMatrix(arr,s,row+1,col); //after column is done, shift to the next row
        }
        // travser the column
        if(col<arr[0].length) // 
        {
            int index = 0;
            List<coordinates> list = new ArrayList<coordinates>();
            if(traverse(arr,s,row,col,index,list)&&list.size()==s.length()){
                System.out.println(list);
                System.exit(0);   
            }
            traverseMatrix(arr,s,row,col+1); // go to next column
        }
    }

    public static boolean traverse(char arr[][], String s,int row, int col, int index,List<coordinates> list)
    {
        if(index==s.length()){ // base case (found it)        
            return true;
        }
        if(isSafe(arr,row,col,s,index)){// out of bound        
            return false;
        }
        if(arr[row][col]==s.charAt(index)){ // correct one
            list.add(new coordinates(row,col));
            if(traverse(arr,s,row+1,col,index+1,list)){return true;}//east
            if(traverse(arr,s,row,col+1,index+1,list)){return true;}//south
            if(traverse(arr,s,row-1,col,index+1,list)){return true;}//west
            if(traverse(arr,s,row,col-1,index+1,list)){return true;}//north 
            if(traverse(arr,s,row+1,col,index+1,list)||traverse(arr,s,row,col+1,index+1,list)
               ||traverse(arr,s,row-1,col,index+1,list)||traverse(arr,s,row,col-1,index+1,list)){
                   list.add(new coordinates(row,col));
            }
        }                    
       
        return false;
    }
    //post: guarteen will not go out of bound at all and to check
    public static boolean isSafe(char arr[][],int row, int col,String s,int index)
    {
        return (row>=0&&row<arr.length) && (col>=0&&col<arr[row].length)&&(arr[row][col] == s.charAt(index));
    }

} 
