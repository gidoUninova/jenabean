package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CUMaterialItem")
public class CUMaterialItem extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUMaterialItem.materialCode")
   private Collection<java.lang.String> materialCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUMaterialItem.CompatibleUnit")
   private CompatibleUnit CompatibleUnit;
}
