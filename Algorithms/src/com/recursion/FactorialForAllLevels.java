package com.recursion;

public class FactorialForAllLevels {

	public static void main(String[] args) {
		System.out.println("Result : " + factorial(5));

	}

	public static int factorial(int n) {
		int[] factorials = new int[n == 0 ? 1 : n + 1];
		factorial(factorials, n);
		printValues(n, factorials);
		return factorials[n];
	}

	public static int factorial(int[] factorials, int n) {
		if (n >= 1) {
			factorials[n] = n * factorial(factorials, n - 1);
			return factorials[n];
		} else {
			factorials[n] = 1;
			return 1;
		}
	}

	private static void printValues(int n, int[] factorials) {
		for (int count = 0; count <= n; count++) {
			System.out.println("Factorial of " + count + " : "
					+ factorials[count]);
		}
	}

}
