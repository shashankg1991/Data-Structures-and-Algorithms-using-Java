package com.queue;

import com.node.SinglyNode;

public class Queue {
	SinglyNode head;
	SinglyNode tail;

	Queue() {
		head = null;
		tail = null;
	}

	public void enqueue(int value) {
		SinglyNode node = SinglyNode.createNewNode(value);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public Integer dequeue() {
		Integer value = null;
		if (head != null) {
			value = head.value;
			head = head.next;
		}
		return value;
	}

	public void print() {
		SinglyNode reference = head;
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
		Queue testQueue = new Queue();
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
