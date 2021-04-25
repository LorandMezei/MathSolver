package lorandmezei.mathsolver.deprecated

import lorandmezei.mathsolver.dataStructures.*
import java.util.ArrayDeque

class ExpressionTreeBuilderIterative(expression: Array<String>)
{
    val expression: Array<String>
    var expressionTree: ExpressionTree
    var parentStack: ArrayDeque<ExpressionTree>
    var currentExpressionTree: ExpressionTree

    // initializer block
    init
    {
        this.expression = expression
        expressionTree = ExpressionTree()
        parentStack = ArrayDeque<ExpressionTree>()
        parentStack.push(expressionTree)
        currentExpressionTree = expressionTree
    }

    fun build(): ExpressionTree
    {
        for (token in expression)
        {
            if (isLeftParenthesis(token))
            {
                currentExpressionTree.leftExpressionTree = ExpressionTree()
                parentStack.push(currentExpressionTree)
                currentExpressionTree = currentExpressionTree.leftExpressionTree!!
            }

            else if (isOperator(token))
            {
                currentExpressionTree.content = token
                currentExpressionTree.rightExpressionTree = ExpressionTree()
                parentStack.push(currentExpressionTree)
                currentExpressionTree = currentExpressionTree.rightExpressionTree!!
            }

            else if (isOperand(token))
            {
                currentExpressionTree.content = token
                var parent = parentStack.pop()
                currentExpressionTree = parent
            }

            else if (isRightParenthesis(token))
            {
                currentExpressionTree = parentStack.pop()
            }
        }

        return expressionTree
    }

    /**
     * Checks whether a given string is an operator.
     * Returns true if operator, false if not an operator.
     */
    fun isOperator(currentString: String): Boolean
    {
        // Operators that a string's characters can be.
        var operators = arrayOf("^", "*", "/", "+", "-")

        return operators.contains(currentString)
    }

    /**
     *
     */
    fun isOperand(currentString: String): Boolean
    {
        // Operators that a string's characters can be.
        var operators = arrayOf("^", "*", "/", "+", "-")

        return !operators.contains(currentString)
    }

    /**
     *
     */
    fun isLeftParenthesis(currentString: String): Boolean
    {
        return currentString.equals("(")
    }

    /**
     *
     */
    fun isRightParenthesis(currentString: String): Boolean
    {
        return currentString.equals(")")
    }
}

/* Sources:
http://www.openbookproject.net/books/pythonds/Trees/ParseTree.html
 */