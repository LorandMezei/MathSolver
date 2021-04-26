package lorandmezei.mathsolver.visitors

import lorandmezei.mathsolver.dataStructures.ExpressionTree

class PrefixPrintVisitor : IVisitor
{
    override fun visit(expressionTree: ExpressionTree): Any?
    {
        // Base case I think.
        if (expressionTree == null)
        {
            return null
        }

        // If the current node is an operator.
        if (expressionTree.leftExpressionTree != null && expressionTree.rightExpressionTree != null)
        {
            when(expressionTree.root)
            {
                "^" -> println("exp ")
                "*" -> println("mul ")
                "/" -> println("div ")
                "+" -> println("add ")
                "-" -> println("sub ")
            }

            // Recursion.
            expressionTree.leftExpressionTree!!.accept(this)
            expressionTree.rightExpressionTree!!.accept(this)
        }

        else
        {
            println(expressionTree.root)
        }

        return ""
    }
}