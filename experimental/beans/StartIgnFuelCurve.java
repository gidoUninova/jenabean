package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("StartIgnFuelCurve")
public class StartIgnFuelCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartIgnFuelCurve.ignitionFuelType")
   private FuelType ignitionFuelType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartIgnFuelCurve.StartupModel")
   private StartupModel StartupModel;
}
