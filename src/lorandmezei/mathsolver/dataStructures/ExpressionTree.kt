package lorandmezei.mathsolver.dataStructures

import lorandmezei.mathsolver.visitors.IVisitor

class ExpressionTree(root: String = "0")
{
    var root: String
    var leftExpressionTree: ExpressionTree?
    var rightExpressionTree : ExpressionTree?

    init
    {
        this.root = root
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