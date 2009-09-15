package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ContractorItem")
public class ContractorItem extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ContractorItem.activityCode")
   private Collection<java.lang.String> activityCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ContractorItem.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ContractorItem.WorkTask")
   private WorkTask WorkTask;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ContractorItem.cost")
   private Collection<java.lang.Float> cost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ContractorItem.ErpPayables")
   private Collection<ErpPayable> ErpPayables;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ContractorItem.bidAmount")
   private Collection<java.lang.String> bidAmount;
}
