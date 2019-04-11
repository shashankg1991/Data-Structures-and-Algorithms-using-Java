package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

public class Height {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Height(Recursion): " + findHeightUsingRecursion(root));
		System.out.println("Height(Iteration): " + findHeightUsingIteration(root));
	}

	public static Integer findHeightUsingRecursion(BTreeNode<Integer> root) {
		if (null == root) {
			return 0;
		}

		// Height of node = height of subtree + 1 as one height level will be
		// used to connect node to child.
		int leftHeight = findHeightUsingRecursion(root.left);
		int rightHeight = findHeightUsingRecursion(root.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	@SuppressWarnings("unchecked")
	public static Integer findHeightUsingIteration(BTreeNode<Integer> root) {
		Integer height = 0;
		if (null == root) {
			return height;
		}

		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();

		// At each level end we add a marked to indicate that the level is done.
		// When the we encounter the marker, we reinsert it to indicate
		// completion of subsequent level at proper place.
		treeNodesQueue.enqueue(root);
		treeNodesQueue.enqueue(null);
		BTreeNode<Integer> current = null;
		while (!treeNodesQueue.isEmpty()) {
			current = (BTreeNode<Integer>) treeNodesQueue.dequeue();

			// If empty check not added here, null be queued and dequeued
			// infinitely
			if (null == current) {
				if (!treeNodesQueue.isEmpty()) {
					treeNodesQueue.enqueue(null);
				}
				height++;
			}
			// Add left and right nodes to queue only if we done't have marker
			// to cater
			else {

				if (null != current.left) {
					treeNodesQueue.enqueue(current.left);
				}
				if (null != current.right) {
					treeNodesQueue.enqueue(current.right);
				}
			}
		}
		return height;
	}
}
