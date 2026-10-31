package com.saurabh.playground.twoPointerIteration;

import java.util.Arrays;

public class ThreeSumProblem {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[][] result = findTripletEqualToZero(arr);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] findTripletEqualToZero(int[] arr) {
        int[][] result = new int[arr.length][3];

        var front = 0;
        var end = arr.length - 1;
        var movingPointer = front;

        while (front < end) {
            var sum = arr[front] + arr[end] + arr[movingPointer];
            if(sum == 0)
                result[front] = new int[] {arr[front], arr[movingPointer], arr[end]};

            if(end == front + 1) {
                end = arr.length -1;
                front++;
                movingPointer = front;
            }

            if(movingPointer == end) {
                end--;
                movingPointer = front;
            }
            movingPointer++;
        }

        return result;
    }
}
