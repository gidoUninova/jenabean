package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("HydroGeneratingEfficiencyCurve")
public class HydroGeneratingEfficiencyCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroGeneratingEfficiencyCurve.HydroGeneratingUnit")
   private HydroGeneratingUnit HydroGeneratingUnit;
}
