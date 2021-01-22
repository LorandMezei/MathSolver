package lorandmezei.mathsolver

interface INode {
    abstract val content: Any
    abstract val rightNode: INode
    abstract val leftNode: INode

    // Accept.
    fun accept(visitor : IVisitor) : Any
}