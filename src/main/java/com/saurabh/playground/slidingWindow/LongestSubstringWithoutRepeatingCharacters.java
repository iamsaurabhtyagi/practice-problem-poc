package com.saurabh.playground.slidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        var str = "bacabdcbb";
        var length = longestSubstringUsingHashMap(str);
        System.out.println(length);
    }

    private static int longestSubstr(String str) {
        if (str == null)
            throw new IllegalArgumentException("Input cannot be null");

        var lastSeen = new HashMap<Character, Integer>();

        var left = 0;
        var longestLength = 0;

        for (var right = 0; right < str.length(); right++) {
            var ch = str.charAt(right);

            if (lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch) + 1);
            }

            lastSeen.put(ch, right);

            longestLength = Math.max(longestLength, right - left + 1);
        }

        return longestLength;
    }

    private static int longestSubstring(String str) {
        if(str == null)
            throw new IllegalArgumentException("Input cannot be null");

        var longestLength = 0;
        var end = 0;

        StringBuilder builder = new StringBuilder();
        while (end < str.length()) {
            var index = builder.indexOf(String.valueOf(str.charAt(end)));
            if(index < 0) {
                builder.append(str.charAt(end));
                end++;
            } else {
                if(builder.length() > longestLength)
                    longestLength = builder.length();

                builder.delete(0, index);
                end++;
            }
        }
        return longestLength;
    }

    private static int longestSubstringUsingHashMap(String str) {
        if(str == null)
            throw new IllegalArgumentException("Input cannot be null");

        var longestLength = 0;

        var left = 0;
        var right = 0;
        var lastSeen = new HashMap<Character, Integer>();

        while (right < str.length()) {
            var ch = str.charAt(right);
            if(lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch) + 1);
            }

            lastSeen.put(str.charAt(right), right);
            longestLength = Math.max(longestLength, right - left + 1);
            right++;
        }

        return longestLength;
    }
}
