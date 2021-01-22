package lorandmezei.mathsolver

import java.util.ArrayList

    fun main()
    {
        /**
         *
         * // build a tree for the following expressions
         * // 5 + 3 - 4; 5*4 + 3; 5 + 4 * 3; 5 * 6 / 10;
         *
         * // more complicated ones: 3 * 2 � 4 * 5 / 3 ;    10 + 30 / 5 * 6 � 19 * 2 / 4
         *
         */
        val expressions: ArrayList<Array<Any>> = ArrayList()
        val expressionsString: ArrayList<String> = ArrayList()

        val expression1: Array<Any> = arrayOf(5, '+', 3, '-', 4)
        expressions.add(expression1)
        expressionsString.add("5 + 3 - 4")

        val expression2: Array<Any> = arrayOf(5, '*', 4, '+', 3)
        expressions.add(expression2)
        expressionsString.add("5 * 4 + 3")

        val expression3: Array<Any> = arrayOf(5, '+', 4, '*', 3)
        expressions.add(expression3)
        expressionsString.add("5 + 4 * 3")

        val expression4: Array<Any> = arrayOf(5, '*', 6, '/', 10)
        expressions.add(expression4)
        expressionsString.add("5 * 6 / 10")

        val expression5: Array<Any> = arrayOf(3, '*', 2, '-', 4, '*', 5, '/', 3)
        expressions.add(expression5)
        expressionsString.add("3 * 2 - 4 * 5 / 3")

        val expression6: Array<Any> = arrayOf(10, '+', 30, '/', 5, '*', 6, '-', 19, '*', 2, '/', 4)
        expressions.add(expression6)
        expressionsString.add("10 + 30 / 5 * 6 - 19 * 2 / 4")

        val tb = TreeBuilder()

        println("=========================================")
        println("= Building expression trees recursively =")
        println("=========================================")

        for (i in 0 until expressions.size)
        {
            // Print expression.
            println("Expression: " + expressionsString[i])

            val t = Tree()

            tb.startBuildTree(expressions[i], t)

            var v: IVisitor = CalculateVisitor()

            println("Calculated value: " + t.traverse(v))

            v = PrefixPrintVisitor()

            print("Prefix print assembly: ")
            println(t.traverse(v))
            println("-----------------------------------------")
        }
        println("========================================================")
        println("= Building expression trees hardcoded with parenthesis =")
        println("========================================================")
        println("Expression: " + "2 * (3 + 5)")

        // Build tree root.
        val t1 = Tree()
        val rootNode = Node(0)
        rootNode.content = ('*')
        t1.rootNode = (rootNode)

        // Build tree root's left child.
        val rootLeftChild = Node(2)
        t1.rootNode.leftNode = rootLeftChild

        // Build tree root's right child.
        val rootRightChild = Node('+')
        t1.rootNode.rightNode = rootRightChild
        var v: IVisitor = CalculateVisitor()

        println("Calculated value: " + t1.traverse(v))

        v = PrefixPrintVisitor()

        print("Prefix print assembly: ")
        println(t1.traverse(v))

        ///////////////////// (5+3)-4 /////////////////////////////////////
    }