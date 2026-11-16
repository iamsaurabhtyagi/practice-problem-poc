package com.saurabh.playground.slidingWindow;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        var k = 3;
        var result = maxSumSubarray(arr, k);
        System.out.println(result);
    }

    private static int maxSumSubarray(int[] arr, int k) {
        var i = 0;
        var j = 0;
        var result = Integer.MIN_VALUE;

        var sum = 0;
        while (j < arr.length) {

            if(j > k - 1) {
                sum = sum - arr[i] + arr[j];
                i++;
            } else {
                sum += arr[j];
            }

            if(j >= k-1 && result < sum)
                result = sum;

            j++;
        }
        return result;
    }
}
