package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// @DisplayNameGeneration(DisplayNameGenerator.Simple.class)
// @DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
// @TestMethodOrder(MethodOrderer.MethodName.class)
// @TestMethodOrder(MethodOrderer.DisplayName.class)
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.Random.class)
class DemoUtilsTest {

    DemoUtils demoUtils;
    List<String> theList;

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
        theList = List.of("luv", "2", "code");

        System.out.println("@BeforeEach executes before the execution of each test method");
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @BeforeEach");
        System.out.println();
    }

    @Test
    @DisplayName("Test Equals and Not Equals")
    // @Order(1)
    void testEqualsAndNotEquals() {
        System.out.println("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4), "2 + 4 should be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1 + 9 should not be 6");
    }

    @Test
    @DisplayName("Test Null and Not Null")
    // @Order(0) // Lowest number first
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
    // @Order(30)
    void testTrueAndFalse() {
        System.out.println("Running test: testTrueAndFalse");

        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @Test
    @DisplayName("Test Array Equals")
    void testArrayEquals() {
        System.out.println("Running test: testArrayEquals");

        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }

    @Test
    @DisplayName("Test Iterable Equals")
    void testIterableEquals() {
        System.out.println("Running test: testIterableEquals");

        assertIterableEquals(theList, demoUtils.getAcademyInList(), "Excepted list should be same as actual list");
    }

    @Test
    @DisplayName("Test Lines Match")
    // @Order(50)
    void testLinesMatch() {
        System.out.println("Running test: testLinesMatch");

        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }

    @Test
    @DisplayName("Test Throws and Does Not Throw")
    void testThrowsAndDoesNotThrow() {
        System.out.println("Running test: testThrowsAndDoesNotThrow");

        assertThrows(Exception.class, () -> { demoUtils.throwException(-1); }, "Should throw exception");
        assertDoesNotThrow(() -> { demoUtils.throwException(9); }, "Should not throw exception");
    }

    @Test
    @DisplayName("Test Timeout")
    void testTimeout() {
        System.out.println("Running test: testTimeout");

        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout(); }, "Method should execute in 3 seconds");
    }
}
