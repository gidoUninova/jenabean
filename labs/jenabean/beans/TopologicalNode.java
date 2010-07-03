package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TopologicalNode")
public class TopologicalNode extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalNode.loadCarrying")
   private Collection<java.lang.Boolean> loadCarrying;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalNode.netInjectionMW")
   private Collection<java.lang.Float> netInjectionMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalNode.TopologicalIsland")
   private TopologicalIsland TopologicalIsland;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalNode.phaseAngle")
   private Collection<java.lang.Float> phaseAngle;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalNode.ConnectivityNodes")
   private ConnectivityNode ConnectivityNodes;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalNode.voltage")
   private Collection<java.lang.Float> voltage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalNode.netInjectionMVar")
   private Collection<java.lang.Float> netInjectionMVar;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalNode.energized")
   private Collection<java.lang.Boolean> energized;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalNode.observabilityFlag")
   private Collection<java.lang.Boolean> observabilityFlag;
}
