package com.tree.binary;

import com.node.BTreeNode;

public class RecursionTraversal {
	/*-
	 * Tree created is 
	 * 			  1
	 * 			/   \
	 * 		   2     3
	 * 		  /\    / \
	 * 		4   5  6   7
	 * @param args
	 */
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();

		System.out.print("Preorder : ");
		preorderTraverse(root);
		System.out.println();

		System.out.print("Inorder : ");
		inorderTraverse(root);
		System.out.println();

		System.out.print("Postorder : ");
		postorderTraverse(root);
		System.out.println();
	}

	/*
	 * Order: Node,Left,Right (NLR)
	 */
	public static void preorderTraverse(BTreeNode<Integer> root) {
		if (null != root) {
			System.out.print(root.value + " ");
			preorderTraverse(root.left);
			preorderTraverse(root.right);
		}
	}

	/*
	 * Order: Left,Node,Right (LNR)
	 */
	public static void inorderTraverse(BTreeNode<Integer> root) {
		if (null != root) {
			inorderTraverse(root.left);
			System.out.print(root.value + " ");
			inorderTraverse(root.right);
		}
	}

	/*
	 * Order: Left,Right,Node (LRN)
	 */
	public static void postorderTraverse(BTreeNode<Integer> root) {
		if (null != root) {
			postorderTraverse(root.left);
			postorderTraverse(root.right);
			System.out.print(root.value + " ");
		}
	}

}
