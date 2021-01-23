package lorandmezei.mathsolver

class Node(content: Char = '0')
{
    var content: Char = content
    var leftNode: Node? = null
    var rightNode : Node? = null

    fun accept(visitor : IVisitor) : Any?
    {
        return visitor.visit(this)
    }
}