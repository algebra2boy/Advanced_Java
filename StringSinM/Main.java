import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String s = "AABCDE";
        s = "ZAAB";
        /*char M[][] = {
                {'A','B','A','A'},
                {'B','C','D','A'},
                {'A','B','C','D'},
                {'E','E','A','B'},
                };
        findS(s, M);
        System.out.println("\n\n");
        findSinM(s, M);
        System.out.println("\n\n");*/

        char m[][] = {
                {'A','B','A','A'},
                {'B','C','D','A'},
                {'A','B','C','B'},
                {'E','X','D','Z'},
                {'A','B','A','A'},
                {'B','C','D','A'},
                {'E','D','C','B'},
                {'E','X','D','Z'}
                };
        findSinMExplore(s, m);
    }

    // non-recursively
    /*public static void findS(String s, char[][] M) {
        ArrayList<Point> result = new ArrayList<>();
        int count = 0;
        for (int r = 0; r < M.length; r++) {
            for (int c = 0; c < M[r].length; c++) {
                if (M[r][c] == s.charAt(count)) {
                    result.add(new Point(r,c));
                    count++;
                }
                else if (count != 0){
                    c--;
                    count = 0;
                    result.clear();
                }
                if (count == s.length())
                    break;
            }
            if (count == s.length())
                break;
        }
        if (count == s.length()) {
            System.out.println("answer = yes\norigin = "  + "(" + (int)result.get(0).getX() + ", " + (int)result.get(0).getY() + ") ");
            System.out.print("Coordinates = [");
            for (Point p : result) {
                System.out.print("(" + (int) p.getX() + ", " + (int) p.getY() + ") ");
            }
            System.out.print("]");
        }
        else
            System.out.println("answer = no");
    }*/

    /*
     * recursively
     * method called from client
     * prints result
     */
    /*public static void findSinM(String s, char[][] M) {
        ArrayList<Point> result = new ArrayList<>();
        if (findSinM(s, M, new Point(0,0),0, result)) {
            System.out.println("answer = yes\norigin = "  + "(" + (int)result.get(0).getX() + ", " + (int)result.get(0).getY() + ") ");
            System.out.print("Coordinates = [");
            for (Point p : result) {
                System.out.print("(" + (int) p.getX() + ", " + (int) p.getY() + ") ");
            }
            System.out.print("]");
        }
        else
            System.out.println("answer = no");
    }
    // finds String s in char array M
    public static boolean findSinM(String s, char[][] M, Point pos, int count, ArrayList<Point> result) {
        // sets row and col
        int r = (int)pos.getY();
        int c = (int)pos.getX();

        // check to see for row adjustment
        if (c == M[0].length) {
            c = 0;
            r++;
            pos.setLocation(c, r);
        }

        // if reached end
        if (r == M.length)
            return false;

        // if pos = next char
        if (M[r][c] == s.charAt(count)) {
            // add result and update count
            result.add(new Point(r,c));
            count++;

            // update pos
            pos.translate(1,0);
            if (pos.getX() == M[0].length) {
                pos.setLocation(0, pos.getY()+1);
            }
        }
        // else if needs reset
        else if (count != 0) {
            // reset count and clear result
            count = 0;
            result.clear();
        }
        // else if does not need reset
        else if (count == 0)
            pos.translate(1,0);

        // if complete return result
            if (count == s.length())
            return true;

        // go to next pos
        return findSinM(s, M, pos, count, result);
    }*/


    public static void findSinMExplore(String s, char[][] M) {
        ArrayList<Point> result = new ArrayList<>();
        if (findSinMExplore(s, M, new Point(0,0),0, result)) {
            System.out.println("answer = yes\norigin = "  + "(" + (int)result.get(0).getX() + ", " + (int)result.get(0).getY() + ") ");
            System.out.print("Coordinates = [");
            for (Point p : result) {
                System.out.print("(" + (int) p.getX() + ", " + (int) p.getY() + ") ");
            }
            System.out.print("]");
        }
        else
            System.out.println("answer = no");
    }
    // finds String in s in char array M
    public static boolean findSinMExplore(String s, char[][] M, Point pos, int count, ArrayList<Point> result) {
        // checks if string found
        if (count == s.length())
            return true;

        // set pos
        int r = (int)pos.getY();
        int c = (int)pos.getX();

        // check if pos is valid
        if (c < 0 || (c == M[0].length && count > 0)) 
            return false;

        // check to see for row adjustment
        if (c == M[0].length) {
            c = 0;
            r++;
            pos.setLocation(c, r);
        }

        // check if pos is valid
        if (r < 0 || r == M.length)
            return false;

        // check if pos is equal
        if (M[r][c] == s.charAt(count) && !result.contains(pos)) {
            result.add(new Point(r,c));
            count++;

            // explore all 4 directions
            if(findSinMExplore(s, M, new Point(c,r-1), count, result)) // north
                return true;
            if(findSinMExplore(s, M, new Point(c+1,r), count, result)) // east
                return true;
            if(findSinMExplore(s, M, new Point(c,r+1), count, result)) // south
                return true;
            if(findSinMExplore(s, M, new Point(c-1,r), count, result)) // west
                return true;

            // if not the first value, return false
            if (count > 1) {
                result.remove(result.size()-1);
                return false;
            }

            // else reset
            count = 0;
            result.clear();
        }
        else if (count > 0)
            return false;

        return findSinMExplore(s, M, new Point(c+1, r), count, result);
    }
}
