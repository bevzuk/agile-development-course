package com.szhdanov.test;

import com.szhdanov.main.BitArray;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: sergey zhdanov
 */
public class BitArrayTest {

    @Test
    public void testInitilizationConsturctor() throws Exception {
        int count = 100;
        BitArray array = new BitArray(count, 0);
        assertTrue("wrong array size", array.count() == count);
        for (int i = 0; i < count; ++i) {
            assertTrue("0 check, wrong value for " + i, array.get(i) == 0);
        }

        array = new BitArray(count, 1);
        assertTrue("wrong array size", array.count() == count);
        for (int i = 0; i < count; ++i) {
            assertTrue("1 check, wrong value for " + i, array.get(i) == 1);
        }
    }

    @Test
    public void testAddNormal() throws Exception {
        BitArray array = new BitArray();
        assertTrue("count not 0", array.count() == 0);
        int count = 100;
        for (int i = 0; i < count; ++i) {
            array.add(i % 2);
        }
        for (int i = 0; i < count; ++i) {
            if (i % 2 != 0) {
                assertEquals(array.get(i), 1);
            } else {
                assertEquals(array.get(i), 0);
            }
        }
        array.add(-1);
        assertTrue("test for set -1 value", array.get(array.count() - 1) == 1);
    }

    // too resource intensive. Uncomment if need.
//    @Test
//    public void testAddMaxRange() throws Exception {
//        BitArray array = new BitArray(Integer.MAX_VALUE, 0);
//        System.out.println(array.count());
//        assertTrue("wrong value of MAX_VALUE index", array.get(Integer.MAX_VALUE - 1) == 0);
//    }

    @Test
    public void testAddEcxeptional() {
        BitArray array = null;
        try {
            array = new BitArray(Integer.MAX_VALUE + 1, 0);

        } catch (Exception ex) {
            //do nothing
        }
        assertTrue("array not null", array == null);

        try {
            array = new BitArray(-1, 0);

        } catch (Exception ex) {
            //do nothing
        }
        assertTrue("array not null", array == null);
    }

    @Test
    public void testSetNormal() throws Exception {
        BitArray array = new BitArray(10, 0);
        assertTrue("wrong size", array.count() == 10);
        assertTrue(array.get(0) == 0);
        array.set(0, 1);
        assertTrue(array.get(0) == 1);

        assertTrue(array.get(5) == 0);
        array.set(5, 1);
        assertTrue(array.get(5) == 1);

        assertTrue(array.get(9) == 0);
        array.set(9, 1);
        assertTrue(array.get(9) == 1);
    }

    @Test
    public void testSetExceptinal() throws Exception {
        BitArray array = new BitArray(10, 0);
        assertTrue("wrong size", array.count() == 10);

        try {
            array.set(-1, 0);
            fail("set with -1");
        } catch (ArrayIndexOutOfBoundsException ex) {
            //do nothing
        }

        try {
            array.set(10, 0);
            fail("set with -1");
        } catch (ArrayIndexOutOfBoundsException ex) {
            //do nothing
        }
    }

    @Test
    public void testGetExceptinal() throws Exception {
        BitArray array = new BitArray(10, 0);
        assertTrue("wrong size", array.count() == 10);

        try {
            array.get(-1);
            fail("set with -1");
        } catch (ArrayIndexOutOfBoundsException ex) {
            //do nothing
        }

        try {
            array.get(10);
            fail("set with -1");
        } catch (ArrayIndexOutOfBoundsException ex) {
            //do nothing
        }
    }

    @Test
    public void testFromStringNormal() throws Exception {
        String testString = "0001001010100101111000101000010010010100110101001010100101001011101001111000110";
        BitArray array = BitArray.fromString(testString);
        assertTrue("different length", array.count() == testString.length());

        int valOfString = -1;
        for (int i = 0; i < testString.length(); ++i) {
            valOfString = Integer.valueOf(testString.substring(i, i + 1));
            assertTrue("wrong value for i: " + i + " given: " + array.get(i) + "; must: " + valOfString, valOfString == array.get(i));
        }
    }

    @Test
    public void testFromStringExceptional() throws Exception {
        String testString = null;
        BitArray bitArray = null;
        try {
            bitArray = BitArray.fromString(testString);
            fail("must be null");
        } catch (IllegalArgumentException ex) {

        }
        assertTrue("must be null", bitArray == null);

        testString = "001001askdfjsl001";
        try {
            bitArray = BitArray.fromString(testString);
            fail("must be null");
        } catch (IllegalArgumentException ex) {

        }
        assertTrue("must be a null", bitArray == null);

        testString = "00100195468309451";
        try {
            bitArray = BitArray.fromString(testString);
            fail("must be a null");
        } catch (IllegalArgumentException ex) {

        }
        assertTrue("must be a null", bitArray == null);
    }

