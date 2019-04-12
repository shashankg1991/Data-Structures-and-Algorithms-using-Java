package com.tree.binary;

import com.node.BTreeNode;

public class NodeToLeafPaths {

	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		int[] paths = new int[100];
		printNodeToLeafPaths(root, paths, 0);
	}

	public static void printNodeToLeafPaths(BTreeNode<Integer> root, int[] paths, int n) {
		if (null == root) {
			return;
		}
		paths[n] = root.value;

		/*-
		 * Print only when no child is present, otherwise printing happens twice for each null child node.
		 * Try printing when root is null.
		 */
		if (null == root.left && null == root.right) {
			printArray(paths, n);
		} else {
			// Both are given same value to insert node value i.e. n+1
			// One will print and other all will override the values in array at
			// same position that last one has printed.
			printNodeToLeafPaths(root.left, paths, n + 1);
			printNodeToLeafPaths(root.right, paths, n + 1);
		}

	}

	public static void printArray(int[] paths, int n) {
		for (int i = 0; i <= n; i++) {
			System.out.print(paths[i] + " ");
		}
		System.out.println();
	}

}
