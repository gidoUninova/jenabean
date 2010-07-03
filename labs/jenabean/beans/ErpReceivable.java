package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpReceivable")
public class ErpReceivable extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpReceivable.CustomerAgreements")
   private Collection<CustomerAgreement> CustomerAgreements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpReceivable.CustomerBillings")
   private Collection<CustomerBilling> CustomerBillings;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpReceivable.CustomerAccounts")
   private CustomerAccount CustomerAccounts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpReceivable.WorkBillingInfo")
   private Collection<WorkBillingInfo> WorkBillingInfo;
}
