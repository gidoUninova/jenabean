package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Work")
public class Work extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.Schedule")
   private Schedule Schedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.ErpProjectAccounting")
   private ErpProjectAccounting ErpProjectAccounting;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.BusinessCase")
   private BusinessCase BusinessCase;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.Request")
   private Request Request;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.WorkTasks")
   private WorkTask WorkTasks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.Customers")
   private Collection<Customer> Customers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.Project")
   private Project Project;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.typeWork")
   private Collection<java.lang.String> typeWork;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.Locations")
   private Collection<Location> Locations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.priority")
   private Collection<java.lang.String> priority;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.WorkBillingInfo")
   private WorkBillingInfo WorkBillingInfo;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.Designs")
   private Design Designs;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Work.WorkFlow")
   private WorkFlow WorkFlow;
}
