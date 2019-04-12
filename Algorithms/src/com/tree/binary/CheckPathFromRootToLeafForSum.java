package com.tree.binary;

import com.node.BTreeNode;

public class CheckPathFromRootToLeafForSum {

	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Path exist for sum 8 : " + checkPathforSum(root, 8));
		System.out.println("Path exist for sum 29 : " + checkPathforSum(root, 29));
	}

	public static boolean checkPathforSum(BTreeNode<Integer> root, int sum) {
		if (null == root) {
			return sum == 0;
		}
		sum -= root.value;
		return checkPathforSum(root.left, sum) || checkPathforSum(root.right, sum);
	}
}
