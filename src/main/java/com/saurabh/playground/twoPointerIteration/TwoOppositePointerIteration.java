package com.saurabh.playground.twoPointerIteration;

public class TwoOppositePointerIteration {

    public static void main(String[] args) {
        int[] arr = {12,3,5,6,4,7,3,6,77};
        twoOppositePointeIteration(arr);
    }

    private static void twoOppositePointeIteration(int[] arr) {
        int front = 0;
        int rear = arr.length - 1;

        while(front <= rear) {
            System.out.println("Front: " + arr[front] + ", Rear: " + arr[rear]);

            front++;
            rear--;
        }
    }

}
