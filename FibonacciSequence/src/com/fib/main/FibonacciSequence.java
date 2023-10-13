package com.fib.main;
import java.util.*;

public class FibonacciSequence {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int numTerms = scanner.nextInt();

        for (int i = 0; i < numTerms; i++) {
            int term = printFibonacciSequence(i);
            System.out.print(term + " ");
        }
    }

    public static int printFibonacciSequence(int numTerms) {
        if (numTerms <= 1) {
            return numTerms;
        } else {
            return printFibonacciSequence(numTerms - 1) + printFibonacciSequence(numTerms - 2);
        }
    }
}
