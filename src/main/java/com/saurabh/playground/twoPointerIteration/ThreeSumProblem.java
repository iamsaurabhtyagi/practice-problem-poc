package com.saurabh.playground.twoPointerIteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = findTripletEqualToZeroSol(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> findTripletEqualToZeroSol(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        //-4 -1 -1 0 1 2
        Arrays.sort(arr);

        for(var i = 0; i < arr.length - 2; i++) {

            if(i > 0 && arr[i] == arr[i-1])
                continue;

            var start = i + 1;
            var end = arr.length - 1;

            while (start < end) {
                var sum = arr[i] + arr[start] + arr[end];

                if(sum < 0)
                    start++;
                else if (sum > 0)
                    end--;
                else {
                    result.add(Arrays.asList(arr[i], arr[start], arr[end]));
                    start++;
                    end--;

                    while (start < end && arr[start] == arr[start - 1])
                        start++;
                    while (start < end && arr[end] == arr[end + 1])
                        end--;
                }
            }
        }

        return result;
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
