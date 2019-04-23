package com.tree.binary;

import com.node.BTreeNode;

public class Mirror {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("Level order after mirror : ");
		LevelOrderTraversal.levelOrderTravsere(mirror(root));
	}

	public static BTreeNode<Integer> mirror(BTreeNode<Integer> root) {
		if (null == root) {
			return null;
		} else {
			mirror(root.left);
			mirror(root.right);

			// Swap the left and the right nodes.
			BTreeNode<Integer> temp = root.left;
			root.left = root.right;
			root.right = temp;
			return root;
		}
	}
}
