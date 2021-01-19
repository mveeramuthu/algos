package com.mveeramuthu.z.fb;

import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis {

    /*

    result = {}
    cur = ""
    curLen = 0

    n = 3
    max = n = 3
    open = 0
    close = 0

    if (open < max)
    cur = cur + "("
    open = open + 1

    if (close < open)
    cur = cur + ")"
    close = close + 1

    // termination condition
    if (curLen == max * 2) {
        result.add(cur);
        return;
    }

     */

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public static void backtrack(List<String> result, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            result.add(cur);
            return;
        }

        if (open < max)
            backtrack(result, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(result, cur+")", open, close+1, max);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
