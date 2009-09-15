package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("AreaLoadCurve")
public class AreaLoadCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaLoadCurve.Season")
   private Season Season;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaLoadCurve.LoadArea")
   private LoadArea LoadArea;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaLoadCurve.DayType")
   private DayType DayType;
}
