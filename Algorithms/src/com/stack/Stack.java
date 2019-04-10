package com.stack;

import com.node.SinglyNode;

public class Stack<T> {
	SinglyNode<T> top;

	Stack() {
		top = null;
	}

	public void push(T value) {
		SinglyNode<T> node = new SinglyNode<>(value);
		if (null == top) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
	}

	public Object pop() {
		Object value = null;
		if (null != top) {
			value = top.value;
			top = top.next;
		}
		return value;
	}

	public boolean isEmpty() {
		return null == top;
	}

	public void print() {
		SinglyNode<T> reference = top;
		System.out.println("Stack:");
		while (reference != null) {
			System.out.println("|" + reference.value + "|");
			if (null == reference.next) {
				System.out.println("---");
			}
			reference = reference.next;

		}
	}

	public static void main(String[] args) {
		Stack<Integer> testStack = new Stack<>();
		testStack.push(1);
		testStack.print();
		testStack.push(2);
		testStack.print();
		testStack.push(3);
		testStack.print();
		testStack.pop();
		testStack.print();
		testStack.pop();
		testStack.print();
	}
}
