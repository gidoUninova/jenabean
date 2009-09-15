package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Bid")
public class Bid extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.Pnode")
   private Pnode Pnode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.EnergyProfile")
   private EnergyProfile EnergyProfile;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.downTimeMax")
   private Collection<java.lang.Float> downTimeMax;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.BidClearing")
   private BidClearing BidClearing;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.shutDownsMax")
   private Collection<java.math.BigInteger> shutDownsMax;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.startUpType")
   private Collection<java.math.BigInteger> startUpType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.GeneratingUnit")
   private GeneratingUnit GeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.marketType")
   private Collection<java.lang.String> marketType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.noLoadCost")
   private Collection<java.lang.Float> noLoadCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.EnergyProducts")
   private Collection<EnergyProduct> EnergyProducts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.upTimeMin")
   private Collection<java.lang.Float> upTimeMin;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.energyMin")
   private Collection<java.lang.Float> energyMin;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.energyMax")
   private Collection<java.lang.Float> energyMax;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.upTimeMax")
   private Collection<java.lang.Float> upTimeMax;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.startUpRampRate")
   private Collection<java.lang.Float> startUpRampRate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.CustomerMeter")
   private CustomerMeter CustomerMeter;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.commodityType")
   private Collection<java.lang.String> commodityType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.operatingMode")
   private Collection<java.lang.String> operatingMode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Bid.startUpsMax")
   private Collection<java.math.BigInteger> startUpsMax;
}
