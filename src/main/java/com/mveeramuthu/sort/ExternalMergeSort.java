package com.mveeramuthu.sort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExternalMergeSort {
    public static void externalSort() {
        try {
            var inPath = Paths.get(Objects.requireNonNull(ExternalMergeSort.class.getClassLoader()
                .getResource("externalsort/input2.txt")).toURI());
            var outPath = Paths.get("src/main/resources/externalsort/output2.txt");
            if(!Files.exists(outPath)) {
                Files.createFile(outPath);
            }

            try (var lines = Files.lines(inPath)) {
                lines.forEach(line -> {
                    System.out.println(line);
                    var lineArr = line.split("\\s*,\\s*");

                    int lineArrLen = lineArr.length;
                    var numbers = new int[lineArrLen + 1];
                    int index = 0;

                    for (int i = 0; i < lineArrLen; i++) {
                        try {
                            numbers[index] = Integer.parseInt(lineArr[i]);
                            index++;
                        } catch (NumberFormatException nfe) {
                            nfe.printStackTrace();
                        }
                    }

                    numbers = Arrays.copyOf(numbers, index);
                    System.out.println("Before - numbers: " + Arrays.toString(numbers));
                    MergeSort.mergeSort(numbers);
                    System.out.println("After - numbers: " + Arrays.toString(numbers));

                });
            }

            try {
                Files.write(outPath,
                    "".getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        externalSort();
    }
}
