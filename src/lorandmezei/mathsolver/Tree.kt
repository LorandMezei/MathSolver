package lorandmezei.mathsolver

class Tree : ITree {
    lateinit var rootNode : INode

    override fun traverse(visitor : IVisitor) : Any {
        return rootNode.accept(visitor)
    }
}