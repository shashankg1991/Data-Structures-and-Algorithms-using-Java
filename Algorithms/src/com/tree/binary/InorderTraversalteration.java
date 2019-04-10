package com.tree.binary;

import com.node.BTreeNode;
import com.stack.Stack;

public class InorderTraversalteration {
	/*-
	 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	 * https://algorithms.tutorialhorizon.com/binary-tree-preorder-traversal-non-recursive-approach/
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
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(4);
		binaryTree.insert(5);
		binaryTree.insert(6);
		binaryTree.insert(7);
		BTreeNode<Integer> root = binaryTree.root;
		inorderTravsere(root);
	}

	@SuppressWarnings("unchecked")
	public static void inorderTravsere(BTreeNode<Integer> root) {
		Stack<BTreeNode<Integer>> treeNodesStack = new Stack<>();
		BTreeNode<Integer> currentNode = root;

		while (!treeNodesStack.isEmpty() || currentNode != null) {
			// Reach the end of left sub-tree
			while (null != currentNode) {
				treeNodesStack.push(currentNode);
				currentNode = currentNode.left;
			}

			// Print the left node
			currentNode = (BTreeNode<Integer>) treeNodesStack.pop();
			System.out.print(currentNode.value + " ");

			/*
			 * Print the root of left node and continue doing so until a right
			 * subtree is found. If no right subtree found print complete
			 * printing till root.
			 * 
			 * The while loop can be removed and will have the same results. It
			 * has been added for simplicity
			 */
			while (currentNode.right == null && !treeNodesStack.isEmpty()) {
				currentNode = (BTreeNode<Integer>) treeNodesStack.pop();
				System.out.print(currentNode.value + " ");
			}

			// If there is right sub-tree process it.
			currentNode = currentNode.right;
		}

	}
}
