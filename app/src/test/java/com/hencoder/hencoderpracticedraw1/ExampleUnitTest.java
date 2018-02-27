package com.hencoder.hencoderpracticedraw1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        int[] heightArray = {1, 10, 15, 170, 300, 350, 150};
        float sum = 0;
        for (int i : heightArray) {
            sum += i;
        }
        float[] degreeArray = new float[heightArray.length];
        for (int i = 0; i < degreeArray.length; i++) {
            degreeArray[i] = heightArray[i] / sum * 100;
        }
        System.out.println(Arrays.toString(degreeArray));
    }
}