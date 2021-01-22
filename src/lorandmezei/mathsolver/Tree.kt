package lorandmezei.mathsolver

class Tree : ITree {
    lateinit var rootNode : INode

    override fun traverse(visitor : IVisitor) : Object {
        return rootNode.accept(visitor)
    }
}