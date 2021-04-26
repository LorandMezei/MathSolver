package lorandmezei.mathsolver

import lorandmezei.mathsolver.deprecated.ExpressionTreeBuilderIterative
import lorandmezei.mathsolver.visitors.*

fun main()
{
    // Get expression from user.
    println("Enter expression")
    val input = "1+2-3*4/5^6"//readLine()!!

    // Parse the input. Turn the String into an Array<String>.
    val inputParser = InputParser()
    val expression: Array<String> = inputParser.toStringArray(input)

    // Make sure the expression is valid before building tree.
    if (inputParser.isValid(expression))
    {
        // Build the expression tree.
        val expressionTreeBuilder = ExpressionTreeBuilder()
        val expressionTree = expressionTreeBuilder.startBuildTree(expression)

        // Calculate the value in the expression tree.
        val v: IVisitor = CalculateVisitor()
        println("Calculated value: " + expressionTree.traverse(v))
    }
}

// Sources:
// https://www.techiedelight.com/add-new-element-array-kotlin/