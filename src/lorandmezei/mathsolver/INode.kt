package lorandmezei.mathsolver

interface INode {
    abstract var content: Any
    abstract var rightNode: INode
    abstract var leftNode: INode

    // Accept.
    fun accept(visitor : IVisitor) : Any?
}