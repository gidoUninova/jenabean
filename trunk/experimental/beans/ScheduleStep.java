package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ScheduleStep")
public class ScheduleStep extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ScheduleStep.SafetyDocument")
   private SafetyDocument SafetyDocument;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ScheduleStep.completedDateTime")
   private Collection<java.lang.String> completedDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ScheduleStep.requiredDocStatus")
   private Collection<java.lang.String> requiredDocStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ScheduleStep.PowerSystemResources")
   private Collection<PowerSystemResource> PowerSystemResources;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ScheduleStep.SwitchingSchedule")
   private SwitchingSchedule SwitchingSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ScheduleStep.requiredControlAction")
   private Collection<java.lang.String> requiredControlAction;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ScheduleStep.text")
   private Collection<java.lang.String> text;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ScheduleStep.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ScheduleStep.instructedDateTime")
   private Collection<java.lang.String> instructedDateTime;
}
