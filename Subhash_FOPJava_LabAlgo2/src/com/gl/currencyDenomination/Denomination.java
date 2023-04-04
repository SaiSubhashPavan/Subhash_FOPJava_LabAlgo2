package com.gl.currencyDenomination;

import java.util.Scanner;

public class Denomination {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations:");
		int size = sc.nextInt();

		System.out.println("Enter the currency denominations value:");
		int[] valueOfCurrency = new int[size];
		for(int i = 0; i < size; i++) {
			valueOfCurrency[i] = sc.nextInt();
		}

		sortCurrency(valueOfCurrency, 0, size-1);

		System.out.println("Enter the amount you want to pay:");
		int amount = sc.nextInt();

		int[] notesCount = new int[size];
		for(int i = 0; i < size && amount > 0; i++) {
			notesCount[i] = amount / valueOfCurrency[i];
			amount -= (valueOfCurrency[i] * notesCount[i]);
		}
		
		System.out.println();
		
		System.out.println("Your payment approach in order to give minimum no. of notes will be:");
		for(int i = 0; i < size; i++) {
			if(notesCount[i] != 0) {
				System.out.println(valueOfCurrency[i] + " : " + notesCount[i]);			
			}
		}

		sc.close();
	}

	public static void sortCurrency(int array[], int a, int b) {
		if(a < b) {
			int p = partition(array, a, b);
			sortCurrency(array, a, p);
			sortCurrency(array, p+1, b);
		}
	}

	public static int partition(int array[], int a, int b) {

		int pivot = array[a];
		int i = a-1, j = b+1;

		while(true)
		{
			do {
				i++;
			}while(array[i] > pivot);

			do {
				j--;
			}while(array[j] < pivot);

			if(i >= j) {
				return j;
			}
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

}
