
public class Cilent
{
    public static void main()
    {
        boolean[][] image1 = {   {false,false,false,false,false,false,false,false,false},
                {false,true, true, true, true, true, true, true, false},         
                {false,true, false,false,false,false,false,false,false},
                {false,true, false,true, false,true, false,true, true},
                {false,true, false,true, false,false,false,false,true},
                {false,true, false,true, true, true, true, false,false},
                {false,true, false,false,false,false,true, false,false},
                {false,true, true, true, true, false,true, true, true}, 
                {false,false,false,false,false,false,true, false,false}};
                
                boolean[][] image2 = {   {true,true,false,false,false,false,false,false,false},
                {false,true, true, true, true, true, true, true, false},         
                {false,true, false,false,false,false,false,false,false},
                {false,true, false,true, false,true, false,true, true},
                {false,true, false,true, false,false,false,false,true},
                {false,true, false,true, true, true, true, false,false},
                {false,true, false,false,false,false,true, false,false},
                {false,true, true, true, true, false,true, true, true}, 
                {false,false,false,false,false,false,true, false,false}};
             
        Grid grid1 = new Grid(image1);      
        Grid grid2 = new Grid(image2);

        System.out.println("Before alter\n"+grid1);
        grid1.alter(image1,3,5);
        System.out.println("After alter(row=3,col=5)\n"+grid1);

        System.out.println("grid2\n"+grid2);
        System.out.println("There is "+grid2.countConponent()+" black blocks in the grid2");
    }
}
