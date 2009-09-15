package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SwitchingSchedule")
public class SwitchingSchedule extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingSchedule.Crews")
   private Collection<Crew> Crews;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingSchedule.endDateTime")
   private Collection<java.lang.String> endDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingSchedule.reason")
   private Collection<java.lang.String> reason;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingSchedule.ScheduleSteps")
   private ScheduleStep ScheduleSteps;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingSchedule.startDateTime")
   private Collection<java.lang.String> startDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingSchedule.WorkTasks")
   private WorkTask WorkTasks;
}
