package com.saurabh.playground.twoPointerIteration;

import java.util.Arrays;

public class ShiftZeroAtEnd {
    public static void main(String[] args) {
        int[] arr = {5,3,0,6,0,7,0,8};

        shiftZeroAtEnd(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void shiftZeroAtEnd(int[] arr) {
        var front = 0;
        var rear = arr.length - 1;

        while(front < rear) {
            if(arr[rear] == 0)
                rear--;

            if(arr[front] == 0) {
                var temp = arr[front];
                arr[front] = arr[rear];
                arr[rear] = temp;

                front++;
                rear--;
            } else {
                front++;
            }
        }
    }
}
