package easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author dvm
 * 
 *         Two Number Sum
 *
 *         Write a function that takes in a non-empty array of distinct integers
 *         and an integer representing a target sum. If any two numbers in the
 *         input array sum up to the target sum, the function should return them
 *         in an array. If no two numbers sum up to the target sum, the function
 *         should return an empty array. Assume that there will be at most one
 *         pair of numbers summing up to the target sum.
 * 
 *         Sample input: [3, 5, -4, 8, 11, 1, -1, 6], 10 Sample output: [-1, 11]
 */

public class _01_Two_Number_Sum {

	public static void main(String[] args) {

		int arr[];

		int[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
		int target = 10;
		arr = twoNumberSum(input, target);
		arr = twoNumberSumOptimised(input, target);
	}

	// O(n) - Time Complexity & O(n) - Space Complexity
	static int[] twoNumberSum(int array[], int target) {

		HashSet<Integer> set = new HashSet<>();

		for (int num : array) {

			if (set.contains(num))
				return new int[] { num, target - num };
			else {
				set.add(target - num);
			}
		}

		return new int[] {};

	}

	// O(nlog(n)) - Time Complexity & O(1) - Space Complexity
	static int[] twoNumberSumOptimised(int array[], int target) {

		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;

		while (left < right) {

			int sumOfLeftAndRight = array[left] + array[right];
			if (sumOfLeftAndRight == target) {
				return new int[] { array[left], array[right] };
			} else if (sumOfLeftAndRight < target) {
				left++;
			} else {
				right--;
			}
		}

		return new int[] {};

	}

}
