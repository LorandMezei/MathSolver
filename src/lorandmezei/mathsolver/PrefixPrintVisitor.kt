package lorandmezei.mathsolver

class PrefixPrintVisitor : IVisitor
{
    override fun visit(node: Node): Any?
    {
        // Base case I think.
        if (node == null)
        {
            return null
        }

        // If the current node is an operator.
        if (node.leftNode != null && node.rightNode != null)
        {
            when(node.content)
            {
                "^" -> println("exp ")
                "*" -> println("mul ")
                "/" -> println("div ")
                "+" -> println("add ")
                "-" -> println("sub ")
            }

            // Recursion.
            node.leftNode!!.accept(this)
            node.rightNode!!.accept(this)
        }

        else
        {
            println(node.content)
        }

        return ""
    }
}