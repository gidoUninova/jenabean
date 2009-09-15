package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Interval")
public class Interval extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Interval.Measurements")
   private Collection<Measurement> Measurements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Interval.length")
   private Collection<java.lang.Float> length;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Interval.PricingStructures")
   private Collection<PricingStructure> PricingStructures;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Interval.CustomerMeters")
   private Collection<CustomerMeter> CustomerMeters;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Interval.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Interval.offset")
   private Collection<java.lang.Float> offset;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Interval.Procedures")
   private Collection<Procedure> Procedures;
}
