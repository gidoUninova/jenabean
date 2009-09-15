package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Design")
public class Design extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Design.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Design.ErpPurchaseOrders")
   private Collection<ErpPurchaseOrder> ErpPurchaseOrders;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Design.price")
   private Collection<java.lang.Float> price;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Design.Work")
   private Work Work;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Design.WorkCostDetails")
   private WorkCostDetail WorkCostDetails;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Design.WorkTasks")
   private WorkTask WorkTasks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Design.ErpBOM")
   private ErpBOM ErpBOM;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Design.DesignLocation")
   private Collection<DesignLocation> DesignLocation;
}
