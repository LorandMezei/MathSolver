// Sources: http://www.openbookproject.net/books/pythonds/Trees/ParseTree.html
//          https://www.codinghelmet.com/exercises/expression-evaluator

package lorandmezei.mathsolver

import org.junit.Test
import kotlin.test.*

class TreeBuilder
{
    fun startBuildTree(expression: CharArray, tree: Tree)
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

    fun buildTree(expression: CharArray): Node
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
     * Given a character array, find the index of the root.
     * The character that will be the root is the last (rightmost) character in the array with the lowest priority.
     *
     * @param expression
     * @return index of the root in character array
     */
    fun findRootIndex(expression: CharArray): Int
    {
        // If expression character array is empty, return -1.
        if (expression.isEmpty())
            return -1

        // Operators that a character can be.
        var operators = charArrayOf('^', '*', '/', '+', '-')

        // Set the initial root index to 0.
        var rootIndex = 0

        // Iterate through each character in the expression.
        for (currentIndex in expression.indices)
        {
            // If the current character is an operator and the root character is an operator.
            if (operators.contains(expression[currentIndex]) && operators.contains(expression[rootIndex]))
            {
                val currentChar: Char = expression[currentIndex]
                val rootChar: Char = expression[rootIndex]

                // If current character (operator) being looked at does NOT HAVE priority over root character (operator):
                if (!checkOperatorPriority(currentChar, rootChar))
                {
                    // set rootIndex to index of current character.
                    rootIndex = currentIndex
                }
            }
            // If the current character is an operator and the root character is an operand.
            else if (operators.contains(expression[currentIndex]) && !operators.contains(expression[rootIndex]))
            {
                val currentChar: Char = expression[currentIndex]
                val rootChar: Char = expression[rootIndex]

                // If current character (operator) being looked at HAS priority over root character (operand):
                if (checkOperatorPriority(currentChar, rootChar))
                {
                    // set rootIndex to index of current character.
                    rootIndex = currentIndex
                }
            }
            // If the current character is an operand and the root character is an operand.
            else if (!operators.contains(expression[currentIndex]) && !operators.contains(expression[rootIndex]))
            {
                val currentChar: Char = expression[currentIndex]
                val rootChar: Char = expression[rootIndex]

                // If current character (operand) being looked at does not have priority over root character (operand):
                if (!checkOperatorPriority(currentChar, rootChar))
                {
                    // set rootIndex to index of current character.
                    rootIndex = currentIndex
                }
            }
            // If the current character is an operand and the root character is an operator.
            else if (!operators.contains(expression[currentIndex]) && operators.contains(expression[rootIndex]))
            {
                val currentChar: Char = expression[currentIndex]
                val rootChar: Char = expression[rootIndex]

                // If current character (operand) being looked at does HAS priority over root character (operator):
                if (checkOperatorPriority(currentChar, rootChar))
                {
                    // set rootIndex to index of current character.
                    rootIndex = currentIndex
                }
            }
        }

        return rootIndex
    }

    /**
     * If current char (operator) is greater priority than the root char (operator), return true;
     *
     * If current char is less or same priority than the root char, return false;
     *
     * @param rootChar
     * @param currentChar
     * @return
     */
    fun checkOperatorPriority(currentChar: Char, rootChar: Char): Boolean
    {
        //--------------------------------------------------------------------------------
        // PEMDAS priority.
        var priority3 = charArrayOf('^') // highest priority
        var priority2 = charArrayOf('*', '/')
        var priority1 = charArrayOf('+', '-') // lowest priority
        //--------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------
        // Determine the priority level of the current char.
        var currentCharPriority: Int = -1;

        if (priority1.contains(currentChar))
            currentCharPriority = 1

        else if (priority2.contains(currentChar))
            currentCharPriority = 2

        else if (priority3.contains(currentChar))
            currentCharPriority = 3
        //--------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------
        // Determine the priority level of the root char.
        var rootCharPriority: Int = -1;

        if (priority1.contains(rootChar))
            rootCharPriority = 1

        else if (priority2.contains(rootChar))
            rootCharPriority = 2

        else if (priority3.contains(rootChar))
            rootCharPriority = 3
        //--------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------
        // Determine if current char has priority over root char.
        var hasPriority = false

        // Current char has higher priority than root char.
        if (currentCharPriority > rootCharPriority)
            hasPriority = true;

        // Current char has lower priority than root char.
        else if (currentCharPriority < rootCharPriority)
            hasPriority = false;

        // Current char has same priority than root char.
        else if (currentCharPriority == rootCharPriority)
            hasPriority = false;
        //--------------------------------------------------------------------------------

        return hasPriority
    }

