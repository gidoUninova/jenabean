package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LevelVsVolumeCurve")
public class LevelVsVolumeCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LevelVsVolumeCurve.Reservoir")
   private Reservoir Reservoir;
}
