package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

public class DeepestNode {

	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Deepest node : " + findDeepestNode(root));
	}

	@SuppressWarnings("unchecked")
	public static int findDeepestNode(BTreeNode<Integer> root) {
		if (null == root) {
			return Integer.MIN_VALUE;
		}
		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();
		treeNodesQueue.enqueue(root);
		BTreeNode<Integer> deepestNode = root;
		while (!treeNodesQueue.isEmpty()) {
			deepestNode = (BTreeNode<Integer>) treeNodesQueue.dequeue();
			if (null != deepestNode.left) {
				treeNodesQueue.enqueue(deepestNode.left);
			}
			if (null != deepestNode.right) {
				treeNodesQueue.enqueue(deepestNode.right);
			}
		}
		return deepestNode.value;
	}
}
