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

    val expression1: Array<Char> = arrayOf('5', '+', '3', '-', '4')

    val tb = TreeBuilder()

    val t = Tree()

    tb.startBuildTree(expression1, t)

    var v: IVisitor = CalculateVisitor()

    println("Calculated value: " + t.traverse(v))

    v = PrefixPrintVisitor()

    v.visit(t.rootNode)
}