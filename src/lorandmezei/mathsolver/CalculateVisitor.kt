package lorandmezei.mathsolver

class CalculateVisitor : IVisitor
{
    // Recursive.
    override fun visit(node : Node) : Any
    {
        // Base case if the node is a leaf node (operand).
        if (node.leftNode == null && node.rightNode == null)
        {
            return node.content.toString().toDouble()
        }

        else
        {
            var answer = 0.0

            val x = node.leftNode.accept(this).toString().toDouble()
            val y = node.rightNode.accept(this).toString().toDouble()

            // Choose correct operator based on character.
            val operator = node.content

            // Switch.
            when(operator)
            {
                '*' -> answer = x * y
                '/' -> answer = x / y
                '+' -> answer = x + y
                '-' -> answer = x - y
            }

            return answer
        }
    }
}