package com.java.coding.problem;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 */
public class IsomorphicString {
    public static void main(String[] args) {
        String s = "foo", t = "bar";
        String u = "egg", v = "add";
        System.out.println(isIsomorphic(s,t));
        System.out.println(isIsomorphic(u,v));
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s==null || t==null)
            return false;
        if (s.length() != t.length())
            return false;
        if (s.isEmpty() && t.isEmpty())
            return true;

        HashMap<Character, Character> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (c2 != map.get(c1))
                    return false;
            } else
                map.put(c1, c2);
        }
        return true;
    }
}
