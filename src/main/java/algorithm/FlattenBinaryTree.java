package main.java.algorithm;

import java.util.Objects;

import main.java.algorithm.common.TreeNode;


/**
 * 114. Flatten Binary Tree to Linked List
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * - The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the
 * list and the left child pointer is always null.
 * - The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * Input: root = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class FlattenBinaryTree
{
    public static void main(String[] args)
    {
        TreeNode root = TreeNode.create();
        root.preOrder();
        flatten(root);
        System.out.println();
        root.preOrder();
    }

    public static void flatten(TreeNode node)
    {
        if(Objects.isNull(node)) {
            return;
        }

        flatten(node.left);
        flatten(node.right);

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.left = null;
        node.right = left;

        while(Objects.nonNull(node.right)) {
            node = node.right;
        }
        node.right = right;
    }
}
