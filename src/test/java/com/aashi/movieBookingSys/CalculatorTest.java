package com.aashi.movieBookingSys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * J unit framework itself has a class called Assertions
 * ASSERTION is a class which has multiple methods to check how actual is dealing with expected
 * // one of method is assertEquals
 * */
/**
 * Name of test class : <ClassName>Test
 * */
public class CalculatorTest {

    /**
     * test add method
     *
     * Name of the test method:
     * test<MethodName>
     * */

    @Test
    public void testAdd(){
        //expected result: 2,3 -> 5 (2+3 = 5)
        int expectedResult = 5; //pass
//        int expectedResult = 7; //fail


        //actual result
        int actualResult = new Calculator().add(2,3);

        /**
         * if actual is matching with the expected
         *
         * yes -> pass
         * no -> fail
         * */

        //Assert if actual result is matching with the expected result
        //if it is matching, then pass this result, else fail
        Assertions.assertEquals(actualResult,expectedResult);
    }

    /**
     * test subtract method
     * */
    @Test
    public void testSubtract(){
        int expectedVal= 10;

        int actualVal = new Calculator().subtract(20,10);

        Assertions.assertEquals(actualVal,expectedVal);
    }

    /**
     * test multiply method
     * */

    /**
     * test division method
     * */
}
