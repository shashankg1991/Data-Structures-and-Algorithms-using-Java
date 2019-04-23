package com.tree.binary;

import com.node.BTreeNode;

/*
 * Means same structure as it is or on swapping left and right nodes, values can be different.
 */
public class QuasiIsomorphic {
	public static void main(String[] args) {
		BTreeNode<Integer> root1 = BinaryTree.createTestBTree();
		root1.left = null;
		BTreeNode<Integer> root2 = BinaryTree.createTestBTree();
		root2.right = null;
		System.out.println("Are quasi isomorphic : " + areQuasiIsomorhic(root1, root2));
	}

	public static boolean areQuasiIsomorhic(BTreeNode<Integer> root1, BTreeNode<Integer> root2) {
		if (null == root1 && null == root2) {
			return true;
		}

		if (null == root1 || null == root2) {
			return false;
		}

		return (areQuasiIsomorhic(root1.left, root2.left) && areQuasiIsomorhic(root1.right, root2.right))
				|| (areQuasiIsomorhic(root1.left, root2.right) && areQuasiIsomorhic(root1.right, root2.left));
	}
}