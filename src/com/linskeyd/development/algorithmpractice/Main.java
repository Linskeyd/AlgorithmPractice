package com.linskeyd.development.algorithmpractice;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    private static final List<String> TEST_VALUES = Arrays.asList(
            "aa",          // false
            "aaaa",        // true
            "aabb",        // true
            "abab",        // true
            "abcedi",      // false
            "acdeeedca",   // false
            "aertbzxaqwb", // true
            "a. ba,b",     // true
            ", , "         // false
    );

    private static final Set<Character> IGNORED_VALUES = Sets.newHashSet(',', '.', ' ');

    public static void main(String[] args) {
        TEST_VALUES.stream()
            .forEach(val -> System.out.println(RepeatedPatternChecker.hasRepeatedPattern(val, IGNORED_VALUES)));
    }
}
