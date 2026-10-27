package com.saurabh.playground.slidingWindow;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {10,20,20,30,40,40,50};
        removeDuplicate(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void removeDuplicate(int[] arr) {
        var slowIndex = 0;
        var fastIndex = 1;

        while (slowIndex < fastIndex) {
            if(arr[slowIndex] == arr[fastIndex]) {
                arr[fastIndex] = 0;
            }

            if(fastIndex < arr.length - 1)
                fastIndex++;
            if(slowIndex < arr.length - 1)
                slowIndex++;
        }
    }

}
