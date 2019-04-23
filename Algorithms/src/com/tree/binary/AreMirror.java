package com.tree.binary;

import com.node.BTreeNode;

public class AreMirror {
	public static void main(String[] args) {
		BTreeNode<Integer> root1 = BinaryTree.createTestBTree();
		BTreeNode<Integer> root2 = Mirror.mirror(BinaryTree.createTestBTree());
		System.out.println("Are mirror : " + areMirror(root1, root2));
	}

	public static boolean areMirror(BTreeNode<Integer> root1, BTreeNode<Integer> root2) {
		if (null == root1 && null == root2) {
			return true;
		}
		if (null == root1 || null == root2) {
			return false;
		} else {
			return root1.value==root2.value && areMirror(root1.left, root2.right);
		}
	}
}
