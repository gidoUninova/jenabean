package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SwitchingOperation")
public class SwitchingOperation extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingOperation.operationTime")
   private Collection<java.lang.String> operationTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingOperation.newState")
   private SwitchState newState;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingOperation.OutageSchedule")
   private OutageSchedule OutageSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchingOperation.Switches")
   private Collection<Switch> Switches;
}
