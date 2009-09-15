package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("StartupModel")
public class StartupModel extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.minimumRunTime")
   private Collection<java.lang.Float> minimumRunTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.stbyAuxPowerMW")
   private Collection<java.lang.Float> stbyAuxPowerMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.startupDate")
   private Collection<java.lang.String> startupDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.startupPriority")
   private Collection<java.math.BigInteger> startupPriority;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.ThermalGeneratingUnit")
   private ThermalGeneratingUnit ThermalGeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.fixedMaintCost")
   private Collection<java.lang.Float> fixedMaintCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.incrementalMaintCost")
   private Collection<java.lang.Float> incrementalMaintCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.riskFactorCost")
   private Collection<java.lang.Float> riskFactorCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.hotStandbyHeat")
   private Collection<java.lang.Float> hotStandbyHeat;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.StartIgnFuelCurve")
   private StartIgnFuelCurve StartIgnFuelCurve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.minimumDownTime")
   private Collection<java.lang.Float> minimumDownTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.StartMainFuelCurve")
   private StartMainFuelCurve StartMainFuelCurve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.StartRampCurve")
   private StartRampCurve StartRampCurve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartupModel.startupCost")
   private Collection<java.lang.Float> startupCost;
}
