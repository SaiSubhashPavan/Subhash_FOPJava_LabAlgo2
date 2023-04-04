package com.gl.payMoney;

import java.util.Scanner;

public class PayMoney {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of transaction array: ");
		int size = sc.nextInt();

		int[] transactionArray = new int[size];
		System.out.println("Enter the values of array:");
		for( int i = 0; i < size; i++) {
			transactionArray[i] = sc.nextInt();			
		}

		System.out.println("Enter the total no of targets that need to be achieved:");
		int targets = sc.nextInt();

		int i = 0;
		while(i < targets) {
			
			System.out.println();
			
			System.out.println("Enter the value of the target:");
			long targetValue = sc.nextInt();

			int sum = 0, flag = 0;
			for(int j = 0; j < size; j++) {
				sum += transactionArray[j];
				if(sum >= targetValue) {
					System.out.println("Target achieved after " + (j+1) + " transactions.");
					flag = 1;
					break;
				}

			}
			if(flag == 0) {
				System.out.println("Given target is not achieved.");
			}
			i++;
		}
		sc.close();

	}

}
