package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RampRateCurve")
public class RampRateCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RampRateCurve.GeneratingUnit")
   private Collection<GeneratingUnit> GeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RampRateCurve.rampRateType")
   private Collection<java.lang.String> rampRateType;
}
