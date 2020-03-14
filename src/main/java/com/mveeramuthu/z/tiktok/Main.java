package com.mveeramuthu.z.tiktok;

public class Main {
    
    private static String removeStr(String str1, String str2) throws Exception {
        if(str1 == null || str2 == null ) {
            throw new Exception("Invalid input!");
        }

        int str1Len = str1.length();
        int str2Len = str2.length();
        if(str2Len > str1Len) {
            throw new Exception("Invalid input!");
        }
        
        StringBuilder resultStr = new StringBuilder();
        int str1Start=0;
        boolean checkSubstr = false;
        
        for (int i=0,j=0; i<str1Len && j<str2Len; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if(checkSubstr) {
                String str1SoFar = str1.substring(str1Start, i+1);
                if(str1SoFar.equals(str2)) {
                    checkSubstr = false;
                    j=0;
                } else {
                    resultStr.append(str1SoFar);
                    j++;
                    if(j >= str2Len) {
                        j=0;
                        checkSubstr = false;
                    }
                }
            } else {
                if(ch1 != ch2) {
                    resultStr.append(ch1);
                    j=0;
                    checkSubstr = false;
                } else {
                    checkSubstr = true;
                    str1Start = i;
                    j++;
                }
            }
        }
        return resultStr.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(removeStr("abwq", "ab"));
            System.out.println(removeStr("xyasabwq", "ab"));
            System.out.println(removeStr("aab", "ab"));
            System.out.println(removeStr("aaab", "ab"));
            System.out.println(removeStr("aabc", "abc"));
            System.out.println(removeStr("aabc", "ab"));
            System.out.println(removeStr("sadjhadhababaabsadiqejasidggicabbABdAbASddaB", "ab"));
            System.out.println(removeStr("", "ab"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}