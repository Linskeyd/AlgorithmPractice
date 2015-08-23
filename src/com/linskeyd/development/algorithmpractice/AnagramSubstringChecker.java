package com.linskeyd.development.algorithmpractice;

import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Simple Anagram Substring checker.  Checks whether one string is the anagram substring of another.
 *
 * Created by linskeyd on 8/22/15.
 */
@NoArgsConstructor
public class AnagramSubstringChecker {

    /**
     * Checks whether or not the given input string's anagram is a substring of the given valToCheck
     *
     * @param input
     *      The value to get an anagram of and see whether that is a substring of valToCheck
     * @param valToCheck
     *      The value to check for the anagram substring in.
     * @return
     *  True if valToCheck has a substring which is an anagram of input.
     */
    public static boolean checkForAnagramSubstring(@NonNull final String input, @NonNull final String valToCheck) {
        // The empty space Character is always a substring of any other string (the empty set)
        if(input.isEmpty()) {
            return true;
        }

        // Do a simple eager check of lengths
        if(valToCheck.length() < input.length()) {
            return false;
        }

        // Walk backward through the valToCheck
        for(int valIndex = valToCheck.length() - 1; valIndex >= 0; valIndex--) {
            if(valToCheck.charAt(valIndex) != input.charAt(0)) {
                continue;
            }

            /*
             * We have traversed to a point in the valToCheck String where input can no longer possibly be a valid
             * anagram substring
             */
            if(valIndex + 1 < input.length()) {
                return false;
            }

            int backwardCounter = valIndex;

            for(int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
                if(valToCheck.charAt(backwardCounter) != input.charAt(inputIndex)) {
                    break;
                }

                // We haven't broken yet so return true;
                if(inputIndex == input.length() - 1) {
                    return true;
                }

                backwardCounter--;
            }
        }

        return false;
    }
}
