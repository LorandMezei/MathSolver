package lorandmezei.mathsolver

import lorandmezei.mathsolver.dataStructures.*
import java.util.ArrayDeque

class ETBuilder(expression: Array<String>)
{
    val expression: Array<String>
    var expressionTree: ExpressionTree
    var parentStack: ArrayDeque<ExpressionTree>
    var currentTree: ExpressionTree

    // initializer block
    init
    {
        this.expression = expression
        expressionTree = ExpressionTree()
        parentStack = ArrayDeque<ExpressionTree>()
        parentStack.push(ExpressionTree())
        currentTree = expressionTree
    }

    fun build()
    {
        for (token in expression)
        {
            if (token.equals("("))
            {

            }

        }
    }
}