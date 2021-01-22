package lorandmezei.mathsolver

class Tree {
    lateinit var rootNode : Node

    fun traverse(visitor : IVisitor) : Any? {
        return rootNode.accept(visitor)
    }
}