package lorandmezei.mathsolver.tests

import org.junit.Test
import kotlin.test.*

import lorandmezei.mathsolver.ExpressionTreeBuilder

class test_ExpressionTreeBuilder
{
    val etb = ExpressionTreeBuilder()

    @Test
    fun findRootIndexTestExpressionEmpty()
    {
        // Empty expression.
        assertEquals(-1, etb.findRootIndex(arrayOf()))
    }
    @Test
    fun findRootIndexTestExpressionSingleDigitIncreasingPriority()
    {
        // 1^2*3/4+5-6
        // Initial expression.
        assertEquals(9, etb.findRootIndex(arrayOf("1","^","2","*","3","/","4","+","5","-","6")))
        //                                                                                     #

        // Going left of root string (#).
        assertEquals(7, etb.findRootIndex(arrayOf("1","^","2","*","3","/","4","+","5")))
        //                                                                             #
        assertEquals(5, etb.findRootIndex(arrayOf("1","^","2","*","3","/","4")))
        //                                                                     #
        assertEquals(3, etb.findRootIndex(arrayOf("1","^","2","*","3")))
        //                                                             #
        assertEquals(1, etb.findRootIndex(arrayOf("1","^","2")))
        //                                                     #
        assertEquals(0, etb.findRootIndex(arrayOf("1")))
        //                                                 #

        // Going right of root string.
        assertEquals(0, etb.findRootIndex(arrayOf("6")))
        //                                                 #
    }
    @Test
    fun findRootIndexTestExpressionSingleDigitDecreasingPriority()
    {
        // 1-2+3/4*5^6
        // Initial expression.
        assertEquals(3, etb.findRootIndex(arrayOf("1","-","2","+","3","/","4","*","5","^","6")))
        //                                                             #

        // Going left of root string (#).
        assertEquals(1, etb.findRootIndex(arrayOf("1","-","2")))
        //                                                     #
        assertEquals(0, etb.findRootIndex(arrayOf("1")))
        //                                                 #

        // Going right of root string.
        assertEquals(3, etb.findRootIndex(arrayOf("3","/","4","*","5","^","6")))
        //                                                             #
        assertEquals(1, etb.findRootIndex(arrayOf("5","^","6")))
        //                                                     #
        assertEquals(0, etb.findRootIndex(arrayOf("6")))
        //                                                 #
    }

    @Test
    fun hasPriorityCurrentStringDigit()
    {
        // Test current string is digit.
        assertFalse(etb.hasPriority("9", "^"))
        assertFalse(etb.hasPriority("9", "*"))
        assertFalse(etb.hasPriority("9", "/"))
        assertFalse(etb.hasPriority("9", "+"))
        assertFalse(etb.hasPriority("9", "-"))
        assertFalse(etb.hasPriority("9", "9"))
    }
    @Test
    fun hasPriorityCurrentStringExponent()
    {
        // Test current string is exponent.
        assertFalse(etb.hasPriority("^", "^"))
        assertTrue(etb.hasPriority("^", "*"))
        assertTrue(etb.hasPriority("^", "/"))
        assertTrue(etb.hasPriority("^", "+"))
        assertTrue(etb.hasPriority("^", "-"))
        assertTrue(etb.hasPriority("^", "9"))
    }
    @Test
    fun hasPriorityCurrentStringMultiplication()
    {
        // Test current string is multiplication.
        assertFalse(etb.hasPriority("*", "^"))
        assertFalse(etb.hasPriority("*", "*"))
        assertFalse(etb.hasPriority("*", "/"))
        assertTrue(etb.hasPriority("*", "+"))
        assertTrue(etb.hasPriority("*", "-"))
        assertTrue(etb.hasPriority("*", "9"))
    }
    @Test
    fun hasPriorityCurrentStringDivision()
    {
        // Test current string is division.
        assertFalse(etb.hasPriority("/", "^"))
        assertFalse(etb.hasPriority("/", "*"))
        assertFalse(etb.hasPriority("/", "/"))
        assertTrue(etb.hasPriority("/", "+"))
        assertTrue(etb.hasPriority("/", "-"))
        assertTrue(etb.hasPriority("/", "9"))
    }
    @Test
    fun hasPriorityCurrentStringAddition()
    {
        // Test current string is addition.
        assertFalse(etb.hasPriority("+", "^"))
        assertFalse(etb.hasPriority("+", "*"))
        assertFalse(etb.hasPriority("+", "/"))
        assertFalse(etb.hasPriority("+", "+"))
        assertFalse(etb.hasPriority("+", "-"))
        assertTrue(etb.hasPriority("+", "9"))
    }
    @Test
    fun hasPriorityCurrentStringSubtraction()
    {
        // Test current string is subtraction.
        assertFalse(etb.hasPriority("-", "^"))
        assertFalse(etb.hasPriority("-", "*"))
        assertFalse(etb.hasPriority("-", "/"))
        assertFalse(etb.hasPriority("-", "+"))
        assertFalse(etb.hasPriority("-", "-"))
        assertTrue(etb.hasPriority("-", "9"))
    }
}