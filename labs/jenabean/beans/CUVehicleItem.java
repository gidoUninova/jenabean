package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CUVehicleItem")
public class CUVehicleItem extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUVehicleItem.rate")
   private Collection<java.lang.Float> rate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUVehicleItem.CompatibleUnit")
   private CompatibleUnit CompatibleUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUVehicleItem.code")
   private Collection<java.lang.String> code;
}
