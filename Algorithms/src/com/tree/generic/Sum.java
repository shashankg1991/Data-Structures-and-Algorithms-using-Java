package com.tree.generic;

import com.node.GenericTreeNode;

public class Sum {
	public static void main(String args[]) {
		GenericTreeNode<Integer> root = GenericTree.getGenericTreeInstance();
		System.out.println("Sum : " + sum(root));
	}

	public static int sum(GenericTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return sum(root.nextSibling) + root.value + sum(root.child);
	}
}
