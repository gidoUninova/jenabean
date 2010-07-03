package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SafetyDocument")
public class SafetyDocument extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SafetyDocument.ScheduleSteps")
   private ScheduleStep ScheduleSteps;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SafetyDocument.PowerSystemResource")
   private PowerSystemResource PowerSystemResource;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SafetyDocument.Isolate_EquipmentList")
   private EquipmentList Isolate_EquipmentList;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SafetyDocument.ClearanceTags")
   private Collection<ClearanceTag> ClearanceTags;
}
