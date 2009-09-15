package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("EnergyPriceCurve")
public class EnergyPriceCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyPriceCurve.EnergyTransactions")
   private Collection<EnergyTransaction> EnergyTransactions;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyPriceCurve.SystemRequirements")
   private Collection<SystemRequirements> SystemRequirements;
}
