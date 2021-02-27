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

    var input: String = "1^2*3/4+5-6"
    var expression: Array<String> = arrayOf("1","^","2","*","3","/","4","+","5","-","6")

    // Build the expression tree. Pass the expression (a character array), and the Tree object
    // to create it in.
    var tb = TreeBuilder()
    var t = Tree()
    tb.startBuildTree(expression, t)

    var v: IVisitor = CalculateVisitor()
    println("Calculated value: " + t.traverse(v))
}