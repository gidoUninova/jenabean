package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SystemRequirements")
public class SystemRequirements extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SystemRequirements.reqType")
   private Collection<java.lang.String> reqType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SystemRequirements.reqMW")
   private Collection<java.lang.Float> reqMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SystemRequirements.EnergyPriceCurves")
   private Collection<EnergyPriceCurve> EnergyPriceCurves;
}
