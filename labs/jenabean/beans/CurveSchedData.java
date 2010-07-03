package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CurveSchedData")
public class CurveSchedData extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedData.y1AxisData")
   private Collection<java.lang.Float> y1AxisData;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedData.xAxisData")
   private Collection<java.lang.Float> xAxisData;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedData.rampDataValue")
   private Collection<java.lang.Float> rampDataValue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedData.y2AxisData")
   private Collection<java.lang.Float> y2AxisData;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedData.CurveSchedule")
   private CurveSchedule CurveSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedData.rampData")
   private Collection<java.lang.Float> rampData;
}
