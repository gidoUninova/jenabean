package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TailbayLossCurve")
public class TailbayLossCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TailbayLossCurve.HydroGeneratingUnit")
   private HydroGeneratingUnit HydroGeneratingUnit;
}
