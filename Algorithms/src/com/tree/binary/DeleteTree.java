package com.tree.binary;

import com.node.BTreeNode;

public class DeleteTree {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		deleteTree(root);
		RecursionTraversal.inorderTraverse(root);
	}

	/*-
	 * Root must be deleted after deleting left and right nodes
	 */
	public static void deleteTree(BTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		deleteTree(root.left);
		deleteTree(root.right);
		root.value = -1;
	}
}
