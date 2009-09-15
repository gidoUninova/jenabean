package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("GenUnitOpCostCurve")
public class GenUnitOpCostCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#GenUnitOpCostCurve.GeneratingUnit")
   private GeneratingUnit GeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#GenUnitOpCostCurve.netGrossMWFlag")
   private Collection<java.lang.Boolean> netGrossMWFlag;
}
