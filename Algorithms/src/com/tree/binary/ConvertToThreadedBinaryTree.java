package com.tree.binary;

import com.node.ThreadedBTreeNode;

/*-
 * 
 * Easy way : do inorder traversal and save in queue. Starting from head, if any node has right == null, set the right as next node in queue.
 * Understand recusrion in sense of authority : https://www.youtube.com/watch?v=d9Ks7O5kUGE
 * https://www.geeksforgeeks.org/convert-binary-tree-threaded-binary-tree-set-2-efficient/
 */
public class ConvertToThreadedBinaryTree {

	public static void main(String[] args) {
		ThreadedBTreeNode<Integer> root = ThreadedBinaryTree.createTestBTree();
		root.left.left.left = new ThreadedBTreeNode<Integer>(8);
		root.right.left.right = new ThreadedBTreeNode<Integer>(9);
		System.out.println("Modified Tree:");
		System.out.println("      1");
		System.out.println("     /   \\");
		System.out.println("    2     3");
		System.out.println("   /\\    / \\");
		System.out.println("  4   5  6   7");
		System.out.println(" /        \\");
		System.out.println("8          9");
		System.out.println();
		createThreaded(root);
		printThreadedTreeInorder(root);
	}

	static ThreadedBTreeNode<Integer> createThreaded(ThreadedBTreeNode<Integer> root) {
		// Base cases : Tree is empty or has single node
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;

		// If left is not null process left subtree. Process left subtree
		// as it does not have any responsibility towards the caller parent.
		//It gives the responsibility to it's left subtree to find a node for itself instead.
		if (root.left != null) {
			// Process the left subtree
			System.out.println("Call threaded root.left : " + root.left);
			ThreadedBTreeNode<Integer> l = createThreaded(root.left);

			System.out.println("Linking from predecessor :" + l + "," + root);
			// Link a thread from predecessor to root.
			l.right = root;
			l.isRightThreaded = true;
		}

		// If current node does not have a right child then root is the
		// rightmost child in the subtree
		if (root.right == null) {
			System.out.println("Returning right : " + root);
			return root;
		}

		// Otherwise, right subtree is responsible for providing the node to the
		// caller.
		System.out.println("Call threaded root.right : " + root.right);
		return createThreaded(root.right);
	}

	public static void printThreadedTreeInorder(ThreadedBTreeNode<Integer> root) {
		// first go to most left node
		ThreadedBTreeNode<Integer> current = getLeftMostNode(root);
		// now travel using right pointers
		while (current != null) {
			System.out.print(" " + current.value);
			// check if node has a right thread
			if (current.isRightThreaded)
				current = current.right;
			else
				// else go to left most node in the right subtree
				current = getLeftMostNode(current.right);
		}
		System.out.println();
	}

	public static ThreadedBTreeNode<Integer> getLeftMostNode(ThreadedBTreeNode<Integer> node) {
		ThreadedBTreeNode<Integer> leftMostNode = node;
		if (null == leftMostNode) {
			leftMostNode = null;
		} else {
			while (leftMostNode.left != null) {
				leftMostNode = leftMostNode.left;
			}
		}
		return leftMostNode;
	}
}
