package com.recursion;

public class CheckArraySorted {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Is sorted : " + isSorted(array, array.length - 1));
	}

	public static boolean isSorted(int[] array, int length) {
		if (length <= 1) {
			return true;
		}
		if (array[length - 1] > array[length]) {
			return false;
		}
		return isSorted(array, length - 1);
	}
}
