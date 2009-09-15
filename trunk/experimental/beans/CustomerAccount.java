package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CustomerAccount")
public class CustomerAccount extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAccount.ErpReceivables")
   private ErpReceivable ErpReceivables;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAccount.WorkBillingInfo")
   private Collection<WorkBillingInfo> WorkBillingInfo;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAccount.CustomerAgreements")
   private CustomerAgreement CustomerAgreements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAccount.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAccount.budgetBill")
   private Collection<java.lang.String> budgetBill;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAccount.billingCycle")
   private Collection<java.lang.String> billingCycle;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAccount.Customer")
   private Customer Customer;
}
