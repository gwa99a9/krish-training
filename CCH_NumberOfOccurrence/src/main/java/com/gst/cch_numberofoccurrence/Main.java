/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gst.cch_numberofoccurrence;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author OBITO
 */
public class Main {

    static SortedMap<String, Integer> count = new TreeMap<>();

    private static void findOccurrence(String text) {
        String[] split = text.split("");
        for (String string : split) {
            if (isValidCharacter(string)) {
                if (count.containsKey(string)) {
                    Integer get = count.get(string);
                    count.replace(string, get + 1);
                } else {
                    count.put(string, 1);
                }
            }
        }
    }

    public static boolean isValidCharacter(String c) {
        return c.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        String text = "Apple is pp x 33  @#@";
        findOccurrence(text.toLowerCase());
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key + "-" + val);
        }
    }
}
