package lorandmezei.mathsolver.deprecated

import lorandmezei.mathsolver.dataStructures.*
import java.util.ArrayDeque

class ExpressionTreeBuilderIterative(expression: Array<String>)
{
    val expression: Array<String>
    var expressionTree: ExpressionTree
    var parentStack: ArrayDeque<ExpressionTree>
    var currentExpressionTree: ExpressionTree

    init
    {
        // Initialize the expression.
        this.expression = expression
        // Create an empty expression tree.
        expressionTree = ExpressionTree()
        // Create an empty Stack to keep track of the parent of the current node.
        parentStack = ArrayDeque<ExpressionTree>()
        // Push the empty expression tree onto the stack
        parentStack.push(expressionTree)
        // Initialize the current expression tree to the empty array.
        currentExpressionTree = expressionTree
    }

    fun build(): ExpressionTree
    {
        for (token in expression)
        {
            if (isLeftParenthesis(token))
            {
                // Add a new node as the left child of the current node, and descend to the left child.
                currentExpressionTree.leftExpressionTree = ExpressionTree()
                parentStack.push(currentExpressionTree)
                currentExpressionTree = currentExpressionTree.leftExpressionTree!!
            }

            else if (isOperator(token))
            {
                /*
                Set the root value of the current node to the operator represented by the current token.
                Add a new node as the right child of the current node and descend to the right child.
                 */
                currentExpressionTree.root = token
                currentExpressionTree.rightExpressionTree = ExpressionTree()
                parentStack.push(currentExpressionTree)
                currentExpressionTree = currentExpressionTree.rightExpressionTree!!
            }

            else if (isOperand(token))
            {
                // Set the root value of the current node to the number and return to the parent.
                currentExpressionTree.root = token
                var parent = parentStack.pop()
                currentExpressionTree = parent
            }

            else if (isRightParenthesis(token))
            {
                // Go to the parent of the current node.
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
        var notOperators = arrayOf("^", "*", "/", "+", "-", "(", ")")

        return !notOperators.contains(currentString)
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

    fun fullyParenthesize(expression: Array<String>)
    {

    }
}

/* Sources:
http://www.openbookproject.net/books/pythonds/Trees/ParseTree.html
 */