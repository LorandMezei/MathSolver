package lorandmezei.mathsolver

import lorandmezei.mathsolver.dataStructures.ExpressionTree
import lorandmezei.mathsolver.dataStructures.Node

class ExpressionTreeBuilder
{
    /**
     * This function should only take in a valid mathematical expression.
     */
    fun startBuildTree(expression: Array<String>): ExpressionTree
    {
        // Create an empty expression tree.
        val tree = ExpressionTree()

        // Find the index in the expression array that is the root value of the current expression.
        var rootIndex = findRootIndex(expression)

        // Create a new node that will be the root node of the tree.
        var rootNode = Node()

        // Set the content of the root node to be the root value found in the expression array.
        rootNode.content = expression[rootIndex]

        // Set the Tree's root node to be the node that was created.
        tree.rootNode = rootNode

        // Call the recursive build tree method on the left child of the tree's root, with the subexpression passed
        // (this subexpression is every value in the expression array that is to the left of the root value).
        rootNode.leftNode = buildTree(expression.copyOfRange(0, rootIndex))

        // Call the recursive build tree method on the right child of the tree's root, with the subexpression passed
        // (this subexpression is every value in the expression array that is to the right of the root value).
        rootNode.rightNode = buildTree(expression.copyOfRange(rootIndex + 1, expression.size))

        // Return the expression tree.
        return tree
    }

    /**
     *
     */
    fun buildTree(expression: Array<String>): Node
    {
        // Base case: If the length of the expression array is 1, that means that it is a leaf node,
        // and it stores only an integer.
        if (expression.size == 1)
        {
            var currentNode = Node()
            currentNode.content = expression[0]

            return currentNode
        }

        if (expression.size == 0)
        {
            println("empty expression -- buildTree")
        }

        // Find the index in the expression array that is the root value of the current expression.
        var rootIndex = findRootIndex(expression)

        // Create a new node that will be the current node.
        var currentNode = Node()

        // Set the content of the current node to be the root value found in the expression array.
        currentNode.content = expression[rootIndex]

        // Call the recursive build tree method on the left child of the tree's root, with the subexpression passed
        // (this subexpression is every value in the expression array that is to the left of the root value).
        currentNode.leftNode = buildTree(expression.copyOfRange(0, rootIndex))

        // Call the recursive build tree method on the left right of the tree's root, with the subexpression passed
        // (this subexpression is every value in the expression array that is to the right of the root value).
        currentNode.rightNode = buildTree(expression.copyOfRange(rootIndex + 1, expression.size))

        return currentNode
    }

    /**
     * Given a string array, find the index of the root.
     * The string that will be the root is the last (rightmost) string in the array with the lowest priority.
     *
     * @param expression
     * @return index of the root in string array
     */
    fun findRootIndex(expression: Array<String>): Int
    {
        // If expression string array is empty, return -1.
        if (expression.isEmpty())
            return -1

        // Set the initial root index to 0.
        var rootIndex = 0

        // Iterate through each string in the expression.
        for (currentIndex in expression.indices)
        {
            val currentString: String = expression[currentIndex]
            val rootString: String = expression[rootIndex]

            // If the current string is an operator and the root string is an operator.
            if (isOperator(currentString) && isOperator(rootString))
            {
                // If current string (operator) being looked at does NOT HAVE priority over root string (operator):
                if (!hasPriority(currentString, rootString))
                {
                    // set rootIndex to index of current string.
                    rootIndex = currentIndex
                }
            }

            // If the current string is an operator and the root string is an operand.
            else if (isOperator(currentString) && !isOperator(rootString))
            {
                // If current string (operator) being looked at HAS priority over root string (operand):
                if (hasPriority(currentString, rootString))
                {
                    // set rootIndex to index of current string.
                    rootIndex = currentIndex
                }
            }

            // If the current string is an operand and the root string is an operand.
            else if (!isOperator(currentString) && !isOperator(rootString))
            {
                // If current string (operand) being looked at does not have priority over root string (operand):
                if (!hasPriority(currentString, rootString))
                {
                    // set rootIndex to index of current string.
                    rootIndex = currentIndex
                }
            }

            // If the current string is an operand and the root string is an operator.
            else if (!isOperator(currentString) && isOperator(rootString))
            {
                // If current string (operand) being looked at does HAS priority over root string (operator):
                if (hasPriority(currentString, rootString))
                {
                    // set rootIndex to index of current string.
                    rootIndex = currentIndex
                }
            }
        }

        // Return root index.
        return rootIndex
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
     * Returns the priority level of a String operator. Larger number means higher priority.
     */
    fun getPriority(currentString: String): Int
    {
        // PEMDAS priority.
        var priority1 = arrayOf("+", "-") // lowest priority
        var priority2 = arrayOf("*", "/")
        var priority3 = arrayOf("^") // highest priority

        // Determine the priority level of the current string.
        var currentStringPriority: Int = -1;

        if (priority1.contains(currentString))
            currentStringPriority = 1

        else if (priority2.contains(currentString))
            currentStringPriority = 2

        else if (priority3.contains(currentString))
            currentStringPriority = 3

        // Return the priority of the string.
        return currentStringPriority
    }

    /**
     * If current string (operator) is greater priority than the root string (operator), return true;
     *
     * If current string is less or same priority than the root string, return false;
     *
     * @param rootString
     * @param currentString
     * @return
     */
    fun hasPriority(currentString: String, rootString: String): Boolean
    {
        // Determine the priority level of the current string.
        var currentStringPriority: Int = getPriority(currentString)

        // Determine the priority level of the root string.
        var rootStringPriority: Int = getPriority(rootString)

        // Determine if current string has priority over root string.
        return currentStringPriority > rootStringPriority
    }
}

// Sources:
// http://www.openbookproject.net/books/pythonds/Trees/ParseTree.html
// https://www.codinghelmet.com/exercises/expression-evaluator