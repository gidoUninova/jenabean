package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("UGStructure")
public class UGStructure extends Structure {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UGStructure.typeName")
   private Collection<java.lang.String> typeName;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UGStructure.ventilation")
   private Collection<java.lang.Boolean> ventilation;
}
