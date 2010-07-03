package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("StartMainFuelCurve")
public class StartMainFuelCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartMainFuelCurve.StartupModel")
   private StartupModel StartupModel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StartMainFuelCurve.mainFuelType")
   private FuelType mainFuelType;
}
