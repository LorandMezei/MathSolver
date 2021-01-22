package lorandmezei.mathsolver

interface ITree {
    // Traverse the tree.
    fun traverse(visitor : IVisitor)
}