package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("OutageReport")
public class OutageReport extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageReport.aveCustomerMinsLost")
   private Collection<java.math.BigInteger> aveCustomerMinsLost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageReport.OutageRecord")
   private OutageRecord OutageRecord;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageReport.totalDuration")
   private Collection<java.math.BigInteger> totalDuration;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageReport.totalCustomers")
   private Collection<java.math.BigInteger> totalCustomers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageReport.totalCustomerMinsLost")
   private Collection<java.math.BigInteger> totalCustomerMinsLost;
}
