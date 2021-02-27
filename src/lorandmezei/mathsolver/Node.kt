package lorandmezei.mathsolver

class Node(content: String = "0")
{
    var content: String = content
    var leftNode: Node? = null
    var rightNode : Node? = null

    fun accept(visitor : IVisitor) : Any?
    {
        return visitor.visit(this)
    }
}