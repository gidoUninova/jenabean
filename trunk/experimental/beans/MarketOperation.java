package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MarketOperation")
public class MarketOperation extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.MarketFactors")
   private MarketFactors MarketFactors;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.rampIntervalNonSpinRes")
   private Collection<java.lang.Float> rampIntervalNonSpinRes;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.rampIntervalSpinRes")
   private Collection<java.lang.Float> rampIntervalSpinRes;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.timeIntervalLength")
   private Collection<java.lang.Float> timeIntervalLength;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.start")
   private Collection<java.lang.String> start;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.RTOs")
   private RTO RTOs;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.dst")
   private Collection<java.lang.Boolean> dst;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.rampIntervalReg")
   private Collection<java.lang.Float> rampIntervalReg;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.rampIntervalEnergy")
   private Collection<java.lang.Float> rampIntervalEnergy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.localTimeZone")
   private Collection<java.lang.String> localTimeZone;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketOperation.end")
   private Collection<java.lang.String> end;
}
