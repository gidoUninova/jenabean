package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Crew")
public class Crew extends CIMCollection {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Crew.Route")
   private Route Route;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Crew.ErpContacts")
   private ErpContact ErpContacts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Crew.WorkTasks")
   private Collection<WorkTask> WorkTasks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Crew.QualificationRequirements")
   private Collection<QualificationRequirement> QualificationRequirements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Crew.Tools")
   private Tool Tools;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Crew.OutageSteps")
   private Collection<OutageStep> OutageSteps;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Crew.SwitchingSchedules")
   private Collection<SwitchingSchedule> SwitchingSchedules;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Crew.Vehicles")
   private Vehicle Vehicles;
}
