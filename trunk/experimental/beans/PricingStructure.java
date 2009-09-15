package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PricingStructure")
public class PricingStructure extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.Intervals")
   private Collection<Interval> Intervals;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.PowerQualityPricings")
   private PowerQualityPricing PowerQualityPricings;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.dailyFloorUsage")
   private Collection<java.math.BigInteger> dailyFloorUsage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.Tariffs")
   private Collection<Tariff> Tariffs;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.dailyEstUsage")
   private Collection<java.math.BigInteger> dailyEstUsage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.revenueClass")
   private Collection<java.lang.String> revenueClass;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.taxExemption")
   private Collection<java.lang.Boolean> taxExemption;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.dailyCeilingUsage")
   private Collection<java.math.BigInteger> dailyCeilingUsage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PricingStructure.CustomerAgreements")
   private Collection<CustomerAgreement> CustomerAgreements;
}
