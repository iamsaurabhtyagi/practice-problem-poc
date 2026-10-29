package com.saurabh.playground.anagram;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        var str1 = "anagramm";
        var str2 = "nagarama";
        System.out.println("Is Anagram: " + checkAnagram(str1, str2));
    }

    private static boolean checkAnagram(String str1, String str2) {
        var map = new HashMap<Character, Integer>();

        if(str1.length() != str2.length())
            return false;

        for(char ch: str1.toCharArray()) {
            var count = map.containsKey(ch) ? map.get(ch) + 1 : 1;
            map.put(ch, count);
        }

        for(char ch : str2.toCharArray()) {
            if(!map.containsKey(ch))
                return false;
            map.compute(ch, (k, counter) -> counter - 1);
        }

        return map.values().stream().mapToInt(Integer::intValue).allMatch(value -> value == 0);
    }
}
