package main.java.algorithm.common;

import java.util.Objects;

import com.sun.source.tree.BinaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode()
    {
    }

    public TreeNode(int val)
    {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * traverse the binary tree on InOrder traversal algorithm
     */
    public void inOrder()
    {
        privInOrder(this);
    }

    private void privInOrder(TreeNode node)
    {
        if(Objects.isNull(node)) {
            return;
        }
        privInOrder(node.left);
        System.out.printf("%s ", node.val);
        privInOrder(node.right);
    }
    /**
     * traverse the binary tree on PreOrder traversal algorithm
     */
    public void preOrder()
    {
        privPreOrder(this);
    }

    private void privPreOrder(TreeNode node)
    {
        if(Objects.isNull(node)) {
            return;
        }
        System.out.printf("%s ", node.val);
        privPreOrder(node.left);
        privPreOrder(node.right);
    }

    /**
     * Java method to create binary tree with test data
     * Tree:
     *      40
     *     /\
     *    20   50
     *   / \    \
     *  10  30   60
     * /   /\
     * 5  67  78
     * @return a sample binary tree for testing
     */
    public static TreeNode create()
    {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);

        root.left.right = new TreeNode(30);
        root.right = new TreeNode(50);
        root.right.right = new TreeNode(60);
        root.left.right.left = new TreeNode(67);
        root.left.right.right = new TreeNode(78);

        return root;
    }
}
