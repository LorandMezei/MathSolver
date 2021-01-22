package lorandmezei.mathsolver

interface ITree {
    // Traverse.
    fun traverse(visitor : IVisitor) : Object
}