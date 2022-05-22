import java.util.*;
public class Bucket
{
    public static void main()
    {
        int[]  a = {105, 87142, 95, 12987120, 7194, 9};
        //int[] a = {400,300,100,200,500};
        int buckets[] [] = new int[10][a.length]; //digits 0-9 
        bucketSort(a,buckets);
    }

    public static void bucketSort(int[] a, int[][] buckets)
    {
        int places = 1;
        while(!(getSlot(0,buckets)==a.length)){ // stop when the first row is full
            bucketToArray(buckets,a);// put bucket into array            
            arrayToBucket(buckets,places,a); // put the array values into bucket
            places*=10;  
            printBucket(buckets);
        }
        System.out.println(Arrays.toString(a));
    }
    public static void bucketToArray(int[][] buckets,int[] a){
        int start = 0; 
        for(int row = 0; row < buckets.length;row++){ // digit 0- 9
                int count = getSlot(row,buckets);
                for(int col = 0; col < count; col++){
                    a[start] = buckets[row][col];
                    start++;
                    buckets[row][col] = 0;   // empty the bucket when it is done "gathering"           
                }
            }
    }
    public static void arrayToBucket(int[][] buckets, int places, int[] a){
        for(int i = 0; i < a.length; i++){
                int digit = ( a[i] / places) % 10; // get digits forward
                int slot = getSlot(digit,buckets); // get the position of where to put the value in the bucket
                buckets[digit][slot] = a[i]; // insert values to bucket
        }
    }
                
    public static int getSlot(int digit, int[][] buckets){
        int slot = 0;
        for(int col = 0; col < buckets[digit].length; col++){
           if(buckets[digit][col]==0){
                break;
           }
           slot++;
        }
        return slot;
    }

    public static void printBucket(int[][] buckets){
        for(int i = 0;i<buckets.length;i++){
            System.out.print(buckets[i][0]);
            for(int j = 1;j<buckets[i].length;j++){
                System.out.printf(","+buckets[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
