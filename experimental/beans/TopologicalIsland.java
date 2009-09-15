package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TopologicalIsland")
public class TopologicalIsland extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TopologicalIsland.TopologicalNodes")
   private TopologicalNode TopologicalNodes;
}
