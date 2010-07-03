package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PowerQualityPricing")
public class PowerQualityPricing extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.powerFactorMin")
   private Collection<java.lang.Float> powerFactorMin;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.emergencyLowVoltLimit")
   private Collection<java.lang.Float> emergencyLowVoltLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.voltImbalanceViolCost")
   private Collection<java.lang.Float> voltImbalanceViolCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.CustomerMeters")
   private CustomerMeter CustomerMeters;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.PricingStructure")
   private PricingStructure PricingStructure;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.valueUninterruptedServiceKW")
   private Collection<java.lang.Float> valueUninterruptedServiceKW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.normalHighVoltLimit")
   private Collection<java.lang.Float> normalHighVoltLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.valueUninterruptedServiceKWh")
   private Collection<java.lang.Float> valueUninterruptedServiceKWh;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.emergencyHighVoltLimit")
   private Collection<java.lang.Float> emergencyHighVoltLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.normalLowVoltLimit")
   private Collection<java.lang.Float> normalLowVoltLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerQualityPricing.voltLimitViolCost")
   private Collection<java.lang.Float> voltLimitViolCost;
}
