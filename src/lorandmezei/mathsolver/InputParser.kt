package lorandmezei.mathsolver

import org.junit.Test
import kotlin.test.*

class InputParser
{
    // Turn a String into an Array<String> with proper digits parsing.
    fun parseInput(input: String): Array<String>
    {
        val chars: CharArray = input.toCharArray()

        val inputArray: Array<String> = arrayOf()
        val list: MutableList<String> = inputArray.toMutableList()

        //----------------------------
        // Iterate through each character in array.
        var index1 = 0
        var index2 = 0
        while (index1 < chars.size)
        {
            // String that will take on the value of a operator or digit(s).
            var stringToAdd = ""

            // If the current character in array is NOT a digit (is an operator):
            if (!chars[index1].isDigit())
            {
                // Make that operator to a string.
                stringToAdd += chars[index1]
                index1++
            }

            // If the current character in array IS a digit:
            else if (chars[index1].isDigit())
            {
                index2 = index1

                // While there are adjacent digits:
                while(chars[index2].isDigit() && index2 < chars.size)
                {
                    // Concatenate the digits together into a single string.
                    stringToAdd += chars[index2]
                    index2++

                    // Make sure index2 doesn't read from outside of array bounds.
                    if (index2 >= chars.size)
                    {
                        break
                    }
                }

                index1 = index2
            }

            // Add the string to the list.
            list.add(stringToAdd)
        }
        //----------------------------

        val expression: Array<String> = list.toTypedArray()

        return expression
    }
}

