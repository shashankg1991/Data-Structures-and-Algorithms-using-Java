package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

public class LeafNodes {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Leaf nodes: " + countLeafNodes(root));
	}

	@SuppressWarnings("unchecked")
	public static Integer countLeafNodes(BTreeNode<Integer> root) {
		Integer leafNodes = 0;
		if (null == root) {
			return leafNodes;
		}

		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();
		treeNodesQueue.enqueue(root);
		BTreeNode<Integer> current = null;
		while (!treeNodesQueue.isEmpty()) {
			current = (BTreeNode<Integer>) treeNodesQueue.dequeue();

			// Check the value with current maximum value.
			if (null == current.left && null == current.right) {
				leafNodes++;
			}

			// Add left and right nodes to queue
			if (null != current.left) {
				treeNodesQueue.enqueue(current.left);
			}
			if (null != current.right) {
				treeNodesQueue.enqueue(current.right);
			}
		}
		return leafNodes;
	}
}
