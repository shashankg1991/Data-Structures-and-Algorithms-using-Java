package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

public class MaximumLevelSum {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Maximum level sum : " + maximumLevelSum(root));
	}

	@SuppressWarnings("unchecked")
	public static int maximumLevelSum(BTreeNode<Integer> root) {
		if (null == root) {
			return Integer.MIN_VALUE;
		}
		int maximumSum = 0;
		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();
		// Insert root and level marker.
		treeNodesQueue.enqueue(root);
		treeNodesQueue.enqueue(null);
		int levelSum = 0;
		while (!treeNodesQueue.isEmpty()) {
			BTreeNode<Integer> current = (BTreeNode<Integer>) treeNodesQueue.dequeue();
			if (current == null) {
				if (levelSum > maximumSum) {
					maximumSum = levelSum;
				}
				// Only insert level marker if there are more elements.
				if (!treeNodesQueue.isEmpty()) {
					treeNodesQueue.enqueue(null);
				}
				levelSum = 0;
			}
			// Queue children
			else {
				levelSum += current.value;
				if (null != current.left) {
					treeNodesQueue.enqueue(current.left);
				}
				if (null != current.right) {
					treeNodesQueue.enqueue(current.right);
				}
			}
		}
		return maximumSum;
	}
}
