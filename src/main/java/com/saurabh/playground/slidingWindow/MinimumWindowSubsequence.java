package com.saurabh.playground.slidingWindow;

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        var s1 = "abcdebdde";
        var s2 = "bde";
        var result = minWindowSubsequence(s1, s2);
        System.out.println(result);
    }

    private static String minWindowSubsequence(String s1, String s2) {

        if(s1 == null || s2 == null)
            return null;
        if(s1.length() < s2.length())
            return "";

        var i = 0;
        var j = 0;

        var minLength = Integer.MAX_VALUE;
        var startIdx = -1;

        while (i < s1.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if(j==s2.length()) {
                var end = i;
                j--;

                while (j>=0) {

                    if(s1.charAt(i) == s2.charAt(j))
                        j--;
                    i--;
                }

                i++;
                j=0;

                var currentIndex = end - i + 1;
                if(currentIndex < minLength) {
                    minLength = currentIndex;
                    startIdx = i;
                }
            }

            i++;
        }
        return startIdx == -1 ? "" : s1.substring(startIdx, startIdx + minLength);
    }
}
