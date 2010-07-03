package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SecurityConstraintsLinear")
public class SecurityConstraintsLinear extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraintsLinear.resourceMW")
   private Collection<java.lang.Float> resourceMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraintsLinear.NetworkDataSets")
   private Collection<NetworkDataSet> NetworkDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraintsLinear.shiftFactor")
   private Collection<java.math.BigInteger> shiftFactor;
}
