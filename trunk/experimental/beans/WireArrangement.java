package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("WireArrangement")
public class WireArrangement extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireArrangement.mountingPointX")
   private Collection<java.math.BigInteger> mountingPointX;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireArrangement.ConductorType")
   private ConductorType ConductorType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireArrangement.mountingPointY")
   private Collection<java.math.BigInteger> mountingPointY;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WireArrangement.WireType")
   private WireType WireType;
}
