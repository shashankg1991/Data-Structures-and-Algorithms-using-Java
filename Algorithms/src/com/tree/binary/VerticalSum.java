package com.tree.binary;

import java.util.HashMap;
import java.util.Map;

import com.node.BTreeNode;

/*-
 * Vertical sum means sum of all nodes in same line
 * https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 */
public class VerticalSum {

	public static Map<Integer, Integer> verticalPositionSumMap = new HashMap<>();

	public static void main(String args[]) {
		BTreeNode<Integer> root = BinaryTree.createTestBTree();
		addToVerticalSumMap(root, 0);
		System.out.println(verticalPositionSumMap);
	}

	public static void addToVerticalSumMap(BTreeNode<Integer> root, int rootLevel) {
		if (null == root)
			return;
		if (verticalPositionSumMap.get(rootLevel) == null) {
			verticalPositionSumMap.put(rootLevel, root.value);
		} else {
			verticalPositionSumMap.put(rootLevel, verticalPositionSumMap.get(rootLevel) + root.value);
		}

		addToVerticalSumMap(root.left, rootLevel - 1);
		addToVerticalSumMap(root.right, rootLevel + 1);
	}
}
