package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SecurityConstraints")
public class SecurityConstraints extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraints.actualMW")
   private Collection<java.lang.Float> actualMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraints.maxMW")
   private Collection<java.lang.Float> maxMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraints.minMW")
   private Collection<java.lang.Float> minMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SecurityConstraints.NetworkDataSets")
   private Collection<NetworkDataSet> NetworkDataSets;
}
