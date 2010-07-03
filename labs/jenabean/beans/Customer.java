package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Customer")
public class Customer extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.TroubleTickets")
   private TroubleTicket TroubleTickets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.Documents")
   private Collection<Document> Documents;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.WorkBillingInfo")
   private Collection<WorkBillingInfo> WorkBillingInfo;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.pucNumber")
   private Collection<java.lang.String> pucNumber;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.Appointments")
   private Collection<Appointment> Appointments;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.customerType")
   private Collection<java.lang.String> customerType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.CustomerLists")
   private Collection<CustomerList> CustomerLists;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.ErpPartner")
   private ErpPartner ErpPartner;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.Work")
   private Collection<Work> Work;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.Requests")
   private Collection<Request> Requests;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.vip")
   private Collection<java.lang.Boolean> vip;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.CustomerAccounts")
   private CustomerAccount CustomerAccounts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Customer.specialNeeds")
   private Collection<java.lang.String> specialNeeds;
}
