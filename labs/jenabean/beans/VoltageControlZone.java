package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("VoltageControlZone")
public class VoltageControlZone extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#VoltageControlZone.BusbarSection")
   private BusbarSection BusbarSection;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#VoltageControlZone.RegulationSchedule")
   private RegulationSchedule RegulationSchedule;
}
