package com.tree.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.node.BTreeNode;
import com.stack.Stack;

public class CreateExpressionTree {

	public static void main(String[] args) {

		String postfix = "ab+cd+*";
		inorderTraverse(createExpressionTree(postfix));
	}

	@SuppressWarnings("unchecked")
	private static BTreeNode<Character> createExpressionTree(String postfix) {
		Stack<BTreeNode<Character>> stack = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			if (isOperator(postfix.charAt(i))) {
				BTreeNode<Character> node = new BTreeNode<>(postfix.charAt(i));
				node.left = (BTreeNode<Character>) stack.pop();
				node.right = (BTreeNode<Character>) stack.pop();
				stack.push(node);
			} else {
				BTreeNode<Character> node = new BTreeNode<>(postfix.charAt(i));
				stack.push(node);
			}
		}
		return (BTreeNode<Character>) stack.pop();
	}
	
	static boolean isOperator(Character c){
		return c.equals('+') || c.equals('-')|| c.equals('*')||c.equals('/');
	}

	public static void inorderTraverse(BTreeNode<Character> root) {
		if (null != root) {
			inorderTraverse(root.left);
			System.out.print(root.value + " ");
			inorderTraverse(root.right);
		}
	}
}
