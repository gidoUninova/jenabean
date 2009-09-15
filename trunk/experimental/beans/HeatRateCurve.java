package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("HeatRateCurve")
public class HeatRateCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatRateCurve.ThermalGeneratingUnit")
   private ThermalGeneratingUnit ThermalGeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatRateCurve.netGrossMWFlag")
   private Collection<java.lang.Boolean> netGrossMWFlag;
}
