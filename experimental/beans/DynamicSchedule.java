package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("DynamicSchedule")
public class DynamicSchedule extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DynamicSchedule.dynSchedStatus")
   private Collection<java.lang.String> dynSchedStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DynamicSchedule.Receive_HostControlArea")
   private HostControlArea Receive_HostControlArea;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DynamicSchedule.dynSchedSignRev")
   private Collection<java.lang.Boolean> dynSchedSignRev;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DynamicSchedule.Send_HostControlArea")
   private HostControlArea Send_HostControlArea;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DynamicSchedule.Measurement")
   private Measurement Measurement;
}
