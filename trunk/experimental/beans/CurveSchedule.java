package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CurveSchedule")
public class CurveSchedule extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.CurveScheduleFormula")
   private CurveSchedFormula CurveScheduleFormula;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.xAxisUnits")
   private XAxisUnits xAxisUnits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.y1AxisUnits")
   private Y1AxisUnits y1AxisUnits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.yAxisType")
   private YAxisType yAxisType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.y2AxisUnits")
   private Y2AxisUnits y2AxisUnits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.rampUnits")
   private RampUnits rampUnits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.rampMethod")
   private RampMethod rampMethod;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.rampStartMethod")
   private RampStartMethod rampStartMethod;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.CurveScheduleDatas")
   private CurveSchedData CurveScheduleDatas;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.curveStyle")
   private CurveStyle curveStyle;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurveSchedule.xAxisType")
   private XAxisType xAxisType;
}
