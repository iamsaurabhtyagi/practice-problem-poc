package com.saurabh.playground.twoPointerIteration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MaximumWaterBucket {
    public static void main(String[] args) {
        int[] arr1 = {1,5,4,3};
        int[] arr2 = {5,4,3,1,5};
        int max = maxWaterAmountInBucketBySlidingWindow(arr2);
        System.out.println(max);
        try {
            String str = "";
            int length = CompletableFuture.supplyAsync(() -> "100").thenApply(x -> x.toUpperCase()).thenApply(x -> x.length()).get();
            System.out.println(length);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static int maxWaterAmountInBucket(int[] arr) {
        int max = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                int distance = j - i;

                int volume = Math.min(arr[i], arr[j]) * distance;
                if(max < volume)
                    max = volume;
            }
        }

        return max;
    }

    private static int maxWaterAmountInBucketBySlidingWindow(int[] arr) {
        int max = 0;

        var pointer1 = 0;
        var pointer2 = pointer1 + 1;

        while(pointer1 < pointer2) {
            var distance = pointer2 - pointer1;
            var min = Math.min(arr[pointer1], arr[pointer2]);
            var volume = min * distance;

            if(pointer2 < arr.length - 1)
                pointer2++;
            if(pointer2 == arr.length - 1)
                pointer1++;

            if(max < volume)
                max = volume;
        }

        return max;
    }
}
