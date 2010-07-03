package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("WorkTask")
public class WorkTask extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.MaterialItems")
   private MaterialItem MaterialItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.ContractorItems")
   private ContractorItem ContractorItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.Locations")
   private Collection<Location> Locations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.CustomerLists")
   private Collection<CustomerList> CustomerLists;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.Schedule")
   private Schedule Schedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.MiscCostItems")
   private MiscCostItem MiscCostItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.LaborItems")
   private LaborItem LaborItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.QualificationRequirements")
   private Collection<QualificationRequirement> QualificationRequirements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.VehicleItems")
   private VehicleItem VehicleItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.sequence")
   private Collection<java.lang.String> sequence;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.Work")
   private Work Work;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.Crews")
   private Collection<Crew> Crews;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.CUTask")
   private CUTask CUTask;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.Overhead")
   private Overhead Overhead;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.WorkCostDetails")
   private WorkCostDetail WorkCostDetails;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.SwitchingSchedule")
   private SwitchingSchedule SwitchingSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkTask.Design")
   private Design Design;
}
