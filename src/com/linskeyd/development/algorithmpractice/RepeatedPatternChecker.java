package com.linskeyd.development.algorithmpractice;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class is small util algorithm exercise.
 *
 * It is meant to check a given String for whether or not it has a repeated character pattern.
 * Example: 'aabb' returns true given that 'b' follows 'a' at least twice.
 *
 * Time: O(n) Space: O(n)
 *
 * Created by linskeyd on 8/22/15.
 */
@NoArgsConstructor
public class RepeatedPatternChecker {

    /**
     * Given a input String, determines if it has a repeated (possible non-contiguous) pattern.
     *
     * @param input
     *      The String to analyze
     * @return
     *  Returns true if the input has a pattern, false otherwise.
     */
    public static boolean hasRepeatedPattern(@NonNull final String input, @NonNull final Set<Character> ignoredCharacters) {
        if(input.isEmpty()) {
            return false;
        }

        final String cleanedString =  input.chars()
                .filter(c -> !ignoredCharacters.contains((char)c))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        final Map<Character, Integer> characterCounts = getCharacterCounts(cleanedString);

        final StringBuilder repeatedChars = new StringBuilder();

        for(int index = 0; index < cleanedString.length(); index++) {
            final char indexVal = cleanedString.charAt(index);

            /*
             * If we have encountered a given character 4 times, we return true for the entire method.
             */
            if (characterCounts.get(indexVal) == 4) {
                return true;
            }

            if(characterCounts.get(indexVal) > 1) {
                repeatedChars.append(indexVal);
            }
        }

        final String repeatedCharsString = repeatedChars.toString();

        // If the resulting string contains no entries, then we return false
        if(repeatedCharsString.length() == 0) {
            return false;
        }

        // If the resulting string is not a palindrome, we return true.
        if(!isPalindrome(repeatedChars)) {
            return true;
        }

        /*
         * If the resulting string is a palindrome, but has an odd length and the middle character is the same as the
         * one before it, also return true
         */
        if(repeatedCharsString.length() % 2 == 1 &&
                repeatedCharsString.charAt(repeatedCharsString.length() / 2 + 1) !=
                repeatedCharsString.charAt(repeatedCharsString.length() / 2)) {
            return true;
        }

        // Otherwise always return false
        return false;
    }

    private static Map<Character, Integer> getCharacterCounts(final String input) {
        final Map<Character, Integer> characterCounts = new HashMap<>();

        for(int index = 0; index < input.length(); index++) {
            final char indexVal = input.charAt(index);

            final int currentCount = characterCounts.containsKey(indexVal) ?
                    characterCounts.get(indexVal) : 0;

            // We increment the number of times which we have seen this character.
            characterCounts.put(indexVal, currentCount + 1);
        }

        return characterCounts;
    }

    private static boolean isPalindrome(final StringBuilder repeatedChars) {
        final String forward = repeatedChars.toString();
        final String reverse = repeatedChars.reverse().toString();

        return forward.equals(reverse);
    }
}
