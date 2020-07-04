package org.madawa.practice.problems;

/*
https://leetcode.com/problems/string-to-integer-atoi/

Implement atoi which converts a string to an integer

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:
Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 */
public class Atoi {
    public static int myAtoi(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        str = str.trim();
        int multiplier = 1;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        char[] ar = str.toCharArray();

        if (ar[index] == '-') {
            multiplier = -1;
            ++index;
        } else if (ar[index] == '+') {
            ++index;
        }

        for (int i = index; i < ar.length; ++i) {
            if(Character.getNumericValue(ar[i]) >= 0 && Character.getNumericValue(ar[i]) <= 9) {
                sb.append(Character.getNumericValue(ar[i]));
            } else {
                break;
            }
        }
        if (!sb.toString().equals("")) {
            double result = multiplier * Double.parseDouble(sb.toString());
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) result;
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-80"));
        System.out.println(myAtoi("67 hukjk"));
    }
}
