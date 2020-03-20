package com.mveeramuthu.binary;

import java.util.Collections;

public class AddBinary {
    public static String addBinary(String a, String b) {
        
        if(a==null || a.isEmpty()) {
            return b;
        }

        if(b==null || b.isEmpty()) {
            return a;
        }
        
        int aLen = a.length()-1;
        int bLen = b.length()-1;
        int carry = 0;
        
        StringBuilder sumSb = new StringBuilder();
        
        while(aLen>=0 && bLen>=0) {
            int m = Character.getNumericValue(a.charAt(aLen));
            int n = Character.getNumericValue(b.charAt(bLen));
            int sum = m + n + carry;

            //System.out.println(m + "+" + n + "+" + carry + "=" + sum);

            carry = sum/2;
            sum = sum%2;
            sumSb.append(sum);

            //System.out.println("newCarry=" + carry + ", newSum=" + sum);
            //System.out.println(sumSb.reverse().toString());
            //System.out.println();
            
            aLen--;
            bLen--;
        }
        
        while (aLen>=0) {
            int m = Character.getNumericValue(a.charAt(aLen));
            int sum = m + carry;

            carry = sum/2;
            sum = sum%2;
            sumSb.append(sum);
            
            aLen--;
        }
        
        while (bLen>=0) {
            int n = Character.getNumericValue(b.charAt(bLen));
            int sum = n + carry;
            
            carry = carry/2;
            sum = sum%2;
            sumSb.append(sum);
            
            bLen--;
        }

        if(carry == 1) {
            sumSb.append("1");
        }
        
        String binarySum = sumSb.reverse().toString();
        System.out.println(a + "+" + b + "=" + binarySum);
        
        return binarySum;
    }
}
