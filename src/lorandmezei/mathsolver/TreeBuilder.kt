// Sources: http://www.openbookproject.net/books/pythonds/Trees/ParseTree.html

package lorandmezei.mathsolver

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

        // Find the index in the expression array that is the root value of the current expression.
        var rootIndex = findRootIndex(expression)

        // Debugging ----------------------------------------------
        println("expression size: " + expression.size)
        println("root index: " + rootIndex)
        //---------------------------------------------------------

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
        var operators = charArrayOf('*', '/', '^', '+', '-')

        var rootIndex = 0

        for (i in expression.indices)
        {
            // If the character is an operator.
            if (operators.contains(expression[i]))
            {
                val rootChar: Char = expression[rootIndex]
                val currentChar: Char = expression[i]

                // If current character being looked at has same or less priority than current root character,
                // set rootIndex to index of current character.
                if (checkPriority(currentChar, rootChar))
                {
                    rootIndex = i
                }
            }

            // If the character is a left parenthesis '('.

            // If the character is a right parenthesis ')'.

            // If the character is a space ' '.
        }

        println("root index: " + rootIndex)
        return rootIndex
    }

    /**
     * If current char is greater priority than the root char, return true;
     *
     * If current char is less or same priority than the root char, return false;
     *
     * @param rootChar
     * @param currentChar
     * @return
     */
    fun checkPriority(currentChar: Char, rootChar: Char): Boolean
    {
        // PEMDAS priority.
        var priority0 = charArrayOf('^') // highest priority
        var priority1 = charArrayOf('*', '/')
        var priority2 = charArrayOf('+', '-') // lowest priority

        //--------------------------------------------------------------------------------
        // Determine the priority level of the current char.
        var currentCharPriority: Int = -1;

        if (priority0.contains(currentChar))
            currentCharPriority = 0

        else if (priority1.contains(currentChar))
            currentCharPriority = 1

        else if (priority2.contains(currentChar))
            currentCharPriority = 2
        //--------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------
        // Determine the priority level of the root char.
        var rootCharPriority: Int = -1;

        if (priority0.contains(rootChar))
            rootCharPriority = 0

        else if (priority1.contains(rootChar))
            rootCharPriority = 1

        else if (priority2.contains(rootChar))
            rootCharPriority = 2
        //--------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------
        var hasPriority = false

        // Current char has higher priority than root char.
        if (currentCharPriority > rootCharPriority)
            hasPriority = true;

        // Current char has lower priority than root char.
        else if (currentCharPriority < rootCharPriority)
            hasPriority = false;

        // Current char has same priority as root char.
        else
            hasPriority = false;
        //--------------------------------------------------------------------------------
        
        return hasPriority
    }
}