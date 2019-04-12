package com.tree.binary;

import com.node.BTreeNode;

public class Sum {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Sum: " + findSum(root));
	}

	public static Integer findSum(BTreeNode<Integer> root) {
		if (null == root) {
			return 0;
		} else {
			return findSum(root.left) + root.value + findSum(root.right);
		}
	}

}
