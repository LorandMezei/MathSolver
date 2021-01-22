package lorandmezei.mathsolver

class Node(content: Any = 0)
{
    lateinit var content: Any
    lateinit var leftNode: Node
    lateinit var rightNode : Node

    init
    {
        this.content = content
    }

    fun accept(visitor : IVisitor) : Any?
    {
        return visitor.visit(this)
    }
}