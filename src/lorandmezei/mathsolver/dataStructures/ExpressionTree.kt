package lorandmezei.mathsolver.dataStructures

import lorandmezei.mathsolver.visitors.IVisitor

class ExpressionTree(content: String = "0")
{
    var content: String
    var leftExpressionTree: ExpressionTree?
    var rightExpressionTree : ExpressionTree?

    init
    {
        this.content = content
        leftExpressionTree = null
        rightExpressionTree = null
    }

    fun accept(visitor : IVisitor) : Any?
    {
        return visitor.visit(this)
    }

    fun traverse(visitor : IVisitor) : Any? {
        return accept(visitor)
    }
}