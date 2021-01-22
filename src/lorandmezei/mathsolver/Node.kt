package lorandmezei.mathsolver

class Node : INode {
    lateinit var content : Object
    lateinit var leftNode : INode
    lateinit var rightNode : INode

    override fun accept(visitor : IVisitor) : Object {
        return visitor.visit(this)
    }
}