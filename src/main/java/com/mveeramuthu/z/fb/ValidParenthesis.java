package com.mveeramuthu.z.fb;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParenthesis {
    public boolean isValid(String str) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<Character>();
        int strLen = str.length();

        for (int i = 0; i < strLen; i++) {
            char curr = str.charAt(i);

            if (map.containsKey(curr)) {
                char top = stack.isEmpty() ? '#' : stack.pop();

                if (top != map.get(curr)) {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }

        return stack.isEmpty();
    }
}
