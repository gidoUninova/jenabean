package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MarketCaseClearing")
public class MarketCaseClearing extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketCaseClearing.postedDate")
   private Collection<java.lang.String> postedDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketCaseClearing.AncillaryServiceClearing")
   private AncillaryServiceClearing AncillaryServiceClearing;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketCaseClearing.modifiedDate")
   private Collection<java.lang.String> modifiedDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MarketCaseClearing.caseType")
   private Collection<java.lang.String> caseType;
}
