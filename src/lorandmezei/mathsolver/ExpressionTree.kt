package lorandmezei.mathsolver

class ExpressionTree {
    lateinit var rootNode : Node

    fun traverse(visitor : IVisitor) : Any? {
        return rootNode.accept(visitor)
    }
}