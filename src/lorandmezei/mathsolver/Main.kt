package lorandmezei.mathsolver

import org.junit.Test
import kotlin.test.assertEquals

// Sources: https://www.techiedelight.com/add-new-element-array-kotlin/

fun main()
{
    /**
     *
     * // build a tree for the following expressions
     * // 5 + 3 - 4; 5*4 + 3; 5 + 4 * 3; 5 * 6 / 10;
     *
     * // more complicated ones: 3 * 2 - 4 * 5 / 3 ;    10 + 30 / 5 * 6 - 19 * 2 / 4
     *
     */

    // Create expression from user input---------------------------------------
    var input: String = "1^2*3/4+5-6" // readLine()!!

    var expression: Array<String> = parseInput(input)
    //-------------------------------------------------------------------------

    // Build the expression tree. Pass the expression (a character array), and the Tree object
    // to create it in.
    var tb = TreeBuilder()
    var t = Tree()
    tb.startBuildTree(expression, t)

    var v: IVisitor = CalculateVisitor()
    println("Calculated value: " + t.traverse(v))
}

fun parseInput(input: String): Array<String>
{
    var chars: CharArray = input.toCharArray()

    var inputArray: Array<String> = arrayOf()
    var list: MutableList<String> = inputArray.toMutableList()

    // Take out multiple digits.
    for (i in chars)
    {
        list.add(i.toString())
    }

    var expression: Array<String> = list.toTypedArray()

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
