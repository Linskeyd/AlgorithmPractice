package com.linskeyd.development.algorithmpractice;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.linskeyd.development.algorithmpractice.BalancedTreeChecker.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO: Move to using TestNG or Truth once enough test case needs accumulate.
 **/
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

    private static final String TEST_BRACE_STRING = "aoijoajfoiaejf(oejfae)fiejo";  // 14, 21

    public static void main(String[] args) {
//        TEST_VALUES.stream()
//            .forEach(val -> System.out.println(RepeatedPatternChecker.hasRepeatedPattern(val, IGNORED_VALUES)));

//        TEST_ANAGRAM_VALUES.entrySet().stream()
//                .forEach(entry -> {
//                    final String prefix = entry.getKey() + " " + entry.getValue() + " ";
//
//                    final boolean result = AnagramSubstringChecker.checkForAnagramSubstring(
//                            entry.getKey(), entry.getValue());
//
//                    System.out.println(prefix + result);
//                });

//        final Node unbalancedRoot = BalancedTreeChecker.generateUnbalancedTestNodes();
//        final Node balancedRoot = BalancedTreeChecker.generateBalancedTestNodes();
//
//        System.out.println("Balanced: " + BalancedTreeChecker.isTreeBalanced(balancedRoot));
//        System.out.println("Unbalanced: " + BalancedTreeChecker.isTreeBalanced(unbalancedRoot));

        OuterBraceFinder.findOuterBraces(TEST_BRACE_STRING, OuterBraceFinder.BraceType.ROUND, 14, false).entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println("Bracket: " + entry.getKey() + " Location: " + entry.getValue());
                });
    }
}
