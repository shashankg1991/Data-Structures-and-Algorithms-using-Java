package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

public class Size {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Maximum value(Recursion): " + findSizeUsingRecursion(root));
		System.out.println("Maximum value(Iteration): " + findSizeUsingIteration(root));
	}

	public static Integer findSizeUsingRecursion(BTreeNode<Integer> root) {
		if (null == root) {
			return 0;
		} else {
			return findSizeUsingRecursion(root.left) + 1 + findSizeUsingRecursion(root.right);
		}
	}

	@SuppressWarnings("unchecked")
	public static Integer findSizeUsingIteration(BTreeNode<Integer> root) {
		Integer size = 0;
		if (null == root) {
			return size;
		}

		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();
		treeNodesQueue.enqueue(root);
		BTreeNode<Integer> current = null;
		while (!treeNodesQueue.isEmpty()) {
			current = (BTreeNode<Integer>) treeNodesQueue.dequeue();
			size++;

			// Add left and right nodes to queue
			if (null != current.left) {
				treeNodesQueue.enqueue(current.left);
			}
			if (null != current.right) {
				treeNodesQueue.enqueue(current.right);
			}
		}
		return size;
	}
}
