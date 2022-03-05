/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gst.cch_numberofoccurrence;

import java.util.Scanner;

/**
 *
 * @author OBITO
 */
public class Main {
//TODO : write test classess

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the string");
        findTheOccurrences(scanner.nextLine());
        scanner.close();
    }

    public static void findTheOccurrences(String text) {
        find(text.toLowerCase());
    }

    private static void find(String rawString) {
        char[] charStringArrayNoDups = removeDuplicates(rawString);
        sort(charStringArrayNoDups);

        for (int i = 0; i < charStringArrayNoDups.length; i++) {
            int countOfOccurrences = 0;
            for (int j = 0; j < rawString.toCharArray().length; j++) {
                if (isValidCharacter(String.valueOf(rawString.toCharArray()[j]))) {
                    if (charStringArrayNoDups[i] == rawString.toCharArray()[j]) {
                        countOfOccurrences++;
                    }
                }
            }
            System.out.println("Occrances of [" + String.valueOf(charStringArrayNoDups[i]) + "]" + " is " + countOfOccurrences);
        }
    }

    private static boolean isValidCharacter(String c) {
        return c.matches("[a-zA-Z]+");
    }

    private static char[] removeDuplicates(String text) {
        StringBuilder noDupsText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (isValidCharacter(String.valueOf(text.charAt(i)))) {
                if (!noDupsText.toString().contains(String.valueOf(text.charAt(i)))) {
                    noDupsText.append(text.charAt(i));
                }
            }
        }
        return noDupsText.toString().toCharArray();
    }

    private static void sort(char[] charStringArrayNoDups) {
        int size = charStringArrayNoDups.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (charStringArrayNoDups[i] > charStringArrayNoDups[j]) {
                    char temp = charStringArrayNoDups[i];
                    charStringArrayNoDups[i] = charStringArrayNoDups[j];
                    charStringArrayNoDups[j] = temp;
                }
            }

        }
    }
}
