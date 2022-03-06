/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gst.cch_missing.number;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author OBITO
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number Sequence and use , as the delimiter.");

        String rawInput = scanner.nextLine();
        String[] rawSplit = rawInput.split(",");
        int[] seqNumbers = new int[rawSplit.length];

        createNumberSequence(rawSplit, seqNumbers);
        sort(seqNumbers);
        System.out.println("Sorted Number Sequence " + Arrays.toString(seqNumbers));
        System.out.println(findTheMissingNumber(seqNumbers));

        scanner.close();
    }

    public static int[] createNumberSequence(String[] rawSplit, int[] seqNumbers) {
        for (int i = 0; i < rawSplit.length; i++) {
            if (!validateInput(rawSplit[i])) {
                System.out.println("Invalid Number Sequence.");
                System.exit(0);
            }
            seqNumbers[i] = Integer.parseInt(rawSplit[i]);
        }
        return seqNumbers;
    }

    public static int[] sort(int[] seqNumbers) {
        int size = seqNumbers.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (seqNumbers[i] > seqNumbers[j]) {
                    int temp = seqNumbers[i];
                    seqNumbers[i] = seqNumbers[j];
                    seqNumbers[j] = temp;
                }
            }
        }
        return seqNumbers;
    }

    public static String findTheMissingNumber(int[] seqNumbers) {
        StringBuilder builder = new StringBuilder();
        builder.append("Missing Numbers for this Sequence are : ");
        for (int i = 0; i < seqNumbers.length - 1; i++) {
            if ((seqNumbers[i + 1] - seqNumbers[i]) == 2) {
                builder.append(seqNumbers[i] + 1).append(",");
            } else if ((seqNumbers[i + 1] - seqNumbers[i]) >= 3) {
                builder = new StringBuilder();
                builder.append("Invalid Number Sequence.");
                break;
            }
        }
        if (builder.toString().endsWith(",")) {
            return builder.replace(builder.toString().length() - 1, builder.toString().length(), "").toString();
        } else {
            return builder.toString();
        }
    }

    public static boolean validateInput(String rawSplit) {
        try {
            Double.parseDouble(rawSplit);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
