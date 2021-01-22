package lorandmezei.mathsolver

class Node() : INode
{
    override lateinit var content : Any
    override lateinit var leftNode : INode
    override lateinit var rightNode : INode

    override fun accept(visitor : IVisitor) : Any?
    {
        return visitor.visit(this)
    }
}