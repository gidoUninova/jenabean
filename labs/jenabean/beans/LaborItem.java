package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LaborItem")
public class LaborItem extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LaborItem.WorkTasks")
   private WorkTask WorkTasks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LaborItem.laborRate")
   private Collection<java.lang.Float> laborRate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LaborItem.ErpContacts")
   private Collection<ErpContact> ErpContacts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LaborItem.laborHours")
   private Collection<java.lang.Float> laborHours;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LaborItem.activityCode")
   private Collection<java.lang.String> activityCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LaborItem.cost")
   private Collection<java.lang.Float> cost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LaborItem.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
}
