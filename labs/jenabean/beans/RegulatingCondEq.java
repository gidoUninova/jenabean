package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RegulatingCondEq")
public class RegulatingCondEq extends ConductingEquipment {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RegulatingCondEq.RegulationSchedule")
   private RegulationSchedule RegulationSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RegulatingCondEq.Controls")
   private Control Controls;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RegulatingCondEq.Measurement")
   private Measurement Measurement;
}
