package com.tree.binary;

import com.node.BTreeNode;

/*-
 *  Each node is either leaf node or has no children
 *  	2 means : 2 nodes
 *  	0 means : Leaf node
 */
public class CreateSpecialTreeFromPreorder {
	static int preorderIndex = 0;

	public static void main(String[] args) {
		int pre0or2[] = { 2, 2, 0, 0, 0 };
		RecursionTraversal.preorderTraverse(createTree(pre0or2));
	}

	public static BTreeNode<Integer> createTree(int pre0or2[]) {
		if (preorderIndex == pre0or2.length) {
			return null;
		} else {
			BTreeNode<Integer> node = new BTreeNode<Integer>(pre0or2[preorderIndex]);
			preorderIndex++;
			if (node.value == 0) {
				return node;
			} else {
				node.left = createTree(pre0or2);
				node.right = createTree(pre0or2);
				return node;
			}
		}
	}
}
