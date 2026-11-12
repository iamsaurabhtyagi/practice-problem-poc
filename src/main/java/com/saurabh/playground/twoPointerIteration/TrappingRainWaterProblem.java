package com.saurabh.playground.twoPointerIteration;

public class TrappingRainWaterProblem {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        var result = trappedRainWaterCount(arr);
        System.out.println("Trapped Water Count: " + result);
    }

    private static int trappedRainWaterCount(int[] arr) {
        var result = 0;

        var leftMax = 0;
        var rightMax = 0;

        var left = 0;
        var right = arr.length - 1;


        while (left < right) {
            if(leftMax <= rightMax) {
                if(arr[left] >= leftMax)
                    leftMax = arr[left];
                else
                    result += leftMax - arr[left];

                left++;
            } else {
                if(arr[right] >= rightMax)
                    rightMax = arr[right];
                else
                    result += rightMax - arr[right];
                right--;
            }
        }

        return result;
    }
}
