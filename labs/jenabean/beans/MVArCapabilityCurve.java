package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MVArCapabilityCurve")
public class MVArCapabilityCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MVArCapabilityCurve.hydrogenPressure")
   private Collection<java.lang.Float> hydrogenPressure;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MVArCapabilityCurve.SynchronousMachines")
   private Collection<SynchronousMachine> SynchronousMachines;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MVArCapabilityCurve.coolantTemperature")
   private TemperatureUnits coolantTemperature;
}
