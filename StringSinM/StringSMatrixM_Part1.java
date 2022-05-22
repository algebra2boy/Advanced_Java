 

import java.util.*;
/*
   This project is to find the whether the given String s exists in the given 2D array
   report the first match and output their coordinates 
   otherwise, no coordinates will be returned  
 */
public class StringSMatrixM_Part1
{
    public static void main()
    {
        String s = "AABCDE";
        char M[][] = {{'B','B','A','A'},
                {'B','C','D','A'},
                {'A','B','C','D'},
                {'E','E','A','B'}};
        System.out.print(find(M,s)+"\n\n");
    }
    public static String find(char M[][],String s){
        List<coordinates> corr = new ArrayList<coordinates>();
        int index = 0;
        for(int row = 0;row<M.length;row++){
            for(int col = 0;col<M[row].length;col++){ 
                if(!(M[row][col]==s.charAt(index))){ // empty the list and set cursor for string to the beginning
                    corr.clear();
                    index = 0;
                } 
                if((M[row][col]==s.charAt(index))){ // add to the list if the correct one, set cursor for string to the next index
                    corr.add(new coordinates(row,col));
                    index++;
                    if(corr.size()==s.length()){ // once it found the first one, return immediately
                        return "answer = Yes"+"\norigin = "+corr.get(0)+"\n"+corr;
                    }
                }
            }
        }
        return "answer = No";
    }
}
