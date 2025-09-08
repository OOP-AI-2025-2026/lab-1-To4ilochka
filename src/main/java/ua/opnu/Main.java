package ua.opnu;

import java.util.Arrays;

public class Main {
    private static final int MIN_TEMP = 0;
    private static final int MAX_TEMP = 100;
    private static final int LOWER_BOUND = 10;
    private static final int UPPER_BOUND = 20;
    private static final int LOWER_TEEN_BOUND = 13;
    private static final int UPPER_TEEN_BOUND = 19;
    private static final int TARGET_NUMBER = 9;
    private static final int PREFIX_LENGTH = 4;
    private static final int[] ARRAY_PATTERN = {1, 2, 3};

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // ======== Logical operations ========

    /**
     * Given two temperatures, return true if one is less than 0 and the other is greater than 100.
     * Example:
     * icyHot(120, -1) → true
     * icyHot(-1, 120) → true
     * icyHot(2, 120) → false
     */
    public boolean icyHot(int temp1, int temp2) {
        return (temp1 < MIN_TEMP && temp2 > MAX_TEMP)
                || (temp1 > MAX_TEMP && temp2 < MIN_TEMP);
    }

    /**
     * Given 2 int values, return true if either of them is in the range 10..20 inclusive.
     * Example:
     * in1020(12, 99) → true
     * in1020(21, 12) → true
     * in1020(8, 99) → false
     */
    public boolean in1020(int a, int b) {
        return isInRange(a, LOWER_BOUND, UPPER_BOUND)
                || isInRange(b, LOWER_BOUND, UPPER_BOUND);
    }

    /**
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 3 int values, return true if 1
     * or more of them are teen.
     * Example:
     * hasTeen(13, 20, 10) → true
     * hasTeen(20, 19, 10) → true
     * hasTeen(20, 10, 13) → true
     */
    public boolean hasTeen(int a, int b, int c) {
        return isInRange(a, LOWER_TEEN_BOUND, UPPER_TEEN_BOUND)
                || isInRange(b, LOWER_TEEN_BOUND, UPPER_TEEN_BOUND)
                || isInRange(c, LOWER_TEEN_BOUND, UPPER_TEEN_BOUND);
    }

    // ======== Boolean expressions ========

    /**
     * The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation.
     * We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
     * Example:
     * sleepIn(false, false) → true
     * sleepIn(true, false) → false
     * sleepIn(false, true) → true
     */
    public boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }

    /**
     * We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling.
     * We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble.
     * Example:
     * monkeyTrouble(true, true) → true
     * monkeyTrouble(false, false) → true
     * monkeyTrouble(true, false) → false
     */
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return aSmile == bSmile;
    }

    /**
     * Given 2 int values, return true if one is negative and one is positive. Except if the parameter "negative"
     * is true, then return true only if both are negative.
     * Example:
     * posNeg(1, -1, false) → true
     * posNeg(-1, 1, false) → true
     * posNeg(-4, -5, true) → true
     */
    public boolean posNeg(int a, int b, boolean negative) {
        return negative ? (a < 0 && b < 0)
                : (a > 0 && b < 0) || (a < 0 && b > 0);
    }

    // ======== Loops and Arrays ========

    /**
     * Given an array of ints, return the number of 9's in the array.
     * Example:
     * arrayCount9([1, 2, 9]) → 1
     * arrayCount9([1, 9, 9]) → 2
     * arrayCount9([1, 9, 9, 3, 9]) → 3
     */
    public int arrayCount9(int[] nums) {
        return countOccurrences(TARGET_NUMBER, nums);
    }

    /**
     * Given an array of ints, return true if one of the first 4 elements in the array is a 9.
     * The array length may be less than 4.
     * Example:
     * arrayFront9([1, 2, 9, 3, 4]) → true
     * arrayFront9([1, 2, 3, 4, 9]) → false
     * arrayFront9([1, 2, 3, 4, 5]) → false
     */
    public boolean arrayFront9(int[] nums) {
        return containsNumberInPrefix(TARGET_NUMBER, PREFIX_LENGTH, nums);
    }

    /**
     * Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
     * Example:
     * array123([1, 1, 2, 3, 1]) → true
     * array123([1, 1, 2, 4, 1]) → false
     * array123([1, 1, 2, 1, 2, 3]) → true
     */
    public boolean array123(int[] nums) {
        for (int i = 0; i <= nums.length - ARRAY_PATTERN.length; i++) {
            int[] sub = Arrays.copyOfRange(nums, i, i + ARRAY_PATTERN.length);

            if (Arrays.equals(sub, ARRAY_PATTERN)) {
                return true;
            }
        }
        return false;
    }

    // ======== Strings ========

    /**
     * Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
     * Example:
     * helloName("Bob") → "Hello Bob!"
     * helloName("Alice") → "Hello Alice!"
     * helloName("X") → "Hello X!"
     */
    public String helloName(String name) {
        return String.format("Hello %s!", name);
    }

    /**
     * Given a string of any length, return a new string where the last 2 chars, if present, are swapped, so "coding"
     * yields "codign".
     * Example:
     * lastTwo("coding") → "codign"
     * lastTwo("cat") → "cta"
     * lastTwo("ab") → "ba"
     */
    public String lastTwo(String str) {
        if (str.length() < 2) {
            return str;
        }

        StringBuilder result = new StringBuilder(str);
        char last = result.charAt(result.length() - 1);
        result.setCharAt(result.length() - 1,
                result.charAt(result.length() - 2));
        result.setCharAt(result.length() - 2, last);
        return result.toString();
    }

    /**
     * Given a string of even length, return a string made of the middle two chars, so the string "string" yields "ri".
     * The string length will be at least 2.
     * middleTwo("string") → "ri"
     * middleTwo("code") → "od"
     * middleTwo("Practice") → "ct"
     */
    public String middleTwo(String str) {
        int mid = str.length() / 2;
        return str.substring(mid - 1, mid + 1);
    }

    private boolean isInRange(int number, int lowerBound, int upperBound) {
        return (number >= lowerBound) && (number <= upperBound);
    }

    private int countOccurrences(int target, int[] array) {
        return (int) Arrays.stream(array)
                .filter(n -> n == target)
                .count();
    }

    private boolean containsNumberInPrefix(int target, int prefixLength, int[] array) {
        return Arrays.stream(array)
                .limit(prefixLength)
                .anyMatch(n -> n == target);
    }
}