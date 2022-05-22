 

// ------------------------------------- TreeNode -------------------------------------------
public class TreeNode
{
    public int data;
    public TreeNode left;
    public TreeNode right;

    // constructs a leaf node with given data
    public TreeNode(int data)
    {
        this(data, null, null);
    }

    // constructs a branch node with given data, left subtree,
    // right subtree
    public TreeNode(int data, TreeNode left,TreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}