    @Test
    public void testToBitString() throws Exception {
        BitArray array = new BitArray();
        assertTrue("check for empty", array.toBitString().equalsIgnoreCase(""));
        String testString = "01100101010100101010111010100101010";
        array = BitArray.fromString(testString);
        assertTrue("check for testString", array.toBitString().equalsIgnoreCase(testString));
    }

    @Test
    public void testFromIntArray() throws Exception {
        int[] testArray = {0, 1, 2};
        BitArray array = BitArray.fromArray(testArray);
        assertTrue("len check", array.count() == testArray.length * 32 + 1);
        for (int i = 0; i < 32; ++i) {
            assertTrue("check for i: " + i, array.get(i) == 0);
        }
        for (int i = 33; i < 63; ++i) {
            assertTrue("check for i: " + i, array.get(i) == 0);
        }
        assertTrue("check for i: " + 32, array.get(32) == 1);
        for (int i = 66; i < 96; ++i) {
            assertTrue("check for i: " + i, array.get(i) == 0);
        }
        assertTrue("check for i: " + 64, array.get(64) == 0);
        assertTrue("check for i: " + 65, array.get(65) == 1);
    }

    @Test
    public void testFromIntArrayExceptional() throws Exception {
        BitArray array = null;
        try {
            array = BitArray.fromArray(null);
            fail("must be a null");
        } catch (IllegalArgumentException ex) {

        }
        try {
            int[] testArray = {};
            array = BitArray.fromArray(testArray);
            fail("must be a null");
        } catch (IllegalArgumentException ex) {

        }
    }

    @Test
    public void testToIntArray() throws Exception {
        int[] testArray = {1, 11, 111};
        BitArray array = BitArray.fromArray(testArray);
        int[] outputArray = array.toIntArray();
        for (int i = 0; i < testArray.length; ++i) {
            assertTrue("check i: " + i, outputArray[i] == testArray[i]);
        }
    }

    @Test
    public void testAnd() throws Exception {
        String testString1 = "000000000100000000";
        String testString2 = "111111111111111111";
        String resultStr = "000000000100000000";
        BitArray array1 = BitArray.fromString(testString1);
        BitArray array2 = BitArray.fromString(testString2);
        BitArray resultArray = array1.and(array2);
        assertTrue("result check", resultArray.toBitString().equalsIgnoreCase(resultStr));
        assertTrue("unchanged 1 check", array1.toBitString().equalsIgnoreCase(testString1));
        assertTrue("unchanged 2 check", array2.toBitString().equalsIgnoreCase(testString2));
    }

    @Test
    public void testAndExceptional() throws Exception {
        String testString1 = "0000000000000100000000";
        String testString2 = "111111111111111111";
        BitArray array1 = BitArray.fromString(testString1);
        BitArray array2 = BitArray.fromString(testString2);
        BitArray resultArray = null;
        try {
            resultArray = array1.and(array2);
            fail("must be a null");
        } catch (IllegalArgumentException ex) {

        }
        assertTrue("must be a null", resultArray == null);
        assertTrue("unchanged 1 check", array1.toBitString().equalsIgnoreCase(testString1));
        assertTrue("unchanged 2 check", array2.toBitString().equalsIgnoreCase(testString2));
    }

    @Test
    public void testOr() throws Exception {
        String testString1 = "000000010100000000";
        String testString2 = "111111111111111111";
        String resultStr = "111111111111111111";
        BitArray array1 = BitArray.fromString(testString1);
        BitArray array2 = BitArray.fromString(testString2);
        BitArray resultArray = array1.or(array2);
        assertTrue("result check", resultArray.toBitString().equalsIgnoreCase(resultStr));
        assertTrue("unchanged 1 check", array1.toBitString().equalsIgnoreCase(testString1));
        assertTrue("unchanged 2 check", array2.toBitString().equalsIgnoreCase(testString2));
    }

    @Test
    public void testOrExceptional() throws Exception {
        String testString1 = "0000000000000100000000";
        String testString2 = "111111111111111111";
        BitArray array1 = BitArray.fromString(testString1);
        BitArray array2 = BitArray.fromString(testString2);
        BitArray resultArray = null;
        try {
            resultArray = array1.or(array2);
            fail("must be a null");
        } catch (IllegalArgumentException ex) {

        }
        assertTrue("must be a null", resultArray == null);
        assertTrue("unchanged 1 check", array1.toBitString().equalsIgnoreCase(testString1));
        assertTrue("unchanged 2 check", array2.toBitString().equalsIgnoreCase(testString2));
    }

    @Test
    public void testXor() throws Exception {
        String testString1 = "000000010100000000";
        String testString2 = "111111111111111111";
        String resultStr = "111111101011111111";
        BitArray array1 = BitArray.fromString(testString1);
        BitArray array2 = BitArray.fromString(testString2);
        BitArray resultArray = array1.xor(array2);
        assertTrue("result check", resultArray.toBitString().equalsIgnoreCase(resultStr));
        assertTrue("unchanged 1 check", array1.toBitString().equalsIgnoreCase(testString1));
        assertTrue("unchanged 2 check", array2.toBitString().equalsIgnoreCase(testString2));
    }

