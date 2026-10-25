package com.saurabh.playground.twoPointerIteration;

public class TwoSumInSortedArray {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        var exist = twoSum(arr, 20);
        System.out.println("Target Exist: " + exist);
    }

    private static boolean twoSum(int[] arr, int target) {
        var targetExist = false;

        var front = 0;
        var rear = arr.length - 1;

        while (front < rear) {
            var sum = arr[front] + arr[rear];
            if(sum == target) {
                targetExist = true;
                break;
            }

            if(sum < target)
                front++;
            else
                rear--;
        }

        return targetExist;
    }
}
