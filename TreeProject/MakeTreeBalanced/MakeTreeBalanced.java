
/* MakeTreeBalanced: Given an array of random unique numbers that makes a
 *                   badly balanced tree, redo it such that it is as fully
 *                   balanced as possible.
 *
static int a[] = {50,40,60,30,70,105,20,80,35,5,10,90,100,110,65};

OUTPUT:
UnBalanced: 
					110
				105
							100
						90
					80
			70
				65
		60
	50
		40
				35
			30
				20
						10
					5


	 Balanced: 
				110
			105
				100
		90
				80
			70
				65
	60
				50
			40
				35
		30
				20
			10
				5 
*/

import java.util.*;
public class MakeTreeBalanced
{
    static int a[] = //{40,20,70,10,30,60,80};
        {50,40,60,30,70,105,20,80,35,5,10,90,100,110,65};
        //{30,20,10};
        //{1,2,3,4};
    static TreeNode root = null;

    public static void main(String[] args)
    {
        System.out.println("\t UnBalanced: ");
        makeTree();
        printTreeSideWays(root, 1);
        System.out.println("\n\n\n");

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("\n\n\n\n");
        System.out.println("\t Balanced: ");
        root = makeBalancedTree(0,a.length-1);
        printTreeSideWays(root, 1);
    }// main

    public static void makeTree()
    {
        for (int i=0; i<a.length; i++)
            root = addNode(root,a[i]);
    }

    public static TreeNode addNode(TreeNode root, int k)
    {
        if (root == null)
            root = new TreeNode(k);
        else if (k <= root.data)
            root.left = addNode(root.left,k);
        else
            root.right = addNode(root.right,k);
        return root;
    }

    public static TreeNode makeBalancedTree(int low,int high)
    {
        if(a.length==0){return null;}
        return makeBalancedTree(root,low,high);
    }
    // postCondition: convert it into a balanced Binary Search Tree that has minimum possible height/
    private static TreeNode makeBalancedTree(TreeNode root, int low, int high){
        if(low <= high){
            int mid = (low + high) /2 ; 
            root = new TreeNode(a[mid]); // cut it half
            root.left = makeBalancedTree(root.left,low,mid-1); // left subtree
            root.right = makeBalancedTree(root.right,mid+1,high); // right subtree 
        }
        return root;
    }
    // postCondition: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private static void printTreeSideWays(TreeNode root, int level)
    {
        if (root != null) {
            printTreeSideWays(root.right, level + 1);
            for (int i = 0; i < level; i++)
            {
                System.out.print("\t");
            }
            System.out.println(root.data);
            printTreeSideWays(root.left, level + 1);
        }
    }
}  // MakeTreeBalanced

