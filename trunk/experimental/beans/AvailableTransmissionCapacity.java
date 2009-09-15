package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("AvailableTransmissionCapacity")
public class AvailableTransmissionCapacity extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AvailableTransmissionCapacity.ScheduleFor")
   private TransmissionService ScheduleFor;
}
