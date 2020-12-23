package com.mveeramuthu.z.oci;

public class RemoveAdjDuplicates {
    public String removeDuplicates(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }

        int strLen = str.length();
        var stack = new StringBuilder();

        for (int i = 0; i < strLen; i++) {
            char currCh = str.charAt(i);
            int stackLen = stack.length();

            if (stackLen > 0 && stack.charAt(stackLen - 1) == currCh) {
                stack.deleteCharAt(stackLen - 1);
            }
            else {
                stack.append(currCh);
            }
        }

        return stack.toString();
    }
}
