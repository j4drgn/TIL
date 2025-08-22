package com.mc.algorithm.e_search;

public class LinearSearch {
	
	public static void main(String[] args) {
		
		int target = 999;
		int[] nums = {1,6,12,17,999,22,14,6,19};
		
		//int index = linearSearch(nums, 999);
		int index = sentinelSearch(nums, 999);
		System.out.println(index);
		
	}

	// 보초법
	private static int sentinelSearch(int[] nums, int target) {
		int lastIndex = nums.length - 1;
		if(nums[lastIndex] == target) return lastIndex;
		
		nums[lastIndex] = target;
		int i = 0;
		while(true) {
			if(target == nums[i]) {
				return i < lastIndex ? i : -1;
			}
			
			i++;
		}
	}

	private static int linearSearch(int[] nums, int target) {
		int i = 0;
		while(true) {
			if(i == nums.length) return -1;
			if(nums[i] == target) return i;
			i++;
		}
	}
	
	

}
