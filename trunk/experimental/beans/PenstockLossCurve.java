package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PenstockLossCurve")
public class PenstockLossCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PenstockLossCurve.HydroGeneratingUnit")
   private HydroGeneratingUnit HydroGeneratingUnit;
}
