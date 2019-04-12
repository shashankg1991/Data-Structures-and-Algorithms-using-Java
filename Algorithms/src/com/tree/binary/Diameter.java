package com.tree.binary;

import com.node.BTreeNode;

public class Diameter {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Diameter: " + getDiameter(root));
	}

	/*-
	 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
	 * 
	 * Diameter can be the max of one:
	 * 	- diameter of left subtree
	 * 	- diameter of right subtree
	 * 	- left height + right height + 1(for root)
	 */
	public static int getDiameter(BTreeNode<Integer> root) {
		if (null == root) {
			return 0;
		}
		int lheight = Height.findHeightUsingRecursion(root.left);
		int rheight = Height.findHeightUsingRecursion(root.right);
		return Math.max(Math.max(getDiameter(root.left), getDiameter(root.right)), (lheight + 1 + rheight));
	}
}
