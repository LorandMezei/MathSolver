package lorandmezei.mathsolver

class TreeBuilder
{
    fun startBuildTree(expression: Array<Any>, tree: Tree)
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

    fun buildTree(expression: Array<Any>): Node
    {
        // Base case: If the length of the expression array is 1, that means that it is a leaf node,
        // and it stores only an integer.
        if (expression.size == 1)
        {
            var currentNode: Node = Node()
            currentNode.content = expression[0]

            return currentNode
        }

        var rootIndex = findRootIndex(expression)

        var currentNode: Node = Node()
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
     * Given a character array, find the index of the root
     * The character that will be the root is the last character in the array with the lowest priority.
     *
     * @param expression
     * @return index of the root in character array
     */
    fun findRootIndex(expression: Array<Any>): Int
    {
        var rootIndex = 0

        for (i in expression.indices)
        {
            // If the character is an operator.
            if (expression[i] == '*' || expression[i] == '/' || expression[i] == '+' || expression[i] == '-')
            {
                val rootChar: Any = expression[rootIndex]
                val currentChar: Any = expression[i]

                // If current char being looked at has same or less priority than current root char,
                // set root_index to index of current_char.
                if (!checkPriority(rootChar, currentChar))
                {
                    rootIndex = i
                }
            }
        }

        return rootIndex
    }

    /**
     * If check_char is greater priority, return true;
     *
     * If check_char is less or same priority, return false;
     *
     * @param rootChar
     * @param currentChar
     * @return
     */
    fun checkPriority(rootChar: Any, currentChar: Any): Boolean
    {
        var priority = false

        // Check char has greater priority.
        if ((currentChar.equals('*') || currentChar.equals('/')) && (rootChar.equals('+') || rootChar.equals('-')))
        {
            priority = true
        }
        else if ((currentChar.equals('*') || currentChar.equals('/')) && (rootChar.equals('*') || rootChar.equals('/')))
        {
            priority = false
        }
        else if ((currentChar.equals('+') || currentChar.equals('-')) && (rootChar.equals('*') || rootChar.equals('/')))
        {
            priority = false
        }
        else if ((currentChar.equals('+') || currentChar.equals('-')) && (rootChar.equals('+') || rootChar.equals('-')))
        {
            priority = false
        }
        else if (!rootChar.equals('*') || !rootChar.equals('/') || !rootChar.equals('+') || !rootChar.equals('-'))
        {
            return false
        }
        
        return priority
    }
}