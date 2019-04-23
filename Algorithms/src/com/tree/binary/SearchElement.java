package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

public class SearchElement {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Element found(Recursion): " + searchElementUsingRecursion(root, 4));
		System.out.println("Element found(Iteration): " + searchElementUsingIteration(root, 4));
	}

	public static BTreeNode<Integer> searchElementUsingRecursion(BTreeNode<Integer> root, Integer value) {

		BTreeNode<Integer> searchedElement = null;
		// Check root
		if (null == root) {
			return searchedElement;
		}
		if (value == root.value) {
			return root;
		}

		// Search in left subtree
		searchedElement = searchElementUsingRecursion(root.left, value);
		if (null != searchedElement) {
			return searchedElement;
		}

		// Search in right subtree
		searchedElement = searchElementUsingRecursion(root.right, value);
		if (null != searchedElement) {
			return searchedElement;
		}
		return searchedElement;
	}

	@SuppressWarnings("unchecked")
	public static boolean searchElementUsingIteration(BTreeNode<Integer> root, Integer value) {
		boolean isPresent = false;
		if (null == root) {
			return isPresent;
		}
		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();
		treeNodesQueue.enqueue(root);
		BTreeNode<Integer> current = null;

		while (!treeNodesQueue.isEmpty()) {
			current = (BTreeNode<Integer>) treeNodesQueue.dequeue();

			// Check the value of root
			if (current.value == value) {
				isPresent = true;
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

		return isPresent;
	}
}
