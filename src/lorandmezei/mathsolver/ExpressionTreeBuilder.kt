package lorandmezei.mathsolver

import org.junit.Test
import kotlin.test.*

class ExpressionTreeBuilder
{
    fun startBuildTree(expression: Array<String>, tree: ExpressionTree)
    {
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
    }

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
            println("empty expression")
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

        // Operators that a string's characters can be.
        var operators = arrayOf("^", "*", "/", "+", "-")

        // Set the initial root index to 0.
        var rootIndex = 0

        // Iterate through each string in the expression.
        for (currentIndex in expression.indices)
        {
            // If the current string is an operator and the root string is an operator.
            if (operators.contains(expression[currentIndex]) && operators.contains(expression[rootIndex]))
            {
                val currentString: String = expression[currentIndex]
                val rootString: String = expression[rootIndex]

                // If current string (operator) being looked at does NOT HAVE priority over root string (operator):
                if (!checkOperatorPriority(currentString, rootString))
                {
                    // set rootIndex to index of current string.
                    rootIndex = currentIndex
                }
            }
            // If the current string is an operator and the root string is an operand.
            else if (operators.contains(expression[currentIndex]) && !operators.contains(expression[rootIndex]))
            {
                val currentString: String = expression[currentIndex]
                val rootString: String = expression[rootIndex]

                // If current string (operator) being looked at HAS priority over root string (operand):
                if (checkOperatorPriority(currentString, rootString))
                {
                    // set rootIndex to index of current string.
                    rootIndex = currentIndex
                }
            }
            // If the current string is an operand and the root string is an operand.
            else if (!operators.contains(expression[currentIndex]) && !operators.contains(expression[rootIndex]))
            {
                val currentString: String = expression[currentIndex]
                val rootString: String = expression[rootIndex]

                // If current string (operand) being looked at does not have priority over root string (operand):
                if (!checkOperatorPriority(currentString, rootString))
                {
                    // set rootIndex to index of current string.
                    rootIndex = currentIndex
                }
            }
            // If the current string is an operand and the root string is an operator.
            else if (!operators.contains(expression[currentIndex]) && operators.contains(expression[rootIndex]))
            {
                val currentString: String = expression[currentIndex]
                val rootString: String = expression[rootIndex]

                // If current string (operand) being looked at does HAS priority over root string (operator):
                if (checkOperatorPriority(currentString, rootString))
                {
                    // set rootIndex to index of current string.
                    rootIndex = currentIndex
                }
            }
        }

        return rootIndex
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
    fun checkOperatorPriority(currentString: String, rootString: String): Boolean
    {
        //--------------------------------------------------------------------------------
        // PEMDAS priority.
        var priority3 = arrayOf("^") // highest priority
        var priority2 = arrayOf("*", "/")
        var priority1 = arrayOf("+", "-") // lowest priority
        //--------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------
        // Determine the priority level of the current string.
        var currentStringPriority: Int = -1;

        if (priority1.contains(currentString))
            currentStringPriority = 1

        else if (priority2.contains(currentString))
            currentStringPriority = 2

        else if (priority3.contains(currentString))
            currentStringPriority = 3
        //--------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------
        // Determine the priority level of the root string.
        var rootStringPriority: Int = -1;

        if (priority1.contains(rootString))
            rootStringPriority = 1

        else if (priority2.contains(rootString))
            rootStringPriority = 2

        else if (priority3.contains(rootString))
            rootStringPriority = 3
        //--------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------
        // Determine if current string has priority over root string.
        var hasPriority = false

        // Current string has higher priority than root string.
        if (currentStringPriority > rootStringPriority)
            hasPriority = true;

        // Current string has lower priority than root string.
        else if (currentStringPriority < rootStringPriority)
            hasPriority = false;

        // Current string has same priority than root string.
        else if (currentStringPriority == rootStringPriority)
            hasPriority = false;
        //--------------------------------------------------------------------------------

        return hasPriority
    }

