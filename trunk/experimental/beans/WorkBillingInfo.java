package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("WorkBillingInfo")
public class WorkBillingInfo extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.receivedDate")
   private Collection<java.lang.String> receivedDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.dueDate")
   private Collection<java.lang.String> dueDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.costEstimate")
   private Collection<java.lang.Float> costEstimate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.ErpAddresses")
   private ErpAddress ErpAddresses;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.ErpReceivables")
   private Collection<ErpReceivable> ErpReceivables;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.deposit")
   private Collection<java.lang.Float> deposit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.CustomerAccounts")
   private Collection<CustomerAccount> CustomerAccounts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.Customer")
   private Collection<Customer> Customer;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.issueDate")
   private Collection<java.lang.String> issueDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.Work")
   private Work Work;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.workPrice")
   private Collection<java.lang.Float> workPrice;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkBillingInfo.discount")
   private Collection<java.lang.Float> discount;
}
