package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("DCLineSegment")
public class DCLineSegment extends Conductor {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DCLineSegment.dcSegmentInductance")
   private Collection<java.lang.Float> dcSegmentInductance;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DCLineSegment.MemberOf_Line")
   private Line MemberOf_Line;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DCLineSegment.dcSegmentResistance")
   private Collection<java.lang.Float> dcSegmentResistance;
}
