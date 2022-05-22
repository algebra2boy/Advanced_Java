
/**
 * FamilyTreeOfUniSprouts_CLIENT:
 */

import java.util.*;
import java.util.Scanner;

public class FamilyTreeOfUniSprouts_CLIENT
{
    // global variables
    static FamilyTreeOfUniSprouts_Node root;
    static String names[][] = {{"Jones","ROOT-Node"},
            {"Bill","Jones"},  {"Katy","Jones"}, {"Mike","Jones"}, {"Tom","Jones"},
            {"Dave1","Bill"},  {"Mary","Bill"}, {"Leo","Katy"}, {"Betty","Mike"}, 
            {"Roger","Mike"}, {"Larry","Mary"}, {"Paul","Mary"}, {"Penny","Mary"},
            {"Don","Betty"}, {"Peter","Paul"}, {"Dave2","Don"}
        };    

    // ====================================================================
    // =========================== MAIN ==================================== 
    // ====================================================================
    public static void main()
    {
        int  playAgain;
        String name, namesList= "\n"; 
        Scanner sc = new Scanner(System.in);

        // Build the Family of UniSprouts Tree       
        buildFamilyTreeOfUniSprouts();

        do {

            // Gather names
            for (int r=0; r<names.length; r++) {
                namesList += "   " + names[r][0] + "     \t" + names[r][1] + "\n";                
            }

            // Output namesList         
            System.out.println(" nameList: \n   Child         Parent" + namesList);

            printFamilyTreeOfUniSprouts(root);
            printSideWays();

            // Input name + print all relatives
            System.out.print("\n\n Enter a name from which to get GrandParent/Parent/Siblings/Cousins/Children/GrandChildren: ");
            name = sc.next();
            printRelatives(name);

            // Play Again?
            System.out.print("\n\n Play Again? (1==yes, 2==no): ");
            playAgain = sc.nextInt();            

        } while (playAgain == 1);

    } // main  
    // ==================== buildFamilyTreeOfUniSprouts ====================== 
    public static void buildFamilyTreeOfUniSprouts()
    {      
        for(int r=0; r<names.length; r++){ // put the name one by one
            if(root == null){
                root = new FamilyTreeOfUniSprouts_Node(names[r][0], 0, null);
            }else{ // root != null
                FamilyTreeOfUniSprouts_Node Parent  = findPerson(names[r][1]);
                FamilyTreeOfUniSprouts_Node child;
                if(Parent.getChildren() == null){ // no child
                    child = new FamilyTreeOfUniSprouts_Node(names[r][0], Parent.getGenerationLevel() + 1, null);
                }else{ // has at least one child 
                    FamilyTreeOfUniSprouts_Node curr_Child = Parent.getChildren();
                    while(curr_Child.getNext() != null){
                        curr_Child = curr_Child.getNext();
                    }
                    child = new FamilyTreeOfUniSprouts_Node(names[r][0], curr_Child.getGenerationLevel(), null);
                }
                placeNodeInFamilyTreeOfUniSprouts(child,Parent);
            }
        }
    }  // buildFamilyTreeOfUniSprouts()

    // ============== placeNodeInFamilyTreeOfUniSprouts  ================= 
    public static void placeNodeInFamilyTreeOfUniSprouts(FamilyTreeOfUniSprouts_Node child, FamilyTreeOfUniSprouts_Node parent)
    {    
        if(parent.getChildren() == null){
            parent.setChildren(child);
        }else{  //parent.getChildren() != null
            FamilyTreeOfUniSprouts_Node curr_Child = parent.getChildren();
            while(curr_Child.getNext() != null){
                curr_Child = curr_Child.getNext();
            }
            curr_Child.setNext(child);
            child.setPrev(curr_Child);
        }
    } // placeNodeInFamilyTreeOfUniSprouts()

    // ==================== findParent  ======================== 
    public static FamilyTreeOfUniSprouts_Node findPerson(String person){
        return findPerson(root, person);
    }

    private static FamilyTreeOfUniSprouts_Node findPerson(FamilyTreeOfUniSprouts_Node Node, String person){
        if(Node == null || Node.getName().equals(person)){ 
            return Node;
        }else if(findPerson(Node.getChildren(),person) == null ){ // no children to search, then search next            
            return findPerson(Node.getNext(),person);
        }else{ // no next to search, then search children
            return findPerson(Node.getChildren(),person); 
        }
    }
    // ==================== findParent  ======================== 

    // ==================== printFamilyTreeOfUniSprouts  ======================== 
    public static void printFamilyTreeOfUniSprouts(FamilyTreeOfUniSprouts_Node current)
    {  
        if(current != null){
            System.out.println("Level:" + current.getGenerationLevel() +" "+ current.getName()+" ");
            printFamilyTreeOfUniSprouts(current.getChildren());
            printFamilyTreeOfUniSprouts(current.getNext());
        }
    }  // printFamilyTreeOfUniSprouts()*/

    public static void printSideWays(){
        printSideWays(root);
    }

    private static void printSideWays(FamilyTreeOfUniSprouts_Node root){
        if(root != null){
            for(int i = 0; i < root.getGenerationLevel(); i++ ){
                System.out.print("\t");
            }
            System.out.println(root.getGenerationLevel()+"."+root.getName());
            printSideWays(root.getChildren());
            printSideWays(root.getNext());
        }
    }

