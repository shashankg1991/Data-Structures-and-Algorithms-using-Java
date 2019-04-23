package com.node;

public class BTreeNodeWithSibling<T> {
	public BTreeNodeWithSibling<T> left;
	public BTreeNodeWithSibling<T> right;
	public BTreeNodeWithSibling<T> sibling;
	public T value;

	public BTreeNodeWithSibling(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public BTreeNodeWithSibling(T value, BTreeNodeWithSibling<T> left, BTreeNodeWithSibling<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}
