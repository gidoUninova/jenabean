package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TargetLevelSchedule")
public class TargetLevelSchedule extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TargetLevelSchedule.lowLevelLimit")
   private Collection<java.lang.Float> lowLevelLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TargetLevelSchedule.highLevelLimit")
   private Collection<java.lang.Float> highLevelLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TargetLevelSchedule.Reservoir")
   private Reservoir Reservoir;
}
