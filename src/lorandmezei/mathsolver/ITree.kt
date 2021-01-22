package lorandmezei.mathsolver

interface ITree {
    // Set root node.
    fun setRootNode(rootNode : INode)

    // Get root node.
    fun getRootNode(): INode

    // Traverse the tree.
    fun traverse(visitor : IVisitor)
}