    // ========================= printRelatives =============================== 
    public static void printRelatives(String name)
    {    
        FamilyTreeOfUniSprouts_Node person = findPerson(name);
        System.out.print("Sibling: ");
        printSibling(person);

        FamilyTreeOfUniSprouts_Node children = person.getChildren();

        System.out.print("Children: ");
        printChildren(children);
        System.out.println();

        System.out.print("GrandChildren: ");
        printGrandChildren(children);

        System.out.print("Parent: "); // parent's level is one less than child
        FamilyTreeOfUniSprouts_Node parent = findParent(name,person.getGenerationLevel() - 1);
        printParent(parent); 
        System.out.println();

        System.out.print("GrandParents: "); // grandparent's level is two less than child
        printGrandParents(parent,person.getGenerationLevel()-2);
        System.out.println();

        System.out.print("Nieces/Nephews: "); // children of the person's sibling(s)
        printNiecesNephew(person);
        System.out.println();

        System.out.print("Cousins: "); // same level but different parents
        printCousins(parent,person.getGenerationLevel()); 
        System.out.println();
    }  // printRelatives()   

    public static void printGrandParents(FamilyTreeOfUniSprouts_Node parent, int level){
        printGrandParents(root,parent.getName(),level);
    }

    private static void printGrandParents(FamilyTreeOfUniSprouts_Node node, String parent, int level){
        if(node != null &&
        node.getGenerationLevel() == level &&
        containChild(node,parent)){ // this method is to make sure node.child(ren) does have the person's parent 
            System.out.print(node.getName() + " ");
        }        
        if(node.getNext() != null){
            printGrandParents(node.getNext(), parent, level);
        }
        if(node.getChildren() != null){
            printGrandParents(node.getChildren(), parent, level);
        }
    }

    public static void printCousins(FamilyTreeOfUniSprouts_Node parent, int level){
        printCousins(root,parent,level);
    }
    // find same level but different parents
    private static void printCousins(FamilyTreeOfUniSprouts_Node node, FamilyTreeOfUniSprouts_Node parent, int level){ 
        //cousin -> Node.parent.sibling.children       
        if(node != null &&
        node.getGenerationLevel() == level && // same level
        findParent(node.getName(), node.getGenerationLevel() - 1) != parent){ // making sure they don't have the same parent
            System.out.print(node.getName() + " ");
        }        
        if(node.getNext() != null){
            printCousins(node.getNext(), parent, level);
        }
        if(node.getChildren() != null){
            printCousins(node.getChildren(), parent, level);
        }
    }

    private static boolean containChild(FamilyTreeOfUniSprouts_Node Node, String name){
        if(Node.getChildren() == null){return false;}
        else{
            FamilyTreeOfUniSprouts_Node curr_Child = Node.getChildren();
            while(curr_Child != null){
                if(curr_Child.getName().equals(name)){return true;}
                curr_Child = curr_Child.getNext();
            }
        }
        return false;
    }

    public static FamilyTreeOfUniSprouts_Node findParent(String name, int level){
        return findParent(root, name, level);
    }

    private static FamilyTreeOfUniSprouts_Node findParent(FamilyTreeOfUniSprouts_Node Node, String name, int level){
        if((Node == null || 
            (Node.getGenerationLevel() == level) && containChild(Node,name))){ // parent's level is one less than the child and make sure the parent do have the children
            return Node;
        }else if(findParent(Node.getChildren(),name,level) == null ){           
            return findParent(Node.getNext(),name,level);
        }else{
            return findParent(Node.getChildren(),name,level); 
        }
    }

    private static void printNiecesNephew(FamilyTreeOfUniSprouts_Node person){
        FamilyTreeOfUniSprouts_Node front = person.getPrevious(), back = person.getNext();
        while(front != null){   printChildren(front.getChildren());  front = front.getPrevious();}
        while(back  != null) {  printChildren(back.getChildren());  back = back.getNext();       }
    }

    public static void printSibling(FamilyTreeOfUniSprouts_Node sibling){
        printSiblingFront(sibling.getPrevious());
        printSiblingBack(sibling.getNext());
        System.out.println();
    }

    private static void printSiblingFront(FamilyTreeOfUniSprouts_Node sibling){
        if(sibling != null){
            printSiblingFront(sibling.getPrevious());
            System.out.print(sibling.getName() + " ");
        }
    }

    private static void printSiblingBack(FamilyTreeOfUniSprouts_Node sibling){
        if(sibling != null){
            printSiblingBack(sibling.getNext());
            System.out.print(sibling.getName() + " ");
        }
    }

    private static void printChildren(FamilyTreeOfUniSprouts_Node children){
        while(children != null){
            System.out.print(children.getName()+" ");
            children = children.getNext();
        }
    }

    private static void printGrandChildren(FamilyTreeOfUniSprouts_Node children){
        while(children != null){
            printChildren(children.getChildren()); // grandchildren branch
            children = children.getNext(); 
        }
        System.out.println();
    }

    private static void printParent(FamilyTreeOfUniSprouts_Node parent){ if(parent != null){System.out.print(parent.getName());}}
}  // FamilyTreeOfUniSprouts_CLIENT

