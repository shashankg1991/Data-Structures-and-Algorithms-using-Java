package com.node;

public class SinglyNode<T> {
	public SinglyNode<T> next;
	public T value;

	public SinglyNode(T value) {
		this.value = value;
		next = null;
	}

	public SinglyNode(T value, SinglyNode<T> next) {
		this.value = value;
		this.next = next;
	}
}
