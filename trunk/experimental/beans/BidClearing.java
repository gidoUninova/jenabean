package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("BidClearing")
public class BidClearing extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BidClearing.lostOpCost")
   private Collection<java.lang.Float> lostOpCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BidClearing.startUpCost")
   private Collection<java.lang.Float> startUpCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BidClearing.clearedMW")
   private Collection<java.lang.Float> clearedMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BidClearing.Bid")
   private Bid Bid;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BidClearing.noLoadCost")
   private Collection<java.lang.Float> noLoadCost;
}
