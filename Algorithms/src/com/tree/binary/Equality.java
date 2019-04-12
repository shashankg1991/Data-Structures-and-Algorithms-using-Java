package com.tree.binary;

import com.node.BTreeNode;

public class Equality {
	public static void main(String[] args) {
		BTreeNode<Integer> root1 = BinaryTree.createTestBTree();
		BTreeNode<Integer> root2 = BinaryTree.createTestBTree();
		root2.left.right.value = 11;
		System.out.println("Are equal : " + areEqual(root1, root1));
		System.out.println("Are equal : " + areEqual(root1, root2));
	}

	public static boolean areEqual(BTreeNode<Integer> root1, BTreeNode<Integer> root2) {
		if (null == root1 && null == root2) {
			return true;
		}
		if (null == root1 || null == root2) {
			return false;
		}

		return root1.value == root2.value && areEqual(root1.left, root2.left) && areEqual(root1.right, root2.right);
	}
}
