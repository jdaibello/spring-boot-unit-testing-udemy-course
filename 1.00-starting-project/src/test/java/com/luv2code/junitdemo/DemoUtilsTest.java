package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// @DisplayNameGeneration(DisplayNameGenerator.Simple.class)
// @DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
        System.out.println();
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only all before all test methods execution in the class");
    }

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each test method");
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @BeforeEach");
        System.out.println();
    }

    @Test
    @DisplayName("Test Equals and Not Equals")
    void testEqualsAndNotEquals() {
        System.out.println("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1 + 9 must not be 6");
    }

    @Test
    @DisplayName("Test Null and Not Null")
    void testNullAndNotNull() {
        System.out.println("Running test: testNullAndNotNull");

        String str1 = null;
        String str2 = "Hello";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    @DisplayName("Test Same and Not Same")
    void testSameAndNotSame() {
        System.out.println("Running test: testSameAndNotSame");

        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @Test
    @DisplayName("Test True and False")
    void testTrueAndFalse() {
        System.out.println("Running test: testTrueAndFalse");

        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }
}
