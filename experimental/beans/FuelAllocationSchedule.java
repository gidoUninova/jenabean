package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("FuelAllocationSchedule")
public class FuelAllocationSchedule extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FuelAllocationSchedule.minFuelAllocation")
   private Collection<java.lang.Float> minFuelAllocation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FuelAllocationSchedule.ThermalGeneratingUnit")
   private ThermalGeneratingUnit ThermalGeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FuelAllocationSchedule.fuelType")
   private FuelType fuelType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FuelAllocationSchedule.fuelAllocationStartDate")
   private Collection<java.lang.String> fuelAllocationStartDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FuelAllocationSchedule.maxFuelAllocation")
   private Collection<java.lang.Float> maxFuelAllocation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FuelAllocationSchedule.FossilFuel")
   private FossilFuel FossilFuel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FuelAllocationSchedule.fuelAllocationEndDate")
   private Collection<java.lang.String> fuelAllocationEndDate;
}
