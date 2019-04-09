package com.recursion;

public class BinarySearch {

	public static void main(String[] args) {
		int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Position : "
				+ binarySearch(4, sortedArray, 0, sortedArray.length - 1));
	}

	public static int binarySearch(int element, int[] sortedArray, int beg,
			int end) {
		if (beg > end) {
			return -1;
		}
		if (beg == end) {
			if (element == sortedArray[beg]) {
				return beg;
			} else {
				return -1;
			}
		} else {
			int center = (beg + end) / 2;
			if (element == sortedArray[center]) {
				return center;
			} else {
				if (element > sortedArray[center]) {
					return binarySearch(element, sortedArray, center + 1, end);
				} else {
					return binarySearch(element, sortedArray, beg, center - 1);
				}
			}
		}
	}
}
