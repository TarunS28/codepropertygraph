package io.shiftleft.dataflowengine.layers.dataflows

import io.shiftleft.SerializedCpg
import io.shiftleft.codepropertygraph.Cpg
import io.shiftleft.dataflowengine.passes.propagateedges.PropagateEdgePass
import io.shiftleft.dataflowengine.passes.reachingdef.ReachingDefPass
import io.shiftleft.dataflowengine.semanticsloader.Semantics

class DataFlowRunner(semantics: Semantics) {

  def run(cpg: Cpg, serializedCpg: SerializedCpg): Unit = {
    val enhancementExecList = Iterator(new PropagateEdgePass(cpg, semantics), new ReachingDefPass(cpg))
    enhancementExecList.foreach(_.createApplySerializeAndStore(serializedCpg))
  }

}
