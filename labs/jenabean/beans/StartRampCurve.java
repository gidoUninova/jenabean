package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("StartRampCurve")
public class StartRampCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartRampCurve.StartupModel")
   private StartupModel StartupModel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartRampCurve.hotStandbyRamp")
   private Collection<java.lang.Float> hotStandbyRamp;
}
