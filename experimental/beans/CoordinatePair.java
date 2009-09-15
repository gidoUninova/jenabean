package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CoordinatePair")
public class CoordinatePair extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CoordinatePair.xPosition")
   private Collection<java.lang.Double> xPosition;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CoordinatePair.PointSequence")
   private PointSequence PointSequence;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CoordinatePair.yPosition")
   private Collection<java.lang.Double> yPosition;
}
