package com.mveeramuthu.z.fb;

class AddStrings {
    public String addStrings(String num1, String num2) {

        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;

        while (num1Len >= 0 || num2Len >= 0) {

            int digit1 = num1Len >= 0 ? num1.charAt(num1Len) - '0' : 0;
            int digit2 = num2Len >= 0 ? num2.charAt(num2Len) - '0' : 0;

            int digitSum = (digit1 + digit2 + carry);
            sum.append(digitSum % 10);
            carry = digitSum / 10;

            num1Len--;
            num2Len--;
        }

        if (carry != 0) {
            sum.append(carry);
        }

        return sum.reverse().toString();
    }
}
