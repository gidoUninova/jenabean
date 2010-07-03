package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("GrossToNetMWCurve")
public class GrossToNetMWCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#GrossToNetMWCurve.GeneratingUnit")
   private GeneratingUnit GeneratingUnit;
}
