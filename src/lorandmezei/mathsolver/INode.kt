package lorandmezei.mathsolver

interface INode {
    // Getter of content.
    fun getContent(): Object

    // Gets left node.
    fun getLeftNode(): INode

    // Gets right node.
    fun getRightNode(): INode

    // Set content.
    fun setContent(content : Object)

    // Set left node.
    fun setLeftNode(leftNode : INode)

    // Set right node.
    fun setRightNode(rightNode : INode)
}