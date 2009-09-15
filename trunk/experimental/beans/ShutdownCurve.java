package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ShutdownCurve")
public class ShutdownCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ShutdownCurve.shutdownCost")
   private Collection<java.lang.Float> shutdownCost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ShutdownCurve.shutdownDate")
   private Collection<java.lang.String> shutdownDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ShutdownCurve.ThermalGeneratingUnit")
   private ThermalGeneratingUnit ThermalGeneratingUnit;
}
