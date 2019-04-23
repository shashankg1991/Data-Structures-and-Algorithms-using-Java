package com.tree.binary;

import com.node.ThreadedBTreeNode;
import com.queue.Queue;

/*-
 * Insertion takes place using a queue.
 * 	Begin with - add root in queue.
 *	Remove element from queue and check if it has any left or right position empty
 *	If yes, insert at it.
 *	If no, then insert left and right in queue in the same order(left first).
 *	As queue reads in the same order as insertion, left node is checked first for insertion and then right node is checked. 
 */
public class ThreadedBinaryTree<T> {
	ThreadedBTreeNode<T> root;

	ThreadedBinaryTree() {
		root = null;
	}

	@SuppressWarnings("unchecked")
	public void insert(T value) {
		ThreadedBTreeNode<T> newNode = new ThreadedBTreeNode<>(value);
		if (null == root) {
			root = newNode;
		} else {

			Queue<ThreadedBTreeNode<T>> treeNodesQueue = new Queue<>();
			treeNodesQueue.enqueue(root);

			while (!treeNodesQueue.isEmpty()) {
				ThreadedBTreeNode<T> queueNode = (ThreadedBTreeNode<T>) treeNodesQueue
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

	/*-
	 * Tree created is 
	 * 			  1
	 * 			/   \
	 * 		   2     3
	 * 		  /\    / \
	 * 		4   5  6   7
	 */
	public static ThreadedBTreeNode<Integer> createTestBTree() {
		ThreadedBinaryTree<Integer> binaryTree = new ThreadedBinaryTree<>();
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(4);
		binaryTree.insert(5);
		binaryTree.insert(6);
		binaryTree.insert(7);
		System.out.println("Tree:");
		System.out.println("     1");
		System.out.println("   /   \\");
		System.out.println("  2     3");
		System.out.println(" /\\    / \\");
		System.out.println("4   5  6   7");
		System.out.println();
		return binaryTree.root;
	}
}
