package com.tree.binary;

import com.node.BTreeNodeWithSibling;

public class AttachSibling {
	public static void main(String[] args) {
		BTreeNodeWithSibling<Integer> root = BinaryTreeWithSibling.createTestBTreeWithSibling();
		attachSibling(root);
	}

	public static void attachSibling(BTreeNodeWithSibling<Integer> root) {
		if (null == root) {
			return;
		}
		if (null != root.left) {
			root.left.sibling = root.right;
		}
		if (null != root.right && null != root.sibling) {
			root.right.sibling = root.sibling.left;
		}
		attachSibling(root.left);
		attachSibling(root.right);
	}
}
