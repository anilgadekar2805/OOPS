package com.ag.interview;

import java.util.Scanner;

public class FindTwoLargestNumber {

	Scanner scanner = null;
	int inputCount;
	int[] inputArray;
	int[] resultArray;
	int count = 0;
	
	public static void main(String[] args) {
		
		FindTwoLargestNumber findLarge = null;
		
		findLarge = new FindTwoLargestNumber();
		
		findLarge.getTotalCountInput();
		
		findLarge.getTotalInput();
		
		
		int[] resultArray = findLarge.getLargeNumberList();
		System.out.println(resultArray.length +" Largest number is : ");
		for(int r=0; r<resultArray.length; r++) {
			System.out.println(r+1 +") " + resultArray[r]);
		}
		
	}
	
	public void getTotalCountInput() {
		 scanner = new Scanner(System.in);
		 
		 try{
			 System.out.print("Enter total number of Inputs = ");
			 int totalInput = Integer.parseInt(scanner.nextLine());
			 inputArray = new int[totalInput];
			 
		 } catch(NumberFormatException nfe) {
			 System.out.println("Please enter valid Integer input ");
			 this.getTotalCountInput();
		 }
	}
	
	
	public void getTotalInput() {
		
		System.out.println("start enter value : ");
		for(int i=0; i<inputArray.length; i++) {
				
			try {
				int input =Integer.parseInt(scanner.nextLine());
				inputArray[i] = input;
			} catch(NumberFormatException e){
				System.out.println("Please enter valid integer value , otherwise you will get out of it ");
				inputArray[i] = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}//for

		System.out.print("User Entered value is : [ ");
		for(int j=0; j<inputArray.length; j++) {
			System.out.print(inputArray[j]+", ");
		}
		System.out.println("]");

	}//method
	
	public int[] getLargeNumberList() {
		int largeNumber = 0;
		int removeIndex=0;
		
		int firstLarge = 0;
		int secondLarge = 0 ;
		/*
		if(count == 0)
		getResultCountInput();
		*/
		
		/*
		for(int large=0; large<inputArray.length; large++) {
			
			if(largeNumber<inputArray[large]) {
				largeNumber = inputArray[large];
				removeIndex = large;
			}
		}
		resultArray[count] = largeNumber;
		inputArray[removeIndex] = 0;
		count++;
		*/
		
		/*
		if(resultArray.length>count){
			getLargeNumberList();
		}
		*/
		
		// Finding Two Largest number from given input List
		resultArray = new int[2];
		for(int large=0; large<inputArray.length; large++) {
					
					if(firstLarge<inputArray[large]) {
						secondLarge = firstLarge;
						firstLarge = inputArray[large];
					}
					
				}
				resultArray[count] = firstLarge;
				resultArray[count+1] = secondLarge;
		
		return resultArray; 
	}

	private void getResultCountInput() {
		
		int totalFindInput;
		
		System.out.println("How many Large number do you want to find : ");
		 try{
			 totalFindInput = Integer.parseInt(scanner.nextLine());
			 System.out.println("U want ="+totalFindInput);
			 
			 resultArray = new int[totalFindInput];
		 } catch(NumberFormatException nfe) {
			 System.out.println("Please enter valid Integer input value, otherwise we did'nt find large numbers ");
			 getResultCountInput();
		 }
		
	}
	
}
