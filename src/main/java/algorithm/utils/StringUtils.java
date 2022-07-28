package main.java.algorithm.utils;

import java.util.Arrays;

public class StringUtils
{
    public static String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}
