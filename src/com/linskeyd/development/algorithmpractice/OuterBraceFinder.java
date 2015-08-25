package com.linskeyd.development.algorithmpractice;

import com.google.common.collect.Maps;
import lombok.NonNull;

import java.util.Map;

/**
 * Created by linskeyd on 8/24/15.
 */
public class OuterBraceFinder {

    public static Map<Character, Integer> findOuterBraces(
            @NonNull final String data,
            @NonNull final BraceType braceType,
            final int cursorPosition,
            final boolean before) {
        if (data.isEmpty()) {
            throw new RuntimeException("Cannot find outer braces; passed data must be non-empty");
        }

        if(cursorPosition > data.length() || cursorPosition <=0 ) {
            throw new RuntimeException("Invalid cursor position specified. Cursor position must not be indexed at a " +
            "position longer than the passed data, and must be a positive integer cursorPosition: " + cursorPosition);
        }

        int index;

        // In this case we don't count the value until one less than the current index.
        if(!before) {
            index = cursorPosition + 1;
        } else {
            index = cursorPosition;
        }

        // No braces to be found at the very end of the input.
        if(index == data.length()) {
            return null;
        }

        final Map<Character, Integer> result = Maps.newHashMap();

        // TODO: Handle the clashing open/close brace case where we find an invalid open or close along the way.
        for(; index < data.length(); index++) {
            if(data.charAt(index) == braceType.close) {
                result.put(braceType.close, index);
                break;
            }
        }

        // When looking for the open brace, the rule for before is slightly different
        if(!before) {
            index = cursorPosition;
        } else {
            index = cursorPosition - 1;
        }

        // Cursor is before and at the very beginning
        if(index == -1) {
            return null;
        }

        for(; index >= 0; index--) {
            if(data.charAt(index) == braceType.open) {
                result.put(braceType.open, index);
                break;
            }
        }

        if(result.size() != 2) {
            throw new RuntimeException("No valid outer braces found of type: " + braceType.name().toString());
        }

        return result;
    }

    public enum BraceType {
        SQUARE('[', ']'),
        CURLY('{', '}'),
        ROUND('(', ')');

        private Character open;
        private Character close;

        BraceType(final Character open, final Character close) {
            this.open = open;
            this.close = close;
        }


        public Character getOpenBrace() {
            return this.open;
        }

        public Character getCloseBrace() {
            return this.close;
        }
    }
}
