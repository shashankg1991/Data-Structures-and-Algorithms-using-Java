package com.node;

public class SinglyNode {
	public SinglyNode next;
	public Integer value;

	private SinglyNode() {
		// no initialization from outside
	}

	public static SinglyNode createNewNode(Integer value) {
		SinglyNode node = new SinglyNode();
		node.value = value;
		node.next = null;
		return node;
	}

	public static SinglyNode createNode(Integer value, SinglyNode next) {
		SinglyNode node = new SinglyNode();
		node.value = value;
		node.next = next;
		return node;
	}
}
