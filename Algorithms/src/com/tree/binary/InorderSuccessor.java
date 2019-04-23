package com.tree.binary;

import com.node.BTreeNode;

/*
 * https://algorithms.tutorialhorizon.com/inorder-successor-in-binary-tree/
 */
public class InorderSuccessor {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		getNextInorderSuccessor(root, 5);
	}

	public static void getNextInorderSuccessor(BTreeNode<Integer> root, Integer valueToFindNextInorder) {
		BTreeNode<Integer> node = SearchElement.searchElementUsingRecursion(root, valueToFindNextInorder);

		// Case 1 : left most element in the right subtree
		if (null != node.right) {
			System.out.println(getLeftMostNode(node));
			return;
		}

		// Case 2: node is the right most node
		if (node.value == getRightMostNode(root).value) {
			System.out.println("No successor");
			return;
		}

		// Case 3: Find the node having the given node as direct left node
		getDirectParentForLeftNode(root, node);
	}

	public static BTreeNode<Integer> getDirectParentForLeftNode(BTreeNode<Integer> root, BTreeNode<Integer> node) {
		if (root == null) {
			return null;
		}

		if (root.value == node.value) {
			return root;
		}

		BTreeNode<Integer> temp = null;
		if (null != (temp = getDirectParentForLeftNode(root.left, node))
				|| null != (temp = getDirectParentForLeftNode(root.right, node))) {
			if (root.left == temp) {
				System.out.println(root);
				return null;
			}
			System.out.println("Backtracking(temp=" + temp + "):" + root);
			// Backtrack
			return root;
		}

		return null;

	}

	public static BTreeNode<Integer> getLeftMostNode(BTreeNode<Integer> root) {
		BTreeNode<Integer> leftMostNode = root;
		if (null == leftMostNode) {
			leftMostNode = null;
		} else {
			while (leftMostNode.left != null) {
				leftMostNode = leftMostNode.left;
			}
		}
		return leftMostNode;
	}

	public static BTreeNode<Integer> getRightMostNode(BTreeNode<Integer> root) {
		BTreeNode<Integer> rightMostNode = root;
		if (null == rightMostNode) {
			rightMostNode = null;
		} else {
			while (rightMostNode.right != null) {
				rightMostNode = rightMostNode.right;
			}
		}
		return rightMostNode;
	}
}
