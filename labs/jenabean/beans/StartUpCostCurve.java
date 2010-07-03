package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("StartUpCostCurve")
public class StartUpCostCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartUpCostCurve.GeneratingUnits")
   private Collection<GeneratingUnit> GeneratingUnits;
}
