import java.util.*;
public class FindStringInMatrix2 {
    //algorithm: left, right, up, down
    public static void main(String[] args) {
        char[][] M = {
                {'A','B','A','A'},
                {'B','C','D','A'},
                {'A','B','C','B'},
                {'E','X','D','Z'},
                {'A','B','A','A'},
                {'B','C','C','A'},
                {'E','D','C','B'},
                {'E','X','D','Z'}
            };
        findStringInMatrix("CDAC",M);
    }
    //public method (there is a private method further down)
    public static void findStringInMatrix(String s, char[][] M) {
        boolean found=false;
        List<String> coordinates=new LinkedList<>();
        int curR=0, curC=0; //current row, current column
        while (curR < M.length && !found) {
            coordinates.clear();
            coordinates = findStringInMatrix(s,M,0,curR,curC,coordinates); //calls the private method
            if(coordinates.size()==s.length()){//check if you found all the coordinates for all of the letters in the string
                found = true;
            }
            curC++; //"move" your "finger" over to the next place in the matrix for checking
            if(curC == M[curR].length) //make sure you are not out of bounds!
            {
                curR++;
                curC = 0;
            }
        }
        System.out.print("answer = ");
        if (found) {
            System.out.print("YES\norigin = "+coordinates.get(0)+"\ncoordinates: ");
            System.out.println(coordinates);
        } else {
            System.out.println("NO");
        }
    }
    //private method, does the actual recursion
    private static List<String> findStringInMatrix(String s, char[][] M,int index,
    int curR, int curC, List<String> coordinates) {
        if(coordinates.size()==s.length()&& correct(s,M,coordinates)){
            return coordinates;
        }else if(M[curR][curC]!=s.charAt(index)){
            return coordinates;
        }else if(M[curR][curC]==s.charAt(index)){
            coordinates.add("(" + curR + "," + curC + ")");
            if(curR != 0){
                findStringInMatrix(s,M,index + 1,curR - 1, curC,coordinates);
            }
            if(curC != 0){
                findStringInMatrix(s,M,index + 1, curR, curC - 1,coordinates);
            }
            if(curC != M.length - 1){
                findStringInMatrix(s,M,index + 1, curR + 1, curC,coordinates);
            }
            if(curC != M[curR].length - 1){
                findStringInMatrix(s,M,index + 1, curR, curC + 1,coordinates);
            }
        }
        return coordinates;
    }
    public static boolean correct(String s, char[][] M,List<String> coordinates ){
        int index = 0;
        for(int i = 0;i < coordinates.size(); i++){
            String coor = coordinates.get(i);
            if(s.charAt(index) != M[(int)coor.charAt(1)-48][(int)coor.charAt(3)-48]){ // check coordinates is correct
                index++;
                return false;
            }
        }
        return true;
    }
}