/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.gst.cch_numberofoccurrence;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author OBITO
 */
public class MainTest {

    public MainTest() {
    }

    @Test
    public void testIsValidCharacterWithNumber() {
        boolean expected = false;
        Assert.assertEquals(expected, Main.isValidCharacter("1"));
    }

    @Test
    public void testIsValidCharacterWithLetter() {
        boolean expected = true;
        Assert.assertEquals(expected, Main.isValidCharacter("A"));
    }

    @Test
    public void testremoveDuplicates() {
        String stringWithDuplicates = "apple is aPPle";
        char[] expectedCharArray = {'a', 'p', 'l', 'e', 'i', 's'};
        Assert.assertArrayEquals(expectedCharArray, Main.removeDuplicates(stringWithDuplicates));
    }

    @Test
    public void testSort() {
        char[] unSortedCharArray = {'a', 'p', 'l', 'e', 'i', 's'};
        char[] expectedSortedCharArray = {'a', 'e', 'i', 'l', 'p', 's'};
        Assert.assertArrayEquals(expectedSortedCharArray, Main.sort(unSortedCharArray));
    }
}
