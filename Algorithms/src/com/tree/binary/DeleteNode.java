package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

class RootNodePair {
	public BTreeNode<Integer> parent;
	public BTreeNode<Integer> node;
	String position;

	RootNodePair(BTreeNode<Integer> parent, BTreeNode<Integer> node, String position) {
		this.parent = parent;
		this.node = node;
		this.position = position;
	}
}

public class DeleteNode {

	/*-
	 * Find the last node and de-link.
	 * Find the node to be deleted.
	 * Replace the found node with last node. 
	 */
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		searchElementAndReplace(root, 3, delinkAndGetLastNode(root));
		System.out.println("After deletion:");
		InorderTraversalteration.inorderTravsere(root);
	}

	/*
	 * We had to create a new data structure to keep track of parent as in java
	 * there is no free function to delete the object. Only way is to remove all
	 * references.
	 */
	public static int delinkAndGetLastNode(BTreeNode<Integer> root) {
		if (null == root)
			return Integer.MIN_VALUE;

		Queue<RootNodePair> treeNodesQueue = new Queue<>();
		treeNodesQueue.enqueue(new RootNodePair(null, root, null));
		RootNodePair current = null;
		while (!treeNodesQueue.isEmpty()) {
			current = (RootNodePair) treeNodesQueue.dequeue();
			if (null != current.node.left) {
				treeNodesQueue.enqueue(new RootNodePair(current.node, current.node.left, "LEFT"));
			}
			if (null != current.node.right) {
				treeNodesQueue.enqueue(new RootNodePair(current.node, current.node.right, "RIGHT"));
			}
		}

		if (current.position.equals("LEFT")) {
			current.parent.left = null;
		}
		if (current.position.equals("RIGHT")) {
			current.parent.right = null;
		}
		return current.node.value;
	}

	@SuppressWarnings("unchecked")
	public static void searchElementAndReplace(BTreeNode<Integer> root, Integer value, Integer replacement) {
		if (null == root) {
			return;
		}
		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();
		treeNodesQueue.enqueue(root);
		BTreeNode<Integer> current = null;

		while (!treeNodesQueue.isEmpty()) {
			current = (BTreeNode<Integer>) treeNodesQueue.dequeue();

			// Check the value of root
			if (current.value == value) {
				current.value = replacement;
				break;
			}

			// Add left and right nodes to queue
			if (null != current.left) {
				treeNodesQueue.enqueue(current.left);
			}
			if (null != current.right) {
				treeNodesQueue.enqueue(current.right);
			}
		}

		return;
	}
}
