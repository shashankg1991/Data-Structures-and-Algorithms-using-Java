package com.node;

public class BTreeNode<T> {
	public BTreeNode<T> left;
	public BTreeNode<T> right;
	public T value;

	public BTreeNode(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public BTreeNode(T value, BTreeNode<T> left, BTreeNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}
