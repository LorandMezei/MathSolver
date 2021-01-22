package lorandmezei.mathsolver

interface IVisitor {
    // Visit.
    fun visit(node : INode) : Any
}