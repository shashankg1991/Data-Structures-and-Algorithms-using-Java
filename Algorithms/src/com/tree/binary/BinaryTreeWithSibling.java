package com.tree.binary;

import com.node.BTreeNodeWithSibling;
import com.queue.Queue;

/*-
 * Insertion takes place using a queue.
 * 	Begin with - add root in queue.
 *	Remove element from queue and check if it has any left or right position empty
 *	If yes, insert at it.
 *	If no, then insert left and right in queue in the same order(left first).
 *	As queue reads in the same order as insertion, left node is checked first for insertion and then right node is checked. 
 */
public class BinaryTreeWithSibling<T> {
	BTreeNodeWithSibling<T> root;

	BinaryTreeWithSibling() {
		root = null;
	}

	@SuppressWarnings("unchecked")
	public void insertSiblingNode(T value) {
		BTreeNodeWithSibling<T> newNode = new BTreeNodeWithSibling<>(value);
		if (null == root) {
			root = newNode;
		} else {

			Queue<BTreeNodeWithSibling<T>> treeNodesQueue = new Queue<>();
			treeNodesQueue.enqueue(root);

			while (!treeNodesQueue.isEmpty()) {
				BTreeNodeWithSibling<T> queueNode = (BTreeNodeWithSibling<T>) treeNodesQueue.dequeue();
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
	public static BTreeNodeWithSibling<Integer> createTestBTreeWithSibling() {
		BinaryTreeWithSibling<Integer> binaryTree = new BinaryTreeWithSibling<>();
		binaryTree.insertSiblingNode(1);
		binaryTree.insertSiblingNode(2);
		binaryTree.insertSiblingNode(3);
		binaryTree.insertSiblingNode(4);
		binaryTree.insertSiblingNode(5);
		binaryTree.insertSiblingNode(6);
		binaryTree.insertSiblingNode(7);
		System.out.println("Tree:");
		System.out.println("     1");
		System.out.println("   /   \\");
		System.out.println("  2     3");
		System.out.println(" /\\    / \\");
		System.out.println("4   5  6   7");
		System.out.println();
		return (BTreeNodeWithSibling<Integer>) binaryTree.root;
	}
}
