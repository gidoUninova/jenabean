package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("IncrementalHeatRateCurve")
public class IncrementalHeatRateCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#IncrementalHeatRateCurve.netGrossMWFlag")
   private Collection<java.lang.Boolean> netGrossMWFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#IncrementalHeatRateCurve.ThermalGeneratingUnit")
   private ThermalGeneratingUnit ThermalGeneratingUnit;
}
