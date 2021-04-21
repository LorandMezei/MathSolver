package lorandmezei.mathsolver.visitors

import lorandmezei.mathsolver.dataStructures.Node

interface IVisitor {
    // Visit.
    fun visit(node : Node) : Any?
}