package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RegulationSchedule")
public class RegulationSchedule extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RegulationSchedule.TapChangers")
   private TapChanger TapChangers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RegulationSchedule.lineDropR")
   private Collection<java.lang.Float> lineDropR;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RegulationSchedule.lineDropX")
   private Collection<java.lang.Float> lineDropX;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RegulationSchedule.VoltageControlZones")
   private VoltageControlZone VoltageControlZones;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RegulationSchedule.RegulatingCondEqs")
   private RegulatingCondEq RegulatingCondEqs;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RegulationSchedule.lineDropCompensation")
   private Collection<java.lang.Boolean> lineDropCompensation;
}
