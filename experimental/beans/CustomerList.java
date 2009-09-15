package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CustomerList")
public class CustomerList extends CIMCollection {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerList.WorkTasks")
   private Collection<WorkTask> WorkTasks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerList.OutageNotification")
   private Collection<OutageNotifice> OutageNotification;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerList.Customers")
   private Collection<Customer> Customers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerList.PlannedOutage")
   private PlannedOutage PlannedOutage;
}
