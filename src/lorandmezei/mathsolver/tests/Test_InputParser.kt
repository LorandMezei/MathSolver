package lorandmezei.mathsolver.tests

import org.junit.Test
import kotlin.test.assertEquals

import lorandmezei.mathsolver.InputParser

class test_InputParser
{
    val ip = InputParser()

    @Test
    fun toStringArraySingleDigits()
    {
        // Single digits expression.
        assertEquals(arrayOf("1","^","2","*","3","/","4","+","5","-","6"),
                ip.toStringArray("1^2*3/4+5-6"))
    }
    @Test
    fun toStringArrayMultipleDigits()
    {
        // Single digits expression.
        assertEquals(arrayOf("1","^","22","*","333","/","4444","+","55555","-","666666"),
                ip.toStringArray("1^22*333/4444+55555-666666"))
    }
}