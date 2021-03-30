package com.miplodder.shorify.shortify;

public class Utility {

    public static String encoding(final int input) {
        StringBuilder rv = new StringBuilder();
        for (int i = 0; i < input / 26; i++) {
            rv.append("z");
        }
        if (input % 26 != 0) {
            rv.append((char) ('a' + (input % 26) - 1));
        }
        return rv.toString();
    }
}