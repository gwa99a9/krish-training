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
        for (int i = 0; i < rawSplit.length; i++) {
            if (!validateInput(rawSplit[i])) {
                System.out.println("Invalid Number Sequence");
                System.exit(0);
            }
            seqNumbers[i] = Integer.parseInt(rawSplit[i]);
        }

        sort(seqNumbers);
        System.out.println(Arrays.toString(seqNumbers));
        findTheMissingNumber(seqNumbers);
        scanner.close();
    }

//TODO : create test classess
    private static void sort(int[] seqNumbers) {
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
    }

    private static void findTheMissingNumber(int[] seqNumbers) {
        for (int i = 0; i < seqNumbers.length - 1; i++) {
            if ((seqNumbers[i + 1] - seqNumbers[i]) == 2) {
                System.out.println(seqNumbers[i] + 1);
            } else if ((seqNumbers[i + 1] - seqNumbers[i]) >= 3) {
                System.out.println("Invalid Sequence");
                break;
            }
        }
    }

    private static boolean validateInput(String rawSplit) {
        try {
            Double.parseDouble(rawSplit);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
