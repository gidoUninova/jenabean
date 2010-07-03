package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Structure")
public class Structure extends Asset {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Structure.jpaRefNum")
   private Collection<java.lang.String> jpaRefNum;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Structure.weedAbate")
   private Collection<java.lang.Boolean> weedAbate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Structure.height")
   private Collection<java.lang.Float> height;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Structure.StructureSupports")
   private StructureSupport StructureSupports;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Structure.fumigant")
   private Collection<java.lang.String> fumigant;
}
