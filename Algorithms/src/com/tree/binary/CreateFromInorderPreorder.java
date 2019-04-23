package com.tree.binary;

import com.node.BTreeNode;

public class CreateFromInorderPreorder {
	static int preorderindex = 0;

	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 6, 3 };
		int[] preorder = { 1, 2, 4, 5, 3, 6 };
		RecursionTraversal.inorderTraverse(createTree(inorder, preorder, 0, inorder.length - 1));
	}

	public static BTreeNode<Integer> createTree(int[] inorder, int[] preorder, int start, int end) {
		if (start > end)
			return null;
		// The left most node in preorder is the root of the tree.
		BTreeNode<Integer> node = new BTreeNode<Integer>(preorder[preorderindex]);

		/*
		 * Find the position of the node in inorder. The left nodes are the
		 * nodes of left subtree and the right nodes are the part of right
		 * subtree
		 */
		preorderindex++;
		// This means has children
		if (start != end) {
			int positionInInorder = getPosition(node.value, inorder);
			node.left = createTree(inorder, preorder, start, positionInInorder - 1);
			node.right = createTree(inorder, preorder, positionInInorder + 1, end);
		}
		return node;
	}

	private static int getPosition(Integer value, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == value) {
				return i;
			}
		}
		return -1;
	}
}
