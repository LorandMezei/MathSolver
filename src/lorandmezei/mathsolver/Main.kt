package lorandmezei.mathsolver

import org.junit.Test
import kotlin.test.assertEquals

fun main()
{
    val input = "10*10" // readLine()!!

    val expression: Array<String> = parseInput(input)

    var expressionTree = createExpressionTree(expression)

    var v: IVisitor = CalculateVisitor()
    println("Calculated value: " + expressionTree.traverse(v))
}

fun createExpressionTree(expression: Array<String>): ExpressionTree
{
    // Build the expression tree. Pass the expression and the Tree object to create it in.
    val tb = ExpressionTreeBuilder()
    val t = ExpressionTree()
    tb.startBuildTree(expression, t)

    return t
}

// Turn a String into an Array<String>
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
        //println("index1: " + index1)
        //println("index2: " + index2)

        // String that will take on the value of a operator or digit(s).
        var stringToAdd = ""

        // If the current character in array is NOT a digit (is an operator):
        if (!chars[index1].isDigit())
        {
            println("chars[index1]: " + chars[index1])

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
                println("chars[index2]: " + chars[index2])

                // Concatenate the digits together into a single string.
                stringToAdd += chars[index2]
                index2++

                // Make sure index2 doesnt read from outside of array bounds.
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

//#####################################################################
@Test
fun parseInputSingleDigits()
{
    // Single digits expression.
    assertEquals(arrayOf("1","^","2","*","3","/","4","+","5","-","6"), parseInput("1^2*3/4+5-6"))
}
//#####################################################################

// Sources: https://www.techiedelight.com/add-new-element-array-kotlin/