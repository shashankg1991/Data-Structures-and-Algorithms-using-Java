package com.tree.generic;

import com.node.GenericTreeNode;

public class CountSiblingsForNode {
	public static void main(String args[]) {
		GenericTreeNode<Integer> root = GenericTree.getGenericTreeInstance();
		System.out.println("Siblings: " + countSiblings(root.child));
	}

	public static int countSiblings(GenericTreeNode<Integer> node) {
		if (node == null) {
			return 0;
		}
		int siblings=0;
		GenericTreeNode<Integer> sibling=node.nextSibling;
		while(null!=sibling){
			siblings++;
			sibling=sibling.nextSibling;
		}
		return siblings;
	}
}
