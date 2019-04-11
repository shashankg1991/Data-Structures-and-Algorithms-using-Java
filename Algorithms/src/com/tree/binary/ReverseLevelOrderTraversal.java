package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;
import com.stack.Stack;

public class ReverseLevelOrderTraversal {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		levelOrderTravsere(root);
	}

	@SuppressWarnings("unchecked")
	public static void levelOrderTravsere(BTreeNode<Integer> root) {
		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();
		Stack<BTreeNode<Integer>> treeNodesStack = new Stack<>();
		treeNodesQueue.enqueue(root);
		while (!treeNodesQueue.isEmpty()) {
			BTreeNode<Integer> node = (BTreeNode<Integer>) treeNodesQueue.dequeue();
			treeNodesStack.push(node);
			if (null != node.left) {
				treeNodesQueue.enqueue(node.left);
			}
			if (null != node.right) {
				treeNodesQueue.enqueue(node.right);
			}
		}

		while (!treeNodesStack.isEmpty()) {
			BTreeNode<Integer> node = (BTreeNode<Integer>) treeNodesStack.pop();
			System.out.print(node.value + " ");
		}
	}
}
