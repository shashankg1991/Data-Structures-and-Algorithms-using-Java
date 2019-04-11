package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

public class LevelOrderTraversal {
	/*-
	 * Similar logic as the tree creation using queue.
	 * 
	 * Tree created is 
	 * 			  1
	 * 			/   \
	 * 		   2     3
	 * 		  /\    / \
	 * 		4   5  6   7
	 * @param args
	 */
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		levelOrderTravsere(root);
	}

	@SuppressWarnings("unchecked")
	public static void levelOrderTravsere(BTreeNode<Integer> root) {
		Queue<BTreeNode<Integer>> treeNodesQueue = new Queue<>();
		treeNodesQueue.enqueue(root);
		while (!treeNodesQueue.isEmpty()) {
			BTreeNode<Integer> node = (BTreeNode<Integer>) treeNodesQueue
					.dequeue();
			System.out.print(node.value + " ");
			if (null != node.left) {
				treeNodesQueue.enqueue(node.left);
			}
			if (null != node.right) {
				treeNodesQueue.enqueue(node.right);
			}
		}
	}
}
