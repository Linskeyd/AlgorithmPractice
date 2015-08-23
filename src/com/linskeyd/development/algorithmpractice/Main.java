package com.linskeyd.development.algorithmpractice;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    private static final Map<String, String> TEST_ANAGRAM_VALUES = ImmutableMap.of(
            "abc", "aeoijcbaweif",  // true
            "123456", "654321",     // true
            "1234a", "6a4321",      // true
            "", "oaifeoifjae",      // true
            "12345", "4321"         // false
    );

    private static final Set<Character> IGNORED_VALUES = Sets.newHashSet(',', '.', ' ');

    public static void main(String[] args) {
//        TEST_VALUES.stream()
//            .forEach(val -> System.out.println(RepeatedPatternChecker.hasRepeatedPattern(val, IGNORED_VALUES)));

        TEST_ANAGRAM_VALUES.entrySet().stream()
                .forEach(entry -> {
                    final String prefix = entry.getKey() + " " + entry.getValue() + " ";

                    final boolean result = AnagramSubstringChecker.checkForAnagramSubstring(
                            entry.getKey(), entry.getValue());

                    System.out.println(prefix + result);
                });
    }
}
