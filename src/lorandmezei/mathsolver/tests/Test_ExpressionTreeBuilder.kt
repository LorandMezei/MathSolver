package lorandmezei.mathsolver.tests

import org.junit.Test
import kotlin.test.*

class test_ExpressionTreeBuilder
{
    /*
    @Test
    fun findRootIndexTestExpressionEmpty()
    {
        // Empty expression.
        assertEquals(-1, findRootIndex(arrayOf()))
    }
    @Test
    fun findRootIndexTestExpressionSingleDigitIncreasingPriority()
    {
        // 1^2*3/4+5-6
        // Initial expression.
        assertEquals(9, findRootIndex(arrayOf("1","^","2","*","3","/","4","+","5","-","6")))
        //                                                                                     #

        // Going left of root string (#).
        assertEquals(7, findRootIndex(arrayOf("1","^","2","*","3","/","4","+","5")))
        //                                                                             #
        assertEquals(5, findRootIndex(arrayOf("1","^","2","*","3","/","4")))
        //                                                                     #
        assertEquals(3, findRootIndex(arrayOf("1","^","2","*","3")))
        //                                                             #
        assertEquals(1, findRootIndex(arrayOf("1","^","2")))
        //                                                     #
        assertEquals(0, findRootIndex(arrayOf("1")))
        //                                                 #

        // Going right of root string.
        assertEquals(0, findRootIndex(arrayOf("6")))
        //                                                 #
    }
    @Test
    fun findRootIndexTestExpressionSingleDigitDecreasingPriority()
    {
        // 1-2+3/4*5^6
        // Initial expression.
        assertEquals(3, findRootIndex(arrayOf("1","-","2","+","3","/","4","*","5","^","6")))
        //                                                             #

        // Going left of root string (#).
        assertEquals(1, findRootIndex(arrayOf("1","-","2")))
        //                                                     #
        assertEquals(0, findRootIndex(arrayOf("1")))
        //                                                 #

        // Going right of root string.
        assertEquals(3, findRootIndex(arrayOf("3","/","4","*","5","^","6")))
        //                                                             #
        assertEquals(1, findRootIndex(arrayOf("5","^","6")))
        //                                                     #
        assertEquals(0, findRootIndex(arrayOf("6")))
        //                                                 #
    }

    @Test
    fun checkOperatorPriorityCurrentStringDigit()
    {
        // Test current string is exponent.
        assertFalse(checkOperatorPriority("9", "^"))
        assertFalse(checkOperatorPriority("9", "*"))
        assertFalse(checkOperatorPriority("9", "/"))
        assertFalse(checkOperatorPriority("9", "+"))
        assertFalse(checkOperatorPriority("9", "-"))
        assertFalse(checkOperatorPriority("9", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringExponent()
    {
        // Test current string is exponent.
        assertFalse(checkOperatorPriority("^", "^"))
        assertTrue(checkOperatorPriority("^", "*"))
        assertTrue(checkOperatorPriority("^", "/"))
        assertTrue(checkOperatorPriority("^", "+"))
        assertTrue(checkOperatorPriority("^", "-"))
        assertTrue(checkOperatorPriority("^", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringMultiplication()
    {
        // Test current string is multiplication.
        assertFalse(checkOperatorPriority("*", "^"))
        assertFalse(checkOperatorPriority("*", "*"))
        assertFalse(checkOperatorPriority("*", "/"))
        assertTrue(checkOperatorPriority("*", "+"))
        assertTrue(checkOperatorPriority("*", "-"))
        assertTrue(checkOperatorPriority("*", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringDivision()
    {
        // Test current string is multiplication.
        assertFalse(checkOperatorPriority("/", "^"))
        assertFalse(checkOperatorPriority("/", "*"))
        assertFalse(checkOperatorPriority("/", "/"))
        assertTrue(checkOperatorPriority("/", "+"))
        assertTrue(checkOperatorPriority("/", "-"))
        assertTrue(checkOperatorPriority("/", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringAddition()
    {
        // Test current string is multiplication.
        assertFalse(checkOperatorPriority("+", "^"))
        assertFalse(checkOperatorPriority("+", "*"))
        assertFalse(checkOperatorPriority("+", "/"))
        assertFalse(checkOperatorPriority("+", "+"))
        assertFalse(checkOperatorPriority("+", "-"))
        assertTrue(checkOperatorPriority("+", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringSubtraction()
    {
        // Test current string is multiplication.
        assertFalse(checkOperatorPriority("-", "^"))
        assertFalse(checkOperatorPriority("-", "*"))
        assertFalse(checkOperatorPriority("-", "/"))
        assertFalse(checkOperatorPriority("-", "+"))
        assertFalse(checkOperatorPriority("-", "-"))
        assertTrue(checkOperatorPriority("-", "9"))
    }
    */
}