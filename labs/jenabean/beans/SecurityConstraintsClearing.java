package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SecurityConstraintsClearing")
public class SecurityConstraintsClearing extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraintsClearing.mwLimit")
   private Collection<java.lang.Float> mwLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraintsClearing.mwFlow")
   private Collection<java.lang.Float> mwFlow;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraintsClearing.NetworkDataSets")
   private Collection<NetworkDataSet> NetworkDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraintsClearing.shadowPrice")
   private Collection<java.lang.Float> shadowPrice;
}
