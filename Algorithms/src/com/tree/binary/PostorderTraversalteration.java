package com.tree.binary;

import com.node.BTreeNode;
import com.stack.Stack;

public class PostorderTraversalteration {
	/*-
	 * https://algorithms.tutorialhorizon.com/binary-tree-postorder-traversal-non-recursive-approach/
	 * See it as creating a stack on the basis of what will be printed at the end.
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
		postorderTravsere(root);
	}

	@SuppressWarnings("unchecked")
	public static void postorderTravsere(BTreeNode<Integer> root) {
		Stack<BTreeNode<Integer>> treeNodesStack1 = new Stack<>();
		Stack<BTreeNode<Integer>> treeNodesStack2 = new Stack<>();

		treeNodesStack1.push(root);

		while (!treeNodesStack1.isEmpty()) {
			BTreeNode<Integer> currentNode = (BTreeNode<Integer>) treeNodesStack1
					.pop();
			treeNodesStack2.push(currentNode);

			if (null != currentNode.left)
				treeNodesStack1.push(currentNode.left);
			if (null != currentNode.right)
				treeNodesStack1.push(currentNode.right);
		}

		while (!treeNodesStack2.isEmpty()) {
			BTreeNode<Integer> currentNode = (BTreeNode<Integer>) treeNodesStack2
					.pop();
			System.out.print(currentNode.value + " ");
		}

	}
}
