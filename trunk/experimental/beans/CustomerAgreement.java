package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CustomerAgreement")
public class CustomerAgreement extends Agreement {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAgreement.CustomerAccount")
   private CustomerAccount CustomerAccount;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAgreement.ServiceLocations")
   private ServiceLocation ServiceLocations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAgreement.ErpReceivable")
   private Collection<ErpReceivable> ErpReceivable;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAgreement.CustomerBillings")
   private Collection<CustomerBilling> CustomerBillings;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAgreement.CustomerMeters")
   private Collection<CustomerMeter> CustomerMeters;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAgreement.PricingStructures")
   private Collection<PricingStructure> PricingStructures;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAgreement.typeService")
   private Collection<java.lang.String> typeService;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAgreement.typeAgreement")
   private Collection<java.lang.String> typeAgreement;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerAgreement.StandardIndustryCode")
   private StandardIndustryCode StandardIndustryCode;
}
