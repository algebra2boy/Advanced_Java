import java.util.*;
public class CopyOfteste2
{
    public static void main()
    {
        /*
         * 
         *               0   1   2   3
         *            0{'A','B','A','A'},
                      1{'B','C','D','A'},
                      2{'A','B','C','B'},
                      3{'E','X','D','Z'},
                      4{'A','B','A','A'}, 
                      5{'B','C','C','A'},
                      6{'E','D','C','B'},
                      7{'E','X','D','Z'}
                      
                      012345  length = 6
                      AABCDE
         * 
         */
        
        char[][] m2 = {{'A','B','A','A'},
                       {'B','C','D','A'},
                       {'A','B','C','B'},
                       {'E','X','D','Z'},
                       {'A','B','A','A'}, 
                       {'B','C','C','A'},
                       {'E','D','C','B'},
                       {'E','X','D','Z'}};
        String s2 = "CDAC";
        findSInM(m2, s2);
    }
    public static void findSInM(char[][] m, String s){
        ArrayList<String> l = new ArrayList<String>();
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                l.clear();
                if(m[i][j] == s.charAt(0)){
                    l = travel(m, s, l, 0, i, j);
                    if(l.size() == s.length()){
                        System.out.println(l);
                    }
                }
                
            }
        }
    }
    public static ArrayList<String> travel(char[][] m, String s, ArrayList<String> coordinates, int index, int i, int j){
        //System.out.println("i: " + i + "\tj: " + j + "\tindex: " + index);
        if(coordinates.size() == s.length() && checkEqual(m,s,coordinates)){
            return coordinates;
        }else if(m[i][j] != s.charAt(index)){
            return coordinates;
        }else if(m[i][j] == s.charAt(index)){
            coordinates.add("(" + i + "," + j + ")");
            if(i != 0){
                travel(m, s, coordinates, index + 1, i - 1, j);
            }
            if(j != 0){
                travel(m, s, coordinates, index + 1, i, j - 1);
            }
            if(i != m.length - 1){
                travel(m, s, coordinates, index + 1, i + 1, j);
            }
            if(j != m[i].length - 1){
                travel(m, s, coordinates, index + 1, i, j + 1);
            }
        }
        return coordinates;
    }
    public static boolean checkEqual(char[][] m, String s, ArrayList<String> list)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != m[(int)list.get(i).charAt(1) - 48][(int)list.get(i).charAt(3) - 48]){
                return false;
            }
        }
        return true;
    }
}
