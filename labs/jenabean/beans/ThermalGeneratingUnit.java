package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ThermalGeneratingUnit")
public class ThermalGeneratingUnit extends GeneratingUnit {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.FossilFuels")
   private FossilFuel FossilFuels;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.EmmissionAccounts")
   private EmissionAccount EmmissionAccounts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.HeatRateCurve")
   private HeatRateCurve HeatRateCurve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.MemberOf_CombinedCyclePlant")
   private CombinedCyclePlant MemberOf_CombinedCyclePlant;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.MembmerOf_CogenerationPlant")
   private CogenerationPlant MembmerOf_CogenerationPlant;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.EmissionCurves")
   private EmissionCurve EmissionCurves;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.oMCost")
   private Collection<java.lang.Float> oMCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.ShutdownCurve")
   private ShutdownCurve ShutdownCurve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.StartupModel")
   private StartupModel StartupModel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.MemberOf_CAESPlant")
   private CAESPlant MemberOf_CAESPlant;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.FuelAllocationSchedules")
   private FuelAllocationSchedule FuelAllocationSchedules;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.IncrementalHeatRateCurve")
   private IncrementalHeatRateCurve IncrementalHeatRateCurve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ThermalGeneratingUnit.HeatInputCurve")
   private HeatInputCurve HeatInputCurve;
}
