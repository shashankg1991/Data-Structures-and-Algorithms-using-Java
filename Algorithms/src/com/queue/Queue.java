package com.queue;

import com.node.SinglyNode;

public class Queue<T> {
	SinglyNode<T> head;
	SinglyNode<T> tail;

	public Queue() {
		head = null;
		tail = null;
	}

	public void enqueue(T value) {
		SinglyNode<T> node = new SinglyNode<>(value);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public Object dequeue() {
		Object value = null;
		if (head != null) {
			value = head.value;
			head = head.next;
		}
		return value;
	}

	public boolean isEmpty() {
		return null == head;
	}

	public void print() {
		SinglyNode<T> reference = head;
		System.out.print("Queue:");
		while (reference != null) {
			System.out.print(reference.value);
			if (null != reference.next) {
				System.out.print("->");
			} else {
				System.out.println();
			}
			reference = reference.next;

		}
	}

	public static void main(String[] args) {
		Queue<Integer> testQueue = new Queue<>();
		testQueue.enqueue(1);
		testQueue.print();
		testQueue.enqueue(2);
		testQueue.print();
		testQueue.enqueue(3);
		testQueue.print();
		testQueue.dequeue();
		testQueue.print();
		testQueue.dequeue();
		testQueue.print();
	}
}
