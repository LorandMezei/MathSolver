package lorandmezei.mathsolver.visitors

import lorandmezei.mathsolver.dataStructures.ExpressionTree

interface IVisitor {
    // Visit.
    fun visit(expressionTree : ExpressionTree) : Any?
}