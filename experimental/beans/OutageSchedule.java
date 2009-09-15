package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("OutageSchedule")
public class OutageSchedule extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageSchedule.PSR")
   private PowerSystemResource PSR;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageSchedule.PlannedOutage")
   private PlannedOutage PlannedOutage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageSchedule.SwitchingOperations")
   private SwitchingOperation SwitchingOperations;
}