    //#####################################################################
    @Test
    fun findRootIndexTestExpressionEmpty()
    {
        // Empty expression.
        assertEquals(-1, findRootIndex(charArrayOf()))
    }
    @Test
    fun findRootIndexTestExpressionIncreasingPriority()
    {
        // 1^2*3/4+5-6
        // Initial expression.
        assertEquals(9, findRootIndex(charArrayOf('1','^','2','*','3','/','4','+','5','-','6')))
        //                                                                                     #

        // Going left of root char (#).
        assertEquals(7, findRootIndex(charArrayOf('1','^','2','*','3','/','4','+','5')))
        //                                                                             #
        assertEquals(5, findRootIndex(charArrayOf('1','^','2','*','3','/','4')))
        //                                                                     #
        assertEquals(3, findRootIndex(charArrayOf('1','^','2','*','3')))
        //                                                             #
        assertEquals(1, findRootIndex(charArrayOf('1','^','2')))
        //                                                     #
        assertEquals(0, findRootIndex(charArrayOf('1')))
        //                                                 #

        // Going right of root char.
        assertEquals(0, findRootIndex(charArrayOf('6')))
        //                                                 #
    }
    @Test
    fun findRootIndexTestExpressionDecreasingPriority()
    {
        // 1-2+3/4*5^6
        // Initial expression.
        assertEquals(3, findRootIndex(charArrayOf('1','-','2','+','3','/','4','*','5','^','6')))
        //                                                             #

        // Going left of root char (#).
        assertEquals(1, findRootIndex(charArrayOf('1','-','2')))
        //                                                     #
        assertEquals(0, findRootIndex(charArrayOf('1')))
        //                                                 #

        // Going right of root char.
        assertEquals(3, findRootIndex(charArrayOf('3','/','4','*','5','^','6')))
        //                                                             #
        assertEquals(1, findRootIndex(charArrayOf('5','^','6')))
        //                                                     #
        assertEquals(0, findRootIndex(charArrayOf('6')))
        //                                                 #
    }
    //#####################################################################

    //#####################################################################
    @Test
    fun checkOperatorPriorityCurrentCharDigit()
    {
        // Test current char is exponent.
        assertFalse(checkOperatorPriority('9', '^'))
        assertFalse(checkOperatorPriority('9', '*'))
        assertFalse(checkOperatorPriority('9', '/'))
        assertFalse(checkOperatorPriority('9', '+'))
        assertFalse(checkOperatorPriority('9', '-'))
        assertFalse(checkOperatorPriority('9', '9'))
    }
    @Test
    fun checkOperatorPriorityCurrentCharExponent()
    {
        // Test current char is exponent.
        assertFalse(checkOperatorPriority('^', '^'))
        assertTrue(checkOperatorPriority('^', '*'))
        assertTrue(checkOperatorPriority('^', '/'))
        assertTrue(checkOperatorPriority('^', '+'))
        assertTrue(checkOperatorPriority('^', '-'))
        assertTrue(checkOperatorPriority('^', '9'))
    }
    @Test
    fun checkOperatorPriorityCurrentCharMultiplication()
    {
        // Test current char is multiplication.
        assertFalse(checkOperatorPriority('*', '^'))
        assertFalse(checkOperatorPriority('*', '*'))
        assertFalse(checkOperatorPriority('*', '/'))
        assertTrue(checkOperatorPriority('*', '+'))
        assertTrue(checkOperatorPriority('*', '-'))
        assertTrue(checkOperatorPriority('*', '9'))
    }
    @Test
    fun checkOperatorPriorityCurrentCharDivision()
    {
        // Test current char is multiplication.
        assertFalse(checkOperatorPriority('/', '^'))
        assertFalse(checkOperatorPriority('/', '*'))
        assertFalse(checkOperatorPriority('/', '/'))
        assertTrue(checkOperatorPriority('/', '+'))
        assertTrue(checkOperatorPriority('/', '-'))
        assertTrue(checkOperatorPriority('/', '9'))
    }
    @Test
    fun checkOperatorPriorityCurrentCharAddition()
    {
        // Test current char is multiplication.
        assertFalse(checkOperatorPriority('+', '^'))
        assertFalse(checkOperatorPriority('+', '*'))
        assertFalse(checkOperatorPriority('+', '/'))
        assertFalse(checkOperatorPriority('+', '+'))
        assertFalse(checkOperatorPriority('+', '-'))
        assertTrue(checkOperatorPriority('+', '9'))
    }
    @Test
    fun checkOperatorPriorityCurrentCharSubtraction()
    {
        // Test current char is multiplication.
        assertFalse(checkOperatorPriority('-', '^'))
        assertFalse(checkOperatorPriority('-', '*'))
        assertFalse(checkOperatorPriority('-', '/'))
        assertFalse(checkOperatorPriority('-', '+'))
        assertFalse(checkOperatorPriority('-', '-'))
        assertTrue(checkOperatorPriority('-', '9'))
    }
    //#####################################################################
}