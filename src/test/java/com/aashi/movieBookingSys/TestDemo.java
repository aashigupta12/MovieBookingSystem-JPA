package com.aashi.movieBookingSys;

import org.junit.jupiter.api.*;

/**
 * This class will be used to demo the unit testing
 * JUnit framework functionality
 *
 * 1) @Test
 * 2) @BeforeEach
 *
 * */
public class TestDemo {

    /**
     * before running any test, we do some preparation
     * */
    @BeforeEach
    public void beforeEachTestMethod(){
        System.out.println("before each test");
    }


    /**
     * whenever we use @Test with any method, it becomes executable & test method
     * */
    @Test //to indicate that the method is a test method
    public void myFirstTest(){
        System.out.println("Inside the first test");
    }

    @Test
    public void mySecondTest(){
        System.out.println("Inside the second test");
    }

    /**
     * I want to execute something after every test is executed
     * */
    @AfterEach
    public void afterEachTestMethod(){
        System.out.println("after each test");
    }

    /**
     * I want to execute only once in the beginning
     * */
    @BeforeAll
    public static void veryBeginning(){
        System.out.println("In the very beginning!!");
    }

    @AfterAll
    public static void lastMethod(){
        System.out.println("At the very last!!");
    }


    /**
     * very beginning of test for once only
     * @BeforeAll
     *
     * Order to execution
     * @BeforeEach
     * @Test
     * @AfterEach
     *
     * at the very last after all test has been done
     * @AfterAll
     * */

}
