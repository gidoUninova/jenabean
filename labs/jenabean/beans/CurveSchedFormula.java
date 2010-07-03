package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CurveSchedFormula")
public class CurveSchedFormula extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedFormula.xLowerBound")
   private Collection<java.lang.Float> xLowerBound;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedFormula.xUpperBound")
   private Collection<java.lang.Float> xUpperBound;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedFormula.CurveSchedule")
   private CurveSchedule CurveSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedFormula.yFunction")
   private Collection<java.lang.String> yFunction;
}
