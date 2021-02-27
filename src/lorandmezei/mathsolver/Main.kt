package lorandmezei.mathsolver

fun main()
{
    /**
     *
     * // build a tree for the following expressions
     * // 5 + 3 - 4; 5*4 + 3; 5 + 4 * 3; 5 * 6 / 10;
     *
     * // more complicated ones: 3 * 2 - 4 * 5 / 3 ;    10 + 30 / 5 * 6 - 19 * 2 / 4
     *
     */

    // Read the user input expression as a string, and turn it into a char array
    // so that individual characters can be looked at one by one.
    var input: String = "1^2*3/4+5-6"//readLine()!!
    var expression: CharArray = input.toCharArray()


    // Debugging --------------------------------
    //expression.forEach{ index->println(index) }
    //println("expression.size" + expression.size)
    //-------------------------------------------

    // Build the expression tree. Pass the expression (a character array), and the Tree object
    // to create it in.
    var tb = TreeBuilder()
    var t = Tree()
    tb.startBuildTree(expression, t)

    var v: IVisitor = CalculateVisitor()
    println("Calculated value: " + t.traverse(v))

    //v = PrefixPrintVisitor()
    //v.visit(t.rootNode)
}