package com.tree.binary;

import com.node.BTreeNode;
import com.queue.Queue;

/*-
 * Insertion takes place using a queue.
 * 	Begin with - add root in queue.
 *	Remove element from queue and check if it has any left or right position empty
 *	If yes, insert at it.
 *	If no, then insert left and right in queue in the same order(left first).
 *	As queue reads in the same order as insertion, left node is checked first for insertion and then right node is checked. 
 */
public class BinaryTree<T> {
	BTreeNode<T> root;

	BinaryTree() {
		root = null;
	}

	@SuppressWarnings("unchecked")
	public void insert(T value) {
		BTreeNode<T> newNode = new BTreeNode<>(value);
		if (null == root) {
			root = newNode;
		} else {

			Queue<BTreeNode<T>> treeNodesQueue = new Queue<>();
			treeNodesQueue.enqueue(root);

			while (!treeNodesQueue.isEmpty()) {
				BTreeNode<T> queueNode = (BTreeNode<T>) treeNodesQueue
						.dequeue();
				if (null == queueNode.left) {
					queueNode.left = newNode;
					return;
				} else {
					treeNodesQueue.enqueue(queueNode.left);
				}
				if (null == queueNode.right) {
					queueNode.right = newNode;
					return;
				} else {
					treeNodesQueue.enqueue(queueNode.right);
				}
			}
		}
	}
}
