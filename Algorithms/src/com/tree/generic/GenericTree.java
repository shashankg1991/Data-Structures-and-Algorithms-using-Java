package com.tree.generic;

import com.node.GenericTreeNode;

/*-
 * Tree Created:
 * 20
 * |
 * |
 * V
 * 2--> 34 --> 50 --> 60 --> 70
 * |
 * |
 * V
 * 15-->20-->30-->40-->100->20
 * |
 * |
 * V
 * 25-->50					
 */
public class GenericTree {
	public static GenericTreeNode<Integer> getGenericTreeInstance() {
		GenericTreeNode<Integer> root = new GenericTreeNode<Integer>(20);
		
		root.child = new GenericTreeNode<Integer>(2);
		root.child.nextSibling = new GenericTreeNode<Integer>(34);
		root.child.nextSibling.nextSibling = new GenericTreeNode<Integer>(50);
		root.child.nextSibling.nextSibling.nextSibling = new GenericTreeNode<Integer>(60);
		root.child.nextSibling.nextSibling.nextSibling.nextSibling = new GenericTreeNode<Integer>(70);
		root.child.child= new GenericTreeNode<Integer>(15);
		
		root.child.child = new GenericTreeNode<Integer>(15);
		root.child.child.nextSibling= new GenericTreeNode<Integer>(20);
		root.child.child.nextSibling.nextSibling= new GenericTreeNode<Integer>(30);
		root.child.child.nextSibling.nextSibling.nextSibling= new GenericTreeNode<Integer>(40);
		root.child.child.nextSibling.nextSibling.nextSibling.nextSibling= new GenericTreeNode<Integer>(100);
		root.child.child.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling= new GenericTreeNode<Integer>(20);
		
		root.child.child.nextSibling.child= new GenericTreeNode<Integer>(25);
		root.child.child.nextSibling.child.nextSibling= new GenericTreeNode<Integer>(50);
		return root;
	}
}
