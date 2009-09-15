package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("HydroPowerPlant")
public class HydroPowerPlant extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.GenSourcePumpDischarge")
   private Reservoir GenSourcePumpDischarge;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.penstockType")
   private PenstockType penstockType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.surgeTankCode")
   private SurgeTankCode surgeTankCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.surgeTankCrestLevel")
   private Collection<java.lang.Float> surgeTankCrestLevel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.plantRatedHead")
   private Collection<java.lang.Float> plantRatedHead;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.Reservoir")
   private Reservoir Reservoir;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.hydroPlantType")
   private HydroPlantType hydroPlantType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.plantMWPumpRating")
   private Collection<java.lang.Float> plantMWPumpRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.plantDischargeCapacity")
   private Collection<java.lang.Float> plantDischargeCapacity;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.dischargeTravelDelay")
   private Collection<java.lang.Float> dischargeTravelDelay;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.Contain_HydroPumps")
   private HydroPump Contain_HydroPumps;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.Contain_HydroGeneratingUnits")
   private HydroGeneratingUnit Contain_HydroGeneratingUnits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPowerPlant.plantMWGenRating")
   private Collection<java.lang.Float> plantMWGenRating;
}
