package lorandmezei.mathsolver.visitors

import lorandmezei.mathsolver.dataStructures.ExpressionTree
import kotlin.math.pow

class CalculateVisitor : IVisitor
{
    // Recursive.
    override fun visit(expressionTree : ExpressionTree) : Any
    {
        // Base case if the node is a leaf node (operand).
        if (expressionTree.leftExpressionTree == null && expressionTree.rightExpressionTree == null)
        {
            // Return the value of the node's content.
            return expressionTree.content.toDouble()
        }

        else
        {
            var answer = 0.0

            val x = expressionTree.leftExpressionTree!!.accept(this).toString().toDouble()
            val y = expressionTree.rightExpressionTree!!.accept(this).toString().toDouble()

            // Choose correct operator based on string's characters.
            val operator = expressionTree.content

            // Switch. Apply the appropriate operation to the nodes' contents.
            when (operator)
            {
                "^" -> answer = x.pow(y)
                "*" -> answer = x * y
                "/" -> answer = x / y
                "+" -> answer = x + y
                "-" -> answer = x - y
            }

            // Return the answer with the operation applied.
            return answer
        }
    }
}