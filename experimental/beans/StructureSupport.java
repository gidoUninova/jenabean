package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("StructureSupport")
public class StructureSupport extends Asset {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StructureSupport.rodLength")
   private Collection<java.lang.Float> rodLength;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StructureSupport.length")
   private Collection<java.lang.Float> length;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StructureSupport.direction")
   private Collection<java.lang.Float> direction;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StructureSupport.Secures_Structure")
   private Structure Secures_Structure;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StructureSupport.size")
   private Collection<java.lang.String> size;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StructureSupport.numRods")
   private Collection<java.math.BigInteger> numRods;
}
