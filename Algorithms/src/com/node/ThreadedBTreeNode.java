package com.node;

public class ThreadedBTreeNode<T> {
	public ThreadedBTreeNode<T> left;
	public ThreadedBTreeNode<T> right;
	public boolean isRightThreaded;
	public T value;

	public ThreadedBTreeNode(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public ThreadedBTreeNode(T value, ThreadedBTreeNode<T> left, ThreadedBTreeNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}
