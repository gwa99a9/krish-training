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
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the string");
        init(scanner.nextLine());
        scanner.close();
    }
    
    public static void init(String rawString) {
        rawString = rawString.toLowerCase().replaceAll("\\s+", "");
        char[] charStringArrayNoDups = removeDuplicates(rawString);
        sort(charStringArrayNoDups);
        System.out.println(findTheOccurrences(rawString, charStringArrayNoDups));
    }
    
    public static String findTheOccurrences(String rawString, char[] charStringArrayNoDups) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charStringArrayNoDups.length; i++) {
            int countOfOccurrences = 0;
            for (int j = 0; j < rawString.toCharArray().length; j++) {
                if (isValidCharacter(String.valueOf(rawString.toCharArray()[j]))) {
                    if (charStringArrayNoDups[i] == rawString.toCharArray()[j]) {
                        countOfOccurrences++;
                    }
                }
            }
            builder.append("Occrances of [").append(String.valueOf(charStringArrayNoDups[i])).append("]").append(" is ").append(countOfOccurrences).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
    
    public static boolean isValidCharacter(String c) {
        return c.matches("[a-zA-Z]+");
    }
    
    public static char[] removeDuplicates(String rawString) {
        rawString = rawString.toLowerCase().replaceAll("\\s+", "");
        StringBuilder noDupsText = new StringBuilder();
        for (int i = 0; i < rawString.length(); i++) {
            if (isValidCharacter(String.valueOf(rawString.charAt(i)))) {
                if (!noDupsText.toString().contains(String.valueOf(rawString.charAt(i)))) {
                    noDupsText.append(rawString.charAt(i));
                }
            }
        }
        return noDupsText.toString().toCharArray();
    }
    
    public static char[] sort(char[] charStringArrayNoDups) {
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
        return charStringArrayNoDups;
    }
}
