package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CustomerBilling")
public class CustomerBilling extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerBilling.billingType")
   private Collection<java.lang.String> billingType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerBilling.billMedia")
   private Collection<java.lang.String> billMedia;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerBilling.outBalance")
   private Collection<java.lang.Float> outBalance;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerBilling.lastPaymentAmt")
   private Collection<java.lang.Float> lastPaymentAmt;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerBilling.CustomerAgreements")
   private Collection<CustomerAgreement> CustomerAgreements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerBilling.pymtPlanAmt")
   private Collection<java.lang.Float> pymtPlanAmt;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerBilling.pymtPlanType")
   private Collection<java.lang.String> pymtPlanType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerBilling.ErpReceivables")
   private Collection<ErpReceivable> ErpReceivables;
}
