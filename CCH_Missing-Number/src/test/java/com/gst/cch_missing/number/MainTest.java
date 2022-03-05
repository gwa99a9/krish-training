/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.gst.cch_missing.number;

import java.util.Arrays;
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
    public void testCreateNumberSequence() {
        String rawInput = "5,2,4,6,8";
        String[] rawSplit = rawInput.split(",");
        int[] seqNumbers = new int[rawSplit.length];
        int[] expectedNumberSequence = {5, 2, 4, 6, 8};
        int[] createNumberSequence = Main.createNumberSequence(rawSplit, seqNumbers);
        Assert.assertArrayEquals(expectedNumberSequence, createNumberSequence);
    }

    @Test
    public void testValidateInput() {
        boolean expected = false;
        Assert.assertEquals(expected, Main.validateInput("A"));
    }

    @Test
    public void testSortWithPositiveNumbersOnly() {
        int[] unSortedNumberArray = {5, 2, 4, 6, 8};
        int[] sortedNumberArray = unSortedNumberArray;
        Arrays.sort(sortedNumberArray);
        Assert.assertArrayEquals(sortedNumberArray, Main.sort(unSortedNumberArray));
    }

    @Test
    public void testSortWithMixedNumbersOnly() {
        int[] unSortedNumberArray = {5, 2, 4, 6, -2, -1, 8};
        int[] sortedNumberArray = unSortedNumberArray;
        Arrays.sort(sortedNumberArray);
        Assert.assertArrayEquals(sortedNumberArray, Main.sort(unSortedNumberArray));
    }

    @Test
    public void testFindTheMissingNumberWithPositiveNumbersOnly() {
        int[] sortedNumberArray = {1, 2, 4, 5, 6, 8};
        Assert.assertEquals("Missing Numbers for this Sequence are : 3,7", Main.findTheMissingNumber(sortedNumberArray));
    }

    @Test
    public void testFindTheMissingNumberWithMixedNumbersOnly() {
        int[] sortedNumberArray = {-3, -1, 1, 2, 4, 5, 6, 8};
        Assert.assertEquals("Missing Numbers for this Sequence are : -2,0,3,7", Main.findTheMissingNumber(sortedNumberArray));
    }

    @Test
    public void testFindTheMissingNumberInvalidSequence() {
        int[] sortedNumberArray = { 2, 4, 5, 6, 9};
        Assert.assertEquals("Invalid Number Sequence.", Main.findTheMissingNumber(sortedNumberArray));
    }
}
