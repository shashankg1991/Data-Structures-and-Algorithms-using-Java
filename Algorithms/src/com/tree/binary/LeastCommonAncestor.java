package com.tree.binary;

import com.node.BTreeNode;

/*-
 *  https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 *  Idea is replace the node by it's ancestor and then find again if the 
 */
public class LeastCommonAncestor {
	public static void main(String[] args) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		System.out.println("LCA(Recursion): " + findLCA(root, 4, 6).value);
	}

	public static BTreeNode<Integer> findLCA(BTreeNode<Integer> root, Integer v1, Integer v2) {
		if (null == root) {
			return null;
		}

		// If either v1 or v2 matches with root's value, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root.value == v1 || root.value == v2) {
			return root;
		}

		// Look for keys in left and right subtrees
		BTreeNode<Integer> leftLCA = findLCA(root.left, v1, v2);
		BTreeNode<Integer> rightLCA = findLCA(root.right, v1, v2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (null != leftLCA && null != rightLCA) {
			return root;
		}

		// Otherwise check if left subtree or right subtree is LCA
		return leftLCA != null ? leftLCA : rightLCA;

	}
}
