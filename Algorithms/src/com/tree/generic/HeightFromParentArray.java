package com.tree.generic;

/*-
 * Tree used:
 * 				0
 * 			/	|	\
 * 			5	1	6
 * 				|	|
 * 				2	4
 * 			  /
 * 			 7
 * 			/
 * 		   8
 * 
 */
public class HeightFromParentArray {
	public static void main(String args[]) {
		// parentArray[i] indicates parent of ith node.
		int[] parentArray = { -1, 0, 1, 6, 6, 0, 0, 2, 7 };
		System.out.println("Height : " + findHeight(parentArray));
	}

	public static int findHeight(int[] parentArray) {
		int maxHeight = 0;
		for (int i = 0; i < parentArray.length; i++) {
			int currentNode = parentArray[i];
			int currentHeight = 0;
			while (currentNode != -1) {
				currentNode = parentArray[currentNode];
				currentHeight++;
			}
			if (maxHeight < currentHeight) {
				maxHeight = currentHeight;
			}
		}
		return maxHeight;
	}
}
