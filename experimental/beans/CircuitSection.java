package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CircuitSection")
public class CircuitSection extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CircuitSection.LinearConductors")
   private LinearConductorAsset LinearConductors;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CircuitSection.ACLineSegments")
   private ACLineSegment ACLineSegments;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CircuitSection.Line")
   private Line Line;
}