    @Test
    public void testXorExceptional() throws Exception {
        String testString1 = "0000000000000100000000";
        String testString2 = "111111111111111111";
        BitArray array1 = BitArray.fromString(testString1);
        BitArray array2 = BitArray.fromString(testString2);
        BitArray resultArray = null;
        try {
            resultArray = array1.xor(array2);
            fail("must be a null");
        } catch (IllegalArgumentException ex) {

        }
        assertTrue("must be a null", resultArray == null);
        assertTrue("unchanged 1 check", array1.toBitString().equalsIgnoreCase(testString1));
        assertTrue("unchanged 2 check", array2.toBitString().equalsIgnoreCase(testString2));
    }

    @Test
    public void testNot() throws Exception {
        String testString = "000000000000111111111111";
        String resultString = "111111111111000000000000";
        BitArray array = BitArray.fromString(testString);
        BitArray resultArray = array.not();
        assertTrue("check result", resultArray.toBitString().equalsIgnoreCase(resultString));
    }

    @Test
    public void testLshft() throws Exception {
        String testString = "1111111111111000000000000";
        String resultString1 = "0001111111111111000000000";
        String resultString2 = "0000000000000000000000000";

        BitArray array = BitArray.fromString(testString);
        BitArray resultArray = array.lshft(3);
        assertTrue("chech result 1", resultArray.toBitString().equalsIgnoreCase(resultString1));
        resultArray = array.lshft(25);
        assertTrue("chech result 2", resultArray.toBitString().equalsIgnoreCase(resultString2));
    }

    @Test
    public void testLshftExceptional() throws Exception {
        BitArray array = new BitArray();
        BitArray resultArray = null;
        try {
            resultArray = array.lshft(3);
            fail("must be a null");
        } catch (Exception ex) {

        }

        array = new BitArray(10, 0);
        try {
            resultArray = array.lshft(-3);
            fail("must be a null");
        } catch (Exception ex) {

        }
    }

    @Test
    public void testRshft() throws Exception {
        String testString = "0000000000001111111111111";
        String resultString1 = "0001111111111111000000000";
        String resultString2 = "0000000000000000000000000";

        BitArray array = BitArray.fromString(testString);
        BitArray resultArray = array.rshft(9);
        assertTrue("chech result 1", resultArray.toBitString().equalsIgnoreCase(resultString1));
        resultArray = array.rshft(25);
        assertTrue("chech result 2", resultArray.toBitString().equalsIgnoreCase(resultString2));
    }

    @Test
    public void testRshftExceptional() throws Exception {
        BitArray array = new BitArray();
        BitArray resultArray = null;
        try {
            resultArray = array.rshft(3);
            fail("must be a null");
        } catch (Exception ex) {

        }

        array = new BitArray(10, 0);
        try {
            resultArray = array.rshft(-3);
            fail("must be a null");
        } catch (Exception ex) {

        }
    }

    @Test
    public void testAppend() throws Exception {
        String testString1 = "00000000000000";
        String testString2 = "11111111111111";
        String resultString = "0000000000000011111111111111";
        BitArray array1 = BitArray.fromString(testString1);
        BitArray array2 = BitArray.fromString(testString2);
        BitArray result = array1.append(array2);
        assertTrue("check result", result.toBitString().equalsIgnoreCase(resultString));
    }

    @Test
    public void testSubArray() throws Exception {
        String testString = "00001110000000";
        BitArray array = BitArray.fromString(testString);
        BitArray resultArray = array.subArray(4, 3);
        assertTrue("cout check", resultArray.count() == 3);
        for (int i = 0; i < resultArray.count(); ++i) {
            assertTrue("check i: " + i, resultArray.get(i) == 1);
        }
    }

    @Test
    public void testSubArrayExceptional() throws Exception {
        String testString = "00001110000000";
        BitArray array = BitArray.fromString(testString);
        BitArray resultArray = null;
        try {
            resultArray = array.subArray(-1, 3);
            fail("must be a null");
        } catch (Exception ex) {

        }

        try {
            resultArray = array.subArray(1000, 3);
            fail("must be a null");
        } catch (Exception ex) {

        }

        try {
            resultArray = array.subArray(1, 0);
            fail("must be a null");
        } catch (Exception ex) {

        }


    }

    @Test
    public void testClone() throws Exception {
        BitArray array = new BitArray();
        array.add(1);
        array.add(1);

        BitArray cloneArray = array.clone();
        assertTrue("clones", cloneArray.get(1) == 1);

        cloneArray.set(1, 0);
        assertTrue("check changed", cloneArray.get(1) == 0);
        assertTrue("check unchanged", array.get(1) == 1);


    }
}
