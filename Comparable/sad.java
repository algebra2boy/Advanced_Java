import java.util.Stack;
public class sad
{
    public static void main(){
        Stack<Integer> s = new Stack<Integer>();
        s.add(1);s.add(2);s.add(3);
        System.out.println(s);
        
        Stack<Integer> s2 = s;
        System.out.println(s.equals(s2));
        System.out.println(s==s2);
        s2.pop();
        System.out.println("s2 ->>"+ s2);
        System.out.println("s ->>"+ s);
    }
}
