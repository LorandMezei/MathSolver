package lorandmezei.mathsolver

interface INode {
    // Getter of content.
    fun getContent()

    // Gets left node.
    fun getLeftNode()

    // Gets right node.
    fun getRightNode()

    // Set content.
    fun setContent(content : Object)

    // Set left node.
    fun setLeftNode(leftNode : INode)

    // Set right node.
    fun setRightNode(rightNode : INode)
}