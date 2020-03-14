package com.mveeramuthu.z.adobe;

/*
cellphone keyboard
123
456
789

at least 4 numbers, no duplication
total number of combinations to unluck the cellphone
legal: 12357,12369,78963
illegal: 12345, 12321
*/

import java.util.ArrayList;
import java.util.List;

public class CellphoneKeyboard {
    
    public static List<String> generateCombinations(int[][] cellphone) {  
        if (cellphone == null) {
            return null; // throw exception
        }
        int rowCount = cellphone.length;
        int colCount = cellphone[0].length; // TODO: check
        List<String> validCombinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                generateValidCombinations(validCombinations, cellphone, rowCount, colCount, i, j, combination);
            }
        }

        return validCombinations;
    }


    private static void generateValidCombinations(List<String> combinationList, int[][] cellphone, int rowCount, int colCount, int i, int j, List<Integer> combination) {
        if (i < 0 || j < 0 || i >= rowCount || j >= colCount) {
            return;
        }
        try {
            combination.add(cellphone[i][j]);

            String combinationStr = new String();
            for (Integer digit : combination) {
                combinationStr += Integer.toString(digit);
            }
            combinationList.add(combinationStr);

            generateValidCombinations(combinationList, cellphone, rowCount, colCount,i - 1, j - 1, combination);
            generateValidCombinations(combinationList, cellphone, rowCount, colCount, i, j - 1, combination);
            generateValidCombinations(combinationList, cellphone, rowCount, colCount,i + 1, j - 1, combination);

            generateValidCombinations(combinationList, cellphone, rowCount, colCount,i - 1, j, combination);
            generateValidCombinations(combinationList, cellphone, rowCount, colCount,i + 1, j, combination);

            generateValidCombinations(combinationList, cellphone, rowCount, colCount,i - 1, j + 1, combination);
            generateValidCombinations(combinationList, cellphone, rowCount, colCount, i, j + 1, combination);
            generateValidCombinations(combinationList, cellphone, rowCount, colCount,i + 1, j + 1, combination);
            
        } catch (Exception ex) {

        }
    }
    
    public static void main(String args[]) {
        List<String> validCombinations = generateCombinations(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
        
        for(String result : validCombinations) {
            System.out.print(result + ",");
        }
    }
}