    //#####################################################################
    @Test
    fun findRootIndexTestExpressionEmpty()
    {
        // Empty expression.
        assertEquals(-1, findRootIndex(arrayOf()))
    }
    @Test
    fun findRootIndexTestExpressionSingleDigitIncreasingPriority()
    {
        // 1^2*3/4+5-6
        // Initial expression.
        assertEquals(9, findRootIndex(arrayOf("1","^","2","*","3","/","4","+","5","-","6")))
        //                                                                                     #

        // Going left of root string (#).
        assertEquals(7, findRootIndex(arrayOf("1","^","2","*","3","/","4","+","5")))
        //                                                                             #
        assertEquals(5, findRootIndex(arrayOf("1","^","2","*","3","/","4")))
        //                                                                     #
        assertEquals(3, findRootIndex(arrayOf("1","^","2","*","3")))
        //                                                             #
        assertEquals(1, findRootIndex(arrayOf("1","^","2")))
        //                                                     #
        assertEquals(0, findRootIndex(arrayOf("1")))
        //                                                 #

        // Going right of root string.
        assertEquals(0, findRootIndex(arrayOf("6")))
        //                                                 #
    }
    @Test
    fun findRootIndexTestExpressionSingleDigitDecreasingPriority()
    {
        // 1-2+3/4*5^6
        // Initial expression.
        assertEquals(3, findRootIndex(arrayOf("1","-","2","+","3","/","4","*","5","^","6")))
        //                                                             #

        // Going left of root string (#).
        assertEquals(1, findRootIndex(arrayOf("1","-","2")))
        //                                                     #
        assertEquals(0, findRootIndex(arrayOf("1")))
        //                                                 #

        // Going right of root string.
        assertEquals(3, findRootIndex(arrayOf("3","/","4","*","5","^","6")))
        //                                                             #
        assertEquals(1, findRootIndex(arrayOf("5","^","6")))
        //                                                     #
        assertEquals(0, findRootIndex(arrayOf("6")))
        //                                                 #
    }
    //#####################################################################

    //#####################################################################
    @Test
    fun checkOperatorPriorityCurrentStringDigit()
    {
        // Test current string is exponent.
        assertFalse(checkOperatorPriority("9", "^"))
        assertFalse(checkOperatorPriority("9", "*"))
        assertFalse(checkOperatorPriority("9", "/"))
        assertFalse(checkOperatorPriority("9", "+"))
        assertFalse(checkOperatorPriority("9", "-"))
        assertFalse(checkOperatorPriority("9", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringExponent()
    {
        // Test current string is exponent.
        assertFalse(checkOperatorPriority("^", "^"))
        assertTrue(checkOperatorPriority("^", "*"))
        assertTrue(checkOperatorPriority("^", "/"))
        assertTrue(checkOperatorPriority("^", "+"))
        assertTrue(checkOperatorPriority("^", "-"))
        assertTrue(checkOperatorPriority("^", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringMultiplication()
    {
        // Test current string is multiplication.
        assertFalse(checkOperatorPriority("*", "^"))
        assertFalse(checkOperatorPriority("*", "*"))
        assertFalse(checkOperatorPriority("*", "/"))
        assertTrue(checkOperatorPriority("*", "+"))
        assertTrue(checkOperatorPriority("*", "-"))
        assertTrue(checkOperatorPriority("*", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringDivision()
    {
        // Test current string is multiplication.
        assertFalse(checkOperatorPriority("/", "^"))
        assertFalse(checkOperatorPriority("/", "*"))
        assertFalse(checkOperatorPriority("/", "/"))
        assertTrue(checkOperatorPriority("/", "+"))
        assertTrue(checkOperatorPriority("/", "-"))
        assertTrue(checkOperatorPriority("/", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringAddition()
    {
        // Test current string is multiplication.
        assertFalse(checkOperatorPriority("+", "^"))
        assertFalse(checkOperatorPriority("+", "*"))
        assertFalse(checkOperatorPriority("+", "/"))
        assertFalse(checkOperatorPriority("+", "+"))
        assertFalse(checkOperatorPriority("+", "-"))
        assertTrue(checkOperatorPriority("+", "9"))
    }
    @Test
    fun checkOperatorPriorityCurrentStringSubtraction()
    {
        // Test current string is multiplication.
        assertFalse(checkOperatorPriority("-", "^"))
        assertFalse(checkOperatorPriority("-", "*"))
        assertFalse(checkOperatorPriority("-", "/"))
        assertFalse(checkOperatorPriority("-", "+"))
        assertFalse(checkOperatorPriority("-", "-"))
        assertTrue(checkOperatorPriority("-", "9"))
    }
    //#####################################################################
}

// Sources: http://www.openbookproject.net/books/pythonds/Trees/ParseTree.html
//          https://www.codinghelmet.com/exercises/expression-evaluator