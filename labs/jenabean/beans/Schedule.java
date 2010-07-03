package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Schedule")
public class Schedule extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Schedule.Project")
   private Project Project;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Schedule.WorkTask")
   private WorkTask WorkTask;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Schedule.dayOfMonth")
   private Collection<java.math.BigInteger> dayOfMonth;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Schedule.For.InspectionDataSets")
   private InspectionDataSet For_InspectionDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Schedule.periodDays")
   private Collection<java.lang.Float> periodDays;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Schedule.Work")
   private Work Work;
}
