package com.tree.binary;

import com.node.BTreeNode;

/*
 * Means same structure, values can be different.
 */
public class Isomorphic {
	public static void main(String[] args) {
		BTreeNode<Integer> root1 = BinaryTree.createTestBTree();
		BTreeNode<Integer> root2 = BinaryTree.createTestBTree();
		System.out.println("Are isomorphic : " + areIsomorhic(root1, root2));
	}

	public static boolean areIsomorhic(BTreeNode<Integer> root1, BTreeNode<Integer> root2) {
		if (null == root1 && null == root2) {
			return true;
		}

		if (null == root1 || null == root2) {
			return false;
		}

		return areIsomorhic(root1.left, root2.left) && areIsomorhic(root1.right, root2.right);
	}
}
