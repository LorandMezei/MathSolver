package lorandmezei.mathsolver

import kotlin.math.pow

class CalculateVisitor : IVisitor
{
    // Recursive.
    override fun visit(node : Node) : Any
    {
        // Base case if the node is a leaf node (operand).
        if (node.leftNode == null && node.rightNode == null)
        {
            // Return the value of the node's content.
            return node.content.toString().toDouble()
        }

        else
        {
            var answer = 0.0

            val x = node.leftNode!!.accept(this).toString().toDouble()
            val y = node.rightNode!!.accept(this).toString().toDouble()

            // Choose correct operator based on character.
            val operator = node.content

            // Switch. Apply the appropriate operation to the nodes' contents.
            when (operator)
            {
                "^" -> answer = x.pow(y)
                "*" -> answer = x * y
                "/" -> answer = x / y
                "+" -> answer = x + y
                "-" -> answer = x - y
            }

            // Return the answer with the operation applied.
            return answer
        }
    }
}