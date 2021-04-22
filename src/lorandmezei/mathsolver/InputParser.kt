package lorandmezei.mathsolver

class InputParser
{
    /**
     * Turn a String into an Array<String> with proper digits parsing.
     */
    fun toStringArray(input: String): Array<String>
    {
        // If the input String is empty, return an empty Array<String>.
        if (input.isEmpty())
        {
            println("Empty expression --toStringArray")
            return arrayOf()
        }

        // Turn the input String into a char array.
        val chars: CharArray = input.toCharArray()
        // Create an empty array of strings.
        val inputArray: Array<String> = arrayOf()
        // Turn the empty array of strings into a list to be able to keep adding elements to it.
        val list: MutableList<String> = inputArray.toMutableList()

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

        // Turn the list back into an array.
        val expression: Array<String> = list.toTypedArray()

        // Return an array of strings.
        return expression
    }

    /**
     * Check if the expression is a valid mathematical expression.
     */
    fun isValid(expression: Array<String>): Boolean
    {
        // Check if expression is empty.
        if (expression.isEmpty())
        {
            print("Empty expression --isValid")
            return false
        }

        // Assume the expression is valid by default.
        var valid: Boolean = true

        return valid
    }
}

