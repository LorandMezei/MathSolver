package lorandmezei.mathsolver

import org.junit.Test
import kotlin.test.assertEquals

// Sources: https://www.techiedelight.com/add-new-element-array-kotlin/

fun main()
{
    var input: String = "2*4" // readLine()!!

    var expression: Array<String> = parseInput(input)

    var expressionTree = createExpressionTree(expression)

    var v: IVisitor = CalculateVisitor()
    println("Calculated value: " + expressionTree.traverse(v))
}

fun createExpressionTree(expression: Array<String>): ExpressionTree
{
    // Build the expression tree. Pass the expression and the Tree object to create it in.
    var tb = ExpressionTreeBuilder()
    var t = ExpressionTree()
    tb.startBuildTree(expression, t)

    return t
}

// Turn a String into an Array<String>
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
