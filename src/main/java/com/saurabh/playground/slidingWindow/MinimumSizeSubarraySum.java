package com.saurabh.playground.slidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        var nums = new int[]{2, 3, 1, 2, 4, 3};
        var target = 7;
        var minSubarraySum = minSizeSubarraySum(nums, target);
        System.out.println(minSubarraySum);
    }

    private static int minSizeSubarraySum(int[] arr, int target) {

        var left = 0;
        var right = 0;
        var sum = 0;
        var minLength = arr.length;

        while (right < arr.length) {


            if(sum < target) {
                sum += arr[right++];
            }

            while (sum >= target) {
                var currentLength = right - left;
                if(minLength > currentLength)
                    minLength = currentLength;

                sum -= arr[left++];
            }

        }

        return minLength;
    }
}
