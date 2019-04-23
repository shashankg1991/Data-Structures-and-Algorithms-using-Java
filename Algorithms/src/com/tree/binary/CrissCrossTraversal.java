package com.tree.binary;

import com.node.BTreeNode;
import com.stack.Stack;

/*-
 * https://www.geeksforgeeks.org/zigzag-tree-traversal/
 * Slightly modified for better understanding
 * When current stack is empty, the level is complete
 */
public class CrissCrossTraversal {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		crissCrossTraversal(root);
	}

	@SuppressWarnings("unchecked")
	public static void crissCrossTraversal(BTreeNode<Integer> root) {
		boolean isLeftToRight = true;
		Stack<BTreeNode<Integer>> currentStack = new Stack<>();
		Stack<BTreeNode<Integer>> nextLevelStack = new Stack<>();
		currentStack.push(root);

		while (!currentStack.isEmpty()) {
			BTreeNode<Integer> current = (BTreeNode<Integer>) currentStack.pop();
			System.out.print(current.value + " ");
			if (isLeftToRight) {
				if (null != current.left) {
					nextLevelStack.push(current.left);
				}
				if (null != current.right) {
					nextLevelStack.push(current.right);
				}
			} else {
				if (null != current.right) {
					nextLevelStack.push(current.right);
				}
				if (null != current.left) {
					nextLevelStack.push(current.left);
				}
			}
			if (currentStack.isEmpty() && !nextLevelStack.isEmpty()) {
				isLeftToRight = !isLeftToRight;
				currentStack = nextLevelStack;
				nextLevelStack = new Stack<>();
			}
		}
	}
}
