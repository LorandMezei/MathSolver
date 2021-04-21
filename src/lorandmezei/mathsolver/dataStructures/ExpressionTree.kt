package lorandmezei.mathsolver.dataStructures

import lorandmezei.mathsolver.dataStructures.Node
import lorandmezei.mathsolver.visitors.IVisitor

class ExpressionTree {
    lateinit var rootNode : Node

    fun traverse(visitor : IVisitor) : Any? {
        return rootNode.accept(visitor)
    }
}