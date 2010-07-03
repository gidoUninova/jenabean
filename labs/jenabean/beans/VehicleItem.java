package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("VehicleItem")
public class VehicleItem extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#VehicleItem.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#VehicleItem.WorkTask")
   private WorkTask WorkTask;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#VehicleItem.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#VehicleItem.cost")
   private Collection<java.lang.Float> cost;
}
