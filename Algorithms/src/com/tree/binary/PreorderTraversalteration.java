package com.tree.binary;

import com.node.BTreeNode;
import com.stack.Stack;

public class PreorderTraversalteration {
	/*-
	 * https://www.geeksforgeeks.org/iterative-preorder-traversal/
	 * Similar logic as the tree creation using queue.
	 * 
	 * Tree created is 
	 * 			  1
	 * 			/   \
	 * 		   2     3
	 * 		  /\    / \
	 * 		4   5  6   7
	 * @param args
	 */
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		preorderTravsere(root);
	}

	@SuppressWarnings("unchecked")
	public static void preorderTravsere(BTreeNode<Integer> root) {
		Stack<BTreeNode<Integer>> treeNodesStack = new Stack<>();
		treeNodesStack.push(root);

		while (!treeNodesStack.isEmpty()) {
			BTreeNode<Integer> node = (BTreeNode<Integer>) treeNodesStack.pop();
			System.out.print(node.value + " ");
			// Add right first so that left is popped first
			if (null != node.right)
				treeNodesStack.push(node.right);
			if (null != node.left)
				treeNodesStack.push(node.left);
		}

	}
}
