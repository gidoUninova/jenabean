package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("DayType")
public class DayType extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DayType.LoadDemandModels")
   private LoadDemandModel LoadDemandModels;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DayType.AreaLoadCurves")
   private AreaLoadCurve AreaLoadCurves;
}
