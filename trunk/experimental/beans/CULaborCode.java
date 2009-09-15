package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CULaborCode")
public class CULaborCode extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CULaborCode.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CULaborCode.CULaborItems")
   private CULaborItem CULaborItems;
}
