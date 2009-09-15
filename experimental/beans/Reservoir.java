package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Reservoir")
public class Reservoir extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.riverOutletWorks")
   private Collection<java.lang.String> riverOutletWorks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.spillwayCrestLevel")
   private Collection<java.lang.Float> spillwayCrestLevel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.SpillsFrom")
   private Reservoir SpillsFrom;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.InflowForecast")
   private InflowForecast InflowForecast;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.spillwayCrestLength")
   private Collection<java.lang.Float> spillwayCrestLength;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.grossCapacity")
   private Collection<java.lang.Float> grossCapacity;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.energyStorageRating")
   private Collection<java.lang.Float> energyStorageRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.normalMinOperateLevel")
   private Collection<java.lang.Float> normalMinOperateLevel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.SpillsInto")
   private Reservoir SpillsInto;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.LevelVsVolumeCurve")
   private LevelVsVolumeCurve LevelVsVolumeCurve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.fullSupplyLevel")
   private Collection<java.lang.Float> fullSupplyLevel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.spillWayGateType")
   private SpillwayGateType spillWayGateType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.spillwayCapacity")
   private Collection<java.lang.Float> spillwayCapacity;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.HydroPowerPlants")
   private HydroPowerPlant HydroPowerPlants;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.TargetLevelSchedule")
   private TargetLevelSchedule TargetLevelSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.activeStorageCapacity")
   private Collection<java.lang.Float> activeStorageCapacity;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.spillTravelDelay")
   private Collection<java.lang.Float> spillTravelDelay;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reservoir.UpstreamFrom")
   private HydroPowerPlant UpstreamFrom;
}
