package lorandmezei.mathsolver

interface IVisitor {
    // Visit.
    fun visit(node : Node) : Any?
}