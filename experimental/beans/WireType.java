package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("WireType")
public class WireType extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireType.phaseConductorSpacing")
   private Collection<java.lang.Float> phaseConductorSpacing;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireType.gMR")
   private Collection<java.lang.Float> gMR;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireType.phaseConductorCount")
   private Collection<java.math.BigInteger> phaseConductorCount;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireType.resistance")
   private Collection<java.lang.Float> resistance;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireType.WireArrangements")
   private WireArrangement WireArrangements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireType.radius")
   private Collection<java.lang.Float> radius;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireType.ampRating")
   private Collection<java.lang.Float> ampRating;
}
