package lorandmezei.mathsolver

class Node(var c : Any,
           var lN : INode,
           var rN : INode) : INode
{
    override var content : Any = c
    override var leftNode : INode = lN
    override var rightNode : INode = rN

    override fun accept(visitor : IVisitor) : Any
    {
        return visitor.visit(this)
    }
}