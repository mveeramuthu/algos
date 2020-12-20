package com.mveeramuthu.z.oci;

import java.util.Stack;

public class ReverseSubstrParentheses {

    public String reverseParentheses(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }

        int strLen = str.length();
        var stack = new Stack<Character>();

        for (int i = 0; i < strLen; i++) {
            char currChar = str.charAt(i);

            if (currChar == ')') {
                var temp = new StringBuilder();

                while (stack.peek() != '(') {
                    temp.append(stack.pop());
                }

                stack.pop();

                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }

            } else {
                stack.push(currChar);
            }
        }

        var builder = new StringBuilder();
        while(!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }

        return builder.toString();
    }
}
