package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("AncillaryServiceClearing")
public class AncillaryServiceClearing extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AncillaryServiceClearing.MarketCaseClearing")
   private MarketCaseClearing MarketCaseClearing;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AncillaryServiceClearing.commodityType")
   private Collection<java.lang.String> commodityType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AncillaryServiceClearing.clearedMW")
   private Collection<java.lang.Float> clearedMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AncillaryServiceClearing.mcp")
   private Collection<java.lang.Float> mcp;
}
