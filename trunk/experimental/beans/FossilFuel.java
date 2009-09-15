package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("FossilFuel")
public class FossilFuel extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.ThermalGeneratingUnit")
   private ThermalGeneratingUnit ThermalGeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.fuelHeatContent")
   private Collection<java.lang.Float> fuelHeatContent;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.fuelSulfur")
   private Collection<java.lang.Float> fuelSulfur;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.fuelDispatchCost")
   private Collection<java.lang.Float> fuelDispatchCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.FuelAllocationSchedule")
   private FuelAllocationSchedule FuelAllocationSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.lowMWBreakpoint")
   private Collection<java.lang.Float> lowMWBreakpoint;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.fuelCost")
   private Collection<java.lang.Float> fuelCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.fossilFuelType")
   private FuelType fossilFuelType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.fuelHandlingCost")
   private Collection<java.lang.Float> fuelHandlingCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.highMWBreakpoint")
   private Collection<java.lang.Float> highMWBreakpoint;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.fuelMixture")
   private Collection<java.lang.Float> fuelMixture;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilFuel.fuelEffFactor")
   private Collection<java.lang.Float> fuelEffFactor;
}
