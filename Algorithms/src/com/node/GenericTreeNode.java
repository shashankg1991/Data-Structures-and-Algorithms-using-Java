package com.node;

public class GenericTreeNode<T> {
	public GenericTreeNode<T> child;
	public GenericTreeNode<T> nextSibling;
	public T value;

	public GenericTreeNode(T value) {
		this.value = value;
		this.child = null;
		this.nextSibling = null;
	}

	public GenericTreeNode(T value, GenericTreeNode<T> child, GenericTreeNode<T> nextSibling) {
		this.value = value;
		this.child = child;
		this.nextSibling = nextSibling;
	}
}
