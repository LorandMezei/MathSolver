package lorandmezei.mathsolver

import lorandmezei.mathsolver.visitors.CalculateVisitor
import lorandmezei.mathsolver.visitors.IVisitor

fun main()
{
    println("Enter expression")
    val input = readLine()!!

    val inputParser = InputParser()
    val expression: Array<String> = inputParser.parseInput(input)

    val expressionTreeBuilder = ExpressionTreeBuilder()
    val expressionTree = expressionTreeBuilder.startBuildTree(expression)

    val v: IVisitor = CalculateVisitor()
    println("Calculated value: " + expressionTree.traverse(v))
}

// Sources:
// https://www.techiedelight.com/add-new-element-array-kotlin/