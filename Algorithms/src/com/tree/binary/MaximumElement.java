package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

public class MaximumElement {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Maximum value(Recursion): " + findMaxElementUsingRecursion(root));
		System.out.println("Maximum value(Iteration): " + findMaxElementUsingIteration(root));
	}

	public static Integer findMaxElementUsingRecursion(BTreeNode<Integer> root) {
		Integer max = Integer.MIN_VALUE;
		if (null == root) {
			return Integer.MIN_VALUE;
		}

		// Get the maximum values of left and right subtree
		Integer leftMax = findMaxElementUsingRecursion(root.left);
		Integer rightMax = findMaxElementUsingRecursion(root.right);
		if (leftMax > rightMax) {
			max = leftMax;
		} else {
			max = rightMax;
		}

		// Check if root has value higher than left and right subtree
		if (root.value > max) {
			max = root.value;
		}
		return max;
	}

	@SuppressWarnings("unchecked")
	public static Integer findMaxElementUsingIteration(BTreeNode<Integer> root) {
		Integer max = Integer.MIN_VALUE;
		if (null == root) {
			return max;
		}

		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();
		treeNodesQueue.enqueue(root);
		BTreeNode<Integer> current = null;
		while (!treeNodesQueue.isEmpty()) {
			current = (BTreeNode<Integer>) treeNodesQueue.dequeue();

			// Check the value with current maximum value.
			if (current.value > max) {
				max = current.value;
			}

			// Add left and right nodes to queue
			if (null != current.left) {
				treeNodesQueue.enqueue(current.left);
			}
			if (null != current.right) {
				treeNodesQueue.enqueue(current.right);
			}
		}
		return max;
	}
}
