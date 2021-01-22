package lorandmezei.mathsolver

class Node(content: Any = 0)
{
    var content: Any = content
    var leftNode: Node? = null
    var rightNode : Node? = null

    fun accept(visitor : IVisitor) : Any?
    {
        return visitor.visit(this)
    }
}