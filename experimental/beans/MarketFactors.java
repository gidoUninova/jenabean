package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MarketFactors")
public class MarketFactors extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketFactors.timeInterval")
   private Collection<java.lang.String> timeInterval;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketFactors.MarketOperations")
   private MarketOperation MarketOperations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketFactors.ActivityRecords")
   private Collection<ActivityRecord> ActivityRecords;
}
